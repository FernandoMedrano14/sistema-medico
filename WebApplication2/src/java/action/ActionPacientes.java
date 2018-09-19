package action;

import actionforms.ActionFormPacientes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;
import mantenimiento.MantenimientoPacientes;
import persistencia.Pacientes;

public class ActionPacientes extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmacionNuevoPaciente";
    private static final String Error = "errorMantenimientoPacientes";
    private static final String Eliminar = "confirmacionEliminarPacientes";
    MantenimientoPacientes pac = new MantenimientoPacientes();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormPacientes formpa = (ActionFormPacientes) form;
        Integer idPaciente = formpa.getIdPaciente();
        Integer idClinica = formpa.getIdClinica();
        Integer idMedicamento = formpa.getIdMedicamento();
        String nombre = formpa.getNombre();
        String apellido = formpa.getApellido();
        String sexo = formpa.getSexo();
        String fecha_nacimiento = formpa.getFecha_nacimiento();
        String telefono = formpa.getTelefono();
        String direccion = formpa.getDireccion();
        String action = formpa.getAction();

        if (formpa == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar")) {
            String adver = "";

            if (idClinica == null || idClinica.equals("")) {
                adver = "favor ingrese dato en el campo vacio";
            }

            if (idMedicamento == null || idMedicamento.equals("")) {
                adver = "favor ingrese dato en el campo vacio";
            }

            if (nombre == null || nombre.equals("")) {
                adver = "favor ingrese dato en el campo vacio";
            }

            if (apellido == null || apellido.equals("")) {
                adver = "favor ingrese dato en el campo vacio";
            }

            if (sexo == null || sexo.equals("")) {
                adver = "favor ingrese dato en el campo vacio";
            }

            if (fecha_nacimiento == null || fecha_nacimiento.equals("")) {
                adver = "favor ingrese dato en el campo vacio";
            }

            if (telefono == null || telefono.equals("")) {
                adver = "favor ingrese dato en el campo vacio";
            }

            if (direccion == null || direccion.equals("")) {
                adver = "favor ingrese dato en el campo vacio";
            }

            if (!adver.equals("")) {
                formpa.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + adver + "</span>");
                return mapping.findForward(Error);
            }

            String respuesta = pac.guardar(idPaciente, idMedicamento, idClinica, nombre, apellido, sexo, fecha_nacimiento, telefono, direccion);
            return mapping.findForward(Confirmar);
        }

        if (action.equals("Consultar")) {
            List<Pacientes> lista = pac.mostrar();
            if (lista == null) {
                formpa.setError("<span style='color:white'>Error al consultar el listado de pacientes" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formpa.setListaPacientes(lista);
                return mapping.findForward(Error);
            }
        }

        if (action.equals("Eliminar")) {
            pac.eliminar(idPaciente);
            return mapping.findForward(Eliminar);
        }

        if (action.equals("BuscarId")) {
            Pacientes paciente = pac.buscarById(idPaciente);
            if (paciente == null) {
                formpa.setError("<spam style='color:red'> El Registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                formpa.setIdPaciente(idPaciente);
                formpa.setIdClinica(idClinica);
                formpa.setIdMedicamento(idMedicamento);
                formpa.setNombre(nombre);
                formpa.setApellido(apellido);
                formpa.setSexo(sexo);
                formpa.setFecha_nacimiento(fecha_nacimiento);
                formpa.setTelefono(telefono);
                formpa.setDireccion(direccion);
                return mapping.findForward(Confirmar);
            }
        }

        if (action.equals("Modificar")) {
            pac.modificar(idPaciente, idMedicamento, idClinica, nombre, apellido, sexo, fecha_nacimiento, telefono, direccion);
            return mapping.findForward(Error);
        }
        return mapping.findForward(Confirmar);
    }
}
