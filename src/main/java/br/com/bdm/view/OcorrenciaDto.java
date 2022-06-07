package br.com.bdm.view;

import br.com.bdm.model.*;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OcorrenciaDto {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Endereco endereco;
    private String gravidade;
    private String doenca;
    private String regiao;
    private String comorbidade;

    public OcorrenciaDto(LocalDateTime dataInicio, LocalDateTime dataFim, Endereco endereco,
                         String gravidade, String doenca, String regiao, String comorbidade) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.endereco = endereco;
        this.gravidade = gravidade;
        this.doenca = doenca;
        this.regiao = regiao;
        this.comorbidade = comorbidade;
    }

    public OcorrenciaDto(LocalDateTime dataInicio, Endereco endereco, String gravidade,
                         String doenca,
                         String regiao, String comorbidade) {
        this.dataInicio = dataInicio;
        this.endereco = endereco;
        this.gravidade = gravidade;
        this.doenca = doenca;
        this.regiao = regiao;
        this.comorbidade = comorbidade;
    }

    public Ocorrencia toModel() {
        String coordenadas = this.converterEndereco();

        Double latitude = Double.parseDouble("0.0");
        Double longitude = Double.parseDouble("0.0");

        //TODO:Terminar de implementar a lógica da conversão

        if (this.dataFim == null) {
            this.dataFim = this.dataInicio;
        }
        return new Ocorrencia(this.dataInicio, this.dataFim, latitude, longitude, this.gravidade,
                new Doenca(this.doenca), new Regiao(this.regiao), this.comorbidade);
    }

    private String converterEndereco() {
        List<String[]> csv = criarCsv();
        try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\carol\\Desktop\\bdmv2" +
                "\\src\\main\\resources\\converter.csv"))) {
            writer.writeAll(csv);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //TODO: implementar o retorno do script com o endereco convertido em latitude e longitude
        return "";
    }

    private List<String[]> criarCsv() {
        String[] header = {"endereco"};
        String[] enderecoAConverter = {this.endereco.toString()};

        List<String[]> lista = new ArrayList<>();
        lista.add(header);
        lista.add(enderecoAConverter);
        return lista;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getGravidade() {
        return gravidade;
    }

    public String getDoenca() {
        return doenca;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getComorbidade() {
        return comorbidade;
    }
}
