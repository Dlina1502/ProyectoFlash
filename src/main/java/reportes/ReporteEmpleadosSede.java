/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;
import conexion_y_funciones.Funciones;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 * Clase creada para generar reporte anual en forma de gráfico de barras
 * @author Usuario
 */
public class ReporteEmpleadosSede extends JFrame {
    private Funciones funcion = new Funciones();
    /**
    * Constructor
    */
    public ReporteEmpleadosSede (String nombreVentana){
        super(nombreVentana);
        JFreeChart barras = ChartFactory.createBarChart("Empleados por sede ", "Sedes", "Número de empleados", crearDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barras);
        chartPanel.setPreferredSize(new Dimension (560,367));
        setContentPane(chartPanel);
    }
    
     private CategoryDataset crearDataset(){
        
        ArrayList<String> sedes = new ArrayList<>();
        ArrayList<Integer> numEmpleados = new ArrayList<>();
        
        int cont = 0;
        String sede = "";
        funcion.consultaEmpleadosSedes(numEmpleados, sedes);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0; i< numEmpleados.size(); i++){
            cont = numEmpleados.get(i);
            sede = sedes.get(i);
            dataset.addValue(cont, sede, "Número de empleados por sede");
        }
        
        return dataset;
     }
}
