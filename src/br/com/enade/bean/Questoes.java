/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enade.bean;

import javax.swing.ImageIcon;

/**
 *
 * @author silas
 */
public class Questoes {
    private int cod_questao;
    private int ano;
    private Curso curso;
    private Disciplina disciplina;
    private String disciplina_opc1;
    private String disciplina_opc2;
    private int n_questao;
    private String tipo;
    private byte[] imagem;
    private String dificuldade;
    private String enunciado;
    private String padrao_resposta_disc;
    private String obvervacao;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String alternativa_correta;

        
    public Questoes(){
         //Construtor padrão
    }
 
    //Abaixo os Constutores dos atributos declarados acima 
    public Questoes(int cod_questao, int ano, Curso curso, Disciplina disciplina, String disciplina_opc1, String disciplina_opc2, int n_questao, String tipo, byte[] imagem, String dificuldade, String enunciado, String padrao_resposta_disc, String obvervacao, String a, String b, String c, String d, String e, String alternativa_correta) {
        this.cod_questao = cod_questao;
        this.ano = ano;
        this.curso = curso;
        this.disciplina = disciplina;
        this.disciplina_opc1 = disciplina_opc1;
        this.disciplina_opc2 = disciplina_opc2;
        this.n_questao = n_questao;
        this.tipo = tipo;
        this.imagem = imagem;
        this.dificuldade = dificuldade;
        this.enunciado = enunciado;
        this.padrao_resposta_disc = padrao_resposta_disc;
        this.obvervacao = obvervacao;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.alternativa_correta = alternativa_correta;
    }

    
     //Abaixo os métodos getters e setters
    public int getCod_questao() {
        return cod_questao;
    }

    public void setCod_questao(int cod_questao) {
        this.cod_questao = cod_questao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina_opc1() {
        return disciplina_opc1;
    }

    public void setDisciplina_opc1(String disciplina_opc1) {
        this.disciplina_opc1 = disciplina_opc1;
    }

    public String getDisciplina_opc2() {
        return disciplina_opc2;
    }

    public void setDisciplina_opc2(String disciplina_opc2) {
        this.disciplina_opc2 = disciplina_opc2;
    }

    public int getN_questao() {
        return n_questao;
    }

    public void setN_questao(int n_questao) {
        this.n_questao = n_questao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getImagem() {
          return imagem;
    }
    
 
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getPadrao_resposta_disc() {
        return padrao_resposta_disc;
    }

    public void setPadrao_resposta_disc(String padrao_resposta_disc) {
        this.padrao_resposta_disc = padrao_resposta_disc;
    }

    public String getObvervacao() {
        return obvervacao;
    }

    public void setObvervacao(String obvervacao) {
        this.obvervacao = obvervacao;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getAlternativa_correta() {
        return alternativa_correta;
    }

    public void setAlternativa_correta(String alternativa_correta) {
        this.alternativa_correta = alternativa_correta;
    }
    
    
    

   
}
