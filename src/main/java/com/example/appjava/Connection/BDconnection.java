package com.example.appjava.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BDconnection {
//la coneccion
    private static final String URL = "jdbc:postgresql://localhost:5432/server";
    private static final String USER = "postgres";
    private static final String CLAVE = "241319";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null){
            try{
                connection = DriverManager.getConnection(URL,USER,CLAVE);
                System.out.println("coneccion creada correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

}
