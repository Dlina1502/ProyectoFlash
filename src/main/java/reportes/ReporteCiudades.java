/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import conexion_y_funciones.Funciones;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.util.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Usuario
 */
public class ReporteCiudades extends JFrame{
    
    private Funciones funcion = new Funciones();
    
    public ReporteCiudades (String nombreVentana, int anio){
        super(nombreVentana);
        JFreeChart barras = ChartFactory.createBarChart("Top 5 ciudades de destino ", "Ciudades de destino", "Número de envíos", crearDataset(anio), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barras);
        chartPanel.setPreferredSize(new Dimension (560,367));
        setContentPane(chartPanel);
    }
    
    private CategoryDataset crearDataset(int anio){
        
        ArrayList<String> ciudades = new ArrayList<>();
        ArrayList<Integer> ventas = new ArrayList<>();
        
        int venta = 0;
        String ciudad = "";
        funcion.consultaTopCiudadDestino(ciudades, ventas);
              
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0; i< ventas.size(); i++){
            venta = ventas.get(i);
            ciudad = ciudades.get(i);
            dataset.addValue(venta, ciudad, "Ciudades de destino más comunes");
        }
        
        return dataset;
    }
}
