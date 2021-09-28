/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_y_funciones;

import java.net.URISyntaxException;
import java.sql.*;

/**
 *
 * @author esteban
 */
public class Funciones extends Conexion {

    //atributos necesarios para la conexion con la base de datos
    private Connection conexion;
    private Statement statement;
    private ResultSet resultSet;
    private String sql;
    
    private String rol;

    //constructor de la clase
    public Funciones() {

        try {
            conexion = getConnection();
            statement = conexion.createStatement();
            resultSet= null;
        } catch (URISyntaxException | SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    
    
    //funcion para obtener el rol de la persona que se logea
    public boolean login (String correo, String clave){
        try{
            sql = "select login ('"+correo+"','"+clave+"')";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                rol = resultSet.getString(1);
            }
            if (rol != null){
                return true;
            }
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        
        return false;
    }
    
    public String get_rol(){
        return rol;
    }

    //funcion para registrar usuarios
    public boolean registrarUsuario(String cedula, String nomSede, String rol,
            String estado, String nombre, String apellido1,
            String apellido2, String telefono, String correo, String clave) {
        try {
            sql = "SELECT registrar_usuario ('" + cedula.toUpperCase() + "','" + nomSede.toUpperCase() + "','" + rol.toUpperCase() + "','" + estado.toUpperCase() + "','"
                    + nombre.toUpperCase() + "','" + apellido1.toUpperCase() + "','" + apellido2.toUpperCase() + "','" + telefono.toUpperCase() + "','" + correo.toUpperCase() + "','" + clave + "')";
            statement.executeQuery(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    //funcion para crear sedes
    public boolean registrarSedes(String barrio, String direccion, int id_ciudad) {

        try {

            sql = "SELECT registrarSede ('" + barrio.toUpperCase() + "','" + direccion + "','" + id_ciudad + "')";
            statement.executeQuery(sql);
            System.out.println("sede registrada con exito");
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    //funcion para registrar ciudades
    public boolean registrarCiudad(String ciudad) {

        try {
            sql = "INSERT INTO ciudad_sede (ciudad) values (?)";
            PreparedStatement statementAux = conexion.prepareStatement(sql);
            statementAux.setString(1, ciudad.toUpperCase());
            statementAux.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("no se pudo agregar. ERROR:" + e);
        }
        return false;
    }

}
