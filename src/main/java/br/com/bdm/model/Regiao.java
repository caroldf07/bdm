package br.com.bdm.model;

public class Regiao {
    private String nome;
    //TODO:Alterar no diagrama de classe
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public Regiao(String nome) {
        this.nome = nome;
    }
}
