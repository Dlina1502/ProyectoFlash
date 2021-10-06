/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flash_project;


import conexion_y_funciones.*;
import interfaz.JFrame_gerente;
import interfaz.JFrame_operador;
import interfaz.JFrame_inicio;
import interfaz.JFrame_secretaria;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;




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

        
        
        
        //new JFrame_inicio().setVisible(true);
        new JFrame_operador().setVisible(true);
    }

    
}
