package mantenimiento;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;

import persistencia.Farmacias;

public class MantenimientoFarmacias {

    public static void main(String[] args) {
        MantenimientoFarmacias man = new MantenimientoFarmacias();
//     System.out.println(man.guardarFarmacia(0,"colonia san benito 75av norte"));

        /* int idFarmacia = 4;
        int respuesta = man.eliminarFarmacias(idFarmacia);
        System.out.println("se elimino con exito");
        System.exit(0);*/
        List<Farmacias> listaFarmacias = null;
        listaFarmacias = man.consultarTodoFarmacias();
        //System.out.println(listaFarmacias.toString());
        for (Farmacias f : listaFarmacias) {
            System.out.println("direccion: " + f.getDireccion());
            System.out.println("CODIGO: " + f.getIdFarmacia());
        }
        System.exit(0);
    }

    public String guardarFarmacia(Integer idFarmacia, String direccion) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        String flag = "";

        Farmacias farmacias = new Farmacias();
        farmacias.setIdFarmacia(idFarmacia);
        farmacias.setDireccion(direccion);

        session.beginTransaction();
        try {
            session.save(farmacias);
            session.getTransaction().commit();
            flag = "Exito al agregar";

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = "No se pudo agregar";
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarFarmacias(Integer idFarmacia) {

        Farmacias farmacias = new Farmacias();

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            farmacias = (Farmacias) session.get(Farmacias.class, idFarmacia);
            session.delete(farmacias);
            session.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
        } finally {
            session.close();
        }
        return flag;

    }

    public List consultarTodoFarmacias() {
        List<Farmacias> lista = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        try {
            Query query = session.createQuery("from Farmacias");
            lista = (List<Farmacias>) query.list();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }
        return lista;
    }

    public int modificar(Integer idFarmacia, String direecion) {
        int mensaje = 0;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Farmacias farmacia = new Farmacias();

        farmacia.setIdFarmacia(idFarmacia);
        farmacia.setDireccion(direecion);

        session.beginTransaction();

        try {
            session.update(farmacia);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = 2;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }

    public int consultarId(Integer idFarmacia) {
        Farmacias con = null;
        String mensaje = "";
        System.out.println("Id en mantenimiento: "+idFarmacia);
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag=0;
        try {
            session.beginTransaction();
            con = (Farmacias) session.get(Farmacias.class, idFarmacia);
//             session.getTransaction();
            session.getTransaction().commit();
            mensaje = "se busco por id con exito";
            flag=1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no pudo buscar por id por " + e;
            }
            e.printStackTrace();
            flag=2;
        } finally {
            session.close();
        }
        return flag;
    }
}
