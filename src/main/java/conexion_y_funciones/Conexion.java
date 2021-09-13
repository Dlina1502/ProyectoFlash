/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_y_funciones;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author esteban
 */
public class Conexion {
    
    
    public Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI("postgres://ihwrunfincatha:b603a5f71d5288afc9d0fedd4ff4c25f569466710355ba2832107e7501466b53@ec2-44-198-80-194.compute-1.amazonaws.com:5432/d2mmkatce45egp");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
        
        return DriverManager.getConnection(dbUrl, username, password);
        
    }
    
}


