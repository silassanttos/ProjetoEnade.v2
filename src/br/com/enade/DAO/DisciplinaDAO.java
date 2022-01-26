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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author silas
 */
public class DisciplinaDAO {
    
    
    
    
    
     public void create(Disciplina d) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO DISCIPLINA (NOME_DISCIPLINA,COD_CURSO)VALUES(?,?)");
            //stmt.setInt(1, p.getCod_curso());
            stmt.setString(1, d.getNome_disciplina());
            
            stmt.setInt(2, d.getCurso().getCod_curso());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

   
   
   
   
   public List<Disciplina> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Disciplina> disciplinas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT d.COD_DISCIPLINA , d.NOME_DISCIPLINA, c.NOME_CURSO FROM  DISCIPLINA AS d JOIN  CURSO AS c on(d.COD_CURSO = c.COD_CURSO) ORDER BY d.NOME_DISCIPLINA ");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Disciplina disciplina = new Disciplina();
                Curso c = new Curso();
                

                disciplina.setCod_disciplina(rs.getInt("d.cod_disciplina"));
                disciplina.setNome_disciplina(rs.getString("d.nome_disciplina"));
                c.setNome_curso(rs.getString("c.NOME_CURSO"));
                
                disciplina.setCurso(c);
                

                disciplinas.add(disciplina);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return disciplinas;

    }
   
   
   
   
   
   
   public List<Disciplina> readForDesc(String Nome) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Disciplina> disciplinas = new ArrayList<>();

        try {
            
            stmt = con.prepareStatement("SELECT d.COD_DISCIPLINA , d.NOME_DISCIPLINA, c.NOME_CURSO FROM  DISCIPLINA AS d LEFT JOIN  CURSO AS c on d.COD_CURSO = c.COD_CURSO WHERE Nome_disciplina LIKE ? ORDER BY d.NOME_DISCIPLINA;");
            stmt.setString(1, "%"+Nome+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Disciplina disciplina = new Disciplina();
                Curso c = new Curso();
                
                disciplina.setCod_disciplina(rs.getInt("d.COD_DISCIPLINA"));
                disciplina.setNome_disciplina(rs.getString("d.NOME_DISCIPLINA"));
                c.setNome_curso(rs.getString("c.NOME_CURSO"));
                disciplina.setCurso(c);
                
  
       
                disciplinas.add(disciplina);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return disciplinas;

    }
   
   
   
   
   

    public void update(Disciplina c) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE disciplina SET Nome_disciplina = ?, COD_CURSO = ? WHERE Cod_disciplina = ?");
            stmt.setString(1, c.getNome_disciplina());
            stmt.setInt(2, c.getCurso().getCod_curso());
            stmt.setInt(3, c.getCod_disciplina());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
    
    
    public void delete(Disciplina d) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
    int confirm =  JOptionPane.showConfirmDialog(null, "Certeza que deseja excluir este ítem?", "Excluir", JOptionPane.YES_NO_OPTION);
            if(confirm ==JOptionPane.YES_OPTION){
                   stmt = con.prepareStatement("DELETE FROM DISCIPLINA WHERE cod_disciplina = ?");
        try {
         
            stmt.setInt(1, d.getCod_disciplina());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: \n 'Disciplina desejada esta tendo referência no cadastro de questões, verifique e tente novamente!'");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    }
}
