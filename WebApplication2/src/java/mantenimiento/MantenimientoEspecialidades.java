
package mantenimiento;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;

import persistencia.Especialidades;

public class MantenimientoEspecialidades {

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    
    public MantenimientoEspecialidades (){
        this.factory = factory;
        this.session = session;
    }
    
    public String guardar (Integer idEspecialidad, String tipo){
        
        String mensaje ="no funciono el try catch";
        
        Especialidades espe = new Especialidades();
        espe.setIdEspecialidad(idEspecialidad);
        espe.setTipo(tipo);
        
        session.beginTransaction();
        
        try {
            session.save(espe);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = "si pudimos insertar";
        } catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                mensaje = "no pudimos agregar " +e;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }
    
    public int eliminar (Integer idEspecialidad){
        Especialidades espe = new Especialidades();
        
        String mensaje = "error el el try-catch";
        
        try {
            session.beginTransaction();
            espe = (Especialidades) session.get(Especialidades.class, idEspecialidad);
            session.delete(espe);
            session.getTransaction().commit();
            mensaje = "se elimino con exito";
        } catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                mensaje = "no se elimino por "+e;
            }
        } finally {
            session.close();
        }
        return 0;
    }
    
    public List<Especialidades> consultar(){
        List<Especialidades> lista = null;
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
    
    public int modificar (Integer idEspecialidad, String tipo){
        int mensaje =0;
        
        Especialidades espe = new Especialidades();
        
        espe.setIdEspecialidad(idEspecialidad);
        espe.setTipo(tipo);
        
        session.beginTransaction();
        
        try {
            session.update(espe);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = 1;
        } catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                mensaje = 2;
            }
       } //finally {
//            session.close();
//        }
        return mensaje;
    }
    
    public Especialidades consultarId (Integer idEspecialidad){
        Especialidades espe = new Especialidades();
        String mensaje ="";
        try {
            session.beginTransaction();
            espe = (Especialidades) session.get(Especialidades.class, idEspecialidad);
            session.getTransaction().commit();
            mensaje = "se busco por id con exito";
        } catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                mensaje = "no logro buscar por id por "+e;
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return espe;
    }

    
}

