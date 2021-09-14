/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_y_funciones;

import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author esteban
 */
public class FuncionesGerente extends Conexion{
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
    
    public void registrarSedes(String barrio, String direccion, String ciudad){
        String sql = "SELECT registrarSede ('" + barrio + "','" + direccion + "','" + ciudad + "')" ;
        
        try {
            Statement statement = getConnection().createStatement();
            statement.executeQuery(sql);
            System.out.println("sede registrada con exito");
        }
        catch (Exception e){
            System.out.println("sede no se pudo registrar. Error: "+ e );
        }
        
    }
}
