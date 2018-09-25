package mantenimiento;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;

import persistencia.Clinicas;
import persistencia.Farmacias;

public class MantenimientoClinicas {

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();

//    public MantenimientoClinicas(){
//    
//        this.factory = factory;
//        this.session = session;
//    }
    public String guardar(Integer idClinica, Integer idFarmacia, String direccion, String horario) {
        String mensaje = "no funciono el try-catch";

        Clinicas cli = new Clinicas();
        cli.setIdClinica(idClinica);

        Farmacias farmacias = new Farmacias();
        farmacias.setIdFarmacia(idFarmacia);
        cli.setFarmacias(farmacias);

        cli.setDireccion(direccion);
        cli.setHorario(horario);

        try {
            session.beginTransaction();
            session.save(cli);
            //session.getTransaction();
            session.getTransaction().commit();
            mensaje = "se inserto con exito";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no guardo por " + e;
            }
        } /*finally {
            session.close();
        }*/
        return mensaje;
    }

    public int eliminar(Integer idClinica) {
        Clinicas cli = new Clinicas();
        int mensaje = 0;

        try {
            session.beginTransaction();
            cli = (Clinicas) session.get(Clinicas.class, idClinica);
            session.delete(cli);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = 2;
            }
        } /*finally {
            session.close();
        }*/
        return mensaje;
    }

    public List<Clinicas> mostrar() {
        List<Clinicas> lista = null;
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Clinicas");
            lista = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }

    public String modificar(Integer idClinica, Integer idFarmacia, String direccion, String horario) {
        
        String mensaje = "";
        Clinicas cli = new Clinicas();
        cli.setIdClinica(idClinica);
        
        Farmacias farmacias = new Farmacias();
        farmacias.setIdFarmacia(idFarmacia);
        cli.setFarmacias(farmacias);

        cli.setDireccion(direccion);
        cli.setHorario(horario);

        
        try {
            session.beginTransaction();
            session.update(cli);
            session.getTransaction().commit();
            mensaje = "exito";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "fracaso";
            }
        }/*finally {
            session.close();
        }*/
        return mensaje;
    }

    public Clinicas consultarId(Integer idClinica) {
        Clinicas cli = new Clinicas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        String mensaje = "";
        try {
            session.beginTransaction();
            cli = (Clinicas) session.get(Clinicas.class, idClinica);
            session.getTransaction().commit();
            mensaje = "asdad";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje="error";
                cli=null;
                System.out.println("ERROR: "+e);
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return cli;
    }
    
    public static void main(String[] args) {
        MantenimientoClinicas m = new MantenimientoClinicas();
        Clinicas cl = m.consultarId(3);
        System.out.println(cl.getDireccion());
    }
    
}
