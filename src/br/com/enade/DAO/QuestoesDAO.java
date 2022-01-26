/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enade.DAO;

import br.com.enade.bean.Curso;
import br.com.enade.bean.Disciplina;
import br.com.enade.bean.Questoes;
import br.com.enade.util.ConnectionFactory;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


/**
 *
 * @author silas
 */
public class QuestoesDAO {

    
    private String enunciado;
    
    
    //Método criação 
        public void create(Questoes q) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO QUESTOES (ANO,COD_CURSO,COD_DISCIPLINA,DISCIPLINA_OPC1,DISCIPLINA_OPC2,N_QUESTAO,TIPO,IMAGEM,DIFICULDADE,ENUNCIADO,PADRAO_RESPOSTA_DISC,OBSERVACAO,A,B,C,D,E,ALTERNATIVA_CORRETA )VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //stmt.setInt(1, p.getCod_curso());
            stmt.setInt(1, q.getAno());
            stmt.setInt(2, q.getCurso().getCod_curso());
            stmt.setInt(3, q.getDisciplina().getCod_disciplina());
            stmt.setString(4, q.getDisciplina_opc1());
            stmt.setString(5, q.getDisciplina_opc2());
            stmt.setInt(6, q.getN_questao());
            stmt.setString(7, q.getTipo());
            stmt.setBytes(8, q.getImagem());
            stmt.setString(9, q.getDificuldade());
            stmt.setString(10, q.getEnunciado());
            stmt.setString(11, q.getPadrao_resposta_disc());
            stmt.setString(12, q.getObvervacao());
            stmt.setString(13, q.getA());
            stmt.setString(14,  q.getB());
            stmt.setString(15, q.getC());
            stmt.setString(16, q.getD());
            stmt.setString(17, q.getE());
            stmt.setString(18, q.getAlternativa_correta());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
       
    
        
        
        
        //Método para listar todos os dados
   public List<Questoes> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questoes> questoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT A.COD_QUESTAO, A.ANO, C.NOME_CURSO, B.NOME_DISCIPLINA, A.DISCIPLINA_OPC1,A.DISCIPLINA_OPC2, A.N_QUESTAO,A.TIPO, A.IMAGEM, A.DIFICULDADE, A.ENUNCIADO, A.PADRAO_RESPOSTA_DISC,A.OBSERVACAO, A.A, A.B, A.C, A.D, A.E, A.ALTERNATIVA_CORRETA  from questoes A  LEFT JOIN disciplina B ON A.COD_DISCIPLINA =  B.COD_DISCIPLINA LEFT JOIN CURSO C ON A.COD_CURSO =  C.COD_CURSO;");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Questoes questao = new Questoes();
                Curso c = new Curso();
                Disciplina d = new Disciplina();
                

                questao.setCod_questao(rs.getInt("A.COD_QUESTAO"));
                questao.setAno(rs.getInt("A.ANO"));
                
                c.setNome_curso(rs.getString("C.NOME_CURSO"));
                questao.setCurso(c);
                
                d.setNome_disciplina(rs.getString("B.NOME_DISCIPLINA"));
                questao.setDisciplina(d);
                questao.setDisciplina_opc1(rs.getString("A.DISCIPLINA_OPC1"));
                questao.setDisciplina_opc2(rs.getString("A.DISCIPLINA_OPC2"));
                questao.setN_questao(rs.getInt("A.N_QUESTAO"));
                questao.setTipo(rs.getString("A.TIPO"));
                questao.setImagem(rs.getBytes("A.IMAGEM"));
                questao.setDificuldade(rs.getString("A.DIFICULDADE"));
                questao.setEnunciado(rs.getString("A.ENUNCIADO"));
                questao.setPadrao_resposta_disc(rs.getString("A.PADRAO_RESPOSTA_DISC"));
                questao.setObvervacao(rs.getString("A.OBSERVACAO"));
                questao.setA(rs.getString("A.A"));
                questao.setB(rs.getString("A.B"));
                questao.setC(rs.getString("A.C"));
                questao.setD(rs.getString("A.D"));
                questao.setE(rs.getString("A.E"));
                questao.setAlternativa_correta(rs.getString("A.ALTERNATIVA_CORRETA"));

                questoes.add(questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return questoes;

    }

   //Metodo para alterar questoes
        public void update(Questoes q) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE questoes SET ANO=?, COD_CURSO=?,COD_DISCIPLINA=?, DISCIPLINA_OPC1=?, DISCIPLINA_OPC2=?, N_QUESTAO=?, TIPO=?, IMAGEM=?, DIFICULDADE=?, ENUNCIADO=?, PADRAO_RESPOSTA_DISC=?, OBSERVACAO=?,A=?,B=?,C=?,D=?,E=?,ALTERNATIVA_CORRETA=?  WHERE COD_QUESTAO=?");
            
            stmt.setInt(1, q.getAno());
            stmt.setInt(2, q.getCurso().getCod_curso());
            stmt.setInt(3, q.getDisciplina().getCod_disciplina());
            stmt.setString(4, q.getDisciplina_opc1());
            stmt.setString(5, q.getDisciplina_opc2());
            stmt.setInt(6, q.getN_questao());
            stmt.setString(7, q.getTipo());
            stmt.setBytes(8, q.getImagem());
            stmt.setString(9, q.getDificuldade());
            stmt.setString(10, q.getEnunciado());
            stmt.setString(11, q.getPadrao_resposta_disc());
            stmt.setString(12, q.getObvervacao());
            stmt.setString(13, q.getA());
            stmt.setString(14, q.getB());
            stmt.setString(15, q.getC());
            stmt.setString(16, q.getD());
            stmt.setString(17, q.getE());
            stmt.setString(18, q.getAlternativa_correta());
            
            
            stmt.setInt(19, q.getCod_questao());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }


        
     //Método para exclusão
    public void delete(Questoes q) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        int confirm =  JOptionPane.showConfirmDialog(null, "Certeza que deseja excluir esta questão?", "Excluir", JOptionPane.YES_NO_OPTION);
            if(confirm ==JOptionPane.YES_OPTION){
            stmt = con.prepareStatement("DELETE FROM QUESTOES WHERE COD_QUESTAO = ?");
        try {
            

            stmt.setInt(1, q.getCod_questao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Questão excluido com sucesso!");
        }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão da questão!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   }
    
        
        //Listagem por ano em intervalo
        
        public List<Questoes> readForAno(String anoInicial, String anoFinal) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questoes> questoes = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT A.COD_QUESTAO,\n" +
                                            " A.ANO,\n" +
                                            " C.NOME_CURSO,\n" +
                                            " B.NOME_DISCIPLINA,\n" +
                                            " A.DISCIPLINA_OPC1,\n" +
                                            " A.DISCIPLINA_OPC2,\n" +
                                            " A.N_QUESTAO,\n" +
                                            " A.TIPO,\n" +
                                            " A.IMAGEM,\n" +
                                            " A.DIFICULDADE,\n" +
                                            " A.ENUNCIADO,\n" +
                                            " A.PADRAO_RESPOSTA_DISC,\n" +
                                            " A.OBSERVACAO,\n" +
                                            " A.A, \n" +
                                            " A.B,\n" +
                                            " A.C,\n" +
                                            " A.D,\n" +
                                            " A.E,\n" +
                                            " A.ALTERNATIVA_CORRETA from questoes A\n" +
                                            " LEFT JOIN disciplina B ON A.COD_DISCIPLINA =  B.COD_DISCIPLINA\n" +
                                            " LEFT JOIN CURSO C ON A.COD_CURSO =  C.COD_CURSO "
                                            + "where A.ANO BETWEEN ? AND ?");
                stmt.setString(1, anoInicial);
                stmt.setString(2,anoFinal);
                rs = stmt.executeQuery();

            while (rs.next()) {

                 Questoes questao = new Questoes();
                Curso c = new Curso();
                Disciplina d = new Disciplina();
                

                questao.setCod_questao(rs.getInt("A.COD_QUESTAO"));
                questao.setAno(rs.getInt("A.ANO"));
                
                c.setNome_curso(rs.getString("C.NOME_CURSO"));
                questao.setCurso(c);
                
                d.setNome_disciplina(rs.getString("B.NOME_DISCIPLINA"));
                questao.setDisciplina(d);
                questao.setDisciplina_opc1(rs.getString("A.DISCIPLINA_OPC1"));
                questao.setDisciplina_opc2(rs.getString("A.DISCIPLINA_OPC2"));
                questao.setN_questao(rs.getInt("A.N_QUESTAO"));
                questao.setTipo(rs.getString("A.TIPO"));
                questao.setImagem(rs.getBytes("A.IMAGEM"));
                questao.setDificuldade(rs.getString("A.DIFICULDADE"));
                questao.setEnunciado(rs.getString("A.ENUNCIADO"));
                questao.setPadrao_resposta_disc(rs.getString("A.PADRAO_RESPOSTA_DISC"));
                questao.setObvervacao(rs.getString("A.OBSERVACAO"));
                questao.setA(rs.getString("A.A"));
                questao.setB(rs.getString("A.B"));
                questao.setC(rs.getString("A.C"));
                questao.setD(rs.getString("A.D"));
                questao.setE(rs.getString("A.E"));
                questao.setAlternativa_correta(rs.getString("A.ALTERNATIVA_CORRETA"));

                questoes.add(questao);
           
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return questoes;
    }
        
        
        
        //Método para setar com ReadTableForDificuldade e filtrar
        public List<Questoes> readForDificuldade(String Dificuldade) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questoes> questoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT A.COD_QUESTAO,\n" +
                                            " A.ANO,\n" +
                                            " C.NOME_CURSO,\n" +
                                            " B.NOME_DISCIPLINA,\n" +
                                            " A.DISCIPLINA_OPC1,\n" +
                                            " A.DISCIPLINA_OPC2,\n" +
                                            " A.N_QUESTAO,\n" +
                                            " A.TIPO,\n" +
                                            " A.IMAGEM,\n" +
                                            " A.DIFICULDADE,\n" +
                                            " A.ENUNCIADO,\n" +
                                            " A.PADRAO_RESPOSTA_DISC,\n" +
                                            " A.OBSERVACAO,\n" +
                                            " A.A, \n" +
                                            " A.B,\n" +
                                            " A.C,\n" +
                                            " A.D,\n" +
                                            " A.E,\n" +
                                            " A.ALTERNATIVA_CORRETA from questoes A\n" +
                                            " LEFT JOIN disciplina B ON A.COD_DISCIPLINA =  B.COD_DISCIPLINA\n" +
                                            " LEFT JOIN CURSO C ON A.COD_CURSO =  C.COD_CURSO  where A.DIFICULDADE like ?");
                stmt.setString(1, "%"+Dificuldade+"%");
                rs = stmt.executeQuery();

            while (rs.next()) {

                 Questoes questao = new Questoes();
                Curso c = new Curso();
                Disciplina d = new Disciplina();
                

                questao.setCod_questao(rs.getInt("A.COD_QUESTAO"));
                questao.setAno(rs.getInt("A.ANO"));
                
                c.setNome_curso(rs.getString("C.NOME_CURSO"));
                questao.setCurso(c);
                
                d.setNome_disciplina(rs.getString("B.NOME_DISCIPLINA"));
                questao.setDisciplina(d);
                questao.setDisciplina_opc1(rs.getString("A.DISCIPLINA_OPC1"));
                questao.setDisciplina_opc2(rs.getString("A.DISCIPLINA_OPC2"));
                questao.setN_questao(rs.getInt("A.N_QUESTAO"));
                questao.setTipo(rs.getString("A.TIPO"));
                questao.setImagem(rs.getBytes("A.IMAGEM"));
                questao.setDificuldade(rs.getString("A.DIFICULDADE"));
                questao.setEnunciado(rs.getString("A.ENUNCIADO"));
                questao.setPadrao_resposta_disc(rs.getString("A.PADRAO_RESPOSTA_DISC"));
                questao.setObvervacao(rs.getString("A.OBSERVACAO"));
                questao.setA(rs.getString("A.A"));
                questao.setB(rs.getString("A.B"));
                questao.setC(rs.getString("A.C"));
                questao.setD(rs.getString("A.D"));
                questao.setE(rs.getString("A.E"));
                questao.setAlternativa_correta(rs.getString("A.ALTERNATIVA_CORRETA"));

                questoes.add(questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return questoes;
    }
        

        
        //Método para setar com ReadTableForDisciplinaFiltro e filtrar
        public List<Questoes> ReadTableForDisciplinaFiltro(String Disciplina, String DISCIPLINA_OPC1, String DISCIPLINA_OPC2) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questoes> questoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT A.COD_QUESTAO,\n" +
                                            " A.ANO,\n" +
                                            " C.NOME_CURSO,\n" +
                                            " B.NOME_DISCIPLINA,\n" +
                                            " A.DISCIPLINA_OPC1,\n" +
                                            " A.DISCIPLINA_OPC2,\n" +
                                            " A.N_QUESTAO,\n" +
                                            " A.TIPO,\n" +
                                            " A.IMAGEM,\n" +
                                            " A.DIFICULDADE,\n" +
                                            " A.ENUNCIADO,\n" +
                                            " A.PADRAO_RESPOSTA_DISC,\n" +
                                            " A.OBSERVACAO,\n" +
                                            " A.A, \n" +
                                            " A.B,\n" +
                                            " A.C,\n" +
                                            " A.D,\n" +
                                            " A.E,\n" +
                                            " A.ALTERNATIVA_CORRETA from questoes A\n" +
                                            " LEFT JOIN disciplina B ON A.COD_DISCIPLINA =  B.COD_DISCIPLINA\n" +
                                            " LEFT JOIN CURSO C ON A.COD_CURSO =  C.COD_CURSO  where B.NOME_DISCIPLINA like ? OR A.DISCIPLINA_OPC1 like ? OR DISCIPLINA_OPC2 like ?");
                stmt.setString(1, "%"+Disciplina+"%");
                stmt.setString(2, "%"+DISCIPLINA_OPC1+"%");
                stmt.setString(3, "%"+DISCIPLINA_OPC2+"%");
                rs = stmt.executeQuery();

            while (rs.next()) {

                Questoes questao = new Questoes();
                Curso c = new Curso();
                Disciplina d = new Disciplina();
                

                questao.setCod_questao(rs.getInt("A.COD_QUESTAO"));
                questao.setAno(rs.getInt("A.ANO"));
                
                c.setNome_curso(rs.getString("C.NOME_CURSO"));
                questao.setCurso(c);
                
                d.setNome_disciplina(rs.getString("B.NOME_DISCIPLINA"));
                questao.setDisciplina(d);
                questao.setDisciplina_opc1(rs.getString("A.DISCIPLINA_OPC1"));
                questao.setDisciplina_opc2(rs.getString("A.DISCIPLINA_OPC2"));
                questao.setN_questao(rs.getInt("A.N_QUESTAO"));
                questao.setTipo(rs.getString("A.TIPO"));
                questao.setImagem(rs.getBytes("A.IMAGEM"));
                questao.setDificuldade(rs.getString("A.DIFICULDADE"));
                questao.setEnunciado(rs.getString("A.ENUNCIADO"));
                questao.setPadrao_resposta_disc(rs.getString("A.PADRAO_RESPOSTA_DISC"));
                questao.setObvervacao(rs.getString("A.OBSERVACAO"));
                questao.setA(rs.getString("A.A"));
                questao.setB(rs.getString("A.B"));
                questao.setC(rs.getString("A.C"));
                questao.setD(rs.getString("A.D"));
                questao.setE(rs.getString("A.E"));
                questao.setAlternativa_correta(rs.getString("A.ALTERNATIVA_CORRETA"));

                questoes.add(questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return questoes;
    }
        
        
        
        //Método para setar com ReadTableForFiltrarTodosCampos
        public List<Questoes> ReadTableForFiltrarTodosCampos(String Disciplina, String Ano, String Ano2, String Dificuldade , String NOME_CURSO, String Tipo) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questoes> questoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT A.COD_QUESTAO,\n" +
                                            " A.ANO,\n" +
                                            " C.NOME_CURSO,\n" +
                                            " B.NOME_DISCIPLINA,\n" +
                                            " A.DISCIPLINA_OPC1,\n" +
                                            " A.DISCIPLINA_OPC2,\n" +
                                            " A.N_QUESTAO,\n" +
                                            " A.TIPO,\n" +
                                            " A.IMAGEM,\n" +
                                            " A.DIFICULDADE,\n" +
                                            " A.ENUNCIADO,\n" +
                                            " A.PADRAO_RESPOSTA_DISC,\n" +
                                            " A.OBSERVACAO,\n" +
                                            " A.A, \n" +
                                            " A.B,\n" +
                                            " A.C,\n" +
                                            " A.D,\n" +
                                            " A.E,\n" +
                                            " A.ALTERNATIVA_CORRETA from questoes A\n" +
                                            " LEFT JOIN disciplina B ON A.COD_DISCIPLINA =  B.COD_DISCIPLINA\n" +
                                            " LEFT JOIN CURSO C ON A.COD_CURSO =  C.COD_CURSO "
                                            + " where B.NOME_DISCIPLINA like ? "
                                            + "AND C.NOME_CURSO like ? "
                                            + "and A.ANO BETWEEN ? AND ? "
                                            + "AND A.DIFICULDADE like ?"
                                            + "AND A.TIPO LIKE ?");
                stmt.setString(1, "%"+Disciplina+"%");
                stmt.setString(2, "%"+NOME_CURSO+"%");
                stmt.setString(3, Ano);
                stmt.setString(4, Ano2);
                stmt.setString(5, "%"+Dificuldade+"%");
                 stmt.setString(6, "%"+Tipo+"%");
                rs = stmt.executeQuery();

            while (rs.next()) {

                 Questoes questao = new Questoes();
                Curso c = new Curso();
                Disciplina d = new Disciplina();
                

                questao.setCod_questao(rs.getInt("A.COD_QUESTAO"));
                questao.setAno(rs.getInt("A.ANO"));
                
                c.setNome_curso(rs.getString("C.NOME_CURSO"));
                questao.setCurso(c);
                
                d.setNome_disciplina(rs.getString("B.NOME_DISCIPLINA"));
                questao.setDisciplina(d);
                questao.setDisciplina_opc1(rs.getString("A.DISCIPLINA_OPC1"));
                questao.setDisciplina_opc2(rs.getString("A.DISCIPLINA_OPC2"));
                questao.setN_questao(rs.getInt("A.N_QUESTAO"));
                questao.setTipo(rs.getString("A.TIPO"));
                questao.setImagem(rs.getBytes("A.IMAGEM"));
                questao.setDificuldade(rs.getString("A.DIFICULDADE"));
                questao.setEnunciado(rs.getString("A.ENUNCIADO"));
                questao.setPadrao_resposta_disc(rs.getString("A.PADRAO_RESPOSTA_DISC"));
                questao.setObvervacao(rs.getString("A.OBSERVACAO"));
                questao.setA(rs.getString("A.A"));
                questao.setB(rs.getString("A.B"));
                questao.setC(rs.getString("A.C"));
                questao.setD(rs.getString("A.D"));
                questao.setE(rs.getString("A.E"));
                questao.setAlternativa_correta(rs.getString("A.ALTERNATIVA_CORRETA"));

                questoes.add(questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return questoes;
    }

        
    
        //Método para setar com ReadTableForCurso e filtrar
        public List<Questoes> readForCurso(String Nome_curso) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questoes> questoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT A.COD_QUESTAO,\n" +
                                            " A.ANO,\n" +
                                            " C.NOME_CURSO,\n" +
                                            " B.NOME_DISCIPLINA,\n" +
                                            " A.DISCIPLINA_OPC1,\n" +
                                            " A.DISCIPLINA_OPC2,\n" +
                                            " A.N_QUESTAO,\n" +
                                            " A.TIPO,\n" +
                                            " A.IMAGEM,\n" +
                                            " A.DIFICULDADE,\n" +
                                            " A.ENUNCIADO,\n" +
                                            " A.PADRAO_RESPOSTA_DISC,\n" +
                                            " A.OBSERVACAO,\n" +
                                            " A.A, \n" +
                                            " A.B,\n" +
                                            " A.C,\n" +
                                            " A.D,\n" +
                                            " A.E,\n" +
                                            " A.ALTERNATIVA_CORRETA from questoes A\n" +
                                            " LEFT JOIN disciplina B ON A.COD_DISCIPLINA =  B.COD_DISCIPLINA\n" +
                                            " LEFT JOIN CURSO C ON A.COD_CURSO =  C.COD_CURSO  where C.NOME_CURSO like ?");
                stmt.setString(1, "%"+Nome_curso+"%");
                rs = stmt.executeQuery();

            while (rs.next()) {

                Questoes questao = new Questoes();
                Curso c = new Curso();
                Disciplina d = new Disciplina();
                

                questao.setCod_questao(rs.getInt("A.COD_QUESTAO"));
                questao.setAno(rs.getInt("A.ANO"));
                
                c.setNome_curso(rs.getString("C.NOME_CURSO"));
                questao.setCurso(c);
                
                d.setNome_disciplina(rs.getString("B.NOME_DISCIPLINA"));
                questao.setDisciplina(d);
                questao.setDisciplina_opc1(rs.getString("A.DISCIPLINA_OPC1"));
                questao.setDisciplina_opc2(rs.getString("A.DISCIPLINA_OPC2"));
                questao.setN_questao(rs.getInt("A.N_QUESTAO"));
                questao.setTipo(rs.getString("A.TIPO"));
                questao.setImagem(rs.getBytes("A.IMAGEM"));
                questao.setDificuldade(rs.getString("A.DIFICULDADE"));
                questao.setEnunciado(rs.getString("A.ENUNCIADO"));
                questao.setPadrao_resposta_disc(rs.getString("A.PADRAO_RESPOSTA_DISC"));
                questao.setObvervacao(rs.getString("A.OBSERVACAO"));
                questao.setA(rs.getString("A.A"));
                questao.setB(rs.getString("A.B"));
                questao.setC(rs.getString("A.C"));
                questao.setD(rs.getString("A.D"));
                questao.setE(rs.getString("A.E"));
                questao.setAlternativa_correta(rs.getString("A.ALTERNATIVA_CORRETA"));

                questoes.add(questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return questoes;
    }
        
          // código Obter foto para setar ao clicar na Jtable
      public BufferedImage obterImagem(String idQuestao){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        InputStream is = null;
        BufferedImage bimg = null;
        
        try {
            stmt = con.prepareStatement("SELECT IMAGEM FROM QUESTOES WHERE COD_QUESTAO = " + idQuestao);
            rs = stmt.executeQuery();

            while (rs.next()) {
              is = rs.getBinaryStream(1);
	      bimg = ImageIO.read(is);
            }
        
            rs.close();
	    is.close();
            
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return bimg;        
      }
      // Fim do codigo buscar imagem 
      
      
      
       //Método inicio pesquisar por filtros de tipo da questao
        public List<Questoes> ReadTableForTipo(String tipoQuestao) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questoes> questoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT A.COD_QUESTAO,\n" +
                                            " A.ANO,\n" +
                                            " C.NOME_CURSO,\n" +
                                            " B.NOME_DISCIPLINA,\n" +
                                            " A.DISCIPLINA_OPC1,\n" +
                                            " A.DISCIPLINA_OPC2,\n" +
                                            " A.N_QUESTAO,\n" +
                                            " A.TIPO,\n" +
                                            " A.IMAGEM,\n" +
                                            " A.DIFICULDADE,\n" +
                                            " A.ENUNCIADO,\n" +
                                            " A.PADRAO_RESPOSTA_DISC,\n" +
                                            " A.OBSERVACAO,\n" +
                                            " A.A, \n" +
                                            " A.B,\n" +
                                            " A.C,\n" +
                                            " A.D,\n" +
                                            " A.E,\n" +
                                            " A.ALTERNATIVA_CORRETA from questoes A\n" +
                                            " LEFT JOIN disciplina B ON A.COD_DISCIPLINA =  B.COD_DISCIPLINA\n" +
                                            " LEFT JOIN CURSO C ON A.COD_CURSO =  C.COD_CURSO  where A.TIPO like ?");
                stmt.setString(1, "%"+tipoQuestao+"%");
                rs = stmt.executeQuery();

            while (rs.next()) {

                Questoes questao = new Questoes();
                Curso c = new Curso();
                Disciplina d = new Disciplina();
                

                questao.setCod_questao(rs.getInt("A.COD_QUESTAO"));
                questao.setAno(rs.getInt("A.ANO"));
                
                c.setNome_curso(rs.getString("C.NOME_CURSO"));
                questao.setCurso(c);
                
                d.setNome_disciplina(rs.getString("B.NOME_DISCIPLINA"));
                questao.setDisciplina(d);
                questao.setDisciplina_opc1(rs.getString("A.DISCIPLINA_OPC1"));
                questao.setDisciplina_opc2(rs.getString("A.DISCIPLINA_OPC2"));
                questao.setN_questao(rs.getInt("A.N_QUESTAO"));
                questao.setTipo(rs.getString("A.TIPO"));
                questao.setImagem(rs.getBytes("A.IMAGEM"));
                questao.setDificuldade(rs.getString("A.DIFICULDADE"));
                questao.setEnunciado(rs.getString("A.ENUNCIADO"));
                questao.setPadrao_resposta_disc(rs.getString("A.PADRAO_RESPOSTA_DISC"));
                questao.setObvervacao(rs.getString("A.OBSERVACAO"));
                questao.setA(rs.getString("A.A"));
                questao.setB(rs.getString("A.B"));
                questao.setC(rs.getString("A.C"));
                questao.setD(rs.getString("A.D"));
                questao.setE(rs.getString("A.E"));
                questao.setAlternativa_correta(rs.getString("A.ALTERNATIVA_CORRETA"));

                questoes.add(questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return questoes;
    }//Fim do codigo pesquisar por filtros de caixas de texto
      
        
        
        //Método Listar todos os dados de questões
        
        public List<Questoes> readListTodos() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Questoes> questoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT A.COD_QUESTAO, A.ANO, C.NOME_CURSO, B.NOME_DISCIPLINA, A.DISCIPLINA_OPC1,A.DISCIPLINA_OPC2, A.N_QUESTAO,A.TIPO, A.IMAGEM, A.DIFICULDADE, A.ENUNCIADO, A.PADRAO_RESPOSTA_DISC,A.OBSERVACAO, A.A, A.B, A.C, A.D, A.E, A.ALTERNATIVA_CORRETA  from questoes A  LEFT JOIN disciplina B ON A.COD_DISCIPLINA =  B.COD_DISCIPLINA LEFT JOIN CURSO C ON A.COD_CURSO =  C.COD_CURSO;");
            rs = stmt.executeQuery();

            while (rs.next()) {

               Questoes questao = new Questoes();
                Curso c = new Curso();
                Disciplina d = new Disciplina();
                

                questao.setCod_questao(rs.getInt("A.COD_QUESTAO"));
                questao.setAno(rs.getInt("A.ANO"));
                
                c.setNome_curso(rs.getString("C.NOME_CURSO"));
                questao.setCurso(c);
                
                d.setNome_disciplina(rs.getString("B.NOME_DISCIPLINA"));
                questao.setDisciplina(d);
                questao.setDisciplina_opc1(rs.getString("A.DISCIPLINA_OPC1"));
                questao.setDisciplina_opc2(rs.getString("A.DISCIPLINA_OPC2"));
                questao.setN_questao(rs.getInt("A.N_QUESTAO"));
                questao.setTipo(rs.getString("A.TIPO"));
                questao.setImagem(rs.getBytes("A.IMAGEM"));
                questao.setDificuldade(rs.getString("A.DIFICULDADE"));
                questao.setEnunciado(rs.getString("A.ENUNCIADO"));
                questao.setPadrao_resposta_disc(rs.getString("A.PADRAO_RESPOSTA_DISC"));
                questao.setObvervacao(rs.getString("A.OBSERVACAO"));
                questao.setA(rs.getString("A.A"));
                questao.setB(rs.getString("A.B"));
                questao.setC(rs.getString("A.C"));
                questao.setD(rs.getString("A.D"));
                questao.setE(rs.getString("A.E"));
                questao.setAlternativa_correta(rs.getString("A.ALTERNATIVA_CORRETA"));

                questoes.add(questao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return questoes;
    }


}
