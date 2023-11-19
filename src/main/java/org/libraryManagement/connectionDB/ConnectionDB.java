package org.libraryManagement.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection connection;

    public ConnectionDB(){
        String url = System.getenv("DB_URL");
        String username = System.getenv("DB_UTILISATEUR");
        String password = System.getenv("DB_MOT_DE_PASSE");
        try{
            this.connection = DriverManager.getConnection(
                    url,username,password
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

