/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.EmpleadosDao;
import entidades.Empleado;

/**
 *
 * @author mariajosegonzalezhidalgo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmpleadosDao empleados = null;
        empleados = new EmpleadosDao();

        Empleado miEmpleado = null;
        System.out.println("---------------------------------------------------");
        System.out.println("LEER UN EMPLEADO ");
        miEmpleado = empleados.leer(32);
        System.out.println(miEmpleado);
        if (miEmpleado != null) {
            System.out.println("---------------------------------------------------");
            System.out.println(miEmpleado.toString());

            /*System.out.println("==============================================");
            System.out.println("INSERTAR EMPLEADO ");
            
            miEmpleado.setCodigoEmpleado(10);
            miEmpleado.setNombre("Maria Jose");
            miEmpleado.setApellido1("Gonzalez");
            miEmpleado.setApellido2("Hidalgo");
            miEmpleado.setExtension("4637");
            miEmpleado.setEmail("mariajosegonzalezhid@gmail.com");
            miEmpleado.setCodigoOficina("GUAY-ECU");
            miEmpleado.setCodigoJefe(4);
            miEmpleado.setPuesto("Gerente General");
            System.out.println("Se pudo insertar el empleado : " + empleados.insertar(miEmpleado));*/
            System.out.println("-----------------------------------------------");
            System.out.println("MODIFICAR EMPLEADO ");
            miEmpleado.setNombre("Margoth");
            //empleados.actualizar(miEmpleado);
            System.out.println(miEmpleado);
            /*System.out.println("==============================================");
            System.out.println("BORRAR EMPLEADO ");           
            System.out.println("Se pudo borrar el empleado : " + empleados.borrar(32));*/
        } else {
            System.exit(0);
        }

    }

}
