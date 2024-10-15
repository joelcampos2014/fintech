package br.com.fintech.factory;

import br.com.fintech.exception.ConnectionFailedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String user = "rm557289";
    private static final String password = "300998";

    public static Connection getConnection() throws SQLException, ConnectionFailedException {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
           throw new ConnectionFailedException("Falha na conexão com o banco de dados!");
        }
    }
}
