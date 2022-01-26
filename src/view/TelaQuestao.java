/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import br.com.enade.DAO.CursoDAO;
import br.com.enade.DAO.DisciplinaDAO;
import br.com.enade.DAO.QuestoesDAO;
import br.com.enade.bean.Curso;
import br.com.enade.bean.Disciplina;
import br.com.enade.bean.Questoes;
import br.com.enade.util.ConnectionFactory;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.*;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author silas
 */
public class TelaQuestao extends javax.swing.JInternalFrame {


    //a linha abaixo cria uma variável para armazenar um texto de acordo com o radion button selecionado
    private String dificuldade;
    private String alternativa_correta;
    private String tipo;
    String gender;
    byte[] imagem = null;
    String filename = null;
    private ImageIcon format = null;
    
    /**
     * Creates new form TelaQuestao
     */
    Connection conexao;
    
      
    public TelaQuestao() {
        this.conexao = null;
        initComponents();
        //Inicialização conexão para uso no JASPER relatório
        conexao = ConnectionFactory.getConnection();

        DefaultTableModel modelo = (DefaultTableModel) JTConsultaQuestoes.getModel();
        JTConsultaQuestoes.setRowSorter(new TableRowSorter(modelo));

        txtCodigo.setEditable(false);

        readJTable();
        
        
        // permite selecionar apenas uma linha de cada vez para mostrar imagem
        JTConsultaQuestoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    
    
    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) JTConsultaQuestoes.getModel();
        modelo.setNumRows(0);
        QuestoesDAO pdao = new QuestoesDAO();

        for (Questoes d : pdao.read()) {

            modelo.addRow(new Object[]{
                d.getCod_questao(),
                d.getAno(),
                d.getCurso().getNome_curso(),
                d.getDisciplina().getNome_disciplina(),
                d.getDisciplina_opc1(),
                d.getDisciplina_opc2(),
                d.getN_questao(),
                d.getTipo(),
                d.getImagem(),
                d.getDificuldade(),
                d.getEnunciado(),
                d.getPadrao_resposta_disc(),
                d.getObvervacao(),
                d.getA(),
                d.getB(),
                d.getC(),
                d.getD(),
                d.getE(),
                d.getAlternativa_correta(),

            });

        }

    }

    //Método para listar por ano
    public void readJTabbleForAno(String anoInicial, String anoFinal) {
        DefaultTableModel modelo = (DefaultTableModel) JTConsultaQuestoes.getModel();
        modelo.setNumRows(0);
        QuestoesDAO pdao = new QuestoesDAO();
        for (Questoes d : pdao.readForAno(anoInicial, anoFinal)) {

            modelo.addRow(new Object[]{
                d.getCod_questao(),
                d.getAno(),
                d.getCurso().getNome_curso(),
                d.getDisciplina().getNome_disciplina(),
                d.getDisciplina_opc1(),
                d.getDisciplina_opc2(),
                d.getN_questao(),
                d.getTipo(),
                d.getImagem(),
                d.getDificuldade(),
                d.getEnunciado(),
                d.getPadrao_resposta_disc(),
                d.getObvervacao(),
                d.getA(),
                d.getB(),
                d.getC(),
                d.getD(),
                d.getE(),
                d.getAlternativa_correta(),

            });

        }
    }

    // Método para listar/Filtrar por Dificuldade 
    public void readJTabbleForDificuldade(String Dificuldade) {
        DefaultTableModel modelo = (DefaultTableModel) JTConsultaQuestoes.getModel();
        modelo.setNumRows(0);
        QuestoesDAO pdao = new QuestoesDAO();
        for (Questoes d : pdao.readForDificuldade(Dificuldade)) {

            modelo.addRow(new Object[]{
                d.getCod_questao(),
                d.getAno(),
                d.getCurso().getNome_curso(),
                d.getDisciplina().getNome_disciplina(),
                d.getDisciplina_opc1(),
                d.getDisciplina_opc2(),
                d.getN_questao(),
                d.getTipo(),
                d.getImagem(),
                d.getDificuldade(),
                d.getEnunciado(),
                d.getPadrao_resposta_disc(),
                d.getObvervacao(),
                d.getA(),
                d.getB(),
                d.getC(),
                d.getD(),
                d.getE(),
                d.getAlternativa_correta(),

            });

        }
    }

    
    
    
    
    
    // Método para listar/Filtrar por Dificuldades caixa de texto 
    public void ReadTableForTipo(String tipoQuestao) {
        DefaultTableModel modelo = (DefaultTableModel) JTConsultaQuestoes.getModel();
        modelo.setNumRows(0);
        QuestoesDAO pdao = new QuestoesDAO();
        for (Questoes d : pdao.ReadTableForTipo(tipoQuestao)) {

            modelo.addRow(new Object[]{
                d.getCod_questao(),
                d.getAno(),
                d.getCurso().getNome_curso(),
                d.getDisciplina().getNome_disciplina(),
                d.getDisciplina_opc1(),
                d.getDisciplina_opc2(),
                d.getN_questao(),
                d.getTipo(),
                d.getImagem(),
                d.getDificuldade(),
                d.getEnunciado(),
                d.getPadrao_resposta_disc(),
                d.getObvervacao(),
                d.getA(),
                d.getB(),
                d.getC(),
                d.getD(),
                d.getE(),
                d.getAlternativa_correta(),

            });

        }
    } // fim codigo caixa de tsxto
    
    
    
    
    

    public void ReadTableForDisciplinaFiltro(String Disciplina, String DISCIPLINA_OPC1, String DISCIPLINA_OPC2) {
        DefaultTableModel modelo = (DefaultTableModel) JTConsultaQuestoes.getModel();
        modelo.setNumRows(0);
        QuestoesDAO pdao = new QuestoesDAO();
        for (Questoes d : pdao.ReadTableForDisciplinaFiltro(Disciplina,DISCIPLINA_OPC1, DISCIPLINA_OPC2)) {

            modelo.addRow(new Object[]{
                d.getCod_questao(),
                d.getAno(),
                d.getCurso().getNome_curso(),
                d.getDisciplina().getNome_disciplina(),
                d.getDisciplina_opc1(),
                d.getDisciplina_opc2(),
                d.getN_questao(),
                d.getTipo(),
                d.getImagem(),
                d.getDificuldade(),
                d.getEnunciado(),
                d.getPadrao_resposta_disc(),
                d.getObvervacao(),
                d.getA(),
                d.getB(),
                d.getC(),
                d.getD(),
                d.getE(),
                d.getAlternativa_correta(),

            });

        }
    }

    //  //Método recebebendo pela DAO para filtrar todos
    public void ReadTableForFiltrarTodosCampos(String Disciplina, String Ano, String Ano2, String Dificuldade, String NOME_CURSO, String tipo) {
        DefaultTableModel modelo = (DefaultTableModel) JTConsultaQuestoes.getModel();
        modelo.setNumRows(0);
        QuestoesDAO pdao = new QuestoesDAO();
        for (Questoes d : pdao.ReadTableForFiltrarTodosCampos(Disciplina, Ano, Ano2, Dificuldade, NOME_CURSO,tipo)) {

            modelo.addRow(new Object[]{
                d.getCod_questao(),
                d.getAno(),
                d.getCurso().getNome_curso(),
                d.getDisciplina().getNome_disciplina(),
                d.getDisciplina_opc1(),
                d.getDisciplina_opc2(),
                d.getN_questao(),
                d.getTipo(),
                d.getImagem(),
                d.getDificuldade(),
                d.getEnunciado(),
                d.getPadrao_resposta_disc(),
                d.getObvervacao(),
                d.getA(),
                d.getB(),
                d.getC(),
                d.getD(),
                d.getE(),
                d.getAlternativa_correta(),

            });

        }
    }

    //  //Método recebebendo pela DAO para filtrar todos
    public void ReadTableForCurso(String Nome_curso) {
        DefaultTableModel modelo = (DefaultTableModel) JTConsultaQuestoes.getModel();
        modelo.setNumRows(0);
        QuestoesDAO pdao = new QuestoesDAO();
        for (Questoes d : pdao.readForCurso(Nome_curso)) {

            modelo.addRow(new Object[]{
                d.getCod_questao(),
                d.getAno(),
                d.getCurso().getNome_curso(),
                d.getDisciplina().getNome_disciplina(),
                d.getDisciplina_opc1(),
                d.getDisciplina_opc2(),
                d.getN_questao(),
                d.getTipo(),
                d.getImagem(),
                d.getDificuldade(),
                d.getEnunciado(),
                d.getPadrao_resposta_disc(),
                d.getObvervacao(),
                d.getA(),
                d.getB(),
                d.getC(),
                d.getD(),
                d.getE(),
                d.getAlternativa_correta(),

            });

        }
    }

    //Método Listando todos dados de questoes
    public void ReadTableListandoTodos() {
        DefaultTableModel modelo = (DefaultTableModel) JTConsultaQuestoes.getModel();
        modelo.setNumRows(0);
        QuestoesDAO pdao = new QuestoesDAO();
        for (Questoes d : pdao.readListTodos()) {

            modelo.addRow(new Object[]{
                d.getCod_questao(),
                d.getAno(),
                d.getCurso().getNome_curso(),
                d.getDisciplina().getNome_disciplina(),
                d.getDisciplina_opc1(),
                d.getDisciplina_opc2(),
                d.getN_questao(),
                d.getTipo(),
                d.getImagem(),
                d.getDificuldade(),
                d.getEnunciado(),
                d.getPadrao_resposta_disc(),
                d.getObvervacao(),
                d.getA(),
                d.getB(),
                d.getC(),
                d.getD(),
                d.getE(),
                d.getAlternativa_correta(),


            });

        }
    }

    //iMPRIMIR rELATORIO
    private void imprimir_rel() {
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão desde relatório?", "Atenção!", JOptionPane.YES_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            //Imprimindo relatório com o framework JasperReport
            try {
          
                HashMap filtro = new HashMap();
                filtro.put("Disciplina", txtDisciplinaFiltro.getText());
                filtro.put("Ano", Integer.parseInt(txtanoInicio.getText()));
                filtro.put("Ano2", Integer.parseInt(txtAnofinal.getText()));
                filtro.put("NOME_CURSO", txtCursoFiltro.getText());
                filtro.put("Dificuldade", txtDificuldadeFiltro.getText());
                filtro.put("Tipo", txtTipo.getText());
                //Usando a classe JASPERpRINT para preparar a impressao de um relatório
                JasperPrint print = JasperFillManager.fillReport("C:\\reports\\relatorio_src.jasper",filtro, conexao);
                //Linha abaixo exibe o relatório através da classe JasperViewer

                JasperViewer.viewReport(print, false);

            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Erro na emissão do relatório!");
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelQuestoes = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtA = new javax.swing.JTextField();
        txtE = new javax.swing.JTextField();
        txtD = new javax.swing.JTextField();
        txtB = new javax.swing.JTextField();
        txtC = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObvervacao = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tbtAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        rbtA = new javax.swing.JRadioButton();
        rbtB = new javax.swing.JRadioButton();
        rbtC = new javax.swing.JRadioButton();
        rbtE = new javax.swing.JRadioButton();
        rbtD = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTConsultaQuestoes = new javax.swing.JTable();
        btnListarFiltrarTodos = new javax.swing.JButton();
        BtnRelatorio = new javax.swing.JButton();
        txtDificuldadeFiltro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDisciplinaFiltro = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtanoInicio = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnLimparFiltros = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btnPesquisarTipo = new javax.swing.JButton();
        btnPesquisarAno = new javax.swing.JButton();
        btnPesquisarDisciplina = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtCursoFiltro = new javax.swing.JTextField();
        txtAnofinal = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblImagem = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbldiretorio = new javax.swing.JTextField();
        btnImagem = new javax.swing.JButton();
        radioDiscursiva = new javax.swing.JRadioButton();
        radioObjetiva = new javax.swing.JRadioButton();
        txtNumQquestao = new javax.swing.JTextField();
        txtDisciplina2 = new javax.swing.JTextField();
        txtDisciplina1 = new javax.swing.JTextField();
        ComboxDisciplina = new javax.swing.JComboBox();
        cbCurso = new javax.swing.JComboBox();
        txtAno = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        rbtDificil = new javax.swing.JRadioButton();
        rbtMedio = new javax.swing.JRadioButton();
        rbtFacil = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEnunciado = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtPadraoDiscursiva = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        alternativa_correta_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnPesquisarDificuldade1 = new javax.swing.JButton();
        txtTotal = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Questões");
        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelQuestoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelQuestoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/add.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 102, -1));

        jLabel4.setText("Digite alternativas");
        jPanelQuestoes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, -1));

        jLabel10.setText("B");
        jPanelQuestoes.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 18, 24));
        jPanelQuestoes.add(txtA, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 370, -1));
        jPanelQuestoes.add(txtE, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 370, -1));
        jPanelQuestoes.add(txtD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 370, -1));
        jPanelQuestoes.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 370, -1));
        jPanelQuestoes.add(txtC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 370, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/application_form.png"))); // NOI18N
        jButton2.setText("Novo");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, -1, -1));

        txtObvervacao.setColumns(20);
        txtObvervacao.setRows(5);
        jScrollPane3.setViewportView(txtObvervacao);

        jPanelQuestoes.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 180, 120));

        jLabel14.setText("Observação:");
        jPanelQuestoes.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel15.setText("C");
        jPanelQuestoes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 18, 24));

        jLabel16.setText("D");
        jPanelQuestoes.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 21, 24));

        jLabel17.setText("E");
        jPanelQuestoes.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 18, 24));

        jLabel18.setText("A");
        jPanelQuestoes.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 18, 24));

        tbtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/application_edit.png"))); // NOI18N
        tbtAlterar.setText("Alterar");
        tbtAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtAlterarActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(tbtAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, 101, -1));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/application_form_delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 610, -1, -1));

        buttonGroup1.add(rbtA);
        rbtA.setText("A");
        rbtA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtAActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(rbtA, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, -1, -1));

        buttonGroup1.add(rbtB);
        rbtB.setText("B");
        rbtB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtBActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(rbtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, -1, -1));

        buttonGroup1.add(rbtC);
        rbtC.setText("C");
        rbtC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(rbtC, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, -1, -1));

        buttonGroup1.add(rbtE);
        rbtE.setText("E");
        rbtE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(rbtE, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 570, -1, -1));

        buttonGroup1.add(rbtD);
        rbtD.setText("D");
        rbtD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(rbtD, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, -1, -1));

        JTConsultaQuestoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Ano", "Curso", "Disciplina", "Disciplina1", "Disciplina2", "Nº ", "Tipo", "IMG", "Dificuldade", "Enunciado", "Padrão Resposta Discursiva", "Obvervação", "A", "B", "C", "D", "E", "Alternatica correta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTConsultaQuestoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTConsultaQuestoesMouseClicked(evt);
            }
        });
        JTConsultaQuestoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTConsultaQuestoesKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(JTConsultaQuestoes);
        if (JTConsultaQuestoes.getColumnModel().getColumnCount() > 0) {
            JTConsultaQuestoes.getColumnModel().getColumn(0).setPreferredWidth(5);
            JTConsultaQuestoes.getColumnModel().getColumn(0).setHeaderValue("Cod.");
            JTConsultaQuestoes.getColumnModel().getColumn(1).setPreferredWidth(4);
            JTConsultaQuestoes.getColumnModel().getColumn(1).setHeaderValue("Ano");
            JTConsultaQuestoes.getColumnModel().getColumn(2).setHeaderValue("Curso");
            JTConsultaQuestoes.getColumnModel().getColumn(3).setHeaderValue("Disciplina");
            JTConsultaQuestoes.getColumnModel().getColumn(4).setHeaderValue("Disciplina1");
            JTConsultaQuestoes.getColumnModel().getColumn(5).setHeaderValue("Disciplina2");
            JTConsultaQuestoes.getColumnModel().getColumn(6).setPreferredWidth(0);
            JTConsultaQuestoes.getColumnModel().getColumn(6).setHeaderValue("Nº ");
            JTConsultaQuestoes.getColumnModel().getColumn(7).setHeaderValue("Tipo");
            JTConsultaQuestoes.getColumnModel().getColumn(8).setPreferredWidth(0);
            JTConsultaQuestoes.getColumnModel().getColumn(8).setHeaderValue("IMG");
            JTConsultaQuestoes.getColumnModel().getColumn(9).setPreferredWidth(80);
            JTConsultaQuestoes.getColumnModel().getColumn(9).setHeaderValue("Dificuldade");
            JTConsultaQuestoes.getColumnModel().getColumn(10).setPreferredWidth(80);
            JTConsultaQuestoes.getColumnModel().getColumn(10).setHeaderValue("Enunciado");
            JTConsultaQuestoes.getColumnModel().getColumn(11).setPreferredWidth(90);
            JTConsultaQuestoes.getColumnModel().getColumn(11).setHeaderValue("Padrão Resposta Discursiva");
            JTConsultaQuestoes.getColumnModel().getColumn(12).setPreferredWidth(80);
            JTConsultaQuestoes.getColumnModel().getColumn(12).setHeaderValue("Obvervação");
            JTConsultaQuestoes.getColumnModel().getColumn(13).setResizable(false);
            JTConsultaQuestoes.getColumnModel().getColumn(13).setPreferredWidth(1);
            JTConsultaQuestoes.getColumnModel().getColumn(13).setHeaderValue("A");
            JTConsultaQuestoes.getColumnModel().getColumn(14).setResizable(false);
            JTConsultaQuestoes.getColumnModel().getColumn(14).setPreferredWidth(0);
            JTConsultaQuestoes.getColumnModel().getColumn(14).setHeaderValue("B");
            JTConsultaQuestoes.getColumnModel().getColumn(15).setResizable(false);
            JTConsultaQuestoes.getColumnModel().getColumn(15).setPreferredWidth(0);
            JTConsultaQuestoes.getColumnModel().getColumn(15).setHeaderValue("C");
            JTConsultaQuestoes.getColumnModel().getColumn(16).setResizable(false);
            JTConsultaQuestoes.getColumnModel().getColumn(16).setPreferredWidth(0);
            JTConsultaQuestoes.getColumnModel().getColumn(16).setHeaderValue("D");
            JTConsultaQuestoes.getColumnModel().getColumn(17).setPreferredWidth(0);
            JTConsultaQuestoes.getColumnModel().getColumn(17).setHeaderValue("E");
            JTConsultaQuestoes.getColumnModel().getColumn(18).setPreferredWidth(1);
            JTConsultaQuestoes.getColumnModel().getColumn(18).setHeaderValue("Alternatica correta");
        }

        jPanelQuestoes.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 1300, 330));

        btnListarFiltrarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/read.png"))); // NOI18N
        btnListarFiltrarTodos.setText("Filtrar");
        btnListarFiltrarTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListarFiltrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarFiltrarTodosActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(btnListarFiltrarTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 170, 80));

        BtnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/print.png"))); // NOI18N
        BtnRelatorio.setText("Gerar Relatório");
        BtnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRelatorioActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(BtnRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, 80));

        txtDificuldadeFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDificuldadeFiltroActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(txtDificuldadeFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 270, 29));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Pesquisar por:");
        jPanelQuestoes.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, -1, -1));
        jPanelQuestoes.add(txtDisciplinaFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 270, 29));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel19.setText("Ano:");
        jLabel19.setMaximumSize(new java.awt.Dimension(25, 20));
        jPanelQuestoes.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, -1, 30));
        jPanelQuestoes.add(txtanoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 120, 30));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel21.setText("Dificuldade:");
        jPanelQuestoes.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, -1, 20));

        btnLimparFiltros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/Actions-edit-clear-icon.png"))); // NOI18N
        btnLimparFiltros.setText("Limpar ");
        btnLimparFiltros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparFiltros.setMaximumSize(new java.awt.Dimension(131, 80));
        btnLimparFiltros.setMinimumSize(new java.awt.Dimension(131, 80));
        btnLimparFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparFiltrosActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(btnLimparFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 20, 150, 80));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel22.setText("Disciplina:");
        jPanelQuestoes.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, -1, 30));

        btnPesquisarTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/zoom_1.png"))); // NOI18N
        btnPesquisarTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarTipoActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(btnPesquisarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 280, 50, 30));

        btnPesquisarAno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/zoom.png"))); // NOI18N
        btnPesquisarAno.setAlignmentY(0.6F);
        btnPesquisarAno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisarAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarAnoActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(btnPesquisarAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 160, 50, 30));

        btnPesquisarDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/zoom.png"))); // NOI18N
        btnPesquisarDisciplina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarDisciplinaActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(btnPesquisarDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 220, 50, 30));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel20.setText("Curso:");
        jPanelQuestoes.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, 30));
        jPanelQuestoes.add(txtCursoFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 270, 32));
        jPanelQuestoes.add(txtAnofinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 120, 30));

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setText("  -");
        jLabel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelQuestoes.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 30, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/zoom.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 190, 50, 30));

        btnListarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/views-32.png"))); // NOI18N
        btnListarTodos.setText("Listar todos");
        btnListarTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListarTodos.setMaximumSize(new java.awt.Dimension(131, 80));
        btnListarTodos.setMinimumSize(new java.awt.Dimension(131, 80));
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(btnListarTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, 160, 80));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        jPanelQuestoes.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1860, 310, -1, 320));

        lblImagem.setMaximumSize(new java.awt.Dimension(570, 300));
        lblImagem.setMinimumSize(new java.awt.Dimension(570, 300));
        lblImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagemMouseClicked(evt);
            }
        });
        jPanelQuestoes.add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 10, 630, 300));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Tipo:");
        jPanelQuestoes.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, -1, -1));

        txtTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanelQuestoes.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 270, 29));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        lbldiretorio.setEditable(false);
        lbldiretorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lbldiretorio);
        lbldiretorio.setBounds(100, 280, 210, 30);

        btnImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/UploudImagem2.png"))); // NOI18N
        btnImagem.setText("Selecionar Imagem");
        btnImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagemActionPerformed(evt);
            }
        });
        jPanel2.add(btnImagem);
        btnImagem.setBounds(100, 250, 210, 30);

        buttonGroup2.add(radioDiscursiva);
        radioDiscursiva.setText("Discursiva");
        radioDiscursiva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        radioDiscursiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDiscursivaActionPerformed(evt);
            }
        });
        jPanel2.add(radioDiscursiva);
        radioDiscursiva.setBounds(110, 220, 92, 28);

        buttonGroup2.add(radioObjetiva);
        radioObjetiva.setText("Objetiva");
        radioObjetiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioObjetivaActionPerformed(evt);
            }
        });
        jPanel2.add(radioObjetiva);
        radioObjetiva.setBounds(220, 220, 78, 28);

        txtNumQquestao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumQquestaoKeyReleased(evt);
            }
        });
        jPanel2.add(txtNumQquestao);
        txtNumQquestao.setBounds(100, 190, 210, 24);
        jPanel2.add(txtDisciplina2);
        txtDisciplina2.setBounds(100, 160, 210, 24);

        txtDisciplina1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisciplina1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtDisciplina1);
        txtDisciplina1.setBounds(100, 130, 210, 24);

        ComboxDisciplina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ComboxDisciplina.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ComboxDisciplinaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        ComboxDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboxDisciplinaActionPerformed(evt);
            }
        });
        jPanel2.add(ComboxDisciplina);
        ComboxDisciplina.setBounds(100, 100, 210, 26);

        cbCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbCurso.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbCursoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(cbCurso);
        cbCurso.setBounds(100, 70, 210, 26);

        txtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoActionPerformed(evt);
            }
        });
        txtAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnoKeyReleased(evt);
            }
        });
        jPanel2.add(txtAno);
        txtAno.setBounds(100, 40, 210, 24);

        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txtCodigo.setCaretColor(new java.awt.Color(204, 204, 204));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel2.add(txtCodigo);
        txtCodigo.setBounds(100, 10, 210, 24);

        buttonGroup3.add(rbtDificil);
        rbtDificil.setText("Difícil");
        rbtDificil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDificilActionPerformed(evt);
            }
        });
        jPanel2.add(rbtDificil);
        rbtDificil.setBounds(250, 310, 63, 28);

        buttonGroup3.add(rbtMedio);
        rbtMedio.setText("Médio");
        rbtMedio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMedioActionPerformed(evt);
            }
        });
        jPanel2.add(rbtMedio);
        rbtMedio.setBounds(170, 310, 66, 28);

        buttonGroup3.add(rbtFacil);
        rbtFacil.setText("Fácil");
        rbtFacil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFacilActionPerformed(evt);
            }
        });
        jPanel2.add(rbtFacil);
        rbtFacil.setBounds(90, 310, 58, 28);

        jLabel12.setText("Dificuldade:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 310, 66, 20);

        jLabel26.setText("Imagem:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(10, 260, 49, 16);

        jLabel24.setText("Tipo:");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(10, 230, 100, 16);

        jLabel5.setText("Nº Questão:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 200, 66, 16);

        jLabel27.setText("Disc. Opcional2:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(10, 170, 91, 16);

        jLabel9.setText("Disc. Opcional1:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 140, 91, 16);

        jLabel13.setText("Disciplina  :");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 110, 64, 16);

        jLabel3.setText("Curso:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 80, 37, 16);

        jLabel2.setText("Ano:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(15, 42, 30, 20);

        jLabel1.setText("Código:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 60, 16);

        txtEnunciado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEnunciadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEnunciadoFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txtEnunciado);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(350, 30, 280, 150);

        jLabel6.setText("Enunciado:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(360, 10, 62, 16);

        txtPadraoDiscursiva.setColumns(20);
        txtPadraoDiscursiva.setRows(5);
        jScrollPane6.setViewportView(txtPadraoDiscursiva);

        jPanel2.add(jScrollPane6);
        jScrollPane6.setBounds(350, 210, 280, 83);

        jLabel25.setText("Padrão Resposta descursiva:");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(350, 190, 167, 16);

        jLabel11.setText("Selecione alternativa correta");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(460, 380, 164, 37);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(alternativa_correta_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(alternativa_correta_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(630, 380, 30, 30);

        jPanelQuestoes.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 650));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanelQuestoes.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 280, 140));

        btnPesquisarDificuldade1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/zoom_1.png"))); // NOI18N
        btnPesquisarDificuldade1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisarDificuldade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarDificuldade1ActionPerformed(evt);
            }
        });
        jPanelQuestoes.add(btnPesquisarDificuldade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 250, 50, 30));

        txtTotal.setBackground(new java.awt.Color(51, 153, 0));
        txtTotal.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(51, 153, 0));
        jPanelQuestoes.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 290, 260, 20));

        jScrollPane1.setViewportView(jPanelQuestoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 115, 2007, 711);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarDisciplinaActionPerformed
        // TODO add your handling code here:
        ReadTableForDisciplinaFiltro(txtDisciplinaFiltro.getText(), txtDisciplinaFiltro.getText(), txtDisciplinaFiltro.getText());
           int cont = 0;
        for (int i = 0; i < JTConsultaQuestoes.getRowCount(); i++) {
            if (JTConsultaQuestoes.getValueAt(i, 1).toString().equals("Concluida"));
            cont++;
        } 
       txtTotal.setText("Quantidade de dados Listados: " + Integer.toString(cont));
    }//GEN-LAST:event_btnPesquisarDisciplinaActionPerformed

    private void btnPesquisarAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarAnoActionPerformed
        // TODO add your handling code here:
        readJTabbleForAno(txtanoInicio.getText(), txtAnofinal.getText());
           int cont = 0;
        for (int i = 0; i < JTConsultaQuestoes.getRowCount(); i++) {
            if (JTConsultaQuestoes.getValueAt(i, 1).toString().equals("Concluida"));
            cont++;
        } 
       txtTotal.setText("Quantidade de dados Listados: " + Integer.toString(cont));

    }//GEN-LAST:event_btnPesquisarAnoActionPerformed

    private void btnPesquisarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarTipoActionPerformed
        ReadTableForTipo(txtTipo.getText());
           int cont = 0;
        for (int i = 0; i < JTConsultaQuestoes.getRowCount(); i++) {
            if (JTConsultaQuestoes.getValueAt(i, 1).toString().equals("Concluida"));
            cont++;
        } 
       txtTotal.setText("Quantidade de dados Listados: " + Integer.toString(cont));
    }//GEN-LAST:event_btnPesquisarTipoActionPerformed

    private void btnLimparFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparFiltrosActionPerformed
        // TODO add your handling code here:
        LimparCampos();
        txtDisciplinaFiltro.setText("");
        txtAnofinal.setText("");
        txtCursoFiltro.setText("");
        txtanoInicio.setText("");
        txtDificuldadeFiltro.setText("");
        lblImagem.setVisible(false);

    }//GEN-LAST:event_btnLimparFiltrosActionPerformed

    private void txtDificuldadeFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDificuldadeFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDificuldadeFiltroActionPerformed

    private void BtnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRelatorioActionPerformed
        // Gerando relatórios de questçoes
        if (txtanoInicio.getText().equals("") || txtDisciplinaFiltro.equals("") || txtDificuldadeFiltro.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha os campos para impressão do relatório!");
            return;
        }
        imprimir_rel();

    }//GEN-LAST:event_BtnRelatorioActionPerformed

    private void btnListarFiltrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarFiltrarTodosActionPerformed
        if(txtanoInicio.getText().equals("")  && txtAnofinal.getText().equals("") || txtAnofinal.getText().equals("") || txtanoInicio.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Insira um intervalo de ano para filtrar os dados!");
        }
        ReadTableForFiltrarTodosCampos(txtDisciplinaFiltro.getText(), txtanoInicio.getText(), txtAnofinal.getText(), txtDificuldadeFiltro.getText(), txtCursoFiltro.getText(), txtTipo.getText());
           int cont = 0;
        for (int i = 0; i < JTConsultaQuestoes.getRowCount(); i++) {
            if (JTConsultaQuestoes.getValueAt(i, 1).toString().equals("Concluida"));
            cont++;
        } 
       txtTotal.setText("Quantidade de dados Listados: " + Integer.toString(cont));


    }//GEN-LAST:event_btnListarFiltrarTodosActionPerformed

    private void JTConsultaQuestoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTConsultaQuestoesKeyReleased
        // TODO add your handling code here:
        
        if (JTConsultaQuestoes.getSelectedRow() != -1) {
            //abaixo o que sera setado nas cbx,label os resultado quando click.
            
            txtCodigo.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 0).toString());
            txtAno.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 1).toString());
            
            String comboCurso = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 2).toString();
                for (int i = 0; i < cbCurso.getItemCount(); i++) {
                    if (cbCurso.getItemAt(i).toString().equalsIgnoreCase(comboCurso)) {
                        cbCurso.setSelectedIndex(i);
                    }
                }
           
            String comboDisciplina = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 3).toString();
                for (int i = 0; i < ComboxDisciplina.getItemCount(); i++) {
                    if (ComboxDisciplina.getItemAt(i).toString().equalsIgnoreCase(comboDisciplina)) {
                        ComboxDisciplina.setSelectedIndex(i);
                    }
                }
                
            txtDisciplina1.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 4).toString());
            txtDisciplina2.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 5).toString());
            txtNumQquestao.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 6).toString());
            
            String tableGender = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 7).toString();
                    if (tableGender.equals("Discursiva")) {
                        radioDiscursiva.setSelected(true);
                    } else if (tableGender.equals("Objetiva")) {
                        radioObjetiva.setSelected(true);
                    }

                    
                    /*    
              int i = JTConsultaQuestoes.getSelectedRow();
            ImageIcon image1 = (ImageIcon) JTConsultaQuestoes.getValueAt(i, 8);
            Image image2 = image1.getImage().getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image3 = new ImageIcon(image2);
            lblImagem.setIcon(image3);
                 /*
              
           String buscaEmostraDificuldade = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 9).toString();
            switch (buscaEmostraDificuldade) {
                case "Fácil":
                    rbtFacil.setSelected(true);
                    break;
                case "Médio":
                    rbtMedio.setSelected(true);
                    break;
                case "Difícil":
                    rbtDificil.setSelected(true);
                    break;
                default:
                    break;
                
            }
                    
            txtEnunciado.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 10).toString());
            txtPadraoDiscursiva.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 11).toString());
            txtObvervacao.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 12).toString());
            txtA.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 13).toString());
            txtB.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 14).toString());
            txtC.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 15).toString());
            txtD.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 16).toString());
            txtE.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 17).toString());
            
            /*String alternativaCorreta = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 18).toString();
            if (alternativaCorreta.equals("A")) {
                        rbtA.setSelected(true);
                    } else if (alternativaCorreta.equals("B")) {
                        rbtB.setSelected(true);
                    }else if (alternativaCorreta.equals("C")) {
                        rbtC.setSelected(true);
                    }else if (alternativaCorreta.equals("D")) {
                        rbtD.setSelected(true);
                    }else if (alternativaCorreta.equals("E")) {
                        rbtE.setSelected(true);
                    }  else {
                       }*/

        }

    }//GEN-LAST:event_JTConsultaQuestoesKeyReleased
    public void vincularCampos(){
        
    }

    private void JTConsultaQuestoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTConsultaQuestoesMouseClicked
        // TODO add your handling code here:
        txtPadraoDiscursiva.setEnabled(true);
        txtA.setEnabled(true);
        txtB.setEnabled(true);
        txtC.setEnabled(true);
        txtD.setEnabled(true);
        txtE.setEnabled(true);
        rbtA.setEnabled(true);
        rbtB.setEnabled(true);
        rbtC.setEnabled(true);
        rbtD.setEnabled(true);
        rbtE.setEnabled(true);
        
        
        int index = JTConsultaQuestoes.getSelectedRow();
        TableModel model = JTConsultaQuestoes.getModel();
        
        
        //Codigo acima habilita as caixas de texto das respostas
/*
        int selectedRowForNewJframe = JTConsultaQuestoes.getSelectedRow();

        
        String Ano = model.getValueAt(index, 1).toString();
        String curso = model.getValueAt(index, 2).toString();
        String disciplina = model.getValueAt(index, 3).toString();
        String disciplinaOpc1 = model.getValueAt(index, 4).toString();
        String disciplinaOpc2 = model.getValueAt(index, 5).toString();
        String nQuestao = model.getValueAt(index, 6).toString();
        String tipoQuestao = model.getValueAt(index, 7).toString();
        String dificuldade_ = model.getValueAt(index, 9).toString();
        String IMAGEM__ = model.getValueAt(index, 8).toString();
        String enunciado = model.getValueAt(index, 10).toString();
        String padrao_resposta_disc = model.getValueAt(index, 11).toString();
        String observacao = model.getValueAt(index, 12).toString();
        String a = model.getValueAt(index, 13).toString();
        String b = model.getValueAt(index, 14).toString();
        String c = model.getValueAt(index, 15).toString();
        String d = model.getValueAt(index, 16).toString();
        String e = model.getValueAt(index, 17).toString();
        String alternativaCorreta = model.getValueAt(index, 18).toString();
   


        if(evt.getClickCount() == 2){
            jtRowData.setVisible(true);
           
    }
        
         jtRowData.pack();
            jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jtRowData.txtano_visualiza.setText(Ano);
            jtRowData.lblCursoDetalhes.setText(curso);
            jtRowData.lblDisciplinaDetalhes.setText(disciplina);
            jtRowData.lblDisciplinaOpc1Detalhes.setText(disciplinaOpc1);
            jtRowData.lblDisciplinaOpc2.setText(disciplinaOpc2);
            jtRowData.txt_nquestao_visualizar.setText(nQuestao);
            jtRowData.lblTipo.setText(tipoQuestao);
            jtRowData.lblDificuldadeDetalhes.setText(dificuldade_);
            
            BufferedImage imagem2 = new QuestoesDAO().obterImagem(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 0).toString());
            Image img = imagem2.getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
            jtRowData.IMAGEM__.setIcon(new ImageIcon(img));
            jtRowData.enunciado_vizualizar.setText(enunciado);
            jtRowData.padrao_resposta_disc.setText(padrao_resposta_disc);
            jtRowData.txtObservacaoDetalhes.setText(observacao);
            jtRowData.resposta_A_detalhes.setText(observacao);
            jtRowData.resposta_B_detalhes.setText(observacao);
            jtRowData.resposta_C_detalhes.setText(observacao);
            jtRowData.resposta_D_detalhes.setText(observacao);
            jtRowData.resposta_E_detalhes.setText(observacao);
            jtRowData.alternativaCorretaDetalhes.setText(alternativaCorreta);
*/

     
        
       
        
        
    //abaixo codigo para mostrar nas caixas de textos, combox etc todos os dados so clicar na jtable
        
        if (JTConsultaQuestoes.getSelectedRow() != -1) {
            
            txtCodigo.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 0).toString());
            txtAno.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 1).toString());
            
            String comboCurso = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 2).toString();
                for (int i = 0; i < cbCurso.getItemCount(); i++) {
                    if (cbCurso.getItemAt(i).toString().equalsIgnoreCase(comboCurso)) {
                        cbCurso.setSelectedIndex(i);
                    }
                }
           
            String comboDisciplina = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 3).toString();
                for (int i = 0; i < ComboxDisciplina.getItemCount(); i++) {
                    if (ComboxDisciplina.getItemAt(i).toString().equalsIgnoreCase(comboDisciplina)) {
                        ComboxDisciplina.setSelectedIndex(i);
                    }
                }
                
            txtDisciplina1.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 4).toString());
            txtDisciplina2.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 5).toString());
            txtNumQquestao.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 6).toString());
            
            String tableGender = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 7).toString();
                    if (tableGender.equals("Discursiva")) {
                        radioDiscursiva.setSelected(true);
                    } else if (tableGender.equals("Objetiva")) {
                        radioObjetiva.setSelected(true);
                    }


            String buscaEmostraDificuldade = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 9).toString();
            switch (buscaEmostraDificuldade) {
                case "Fácil":
                    rbtFacil.setSelected(true);
                    break;
                case "Médio":
                    rbtMedio.setSelected(true);
                    break;
                case "Difícil":
                    rbtDificil.setSelected(true);
                    break;
                default:
                    break;
                
            }
           
            
            txtEnunciado.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 10).toString());
            txtPadraoDiscursiva.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 11).toString());
            txtObvervacao.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 12).toString());
            txtA.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 13).toString());
            txtB.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 14).toString());
            txtC.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 15).toString());
            txtD.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 16).toString());
            txtE.setText(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 17).toString());
           /* String alternaticaC = JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 18).toString();
                    if (alternaticaC.equals("A")) {
                        rbtA.setSelected(true);
                    } else if (alternaticaC.equals("B")) {
                        rbtB.setSelected(true);
                    }else if (alternaticaC.equals("C")) {
                        rbtC.setSelected(true);
                    }else if (alternaticaC.equals("D")) {
                        rbtD.setSelected(true);
                    }else if (alternaticaC.equals("E")) {
                        rbtE.setSelected(true);
                    }else{}
    */
            
             BufferedImage imagemVisible = new QuestoesDAO().obterImagem(JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 0).toString());
            Image imagemM = imagemVisible.getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
            lblImagem.setIcon(new ImageIcon(imagemM));
            lblImagem.setVisible(true);
            
/*
              int i = JTConsultaQuestoes.getSelectedRow();
            ImageIcon image1 = (ImageIcon) JTConsultaQuestoes.getValueAt(i, 8);
            Image image2 = image1.getImage().getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image3 = new ImageIcon(image2);
            lblImagem.setIcon(image3);
                 */
        }
     
             
    }//GEN-LAST:event_JTConsultaQuestoesMouseClicked

    private void ComboxDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboxDisciplinaActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_ComboxDisciplinaActionPerformed

    private void ComboxDisciplinaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ComboxDisciplinaAncestorAdded
        // TODO add your handling code here:

        DisciplinaDAO dao = new DisciplinaDAO();
        List<Disciplina> lista = dao.read();
        //Abaixo remove para nao constar dados duplicados
        ComboxDisciplina.removeAll();
        for (Disciplina d : lista) {
            ComboxDisciplina.addItem(d);
        }
    }//GEN-LAST:event_ComboxDisciplinaAncestorAdded

    private void cbCursoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbCursoAncestorAdded

        CursoDAO dao = new CursoDAO();
        List<Curso> list = dao.read();
        //Abaixo remove para nao constar dados duplicados
        cbCurso.removeAll();
        for (Curso c : list) {
            cbCurso.addItem(c);
        }
    }//GEN-LAST:event_cbCursoAncestorAdded

    private void rbtDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDActionPerformed
        // TODO add your handling code here:
        alternativa_correta = "D";
    }//GEN-LAST:event_rbtDActionPerformed

    private void rbtEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEActionPerformed
        // TODO add your handling code here:
        alternativa_correta = "E";
    }//GEN-LAST:event_rbtEActionPerformed

    private void rbtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCActionPerformed
        // TODO add your handling code here:
        alternativa_correta = "C";
    }//GEN-LAST:event_rbtCActionPerformed

    private void rbtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBActionPerformed
        // TODO add your handling code here:
        alternativa_correta = "B";
    }//GEN-LAST:event_rbtBActionPerformed

    private void rbtAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtAActionPerformed
        // TODO add your handling code here:
        alternativa_correta = "A";
    }//GEN-LAST:event_rbtAActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        if (JTConsultaQuestoes.getSelectedRow() != -1) {

            Questoes q = new Questoes();
            QuestoesDAO dao = new QuestoesDAO();

            q.setCod_questao((int) JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 0));
            try {
                
                
                dao.delete(q);
            } catch (SQLException ex) {
                Logger.getLogger(TelaQuestao.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtAno.setText("");
            txtNumQquestao.setText("");
            txtEnunciado.setText("");
            txtObvervacao.setText("");
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            txtD.setText("");
            txtE.setText("");
            readJTable();
            
             } else {
            JOptionPane.showMessageDialog(null, "Selecione uma questão para excluir!.");
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtAlterarActionPerformed
        // TODO add your handling code here:
        if (JTConsultaQuestoes.getSelectedRow() != -1) {

            Questoes q = new Questoes();
            Disciplina obj_disciplina = new Disciplina();
            Curso obj_curso = new Curso();

            QuestoesDAO dao = new QuestoesDAO();

            q.setAno(Integer.parseInt(txtAno.getText()));

            //Recebe os dados do Combobox
            obj_curso = (Curso) cbCurso.getSelectedItem();
            q.setCurso(obj_curso);

            //Recebe os dados do Combobox Disciplina
            obj_disciplina = (Disciplina) ComboxDisciplina.getSelectedItem();
            q.setDisciplina(obj_disciplina);
            
            q.setDisciplina_opc1(txtDisciplina1.getText());
            q.setDisciplina_opc2(txtDisciplina2.getText());

            q.setN_questao(Integer.parseInt(txtNumQquestao.getText()));
            q.setTipo(tipo);
            //Abaixo para inserção da imagem
            q.setImagem(imagem);

            q.setDificuldade(dificuldade);
            q.setEnunciado(txtEnunciado.getText());
            q.setPadrao_resposta_disc(txtPadraoDiscursiva.getText());
            q.setObvervacao(txtObvervacao.getText());
            q.setA(txtA.getText());
            q.setB(txtB.getText());
            q.setC(txtC.getText());
            q.setD(txtD.getText());
            q.setE(txtE.getText());
            q.setAlternativa_correta(alternativa_correta);

            q.setCod_questao((int) JTConsultaQuestoes.getValueAt(JTConsultaQuestoes.getSelectedRow(), 0));
            dao.update(q);

            txtAno.setText("");
            txtNumQquestao.setText("");
            txtEnunciado.setText("");
            txtObvervacao.setText("");
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            txtD.setText("");
            txtE.setText("");
            readJTable();
         
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma disciplina para edição!.");
        
        }
    }//GEN-LAST:event_tbtAlterarActionPerformed

    private void txtEnunciadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnunciadoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnunciadoFocusLost

    private void txtEnunciadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnunciadoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnunciadoFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        LimparCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rbtDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDificilActionPerformed
        // TODO add your handling code here:
        dificuldade = "Difícil";

    }//GEN-LAST:event_rbtDificilActionPerformed

    private void rbtMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMedioActionPerformed
        // TODO add your handling code here:
        dificuldade = "Médio";
    }//GEN-LAST:event_rbtMedioActionPerformed

    private void rbtFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFacilActionPerformed
        // TODO add your handling code here:
        dificuldade = "Fácil";
    }//GEN-LAST:event_rbtFacilActionPerformed

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        try {

            if (txtAno.getText().equals("") || txtNumQquestao.getText().equals("") || txtEnunciado.getText().equals("")) {
                JOptionPane.showMessageDialog(jPanelQuestoes, "Preencha todos os campos obrigatórios!");
                return;
            }
 

            Questoes q = new Questoes();
            Disciplina obj_disciplina = new Disciplina();
            Curso obj_curso = new Curso();

            QuestoesDAO dao = new QuestoesDAO();

            q.setAno(Integer.parseInt(txtAno.getText()));

            //Recebe os dados do Combobox
            obj_curso = (Curso) cbCurso.getSelectedItem();
            q.setCurso(obj_curso);

            //Recebe os dados do Combobox Disciplina
            obj_disciplina = (Disciplina) ComboxDisciplina.getSelectedItem();
            q.setDisciplina(obj_disciplina);

            q.setDisciplina_opc1(txtDisciplina1.getText());
            q.setDisciplina_opc2(txtDisciplina2.getText());

            q.setN_questao(Integer.parseInt(txtNumQquestao.getText()));
            q.setTipo(tipo);
            //Abaixo para inserção da imagem 
            //BufferedImage image = null;
            
            q.setImagem(imagem);
            //q.setImagem(ManipularImagem.getImgBytes(imagem));
           
            //Fim insercão imagem
            q.setDificuldade(dificuldade);
            q.setEnunciado(txtEnunciado.getText());
            q.setPadrao_resposta_disc(txtPadraoDiscursiva.getText());
            q.setObvervacao(txtObvervacao.getText());
            q.setA(txtA.getText());
            q.setB(txtB.getText());
            q.setC(txtC.getText());
            q.setD(txtD.getText());
            q.setE(txtE.getText());
            q.setAlternativa_correta(alternativa_correta);

            dao.create(q);
            txtAno.setText("");
            txtNumQquestao.setText("");
            txtObvervacao.setText("");
            txtEnunciado.setText("");
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            txtD.setText("");
            txtE.setText("");

            readJTable();

            JOptionPane.showMessageDialog(null, "Questão Salvo com sucesso!");

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar, Tente novamente ou consulte o administrador do sistema!");
        } catch (Exception ex) {
            Logger.getLogger(TelaQuestao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ReadTableForCurso(txtCursoFiltro.getText());
        
           int cont = 0;
        for (int i = 0; i < JTConsultaQuestoes.getRowCount(); i++) {
            if (JTConsultaQuestoes.getValueAt(i, 1).toString().equals("Concluida"));
            cont++;
        } 
       txtTotal.setText("Quantidade de dados Listados: " + Integer.toString(cont));
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosActionPerformed
        // TODO add your handling code here:
        ReadTableListandoTodos();
        
         int cont = 0;
        for (int i = 0; i < JTConsultaQuestoes.getRowCount(); i++) {
            if (JTConsultaQuestoes.getValueAt(i, 1).toString().equals("Concluida"));
            cont++;
        } 
       txtTotal.setText("Quantidade de dados Listados: " + Integer.toString(cont));
        

    }//GEN-LAST:event_btnListarTodosActionPerformed

    private void txtDisciplina1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisciplina1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisciplina1ActionPerformed

    private void radioDiscursivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDiscursivaActionPerformed
        // TODO add your handling code here:
        tipo = "Discursiva";

        txtPadraoDiscursiva.setEnabled(true);

        txtA.setEnabled(false);
        txtB.setEnabled(false);
        txtC.setEnabled(false);
        txtD.setEnabled(false);
        txtE.setEnabled(false);
        rbtA.setEnabled(false);
        rbtB.setEnabled(false);
        rbtC.setEnabled(false);
        rbtD.setEnabled(false);
        rbtE.setEnabled(false);
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtD.setText("");
        txtE.setText("");


    }//GEN-LAST:event_radioDiscursivaActionPerformed

    private void radioObjetivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioObjetivaActionPerformed
        // TODO add your handling code here:
        tipo = "Objetiva";
        txtPadraoDiscursiva.setEnabled(false);
        txtPadraoDiscursiva.setText("");

        txtA.setEnabled(true);
        txtB.setEnabled(true);
        txtC.setEnabled(true);
        txtD.setEnabled(true);
        txtE.setEnabled(true);
        rbtA.setEnabled(true);
        rbtB.setEnabled(true);
        rbtC.setEnabled(true);
        rbtD.setEnabled(true);
        rbtE.setEnabled(true);

    }//GEN-LAST:event_radioObjetivaActionPerformed

    private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagemActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        //lblImagem.setIcon(new ImageIcon(f.toString()));
        filename = f.getAbsolutePath();
        lbldiretorio.setText(filename);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH));
        lblImagem.setIcon(imageIcon);
        


        try {

            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            imagem = bos.toByteArray();

        } catch (Exception e) {
            System.out.println("erro imagem" + e);
        }


    }//GEN-LAST:event_btnImagemActionPerformed

    private void lblImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagemMouseClicked
        // TODO add your handling code here:
        /*
            int i = JTConsultaQuestoes.getSelectedRow();
            ImageIcon image1 = (ImageIcon) JTConsultaQuestoes.getValueAt(i, 8);
            Image image2 = image1.getImage().getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image3 = new ImageIcon(image2);
            lblImagem.setIcon(image3);
        */
    }//GEN-LAST:event_lblImagemMouseClicked

    private void btnPesquisarDificuldade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarDificuldade1ActionPerformed
        // TODO add your handling code here:
        readJTabbleForDificuldade(txtDificuldadeFiltro.getText());
        
           int cont = 0;
        for (int i = 0; i < JTConsultaQuestoes.getRowCount(); i++) {
            if (JTConsultaQuestoes.getValueAt(i, 1).toString().equals("Concluida"));
            cont++;
        } 
       txtTotal.setText("Quantidade de dados Listados: " + Integer.toString(cont));
    }//GEN-LAST:event_btnPesquisarDificuldade1ActionPerformed

    private void txtAnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoKeyReleased
        // TODO add your handling code here:
        txtAno.setText(txtAno.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_txtAnoKeyReleased

    private void txtNumQquestaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumQquestaoKeyReleased
       txtNumQquestao.setText(txtNumQquestao.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_txtNumQquestaoKeyReleased

    private void LimparCampos() {
        txtAno.setText("");
        txtCodigo.setText("");
        txtNumQquestao.setText("");
        txtEnunciado.setText("");
        txtObvervacao.setText("");
        txtDisciplina1.setText("");
        txtDisciplina2.setText("");
        txtPadraoDiscursiva.setText("");
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtD.setText("");
        txtE.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRelatorio;
    private javax.swing.JComboBox ComboxDisciplina;
    private javax.swing.JTable JTConsultaQuestoes;
    private javax.swing.JLabel alternativa_correta_label;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImagem;
    private javax.swing.JButton btnLimparFiltros;
    private javax.swing.JButton btnListarFiltrarTodos;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnPesquisarAno;
    private javax.swing.JButton btnPesquisarDificuldade1;
    private javax.swing.JButton btnPesquisarDisciplina;
    private javax.swing.JButton btnPesquisarTipo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cbCurso;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelQuestoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTextField lbldiretorio;
    private javax.swing.JRadioButton radioDiscursiva;
    private javax.swing.JRadioButton radioObjetiva;
    private javax.swing.JRadioButton rbtA;
    private javax.swing.JRadioButton rbtB;
    private javax.swing.JRadioButton rbtC;
    private javax.swing.JRadioButton rbtD;
    private javax.swing.JRadioButton rbtDificil;
    private javax.swing.JRadioButton rbtE;
    private javax.swing.JRadioButton rbtFacil;
    private javax.swing.JRadioButton rbtMedio;
    private javax.swing.JButton tbtAlterar;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAnofinal;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCursoFiltro;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextField txtDificuldadeFiltro;
    private javax.swing.JTextField txtDisciplina1;
    private javax.swing.JTextField txtDisciplina2;
    private javax.swing.JTextField txtDisciplinaFiltro;
    private javax.swing.JTextField txtE;
    private javax.swing.JTextPane txtEnunciado;
    private javax.swing.JTextField txtNumQquestao;
    private javax.swing.JTextArea txtObvervacao;
    private javax.swing.JTextArea txtPadraoDiscursiva;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JTextField txtanoInicio;
    // End of variables declaration//GEN-END:variables


    
}
