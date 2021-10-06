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
import interfaz.Factura;
import interfaz.Ventanafactura;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.WindowConstants;
import reportes.ReporteAnualVentas;
import reportes.ReporteCiudades;
import reportes.ReporteEmpleadosSede;
import reportes.ReporteVentaSedes;




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
        /*ReporteAnualVentas reporte = new ReporteAnualVentas ("Reporte 1", 2021);
        reporte.setSize(800, 400);
        reporte.setLocationRelativeTo(null);
        reporte.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        reporte.setVisible(true);*/
                
        //new JFrame_inicio().setVisible(true);
        new JFrame_inicio().setVisible(true);
    }

    
}
