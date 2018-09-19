package mantenimiento;

import java.util.Iterator;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Proveedores;

public class MantenimientoProveedores {

    public static void main(String[] args) {

        //guardar
        MantenimientoProveedores man = new MantenimientoProveedores();
        System.out.println(man.guardarProveedor(0, "Medicamentos", "Maricarmen Analuz"));

        //consultar
        /*List<Proveedores> proveedor = man.consultarTodoProveedor();
        System.out.println("Id Proveedor" + proveedor);
        System.out.println("Rubro" + proveedor.));*/
        
        //eliminar
        //System.out.println(man.eliminarProveedor(7));
    }

    public int guardarProveedor(Integer idProveedor, String rubro, String encargado) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Proveedores proveedor = new Proveedores();
        proveedor.setIdProveedor(idProveedor);
        proveedor.setRubro(rubro);
        proveedor.setEncargado(encargado);

        session.beginTransaction();
        try {
            session.save(proveedor);
            session.getTransaction().commit();
            System.out.println("Exito al guardar");
            flag = 6;
        } catch (Exception e) {
            System.out.println("error en el catch " + e);
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Erro al guardar" + e);
                flag = 1;
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarProveedor(Integer idProveedor) {
        Proveedores proveedor = new Proveedores();

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            proveedor = (Proveedores) session.get(Proveedores.class, idProveedor);
            session.delete(proveedor);
            session.getTransaction().commit();
            System.out.println("Eliminado con exito");
            flag = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("No se pudo eliminar");
                flag = 1;
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodoProveedores() {

        List<Proveedores> lista = null;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        try {
            Query query = session.createQuery("from Proveedores");
            lista = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            session.close();
        }

        return lista;
    }
    
    
     public int modificar (Integer idProveedor, String rubro, String encargado){
        
         SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
         int mensaje = 0;
        
        Proveedores proveedores = new Proveedores();
        
        proveedores.setIdProveedor(idProveedor);
        proveedores.setRubro(rubro);
        proveedores.setEncargado(encargado);
        
        session.beginTransaction();
        
        try {
            session.update(proveedores);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = 1;
        } catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                mensaje = 2;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }
     
     public int consultarId (Integer idProveedor){
         SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
         Proveedores proveedores = null;
         int flag=0;
         try {
             session.beginTransaction();
             proveedores = (Proveedores) session.get(Proveedores.class, idProveedor);
//             session.getTransaction();
             session.getTransaction().commit();
             flag=1;
         } catch (Exception e) {
             if(session.getTransaction().isActive()){
                 session.getTransaction().rollback();
                flag = 2;
             }
             e.printStackTrace();
         } finally {
             session.close();
         }
         return flag;
     }

}
