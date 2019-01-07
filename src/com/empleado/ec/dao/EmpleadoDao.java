/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empleado.ec.dao;

import com.empleado.ec.entity.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Freddie
 */
public class EmpleadoDao {
    private String mensaje="";
    public String agregarEmpleado(Connection con, Empleado emp){
        PreparedStatement pst=null;
        String sql="INSERT INTO EMPLEADO (IDEMPLEADO,NOMBRES,APELLIDOS,CEDULA,ESTADOCIVIL,GENERO,EDAD)"+
                    " VALUES(?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,emp.getIdEmpleado());
            pst.setString(2, emp.getNombres());
            pst.setString(3, emp.getApellidos());
            pst.setString(4, emp.getCedula());
            pst.setString(5, emp.getEstadoCivil()+"");
            pst.setString(6, emp.getGenero()+"");
            pst.setInt(7, emp.getEdad());
            mensaje="Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje="Guardado InCorrectamente"+e.getMessage();
        }
        return mensaje;
    }
    public String modificarEmpleado(Connection con, Empleado emp){
        PreparedStatement pst=null;
        String sql="UPDATE EMPLEADO SET NOMBRES=? ,APELLIDOS=?,CEDULA=?,ESTADOCIVIL=?,GENERO=?,EDAD=?"+
                    "WHERE IDEMPLEADO=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, emp.getNombres());
            pst.setString(2, emp.getApellidos());
            pst.setString(3, emp.getCedula());
            pst.setString(4, emp.getEstadoCivil()+"");
            pst.setString(5, emp.getGenero()+"");
            pst.setInt(6, emp.getEdad());
            pst.setInt(7,emp.getIdEmpleado());
            mensaje="Actualizado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje="Actualizado InCorrectamente"+e.getMessage();
        }
        return mensaje;
    }
    public String eliminarEmpleado(Connection con, int id){
        PreparedStatement pst=null;
        String sql="DELETE FROM EMPLEADO WHERE IDEMPLEADO=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            mensaje="Eliminado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje="Eliminado InCorrectamente"+e.getMessage();
        }
        return mensaje;
    }
    public void listarEmpleado(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"ID","NOMBRES","APELLIDOS","CEDULA","ESTADO CIVIL","GENERO","EDAD"};
        model=new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM EMPLEADO ORDER BY IDEMPLEADO";
        String [] filas= new String[7];
        Statement st=null;
        ResultSet rs= null;
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 7; i++) {
                    filas[i]=rs.getString(i+1);
                   // System.out.println(rs.getString(i+1));
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
     public int getMaxID(Connection con){
        int id=0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql="SELECT MAX(IDEMPLEADO)+1 FROM EMPLEADO"; //mUESTRA EL ID PRESENTE
        try {
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar ID"+e.getMessage());
        }
        return id;
    } 
}
