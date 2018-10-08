package mantenimiento;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;

import persistencia.Citas;
import persistencia.Pacientes;
import persistencia.Consultorios;
import persistencia.Medicos;

public class MantenimientoCitas {

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    String mensaje = "Error en el try-catch";

//    public MantenimientoCitas() {
  //      this.factory = factory;
    //    this.session = session;
    //}

    public String guardar(Integer idCita, Integer idConsultorio, Integer idPaciente, Integer idMedico, String fecha_cita, String hora_cita) {
        Citas ci = new Citas();
        ci.setIdCita(idCita);

        Consultorios con = new Consultorios();
        con.setIdConsultorio(idConsultorio);
        ci.setConsultorios(con);

        Pacientes pac = new Pacientes();
        pac.setIdPaciente(idPaciente);
        ci.setPacientes(pac);

        Medicos med = new Medicos();
        med.setIdMedico(idMedico);
        ci.setMedicos(med);

        ci.setFechaCita(fecha_cita);
        ci.setHoraCita(hora_cita);

        try {
            session.beginTransaction();
            session.save(ci);
            session.getTransaction().commit();
            mensaje = "exito al guardar la cita";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "error al guardar por " + e;
            }
        }/* finally {
            session.close();
        }*/
        return mensaje;
    }

    public int eliminar(Integer idCita) {
        Citas ci = new Citas();
        int mensaje = 0;
        try {
            session.beginTransaction();
            ci = (Citas) session.get(Citas.class, idCita);
            session.delete(ci);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = 2;
            }
        }/*finally {
            session.close();
        }*/
        return mensaje;
    }

    public List<Citas> mostrar() {
        List<Citas> lista = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Citas");
            lista = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } //finally {
            //session.close();
        //}
        return lista;
    }

    public int modificar(Integer idCita, Integer idConsultorio, Integer idPaciente, Integer idMedico, String fecha_cita, String hora_cita) {
        Citas ci = new Citas();
        ci.setIdCita(idCita);
        int mensaje = 0;

        Consultorios con = new Consultorios();
        con.setIdConsultorio(idConsultorio);
        ci.setConsultorios(con);

        Pacientes pac = new Pacientes();
        pac.setIdPaciente(idPaciente);
        ci.setPacientes(pac);

        Medicos med = new Medicos();
        med.setIdMedico(idMedico);
        ci.setMedicos(med);

        ci.setFechaCita(fecha_cita);
        ci.setHoraCita(hora_cita);

        try {
            session.beginTransaction();
            session.update(ci);
            session.getTransaction().commit();
            System.out.println("Mantenimiento Citas Modificado correcto");
            mensaje = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error al modificar en mantenimiento citas "+e);
                mensaje = 2;
            }
        }/*finally {
            session.close();
        }*/
        return mensaje;
    }

    public Citas consultarId(Integer idCita) {
        Citas ci = new Citas();
        
        try {
            session.getTransaction();
            ci = (Citas) session.get(Citas.class, idCita);
 //           session.getTransaction()//.commit();
            System.out.println("exito al buscar por id");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje="no consulto por id"+e;
                ci=null;
                System.out.println(mensaje);
            }
            e.printStackTrace();
        } finally {
            //session.close();
        }
        return ci;
    }
}

