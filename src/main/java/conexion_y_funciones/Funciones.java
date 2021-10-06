/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_y_funciones;

import java.net.URISyntaxException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author esteban
 */
public class Funciones extends Conexion{

    //atributos necesarios para la conexion con la base de datos
    private Connection conexion;
    private Statement statement;
    private ResultSet resultSet;
    private String sql;   
    private String rol;
    

    //constructor de la clase
    public Funciones()  {

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
            correo = correo.trim();
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
    public void registrarUsuario(String cedula, String barrio,String direccion, String ciudad, String rol,
            String estado, String nombre, String apellido1,
            String apellido2, String telefono, String correo, String clave) {
        try {
            sql = "SELECT registrar_usuario ('" + cedula.toUpperCase() + "','" + barrio.toUpperCase() + "','"+ direccion.toUpperCase() +"','"+ciudad.toUpperCase()+ "','" + rol.toUpperCase() + "','" + estado.toUpperCase() + "','"
                    + nombre.toUpperCase() + "','" + apellido1.toUpperCase() + "','" + apellido2.toUpperCase() + "','" + telefono.toUpperCase() + "','" + correo.toUpperCase() + "','" + clave + "')";
            statement.executeQuery(sql);
            JOptionPane.showMessageDialog(null,"Usuario registrado con éxito");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }


    }
    
    public void editarUsuario(String cedula, String nombre, String apellido1, String apellido2, String telefono, 
                              String correo, String barrio, String direccion, String ciudad, String rol, String estado) {
        try {
            sql = "SELECT actualizar_usuario('"+cedula+"','"+nombre.toUpperCase()+"','" + apellido1.toUpperCase() + "','" + apellido2.toUpperCase() + "','" + telefono.toUpperCase() + "','" + correo.toUpperCase() + "','" + barrio.toUpperCase()+"','"+ direccion.toUpperCase() +"','"+ciudad.toUpperCase()+ "','" + rol.toUpperCase()+"','"+estado.toUpperCase()+"')";
            statement.executeQuery(sql);
            JOptionPane.showMessageDialog(null,"Usuario editado con éxito");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //funcion para crear sedes
    public void registrarSedes(String barrio, String direccion, String ciudad, String telefono) {

        try {

            sql = "SELECT registrarSede ('" + barrio.toUpperCase() + "','" + direccion.toUpperCase() + "','" + ciudad.toUpperCase() + "','"+ telefono +"')";
            statement.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "sede registrada con exito");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //funcion para consultar los datos de una persona
    public void consultar_datos_usuario(String documento,
            javax.swing.JTextField jTextNombre,
            javax.swing.JTextField jTextApellido1,
            javax.swing.JTextField jTextApellido2,
            javax.swing.JTextField jTextTelefono,
            javax.swing.JTextField jTextCorreo,
            javax.swing.JComboBox<String> jcomboSede,
            javax.swing.JComboBox<String> jcomborol,
            javax.swing.JComboBox<String> jcomboestado){
        try {
            sql = "select * from consulta_usuario('"+documento+"')";
            PreparedStatement statementAux = conexion.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                jTextNombre.setText(resultSet.getString(5));
                jTextApellido1.setText(resultSet.getString(6));
                jTextApellido2.setText(resultSet.getString(7));
                jTextTelefono.setText(resultSet.getString(8));
                jTextCorreo.setText(resultSet.getString(9));
                jcomboestado.setSelectedItem(resultSet.getString(4));
                jcomboSede.setSelectedItem(resultSet.getString(2));
                jcomborol.setSelectedItem(resultSet.getString(3));
            }
            JOptionPane.showMessageDialog(null,"Usuario consultado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"No se pudo consultar el usuario");
        }
        
    }
    
    //funcion para consultar datos que puede editar secretaria 
    public void consultar_datos_usuario_secretaria(String documento,
            javax.swing.JTextField jTextNombre,
            javax.swing.JTextField jTextApellido1,
            javax.swing.JTextField jTextApellido2,
            javax.swing.JTextField jTextTelefono,
            javax.swing.JTextField jTextCorreo,
            javax.swing.JComboBox<String> jcomboSede,
            javax.swing.JComboBox<String> jcomborol){
        try {
            sql = "select * from consulta_usuario('"+documento+"')";
            PreparedStatement statementAux = conexion.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                jTextNombre.setText(resultSet.getString(5));
                jTextApellido1.setText(resultSet.getString(6));
                jTextApellido2.setText(resultSet.getString(7));
                jTextTelefono.setText(resultSet.getString(8));
                jTextCorreo.setText(resultSet.getString(9));
                jcomboSede.setSelectedItem(resultSet.getString(2));
                jcomborol.setSelectedItem(resultSet.getString(3));
            }
            JOptionPane.showMessageDialog(null,"Usuario consultado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"No se pudo consultar el usuario");
        }
        
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
    
    public void consultar_sedes_combo(javax.swing.JComboBox<String> jcombobox){
        
        
        try{
            sql = "select concat_ws('//',sedes.barrio,sedes.direccion,ciudad_sede.ciudad)  \n" +
"                   from sedes inner join ciudad_sede on sedes.id_ciudad = ciudad_sede.id_ciudad";
            resultSet = statement.executeQuery(sql);
            jcombobox.addItem("Seccione sede");
            while (resultSet.next()) {
                jcombobox.addItem(resultSet.getString(1));
            }
            
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        
    }
    
    public void consultar_roles_combo(javax.swing.JComboBox<String> jcombobox){
        
        
        try{
            sql = "select tipo_rol from rol_empleados";
            resultSet = statement.executeQuery(sql);
              
            jcombobox.addItem("Seleccione rol");
            while (resultSet.next()) {
                jcombobox.addItem(resultSet.getString("tipo_rol"));
            }
            
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        
    }
    
    public void consultar_estados_combo(javax.swing.JComboBox<String> jcombobox){
        
        
        try{
            sql = "SELECT tipo_estado FROM estado_empleado";
            resultSet = statement.executeQuery(sql);
              
            jcombobox.addItem("Seleccione un estado");
            while (resultSet.next()) {
                jcombobox.addItem(resultSet.getString("tipo_estado"));
            }
            
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        
    }
    
    public void creartabla(javax.swing.JTable jTable){
        DefaultTableModel model;
        String[] titulos = {"Documento", "Sede", "Tipo empleado", "Estado", "Nombre", "Apellido 1", "Apellido 2", "telefono", "correo", "clave"};
        String[] registros = new String[50];
        sql = "SELECT * FROM lista_usuarios()";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                registros[4] = resultSet.getString(5);
                registros[5] = resultSet.getString(6);
                registros[6] = resultSet.getString(7);
                registros[7] = resultSet.getString(8);
                registros[8] = resultSet.getString(9);
                registros[9] = resultSet.getString(10);
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(200);
            jTable.getColumnModel().getColumn(9).setPreferredWidth(150);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void creartablaO(javax.swing.JTable jTable){
        DefaultTableModel model;
        String[] titulos = {"Documento", "Sede", "Tipo empleado", "Estado", "Nombre", "Apellido 1", "Apellido 2", "telefono", "correo"};
        String[] registros = new String[50];
        sql = "SELECT * FROM lista_usuarios()";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                registros[4] = resultSet.getString(5);
                registros[5] = resultSet.getString(6);
                registros[6] = resultSet.getString(7);
                registros[7] = resultSet.getString(8);
                registros[8] = resultSet.getString(9);
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(7).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(150);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void creartablausuario(javax.swing.JTable jTable, String indice){
        DefaultTableModel model;
        String[] titulos = {"Documento", "Sede", "Tipo empleado", "estado", "Nombre", "Apellido 1", "Apellido 2", "telefono", "correo", "clave"};
        String[] registros = new String[50];
        sql = "SELECT * FROM consulta_usuario('"+indice+"')";
        model = new DefaultTableModel(null, titulos); 
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                registros[4] = resultSet.getString(5);
                registros[5] = resultSet.getString(6);
                registros[6] = resultSet.getString(7);
                registros[7] = resultSet.getString(8);
                registros[8] = resultSet.getString(9);
                registros[9] = resultSet.getString(10);
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(9).setPreferredWidth(150);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void creartablausuarioO(javax.swing.JTable jTable, String indice){
        DefaultTableModel model;
        String[] titulos = {"Documento", "Sede", "Tipo empleado", "estado", "Nombre", "Apellido 1", "Apellido 2", "telefono", "correo"};
        String[] registros = new String[50];
        sql = "SELECT * FROM consulta_usuario('"+indice+"')";
        model = new DefaultTableModel(null, titulos); 
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                registros[4] = resultSet.getString(5);
                registros[5] = resultSet.getString(6);
                registros[6] = resultSet.getString(7);
                registros[7] = resultSet.getString(8);
                registros[8] = resultSet.getString(9);
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(7).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(150);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public String consultarContraseña(String documento, String password){        
        String a="";
        try{
        sql = "SELECT clave FROM informacion_empleados WHERE documento_empleado = '"+documento+"'";
        resultSet = statement.executeQuery(sql);
        
        if (resultSet.next()){
            a=resultSet.getString("clave");
            return a;
        }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return a;
    }
    
    public void editarContraseña(String documento, String password){        
        try{
            sql = "UPDATE informacion_empleados SET clave = '"+password+"' WHERE documento_empleado = '"+documento+"'";
            statement.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "Contraseña editada con éxito");        
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Contraseña editada con éxito");
        }
    }
    
    public void creartablasede(javax.swing.JTable jTable){
        DefaultTableModel model;
        String[] titulos = {"Barrio", "Direccion", "ciudad", "Telefono"};
        String[] registros = new String[50];
        sql = "SELECT * FROM consultar_sedes()";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(175);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void creartablasedebarrio(javax.swing.JTable jTable, String barrio){
        DefaultTableModel model;
        String[] titulos = {"Barrio", "Direccion", "ciudad", "Telefono"};
        String[] registros = new String[50];
        sql = "SELECT * FROM consultar_sedes_barrio('"+barrio+"')";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(175);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void creartablasedeciudad(javax.swing.JTable jTable, String ciudad){
        DefaultTableModel model;
        String[] titulos = {"Barrio", "Direccion", "ciudad", "Telefono"};
        String[] registros = new String[50];
        sql = "SELECT * FROM consultar_sedes_ciudad('"+ciudad+"')";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(175);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void editarSede(String barrieE, String direccionE, String ciudadE, String barrio, String direccion, String ciudad, String telefono) {
        try {
            sql = "SELECT * FROM consultar_datos_sede('"+barrieE+"','"+direccionE+"','"+ciudadE+"')";
            resultSet = statement.executeQuery(sql);
            int id_sede = 0;
            while (resultSet.next()){
                id_sede = resultSet.getInt(1);
            }
            sql = "SELECT actualizar_sedes("+id_sede+",'"+barrio.toUpperCase()+"','"+direccion.toUpperCase()+"','"+ciudad.toUpperCase()+"','"+telefono+"')";
            statement.executeQuery(sql);
            JOptionPane.showMessageDialog(null,"Sede editada con éxito");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultarSede(String barrio, String direccion, String ciudad, 
            javax.swing.JTextField jTextBarrio, javax.swing.JTextField jTextDireccion, 
            javax.swing.JTextField jTextCiudad, javax.swing.JTextField jTextTelefono){
        try {
            sql = "SELECT * FROM consultar_datos_sede('"+barrio+"','"+direccion+"','"+ciudad+"')";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){                
                jTextBarrio.setText(resultSet.getString(2));
                jTextDireccion.setText(resultSet.getString(3));
                jTextCiudad.setText(resultSet.getString(4));
                jTextTelefono.setText(resultSet.getString(5));
            }
            JOptionPane.showMessageDialog(null,"Sede consultada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"No se pudo consultar la sede");
        }
    }
    
    public void eliminarsede(String barrieE, String direccionE, String ciudadE){
        try{
            sql = "SELECT * FROM consultar_datos_sede('"+barrieE+"','"+direccionE+"','"+ciudadE+"')";
            resultSet = statement.executeQuery(sql);
            int id_sede = 0;
            while (resultSet.next()){
                id_sede = resultSet.getInt(1);
            }
            int a = JOptionPane.YES_NO_OPTION;
            int b = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta sede?\nTodos los datos relacionados con ella se eliminaran.", "Eliminar sede", a);
            if (b == 0){
                sql = "SELECT eliminar_sede("+id_sede+")";
                statement.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "La sede se ha eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "La operacion se ha cancelado");
            }                   
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en el proceso, no se ha elimnado nada");
        }
    }
    
    public void consultaVentasMeses(int[][] arreglo, int anio){
        try{
            sql = "select EXTRACT(MONTH FROM fecha),count (id_factura) from factura where EXTRACT(YEAR FROM fecha) = "+anio+" group by extract(MONTH from fecha);";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                arreglo[resultSet.getInt(1)-1][0] =  resultSet.getInt(2);
            }                  
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en el proceso, no se consultó nada");
        }
    }
}
