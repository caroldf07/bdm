package br.com.bdm.dao;

import br.com.bdm.db.DBManager;
import br.com.bdm.model.*;
import br.com.bdm.view.OcorrenciaDto;

import java.sql.*;
import java.time.ZoneId;
import java.util.Objects;

public class OcorrenciaDao {
    private static final String SALVO = "Ocorrência salva com sucesso";
    private Connection connection = DBManager.criarConexao();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public String registrarOcorrencia(OcorrenciaDto ocorrenciaDto) {
        Ocorrencia ocorrencia = ocorrenciaDto.toModel();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO T_CONSULTA_OCORRENCIA" +
                    "(cd_ocorrencia, " +
                    "dt_inicio_ocorrencia, dt_fim_ocorrencia, latitude, longitude, cd_doenca, " +
                    "cd_regiao, gravidade, comorbidade) VALUES (default, ?, ?, ?, " +
                    "?, ?, ?,?, ?)");

            preparedStatement.setDate(1, Date.valueOf(ocorrencia.getDataInicio().toLocalDate()));
            preparedStatement.setDate(2, Date.valueOf(ocorrencia.getDataFim().toLocalDate()));
            preparedStatement.setDouble(3, ocorrencia.getLatitude());
            preparedStatement.setDouble(4, ocorrencia.getLongitude());
            //TODO: fazer código com a query de busca da doença
            preparedStatement.setInt(5, 1);
            //TODO: fazer código com a query de busca da região
            preparedStatement.setInt(6, 1);
            preparedStatement.setString(7, ocorrencia.getGravidade());
            preparedStatement.setString(8, ocorrencia.getComorbidade());

            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                Objects.requireNonNull(preparedStatement).close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return SALVO;
    }

    public Ocorrencia consultaOcorrencia(int id) {
        Ocorrencia ocorrencia = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM T_CONSULTA_OCORRENCIA WHERE cd_ocorrencia = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ocorrencia = new Ocorrencia(resultSet.getDate("dt_inicio_ocorrencia").toInstant()
                                                     .atZone(ZoneId.systemDefault())
                                                     .toLocalDateTime(),
                        resultSet.getDate("dt_fim_ocorrencia").toInstant()
                                 .atZone(ZoneId.systemDefault()).toLocalDateTime(),
                        resultSet.getDouble("latitude"), resultSet.getDouble("longitude"),
                        resultSet.getString("gravidade"),
                        new Doenca(resultSet.getString("cd_doenca")),
                        new Regiao(resultSet.getString("cd_regiao")),
                        resultSet.getString("comorbidade"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                Objects.requireNonNull(preparedStatement).close();
                Objects.requireNonNull(resultSet).close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return ocorrencia;
    }
}
