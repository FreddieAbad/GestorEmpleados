
package com.empleado.ec.bo;

import com.empleado.ec.dao.EmpleadoDao;
import com.empleado.ec.db.Conexion;
import com.empleado.ec.entity.Empleado;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

public class EmpleadoBo {
    private String mensaje="";
    private EmpleadoDao edao = new EmpleadoDao();
    
    public String agregarEmpleado( Empleado emp){
        Connection con= Conexion.getConnection();
        try {
            mensaje=edao.agregarEmpleado(con, emp);

        } catch (Exception e) {
            mensaje=mensaje+" "+e.getMessage();
        }finally{
            try {
                if(con!=null){
                    con.close();
                }
            } catch (Exception e) {
                mensaje=mensaje+ " " + e.getMessage();
            }
        }
        return mensaje;
    }
    public String modificarEmpleado(Empleado emp){
        Connection con= Conexion.getConnection();
        try {
            mensaje=edao.modificarEmpleado(con, emp);

        } catch (Exception e) {
            mensaje=mensaje+" "+e.getMessage();
        }finally{
            try {
                if(con!=null){
                    con.close();
                }
            } catch (Exception e) {
                mensaje=mensaje+ " " + e.getMessage();
            }
        }
        return mensaje;
    }
    public String eliminarEmpleado(int id){
        Connection con= Conexion.getConnection();
        try {
            mensaje=edao.eliminarEmpleado(con, id);

        } catch (Exception e) {
            mensaje=mensaje+" "+e.getMessage();
        }finally{
            try {
                if(con!=null){
                    con.close();
                }
            } catch (Exception e) {
            }
        }
        return mensaje;
    }
    public void listarEmpleado(JTable table) throws SQLException{
        Connection con= Conexion.getConnection();
        edao.listarEmpleado(con, table);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
