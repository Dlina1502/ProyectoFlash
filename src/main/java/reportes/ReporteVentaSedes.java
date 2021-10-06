/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import conexion_y_funciones.Funciones;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * Clase creada para generar reporte mensual de las ventas 
 * @author Usuario
 */
public class ReporteVentaSedes extends JFrame{
    private Funciones funcion = new Funciones();
    public ReporteVentaSedes (String nombreVentana, int anio){
        super(nombreVentana);
        JFreeChart torta = ChartFactory.createPieChart("Ventas por sede durante el año "+anio, createDataset(anio), true, true, false);
        ChartPanel chartPanel = new ChartPanel(torta);
        chartPanel.setPreferredSize(new Dimension (560,367));
        setContentPane(chartPanel);
    }
    
    private PieDataset createDataset(int anio){
        
        ArrayList<String> sedes = new ArrayList<>();
        ArrayList<Integer> ventas = new ArrayList<>();
        
        int venta = 0;
        String sede = "";
        funcion.consultaVentasSedes(ventas, sedes, anio);

        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(int i = 0; i< ventas.size(); i++){
            venta = ventas.get(i);
            sede = sedes.get(i);
            dataset.setValue(sede, venta);
        }
        
        return dataset;
    }
    
}
