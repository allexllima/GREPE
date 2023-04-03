package com.softgus.grepe.config;

import android.graphics.drawable.shapes.OvalShape;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnMySQL {
    private static Connection connection = null;
    public static String status = "Sem conexão...";

    public static java.sql.Connection initConnection() {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";                     // Driver padrão JDBC
            Class.forName(driverName).newInstance();

            String server = "HostNAME:3306";                                 // Url do servidor DB
            String db = "grepe";                                                // Nome do seu banco de dados | PARAMETRO ADICIONAL -> "bancoteste/?useSSL=false" + "?autoReconnect=true&useSSL=false"
            String url = "jdbc:mysql://" + server + "/" + db + "?zeroDateTimeBehavior=convertToNull";
            String username = "user";
            String password = "Password";

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {                                           // Testa sua conexão//
                status = ("STATUS --> Conectado com sucesso!");
            } else {
                status = ("STATUS --> Não foi possivel realizar conexão");
            }
            return connection;

        } catch (ClassNotFoundException ex) {                                   // Driver não encontrado
            System.out.println("O driver expecificado não foi encontrado." + ex);
            return null;
        } catch (SQLException ex) {                                             // Não conseguindo se conectar ao banco
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConnMySQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Config.Conn-InstantiotionException/IllegalAccessException: " + ex);
        }
        return null;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static String statusConnection() {
        return status;
    }

    public static boolean closeConnection() {
        try {
            ConnMySQL.initConnection().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection rebootConnection() {
        closeConnection();
        return ConnMySQL.initConnection();
    }

}
