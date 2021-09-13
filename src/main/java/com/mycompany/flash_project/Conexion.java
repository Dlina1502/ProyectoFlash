/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flash_project;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author esteban
 */
public class Conexion {
    
    private Connection con;
    
    public void getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI("postgres://ihwrunfincatha:b603a5f71d5288afc9d0fedd4ff4c25f569466710355ba2832107e7501466b53@ec2-44-198-80-194.compute-1.amazonaws.com:5432/d2mmkatce45egp");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        con = DriverManager.getConnection(dbUrl, username, password);
    }
    
    public void lanzar () throws SQLException{

        String sql = " INSERT INTO pruebas (id, tipo) VALUES (? , ?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, 6);
        statement.setString(2, "raaaaaaaaaaaam");
        
        statement.executeUpdate ();
    }
}


