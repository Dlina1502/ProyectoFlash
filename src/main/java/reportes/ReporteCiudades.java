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
 *
 * @author Usuario
 */
public class ReporteCiudades extends JFrame{
    
    public ReporteCiudades (String nombreVentana, int anio){
        super(nombreVentana);
        JFreeChart barras = ChartFactory.createBarChart("Top 5 ciudades de destino en el año "+anio, "Ventas", "Ciudades de destino", crearDataset(anio), PlotOrientation.VERTICAL, true, true, false);
    }
    
    private CategoryDataset crearDataset(int anio){
        int ciudad1 = 0, ciudad2 = 0, ciudad3 = 0, ciudad4=0, ciudad5=0;
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        
        return dataset;
    }
}
