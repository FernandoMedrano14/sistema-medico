package mantenimiento;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;

import persistencia.Usuarios;

public class MantenimientoUsuarios {

    public static void main(String[] args) {

        MantenimientoUsuarios man = new MantenimientoUsuarios();
      System.out.println(man.guardarUsuario(0, "Diego Orellana", "sene69@hotmail.com", "123456", "Masculino", "admin" ,"color favorito","azul"));
//        List<Usuarios> usuario = man.consultarTodoUsuario();
//        System.out.println("Id Usuario" + usuario.);
//        System.out.println("Nombre Usuario" + usuario.getNombre());
//        System.out.println("Correo" + usuario.getCorreo());
//        System.out.println("Contraseña" + usuario.getContra());
//        System.out.println("Genero" + usuario.getGenero());
//        System.out.println("Tipo" + usuario.getTipo());
        //System.out.println(usuario.get(0).getNombre());
        
        
        //LOGIN
//        Usuarios u = man.login("davidflores@gmail.com", "123456");
//        System.out.println(u.getNombre());
        
    }

    public int guardarUsuario(Integer idUsuario, String nombre, String correo, String contra, String genero, String tipo,String pregunta,String respuesta) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Usuarios usuario = new Usuarios();
        usuario.setIdUsuario(idUsuario);
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContra(contra);
        usuario.setGenero(genero);
        usuario.setTipo(tipo);
        usuario.setPregunta(pregunta);
        usuario.setRespuesta(respuesta);

        session.beginTransaction();
        try {
            session.save(usuario);
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

    public int eliminarUsuario(Integer idUsuario) {

        Usuarios usuario = new Usuarios();

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
     
        int flag = 0;
     
        try {
            session.beginTransaction();
            usuario = (Usuarios) session.get(Usuarios.class, idUsuario);
            session.delete(usuario);
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

    public List consultarTodoUsuario() {

        List<Usuarios> lista = null;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try {

            Query query = session.createQuery("from Usuarios");
            lista = (List<Usuarios>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }
    
    public Usuarios login(String usuario , String password){
        Usuarios u = new Usuarios();
         SessionFactory factory = HibernateUtil.getSessionFactory();
          Session session = factory.openSession();
        try{
            Query q = session.createQuery("FROM Usuarios u where u.correo=:correo AND u.contra=:contra")
            .setParameter("correo", usuario).setParameter("contra",password);
            u=q.list().size()>0?(Usuarios) q.list().get(0):null;
        }catch(Exception e){
            System.out.println("error al logear" + e);
        }finally{
            session.close();
        }
        return u;
    }
    
    
     public int modificar (Integer idUsuario, String nombre, String correo, String contra, String genero, String tipo , String pregunta, String respuesta){
        int mensaje = 0;
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        Usuarios usuario = new Usuarios();
        
        usuario.setIdUsuario(idUsuario);
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContra(contra);
        usuario.setGenero(genero);
        usuario.setTipo(tipo);
        usuario.setPregunta(pregunta);
        usuario.setRespuesta(respuesta);
        
        session.beginTransaction();
        
        try {
            session.update(usuario);
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
     
     public Usuarios consultarId (Integer idUsuario){
         
         SessionFactory factory = HibernateUtil.getSessionFactory();
         Session session = factory.openSession();
         Usuarios usuario = null;
         
         String mensaje = "";
         try {
             session.beginTransaction();
             usuario = (Usuarios) session.get(Usuarios.class, idUsuario);
//             session.getTransaction();
             session.getTransaction().commit();
             mensaje = "se busco por id con exito";
         } catch (Exception e) {
             if(session.getTransaction().isActive()){
                 session.getTransaction().rollback();
                 mensaje ="no pudo buscar por id por "+e;
             }
             e.printStackTrace();
         } finally {
             session.close();
         }
         return usuario;
     }
     
     public boolean consultarPorCorreo(String correo){
         SessionFactory factory = HibernateUtil.getSessionFactory();
         Session session = factory.openSession();
         boolean r = false;
         try {
             Query q = session.createQuery("Select from Usuarios u where u.correo=:correo").setParameter("correo", correo);
             r=q.list().size()>0;             
         } catch (Exception e) {
             System.out.println("ERROR AL BUSCAR POR CORREO. "+e);
         }finally{
             session.close();
         }
         return r;
     }

}
