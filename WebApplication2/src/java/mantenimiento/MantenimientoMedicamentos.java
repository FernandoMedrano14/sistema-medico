package mantenimiento;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;

import persistencia.Medicamentos;
import persistencia.Farmacias;
import persistencia.Proveedores;

public class MantenimientoMedicamentos {

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    String mensaje = "error en el try-catch";

    public String guardar(Integer idMedicamento, Integer idFarmacia, Integer idProveedor, String nombre, String tipo) {

        Medicamentos med = new Medicamentos();
        med.setIdMedicamento(idMedicamento);

        Farmacias farmacia = new Farmacias();
        farmacia.setIdFarmacia(idFarmacia);
        med.setFarmacias(farmacia);

        Proveedores prov = new Proveedores();
        prov.setIdProveedor(idProveedor);
        med.setProveedores(prov);

        med.setNombre(nombre);
        med.setTipo(tipo);

        try {
            session.beginTransaction();
            session.save(med);
            session.getTransaction().commit();
            mensaje = "se inserto con exito";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no pudimos insertar por " + e;
            }
        }
        /*finally {
            session.close();
        }*/
        return mensaje;
    }

    public int eliminar(Integer idMedicamentos) {
        Medicamentos med = new Medicamentos();
        int mensaje = 0;

        try {
            session.beginTransaction();
            med = (Medicamentos) session.get(Medicamentos.class, idMedicamentos);
            session.delete(med);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = 2;
            }
        }
        /*finally {
            session.close();
        }*/
        return mensaje;
    }

    public List<Medicamentos> mostrar() {
        List<Medicamentos> lista = null;
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Medicamentos");
            lista = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }

    public String modificar(Integer idMedicamento, Integer idFarmacia, Integer idProveedor, String nombre, String tipo) {

        Medicamentos med = new Medicamentos();
        med.setIdMedicamento(idMedicamento);

        Farmacias farmacia = new Farmacias();
        farmacia.setIdFarmacia(idFarmacia);
        med.setFarmacias(farmacia);

        Proveedores prov = new Proveedores();
        prov.setIdProveedor(idProveedor);
        med.setProveedores(prov);

        med.setNombre(nombre);
        med.setTipo(tipo);

        try {
            session.beginTransaction();
            session.update(prov);
            session.getTransaction().commit();
            mensaje = "se modifico con exito";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no pudimos modificar por " + e;
            }
        }/* finally {
            session.close();
        }*/
        return mensaje;
    }

    public Medicamentos buscarById(Integer idMedicamentos) {
        Medicamentos med = new Medicamentos();
        try {
            session.getTransaction();
            med = (Medicamentos) session.get(Medicamentos.class, idMedicamentos);
            session.getTransaction().commit();
            mensaje = "exito al buscar por id";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no consulto por id " + e;
                med = null;
                System.out.println("error" + e);
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return med;
    }

    public static void main(String[] args) {
        MantenimientoMedicamentos med = new MantenimientoMedicamentos();
        // System.out.println(med.guardar(0, 2, 2, "acetaminofen", "analgesico"));
        int idMedicamento = 4;
        int respuesta = med.eliminar(idMedicamento);
        System.out.println("se elimino con exito");

    }
}
