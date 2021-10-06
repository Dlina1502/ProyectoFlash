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

/**
 * Clase creada para generar reporte mensual de las ventas 
 * @author Usuario
 */
public class ReporteVentaSedes extends JFrame{
    public ReporteVentaSedes (String nombreVentana, String año){
        super(nombreVentana);
        //JFreeChart barras = ChartFactory.createBarChart("Ventas del año "+año, "Ventas", "Meses", crearDataset(), PlotOrientation.VERTICAL, true, true, false);
    }
    
}
