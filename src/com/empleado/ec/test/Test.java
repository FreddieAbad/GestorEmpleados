/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empleado.ec.test;

import com.empleado.ec.bo.EmpleadoBo;
import com.empleado.ec.entity.Empleado;

/**
 *
 * @author Freddie
 */
public class Test {
    EmpleadoBo ebo= new EmpleadoBo();
    Empleado emp=new Empleado();
    String mensaje="";
    public void insertar(){
        /*emp.setNombres("Freddy");
        emp.setApellidos("Leon");
        emp.setCedula("0104496766");
        emp.setEstadoCivil('S');
        emp.setGenero('M');
        emp.setEdad(25);*/
        System.out.println(ebo.getMaxID());
        emp.setIdEmpleado(ebo.getMaxID());
        emp.setNombres("Leo");
        emp.setApellidos("Abad");
        emp.setCedula("0704496766");
        emp.setEstadoCivil('S');
        emp.setGenero('M');
        emp.setEdad(25);
        mensaje=ebo.agregarEmpleado(emp);
        System.out.println(mensaje);
    }
    public void modificar(){
        emp.setIdEmpleado(2);
        emp.setNombres("Leo");
        emp.setApellidos("Abad");
        emp.setCedula("0704496766");
        emp.setEstadoCivil('S');
        emp.setGenero('M');
        emp.setEdad(25);
        mensaje=ebo.modificarEmpleado(emp);
        System.out.println(mensaje);
    }
    public void eliminar(){
        mensaje=ebo.eliminarEmpleado(3);
        System.out.println(mensaje);
    }
    public static void main(String[] args) {
        Test test= new Test();
        test.insertar();
        //test.modificar();
        //test.eliminar();
    }
}
