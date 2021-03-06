/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import br.com.enade.DAO.CursoDAO;
import br.com.enade.bean.Curso;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author silas
 */
public class TelaCurso extends javax.swing.JInternalFrame {
    
    
    
    /**
     * Creates new form TelaCadastroCurso
     */
   
    public TelaCurso() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTCursos.getModel();
        jTCursos.setRowSorter(new TableRowSorter(modelo));
        txtCod_curso.setEditable(false); //Codigo em desabled, cinza.
        readJTable();
        
    }

    public void readJTable() {
        
        DefaultTableModel modelo = (DefaultTableModel) jTCursos.getModel();
        modelo.setNumRows(0);
        CursoDAO pdao = new CursoDAO();

        for (Curso c : pdao.read()) {

            modelo.addRow(new Object[]{
                c.getCod_curso(),
                c.getNome_curso()
            });

        }

    }

    
    
     public void readJTableForDesc(String Nome) {
        
        DefaultTableModel modelo = (DefaultTableModel) jTCursos.getModel();
        modelo.setNumRows(0);
        CursoDAO pdao = new CursoDAO();

        for (Curso c : pdao.readForDesc(Nome)) {

            modelo.addRow(new Object[]{
                c.getCod_curso(),
                c.getNome_curso()
            });

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCod_curso = new javax.swing.JTextField();
        txtNome_curso = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        BtnSair = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCursos = new javax.swing.JTable();
        txtListar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        lblMensagem = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro Curso");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("NOME");

        jLabel3.setText("C??DIGO");

        txtCod_curso.setBackground(new java.awt.Color(204, 204, 204));
        txtCod_curso.setCaretColor(new java.awt.Color(102, 102, 102));
        txtCod_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_cursoActionPerformed(evt);
            }
        });

        txtNome_curso.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNome_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome_cursoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/add.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/application_form_delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/application_form.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        BtnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/stop.png"))); // NOI18N
        BtnSair.setText("Sair");
        BtnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSairActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/application_edit.png"))); // NOI18N
        btnAlterar.setText("Editar");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jTCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C??digo", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCursosMouseClicked(evt);
            }
        });
        jTCursos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCursosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTCursos);
        if (jTCursos.getColumnModel().getColumnCount() > 0) {
            jTCursos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTCursos.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        jLabel5.setText("Pesquisar Curso:");

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/images/application_form_magnify.png"))); // NOI18N
        btnListar.setText("Buscar");
        btnListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCod_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(10, 10, 10)
                                    .addComponent(txtListar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnListar))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnNovo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnSalvar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAlterar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMensagem)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar)
                            .addComponent(btnAlterar)
                            .addComponent(btnExcluir)
                            .addComponent(BtnSair))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnListar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(500, 115, 565, 555);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //B??tao Salvar
        
        try {
            if(txtNome_curso.getText().equals("")){
                JOptionPane.showMessageDialog(jTCursos,"Preencha o campo nome!");
                return;
            }
            
        Curso c = new Curso();
        CursoDAO dao = new CursoDAO();

        
        c.setNome_curso(txtNome_curso.getText());
        dao.create(c);

        txtCod_curso.setText("");
        txtNome_curso.setText("");

        readJTable();

        //LimparCampos(); //Ap??s cadastrar, M??todo chamado para limpar os campos.
        
        lblMensagem.setText("Curso salvo com Sucesso!");
            
        } catch (HeadlessException e) {
           lblMensagem.setText("Erro ao salvar, Tente Novamente!");
        } catch (Exception ex) {
            Logger.getLogger(TelaCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtNome_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome_cursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome_cursoActionPerformed

    private void txtCod_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_cursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCod_cursoActionPerformed

    private void BtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSairActionPerformed
        // TODO add your handling code here:
       // TelaPrincipal.cadastro=false;
        dispose();
        
    }//GEN-LAST:event_BtnSairActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
   
        
           if (jTCursos.getSelectedRow() != -1) {
               
               Curso c = new Curso();
               CursoDAO dao = new CursoDAO();
               
               c.setNome_curso(txtNome_curso.getText());
               
               
               c.setCod_curso((int) jTCursos.getValueAt(jTCursos.getSelectedRow(), 0));
               dao.update(c);
                    txtCod_curso.setText("");
                    txtNome_curso.setText("");
                    readJTable();
                     } else {
            JOptionPane.showMessageDialog(null, "Selecione um curso para edit??lo!.");
        }
         
 
    }//GEN-LAST:event_btnAlterarActionPerformed
    
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        
        
       //TelaPrincipal.cadastro= true; //Tornando a variavel verdadeira, quando clicar em submenu para abrir uma s?? tela.
       
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
      //Limpeza do button NOVO CURSO, M??todo chama para limpeza dos campos. 
      
      LimparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        
     readJTableForDesc(txtListar.getText());
     
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        
         if (jTCursos.getSelectedRow() != -1) {

            Curso c = new Curso();
            CursoDAO dao = new CursoDAO();

            c.setCod_curso((int) jTCursos.getValueAt(jTCursos.getSelectedRow(), 0));
            
             try {
                 dao.delete(c);
             } catch (SQLException ex) {
                 Logger.getLogger(TelaCurso.class.getName()).log(Level.SEVERE, null, ex);
             }

            txtCod_curso.setText("");
            txtNome_curso.setText("");

            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um curso para excluir.");
        }
         
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTCursosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCursosKeyReleased
        // TODO add your handling code here:
         if (jTCursos.getSelectedRow() != -1) {

            txtNome_curso.setText(jTCursos.getValueAt(jTCursos.getSelectedRow(), 1).toString());
        }
        
    }//GEN-LAST:event_jTCursosKeyReleased

    private void jTCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCursosMouseClicked
        // TODO add your handling code here:
        if (jTCursos.getSelectedRow() != -1) {

            txtNome_curso.setText(jTCursos.getValueAt(jTCursos.getSelectedRow(), 1).toString());
        }
        
    }//GEN-LAST:event_jTCursosMouseClicked
private void LimparCampos(){
    txtNome_curso.setText("");
      txtCod_curso.setText(null);
      txtNome_curso.setText(null);
      txtListar.setText(null);
      

      
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSair;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCursos;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JTextField txtCod_curso;
    private javax.swing.JTextField txtListar;
    private javax.swing.JTextField txtNome_curso;
    // End of variables declaration//GEN-END:variables

    private void addRow(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
