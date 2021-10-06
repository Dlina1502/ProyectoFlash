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
 * Clase creada para generar reporte mensual de las ventas 
 * @author Usuario
 */
public class ReporteVentaSedes extends JFrame{
    public ReporteVentaSedes (String nombreVentana, String anio){
        super(nombreVentana);
        JFreeChart torta = ChartFactory.createPieChart("Ventas por sede durante el año "+anio, createDataset(), true, true, false);
    }
    
    private CategoryDataset crearDataset(int anio){
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        
        return dataset;
    }
    
}
