package br.com.fiap.fintech.fintechgrandfinale.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String usuario = "RM556212";
    private static final String senha = "Diego#2024";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, usuario, senha);
    }
}
