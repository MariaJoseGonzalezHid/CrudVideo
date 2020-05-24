/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entidades.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariajosegonzalezhidalgo
 */
public class EmpleadosDao {

    Connection conexion = null;

    public EmpleadosDao() {
        try{
           conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria");
        } 
        catch (SQLException ex) {
            System.err.println("Error en la conexión: " + ex.getMessage());
        }
    }

    public Empleado leer(Integer idEmpleado){

        Empleado emp = null;
        PreparedStatement stm = null;
        String sql = "SELECT * FROM Empleados where CodigoEmpleado = ?";

        if (conexion == null) {
            return emp;
        }
        try {
            stm = conexion.prepareStatement(sql);
            stm.setInt(1, idEmpleado);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                emp = new Empleado(
                        rs.getInt("CodigoEmpleado"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido1"),
                        rs.getString("Apellido2"),
                        rs.getString("Extension"),
                        rs.getString("email"),
                        rs.getString("codigoOficina"),
                        rs.getInt("CodigoJefe"),
                        rs.getString("Puesto")
                );
            }
        } catch (SQLException ex) {
            System.err.println("Error en la lectura: " + ex.getMessage() + " " + stm.toString());
        }

        return emp;
    }

    public Boolean actualizar(Empleado empleado) {
        //String query = "UPDATE empleados set Apellido1 = 'Magaña' where apellido1 = 'Jimenez'";
        Boolean resultado = false;
        String sql = "UPDATE empleados set nombre=?, apellido1=?, apellido2=? where CodigoEmpleado = ?";
        PreparedStatement stm = null;
        //evitamos errores usando el IF
        if (conexion == null || empleado == null) {
            System.err.println("Error la conexion del empleado ");
            return false;
        }
        try {
            stm = conexion.prepareStatement(sql);
            stm.setString(1, empleado.getNombre());
            stm.setString(2, empleado.getApellido1());
            stm.setString(3, empleado.getApellido2());
            stm.setInt(4, empleado.getCodigoEmpleado());

            resultado = stm.execute();
        } catch (SQLException ex) {
            System.err.println("Error en la actualizacion : " + ex.getMessage() + stm.toString());
        }
        return resultado;
    }

    public Boolean borrar(Integer idEmpleado) {

        Boolean result = false;
        String sql = "DELETE FROM Empleados WHERE codigoEmpleado = ?";
        PreparedStatement stm = null;
        if (conexion == null) {
            System.err.println("Error la conexion del empleado ");
            return false;
        }
        try {

            stm = conexion.prepareStatement(sql);
            stm.setInt(1, idEmpleado);
            result = stm.execute();
        } catch (SQLException ex) {
            System.err.println("Error en la actualizacion : " + ex.getMessage() + stm.toString());
        }
        return result;
    }

    public Boolean insertar(Empleado empleado) {
        Boolean result = false;
        String sql = "INSERT INTO Empleados (CodigoEmpleado, Nombre, Apellido1, Apellido2, Extension, Email,"
                + "CodigoOficina, CodigoJefe, Puesto) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = null;
        if (conexion == null || empleado == null) {
            System.err.println("Error la conexion del empleado ");
            return false;
        }
        try {
            stm = conexion.prepareStatement(sql);
            stm.setInt(1, empleado.getCodigoEmpleado());
            stm.setString(2, empleado.getNombre());
            stm.setString(3, empleado.getApellido1());
            stm.setString(4, empleado.getApellido2());
            stm.setString(5, empleado.getExtension());
            stm.setString(6, empleado.getEmail());
            stm.setString(7, empleado.getCodigoOficina());
            stm.setInt(8, empleado.getCodigoJefe());
            stm.setString(9, empleado.getPuesto());
            stm.execute();

        } catch (SQLException ex) {
            System.err.println("Error en la actualizacion : " + ex.getMessage() + stm.toString());
        }
        return result;
    }
}
