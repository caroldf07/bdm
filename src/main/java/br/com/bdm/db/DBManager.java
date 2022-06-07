package br.com.bdm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance;

    private DBManager() {
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }

        return instance;
    }


    public static Connection criarConexao() {
        Connection conexao;
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:15432/bdm-db?sslmode=disable",
                    "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }
}
