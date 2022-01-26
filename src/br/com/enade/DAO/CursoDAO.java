/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enade.DAO;

import br.com.enade.bean.Curso;
import br.com.enade.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author silas
 */
public class CursoDAO {
   public void create(Curso p) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO curso (NOME_CURSO)VALUES(?)");
            //stmt.setInt(1, p.getCod_curso());
            stmt.setString(1, p.getNome_curso());

            stmt.executeUpdate();
             
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

   
   
   
   
   public List<Curso> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Curso> cursos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM CURSO ORDER BY NOME_CURSO");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Curso curso = new Curso();

                curso.setCod_curso(rs.getInt("cod_curso"));
                curso.setNome_curso(rs.getString("nome_curso"));
      
                cursos.add(curso);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cursos;

    }
   
   
   
   
   
   
   public List<Curso> readForDesc(String Nome) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Curso> cursos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM curso WHERE Nome_curso LIKE ?");
            stmt.setString(1, "%"+Nome+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Curso curso = new Curso();

                curso.setCod_curso(rs.getInt("cod_curso"));
                curso.setNome_curso(rs.getString("nome_curso"));
                cursos.add(curso);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cursos;

    }
   
   
   
   
   

    public void update(Curso c) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE curso SET Nome_curso = ? WHERE Cod_curso = ?");
            stmt.setString(1, c.getNome_curso());
            stmt.setInt(2, c.getCod_curso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
    
    
    public void delete(Curso c) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
            int confirm =  JOptionPane.showConfirmDialog(null, "Certeza que deseja excluir este ítem?", "Excluir", JOptionPane.YES_NO_OPTION);
            if(confirm ==JOptionPane.YES_OPTION){
              stmt = con.prepareStatement("DELETE FROM curso WHERE cod_curso = ?");

        try {
            
            stmt.setInt(1, c.getCod_curso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: \n 'Curso escolhido para exclusão esta tendo referência no cadastro de questões ou disciplina, verifique e tente novamente!'");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        }
   }
}
