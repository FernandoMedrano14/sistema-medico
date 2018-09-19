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
            mensaje = "se inserto conexito la medicina";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no pudimos insertar por " + e;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }

    public String eliminar(Integer idMedicamentos) {
        Medicamentos med = new Medicamentos();

        try {
            session.beginTransaction();
            med = (Medicamentos) session.get(Medicamentos.class, idMedicamentos);
            session.delete(med);
            session.getTransaction().commit();
            mensaje = "delete exitoso";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no se elimino por " + e;
            }
        } finally {
            session.close();
        }
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
            mensaje = "se modifico conexito la medicina";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no pudimos modificar por " + e;
            }
        } finally {
            session.close();
        }
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
                mensaje = "no consulto por id devido por " + e;
            }
        } finally {
            session.close();
        }
        return med;
    }

}
