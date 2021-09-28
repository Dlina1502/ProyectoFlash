/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flash_project;


import conexion_y_funciones.*;
import interfaz.JFrame_inicio;
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
        Funciones gerente = new Funciones();
        String aux;
        //aux = gerente.registrarUsuario("10050364890", "brisas","gerente","activo", "santiago","hincapie", "","3158870896","niidea@hotmail.com", "pirimpampa");
        //gerente.login("niidea@hotmail.com", "pirimpampa");
        //aux = gerente.get_rol();
        //gerente.registrarUsuario("1648977", "brisas", "gerente","activo", "esteban", "lopez", "", "318244", "espar@hotmail.es", "fajfoidajf");
        //System.out.println(aux);
        
         new JFrame_inicio().setVisible(true);
    }

    
}
