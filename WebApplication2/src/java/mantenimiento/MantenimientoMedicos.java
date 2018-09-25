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
        //MantenimientoEspecialidades espe = new MantenimientoEspecialidades();
        //System.out.println(medi.guardar(0, 1, "Dante", "Vergili", "pedriatra", "12458989"));

        /*int idMedico =5;
        String respuesta = medi.eliminar(idMedico);
        System.out.println("se elimino con exito");*/
        List<Medicos> listamedi = null;
        listamedi = medi.consultar();
        //System.out.println(listamedi.get(0).getNombre());

        for (Medicos m : listamedi) {
            System.out.println("codigo" + m.getIdMedico());
            System.out.println("nombre" + m.getNombre());
            System.out.println("apellido" + m.getApellido());
            System.out.println("telefono" + m.getTelefono());
        
        }
    }

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();

    public String guardar(Integer idMedico, Integer idEspecialidad, String nombre, String apellido,  String telefono) {
        System.out.println("ENTRE A GUARDAR");
        String mensaje = "No funciona el try catch";

        Medicos medi = new Medicos();
        medi.setIdMedico(idMedico);

        Especialidades espe = new Especialidades();
        espe.setIdEspecialidad(idEspecialidad);
        medi.setEspecialidades(espe);

        medi.setNombre(nombre);
        medi.setApellido(apellido);
        medi.setTelefono(telefono);

        try {
            session.beginTransaction();
            session.save(medi);
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

    public int eliminar(Integer idMedico) {

        Medicos medi = new Medicos();

        int mensaje = 0;

        try {
            session.beginTransaction();
            medi = (Medicos) session.get(Medicos.class, idMedico);
            session.delete(medi);
            session.getTransaction().commit();
            mensaje = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = 2;
            }
        } //finally {
        //session.close();
        //}
        return mensaje;
    }

    public List<Medicos> consultar() {
        List<Medicos> lista = null;
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Medicos");
            lista = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }

    public String modificar(Integer idMedico, Integer idEspecialidad, String nombre, String apellido, String telefono) {
        String mensaje = "no pudimos modificar los datos";
        Medicos medi = new Medicos();
        medi.setIdMedico(idMedico);

        Especialidades espe = new Especialidades();
        espe.setIdEspecialidad(idEspecialidad);
        medi.setEspecialidades(espe);

        medi.setNombre(nombre);
        medi.setApellido(apellido);
        medi.setTelefono(telefono);

        try {
            session.beginTransaction();
            session.update(medi);
            session.getTransaction().commit();
            mensaje = "se modifico con exito los datos";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "ERROR al guardar los datos " + e;
            }
        } //finally {
        //session.close();
        //}
        return mensaje;
    }

    public Medicos consultarById(Integer idMedico) {
        Medicos medi = null;
        String mensaje = "";
        try {
            session.beginTransaction();
            medi = (Medicos) session.get(Medicos.class, idMedico);
            // session.getTransaction();
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
