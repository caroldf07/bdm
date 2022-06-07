package br.com.bdm.model;

import java.time.LocalDateTime;

public class Ocorrencia {
    private int id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    //TODO: corrigir no diagrama de classe o tipo de latitude e longitude
    private double latitude;
    private double longitude;
    private String gravidade;
    private Doenca doenca;
    private Regiao regiao;
    private String comorbidade;

    public Ocorrencia(LocalDateTime dataInicio, LocalDateTime dataFim, double latitude, double longitude, String gravidade, Doenca doenca, Regiao regiao, String comorbidade) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gravidade = gravidade;
        this.doenca = doenca;
        this.regiao = regiao;
        this.comorbidade = comorbidade;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public String getComorbidade() {
        return comorbidade;
    }

    public void setComorbidade(String comorbidade) {
        this.comorbidade = comorbidade;
    }
}
