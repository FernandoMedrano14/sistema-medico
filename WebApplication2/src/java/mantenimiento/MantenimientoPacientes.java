package mantenimiento;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;
import persistencia.Pacientes;
import persistencia.Medicamentos;
import persistencia.Clinicas;

public class MantenimientoPacientes {

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    String mensaje = "error en el try-catch";

    public MantenimientoPacientes() {
        this.factory = factory;
        this.session = session;
    }

    public String guardar(Integer idPaciente, Integer idMedicamento, Integer idClinica, String nombre, String apellido, String sexo, String fecha_nacimiento, String telefono, String direccion) {

        Pacientes paciente = new Pacientes();
        paciente.setIdPaciente(idPaciente);

        Clinicas cli = new Clinicas();
        cli.setIdClinica(idClinica);
        paciente.setClinicas(cli);

        Medicamentos med = new Medicamentos();
        med.setIdMedicamento(idMedicamento);
        paciente.setMedicamentos(med);

        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setSexo(sexo);
        paciente.setFechaNacimiento(fecha_nacimiento);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);

        try {
            session.beginTransaction();
            session.save(paciente);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = "Exito al guardar";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no funciono la operacion por " + e;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }

    public String eliminar(Integer idPaciente) {
        Pacientes pa = new Pacientes();

        try {
            session.beginTransaction();
            pa = (Pacientes) session.get(Pacientes.class, idPaciente);
            session.delete(pa);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = "Exito al eliminar";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "error al eliminar por " + e;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }

    public List<Pacientes> mostrar() {
        List<Pacientes> lista = null;
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Pacientes");
            lista = query.list();
            mensaje = "Exito al consultar";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }

    public String modificar(Integer idPaciente, Integer idMedicamento, Integer idClinica, String nombre, String apellido, String sexo, String fecha_nacimiento, String telefono, String direccion) {

        Pacientes paciente = new Pacientes();
        paciente.setIdPaciente(idPaciente);

        Clinicas cli = new Clinicas();
        cli.setIdClinica(idClinica);
        paciente.setClinicas(cli);

        Medicamentos med = new Medicamentos();
        med.setIdMedicamento(idMedicamento);
        paciente.setMedicamentos(med);

        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setSexo(sexo);
        paciente.setFechaNacimiento(fecha_nacimiento);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);

        try {
            session.beginTransaction();
            session.update(paciente);
            session.getTransaction();
            session.getTransaction().commit();
            mensaje = "Exito al guardar";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "no funciono la operacion por " + e;
            }
        } finally {
            session.close();
        }
        return mensaje;
    }

    public Pacientes buscarById(Integer idPaciente) {
        Pacientes pa = new Pacientes();

        try {
            session.getTransaction();
            pa = (Pacientes) session.get(Pacientes.class, idPaciente);
            session.getTransaction().commit();
            mensaje = "Exito con la busqueda por Id";
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                mensaje = "Error al buscar por Id por " + e;
            }
        } finally {
            session.close();
        }
        return pa;
    }

}
