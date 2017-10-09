package br.edu.notasapp.domain;

import java.io.Serializable;

/**
 * Criado por Juan em 09/10/2017.
 */

public class Materia implements Serializable{

    /* A classe foi criada só com o objetivo de mostrar como funciona o objeto Bundle
    Fiquem livres para implementar o modelo que quiserem.
     */

    private String nome;
    private Double nota1;
    private Double nota2;

    public Materia(String nome, Double nota1, Double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }
}
