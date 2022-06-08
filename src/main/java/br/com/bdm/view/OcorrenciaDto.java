package br.com.bdm.view;

import br.com.bdm.model.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.bdm.script.ScriptConversaoEndereco.executarScript;

public class OcorrenciaDto {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Endereco endereco;
    private String gravidade;
    private String doenca;
    private String regiao;
    private String comorbidade;
    String path = System.getProperty("user.dir");

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
        this.converterEndereco();
        List<Coordenadas> dados = this.recuperarCoordenadas();
        String[] coordenadas = dados.get(0).toString().split(",");
        double latitude = Double.parseDouble(coordenadas[0]);
        double longitude = Double.parseDouble(coordenadas[1]);

        if (this.dataFim == null) {
            this.dataFim = this.dataInicio;
        }
        return new Ocorrencia(this.dataInicio, this.dataFim, latitude, longitude, this.gravidade,
                new Doenca(this.doenca), new Regiao(this.regiao), this.comorbidade);
    }

    private void converterEndereco() {
        criarCsv();
        executarScript();
    }

    private List<Coordenadas> recuperarCoordenadas() {
        List<Coordenadas> dados = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path +
                "\\src\\main\\resources\\coordenadas.csv"))) {
            dados = new CsvToBeanBuilder<Coordenadas>(reader).withType(Coordenadas.class).build()
                                                             .parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dados;
    }

    private void criarCsv() {
        String[] header = {"endereço"};
        String[] enderecoAConverter = {this.endereco.toString()};

        List<String[]> lista = new ArrayList<>();
        lista.add(header);
        lista.add(enderecoAConverter);

        try (CSVWriter writer = new CSVWriter(new FileWriter(path +
                "\\src\\main\\resources\\converter.csv"))) {
            writer.writeAll(lista);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
