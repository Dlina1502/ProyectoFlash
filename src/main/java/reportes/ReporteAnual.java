/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Clase creada para generar reporte anual en forma de gráfico de barras
 * @author Usuario
 */
public class ReporteAnual extends JFrame{
    
    /**
    * Contructor
    */
    public ReporteAnual (String nombreVentana, String año){
        super(nombreVentana);
        JFreeChart barras = ChartFactory.createBarChart("Ventas del año "+año, "Ventas", "Meses", crearDataset(), PlotOrientation.VERTICAL, true, true, false);
    }
    
    private CategoryDataset crearDataset(){
        final String escala1 = "Enero";
        final String escala2 = "Febrero";
        final String escala3 = "Marzo";
        final String escala4 = "Abril";
        final String escala5 = "Mayo";
        final String escala6 = "Junio";
        final String escala7 = "Julio";
        final String escala8 = "Agosto";
        final String escala9 = "Septiembre";
        final String escala10 = "Octubre";
        final String escala11 = "Noviembre";
        final String escala12 = "Diciembre";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //hacer llamado a la base de datos para que se cuentes las ventas por mes del año que ingrese el usuario
        
        return dataset;
    }
}
