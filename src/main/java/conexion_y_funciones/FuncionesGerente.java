/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_y_funciones;

import java.net.URISyntaxException;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author esteban
 */
public class FuncionesGerente extends Conexion{
    private Connection conexion;
    private Statement statement;
    private String sql;
    
    public FuncionesGerente(){
        
        try {
            conexion = getConnection();
            statement = conexion.createStatement();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    /*public void registrarUsuario(int cedula, String sede, String rol_empleado, 
                                String estado, String nombre, String apellido1, 
                                String apellido2, int telefono, String correo) throws SQLException, URISyntaxException
    {
        
        String sql = " INSERT INTO comandante (cod_comandante, nombre, apellidos, anio_servicio, escuela, fecha_ingreso) VALUES (? , ? , ? , ? , ? , ?)";
        PreparedStatement statement = getConnection().prepareStatement (sql);

        statement.setInt(1, comandante.getCod_comandante());
        statement.setString(2, comandante.getNombre());
        statement.setString(3, comandante.getApellidos());
        statement.setInt(4, comandante.getAnio_servicio());
        statement.setString(5, comandante.getEscuela());
        statement.setString(6, comandante.getFecha_ingreso());


        statement.executeUpdate ();

    }
    Funcion en proceso */
    
    public boolean registrarCiudad(String ciudad) {
        
        
        try {
            sql = "INSERT INTO ciudad_sede (ciudad) values (?)";
            PreparedStatement statementAux = conexion.prepareStatement(sql);
            statementAux.setString(1, ciudad);
            statementAux.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("no se pudo agregar. ERROR:" + e);
        }
        return false;
    }
    
    public boolean registrarSedes(String barrio, String direccion, String ciudad) {

        sql = "SELECT EXISTS(SELECT * FROM ciudad_sede WHERE ciudad='" + ciudad + "' )";
        boolean res = false;

        try {
            ResultSet respuesta = statement.executeQuery(sql);

            while (respuesta.next()) {
                res = respuesta.getBoolean(1);
            }

            if (res) {
                sql = "SELECT registrarSede ('" + barrio + "','" + direccion + "','" + ciudad + "')";
                statement.executeQuery(sql);
                System.out.println("sede registrada con exito");
                return true;
            } else {
                System.out.println("la ciudad no existe en la base de datos");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
}
