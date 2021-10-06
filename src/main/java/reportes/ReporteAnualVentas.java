/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import conexion_y_funciones.Funciones;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Clase creada para generar reporte anual en forma de gráfico de barras
 * @author Usuario
 */
public class ReporteAnualVentas extends JFrame{
    private Funciones funcion = new Funciones();
    /**
    * Constructor
    */
    public ReporteAnualVentas (String nombreVentana, int anio){
        super(nombreVentana);
        JFreeChart barras = ChartFactory.createBarChart("Ventas del año "+anio, "Ventas", "Meses", crearDataset(anio), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barras);
        chartPanel.setPreferredSize(new Dimension (560,367));
        setContentPane(chartPanel);
    }
    
    private CategoryDataset crearDataset(int anio){
        int en = 0, feb = 0, mar=0, abr=0, may=0, jun=0, jul=0, ag=0, sep=0, oct=0, nov=0, dic=0;
        int[][] ventasPorMes = new int[12][1];
        
        funcion.consultaVentasMeses(ventasPorMes, anio);
        
        en = ventasPorMes[0][0];
        feb = ventasPorMes[1][0];
        mar = ventasPorMes[2][0];
        abr = ventasPorMes[3][0];
        may = ventasPorMes[4][0];
        jun = ventasPorMes[5][0];
        jul = ventasPorMes[6][0];
        ag = ventasPorMes[7][0];
        sep = ventasPorMes[8][0];
        oct = ventasPorMes[9][0];
        nov = ventasPorMes[10][0];
        dic = ventasPorMes[11][0];
      
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
        
        dataset.addValue(en, escala1, "Ventas por mes");
        dataset.addValue(feb, escala2, "Ventas por mes");
        dataset.addValue(mar, escala3, "Ventas por mes");
        dataset.addValue(abr, escala4, "Ventas por mes");
        dataset.addValue(may, escala5, "Ventas por mes");
        dataset.addValue(jun, escala6, "Ventas por mes");
        dataset.addValue(jul, escala7, "Ventas por mes");
        dataset.addValue(ag, escala8, "Ventas por mes");
        dataset.addValue(sep, escala9, "Ventas por mes");
        dataset.addValue(oct, escala10, "Ventas por mes");
        dataset.addValue(nov, escala11, "Ventas por mes");
        dataset.addValue(dic, escala12, "Ventas por mes");
        
        return dataset;
    }
}
