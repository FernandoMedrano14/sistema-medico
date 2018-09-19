
package Pruevas;

import java.util.List;
import mantenimiento.MantenimientoEspecialidades;
import mantenimiento.MantenimientoConsultorios;
import mantenimiento.MantenimientoFarmacias;
import persistencia.Consultorios;
import persistencia.Especialidades;
import persistencia.Farmacias;


public class pruebas {

    public static void main(String[] args) {
        System.out.println("hola mundo");
        MantenimientoConsultorios con = new MantenimientoConsultorios();
        //System.out.println(con.guardar(0, 72716503, "Oncologia"));
        //System.out.println(con.eliminar(6));
        
//        List<Consultorios> lista = null;
//        lista = con.mostrarConsultorio();
//        for(Consultorios c : lista){
//            System.out.println("idConsultorio "+c.getIdConsultorio());
//            System.out.println("numero "+c.getNumero());
//            System.out.println("area "+c.getArea());
//        -------------------*especialidades*--------------------------  

    MantenimientoEspecialidades espe = new MantenimientoEspecialidades();

//        System.out.println(espe.guardar(0, "Ortopeda"));
//        System.out.println(espe.eliminar(2));   
//        List<Especialidades> lista = null;
//        lista = espe.consultar();
//        for(Especialidades e : lista){
//            System.out.println("idEspecialidades "+e.getIdEspecialidad());
//            System.out.println("tipo "+e.getTipo());
//        }
//System.out.println(espe.modificar(5, "Cardiologia"));        


            MantenimientoFarmacias farmacia = new MantenimientoFarmacias();   
            System.out.println();

        


    }
}
