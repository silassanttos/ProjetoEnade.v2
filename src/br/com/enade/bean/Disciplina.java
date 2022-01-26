/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enade.bean;

/**
 *
 * @author silas
 */
public class Disciplina {
    private int cod_disciplina;
    private String nome_disciplina;
    private Curso curso; //chave estrangeira
 
    
    public Disciplina(){
         //Construtor padrão
    }
    
    
     public Disciplina(int cod_disciplina, String nome_disciplina,Curso curso) {
        this.cod_disciplina = cod_disciplina;
        this.nome_disciplina = nome_disciplina;
        this.curso = curso;
        
    }

     
    public int getCod_disciplina() {
        return cod_disciplina;
    }

    public void setCod_disciplina(int cod_disciplina) {
        this.cod_disciplina = cod_disciplina;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setCod_disciplina(Disciplina d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public String toString() {
        return this.getNome_disciplina();
    }
}
