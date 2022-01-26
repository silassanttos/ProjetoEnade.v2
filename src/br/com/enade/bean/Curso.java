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
public class Curso {
    
    private int cod_curso;
    private String nome_curso;

    public Curso(){
        //Construtor padrão
    }
    
    
    public Curso(int cod_curso, String nome_curso) {
        this.cod_curso = cod_curso;
        this.nome_curso = nome_curso;
    }

    public int getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(int cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    @Override
    public String toString() {
        return this.getNome_curso();
    }
    
    
}
