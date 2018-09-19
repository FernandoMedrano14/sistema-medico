package mantenimiento;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;
import persistencia.Especialidades;
import persistencia.Medicos;

public class MantenimientoMedicos {

    public static void main(String[] args) {
        MantenimientoMedicos medi = new MantenimientoMedicos();
        System.out.println(medi.guardar(0, 1, "Dante", "Vergili", "neurologo", "12458989"));
    }

    SessionFactory factory;
    Session session;

    public MantenimientoMedicos() {
        this.factory = HibernateUtil.getSessionFactory();
        this.session = factory.openSession();
    }

    public String guardar(Integer idMedico, Integer idEspecialidad, String nombre, String apellido, String especialidad, String telefono) {
        System.out.println("ENTRE A GUARDAR");
        String mensaje = "No funciona el try cacath";

        Medicos medi = new Medicos();
        medi.setIdMedico(idMedico);

        Especialidades espe = new Especialidades();
        espe.setIdEspecialidad(idEspecialidad);
        medi.setEspecialidades(espe);

        medi.setNombre(nombre);
        medi.setApellido(apellido);
        medi.setEspecialidad(especialidad);
        medi.setTelefono(telefono);

        try {
            session.beginTransaction();
            session.save(medi);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = "se guardo con exito los datos";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "ERROR al guardar los datos " + e;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }

    public String eliminar(Integer idMedico) {

        Medicos medi = new Medicos();

        String mensaje = "error en  el try cacatch ";

        try {
            session.beginTransaction();
            medi = (Medicos) session.get(Especialidades.class, idMedico);
            session.delete(medi);
            session.getTransaction().commit();
            mensaje = "se elimino con exito";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no se inserto por " + e;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }

    public List<Medicos> consultar() {
        List<Medicos> lista = null;
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Especialidades");
            lista = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }

    public String modificar(Integer idMedico, Integer idEspecialidad, String nombre, String apellido, String especialidad, String telefono) {
        String mensaje = "no pudimos modificar los datos";
        Medicos medi = new Medicos();
        medi.setIdMedico(idMedico);

        Especialidades espe = new Especialidades();
        espe.setIdEspecialidad(idEspecialidad);
        medi.setEspecialidades(espe);

        medi.setNombre(nombre);
        medi.setApellido(apellido);
        medi.setEspecialidad(especialidad);
        medi.setTelefono(telefono);

        try {
            session.beginTransaction();
            session.update(medi);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = "se modifico con exito los datos";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "ERROR al guardar los datos " + e;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }

    public Medicos consultarById(Integer idMedico) {
        Medicos medi = null;
        String mensaje = "";
        try {
            session.beginTransaction();
            medi = (Medicos) session.get(Medicos.class, idMedico);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = "se busco por id con exito";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no pudo busar por id por " + e;
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return medi;
    }
}
