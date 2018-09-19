
package mantenimiento;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;

import persistencia.Consultorios;

public class MantenimientoConsultorios {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    
    public MantenimientoConsultorios(){
        this.factory = factory;
        this.session = session;
    }
    
    public String guardar (Integer idConsultorio, Integer numero, String area){
        String mensaje = "";
        
        Consultorios con = new Consultorios();
        
        con.setIdConsultorio(idConsultorio);
        con.setNumero(numero);
        con.setArea(area);
        try {
            session.beginTransaction();
            session.save(con);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = "Exito al guardar";
        } catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                mensaje = "Error al Guardar debido a: "+e;
            }
        } //finally {
//            session.close();
//        }
        return mensaje;
    }
    
    public int eliminar (Integer idConsultorio){
        
        Consultorios con = new Consultorios();
        int mensaje = 0;
        
        try {
            session.beginTransaction();
            con = (Consultorios) session.get(Consultorios.class, idConsultorio);
            session.delete(con);
            session.getTransaction().commit();
            mensaje = 1;
        } catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                mensaje = 2;
            }
//        } finally {
//            session.close();
//        }
        }
        return mensaje;
    }
    
    public List <Consultorios> mostrarConsultorio(){
        List<Consultorios> lista = null;
        session.beginTransaction();
        
        try {
            Query query = session.createQuery("from Consultorios");
            lista = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }
    
     public int modificar (Integer idConsultorio, Integer numero, String area){
        int mensaje = 0;
        
        Consultorios con = new Consultorios();
        
        con.setIdConsultorio(idConsultorio);
        con.setNumero(numero);
        con.setArea(area);
        try {
            session.beginTransaction();
            session.update(con);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = 1;
        } catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                mensaje = 2;
            }
        }// finally {
//            session.close();
//        }
        return mensaje;
    }
     
     public int consultarId (Integer idConsultorio){
         Consultorios con = null;
         String mensaje = "";
         System.out.println("Id en mantenimiento "+idConsultorio);
         try {
             session.beginTransaction();
             con = (Consultorios) session.get(Consultorios.class, idConsultorio);
//             session.getTransaction();
             session.getTransaction().commit();
             mensaje = "se busco por id con exito";
         } catch (Exception e) {
             if(session.getTransaction().isActive()){
                 session.getTransaction().rollback();
                 mensaje ="no pudo busar por id por: "+e;
             }
             e.printStackTrace();
         } //finally {
//             session.close();
//         }
         return 0;
     }
     public Consultorios consultaId (Integer  idConsultorio){
         Consultorios consul = null;
         SessionFactory factory = HibernateUtil.getSessionFactory();
         Session session = factory.openSession();
         try {
             session.beginTransaction();
             consul = (Consultorios) session.get(Consultorios.class, idConsultorio);
             System.out.println("consulta por id correcta");
             session.getTransaction().commit();
         } catch (Exception e) {
             if (session.getTransaction().isActive()) {
                 session.getTransaction().rollback();
                 System.out.println("error en consultar por id consultorios "+e);
                 consul = null;
             }
         }//finally{
            // session.close();
         //}
        return consul;
     }
    
}
