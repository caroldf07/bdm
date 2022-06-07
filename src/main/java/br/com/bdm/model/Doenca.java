package br.com.bdm.model;

public class Doenca {

    //TODO:Alterar no diagrama de classe
    private int id;

    private String nome;

    public Doenca(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
