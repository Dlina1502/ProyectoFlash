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
public class ReporteAnual extends JFrame{
    private Funciones funcion = new Funciones();
    /**
    * Constructor
    */
    public ReporteAnual (String nombreVentana, int anio){
        super(nombreVentana);
        JFreeChart barras = ChartFactory.createBarChart("Envíos del año "+anio, "Meses", "Total ventas por mes", crearDataset(anio), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barras);
        chartPanel.setPreferredSize(new Dimension (560,367));
        setContentPane(chartPanel);
    }
    
    private CategoryDataset crearDataset(int anio){
        int en = 0, feb = 0, mar=0, abr=0, may=0, jun=0, jul=0, ag=0, sep=0, oct=0, nov=0, dic=0;
        int[][] enviosPorMes = new int[12][1];
        
        funcion.consultaEnviosMeses(enviosPorMes, anio);
        
        en = enviosPorMes[0][0];
        feb = enviosPorMes[1][0];
        mar = enviosPorMes[2][0];
        abr = enviosPorMes[3][0];
        may = enviosPorMes[4][0];
        jun = enviosPorMes[5][0];
        jul = enviosPorMes[6][0];
        ag = enviosPorMes[7][0];
        sep = enviosPorMes[8][0];
        oct = enviosPorMes[9][0];
        nov = enviosPorMes[10][0];
        dic = enviosPorMes[11][0];
      
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
        
        dataset.addValue(en, escala1, "Envíos por mes");
        dataset.addValue(feb, escala2, "Envíos por mes");
        dataset.addValue(mar, escala3, "Envíos por mes");
        dataset.addValue(abr, escala4, "Envíos por mes");
        dataset.addValue(may, escala5, "Envíos por mes");
        dataset.addValue(jun, escala6, "Envíos por mes");
        dataset.addValue(jul, escala7, "Envíos por mes");
        dataset.addValue(ag, escala8, "Envíos por mes");
        dataset.addValue(sep, escala9, "Envíos por mes");
        dataset.addValue(oct, escala10, "Envíos por mes");
        dataset.addValue(nov, escala11, "Envíos por mes");
        dataset.addValue(dic, escala12, "Envíos por mes");
        
        return dataset;
    }
}
