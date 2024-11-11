package br.com.fiap.fintech.fintechgrandfinale.factory;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection = null;
    private static final String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String usuario = "RM557969";
    private static final String senha = "031293";

    public static Connection getConnection() throws SQLException {

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }
}
