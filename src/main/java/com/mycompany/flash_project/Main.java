/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flash_project;


import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




/**
 *
 * @author esteban
 */
public class Main {

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, URISyntaxException {
        // TODO code application logic here
        Conexion conexion = new Conexion();
        conexion.getConnection();
        conexion.lanzar();
    }

    
}
