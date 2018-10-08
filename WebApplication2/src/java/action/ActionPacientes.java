package action;

import actionforms.ActionFormPacientes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;
import mantenimiento.MantenimientoClinicas;
import mantenimiento.MantenimientoMedicamentos;
import mantenimiento.MantenimientoPacientes;
import persistencia.Clinicas;
import persistencia.Medicamentos;
import persistencia.Pacientes;

public class ActionPacientes extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmarPacientes";
    private static final String Error = "errorMantenimientoPacientes";
    private static final String Eliminar = "EliminarPacientes";
    private static final String guardado = "guardadopacientes";
    private static final String agregar = "irAgregarPacientes";
    private static final String confirmarID = "consultaIdPacientes";
    private static final String consultar = "consultarPacientes";
    private static final String modificar = "modificarpacientes";
    private static final String irmodificar = "irmodificarpacientes";

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

        if (action.equals("Agregar Paciente")) {

            MantenimientoMedicamentos medicamentos = new MantenimientoMedicamentos();
            List<Medicamentos> listaMedicamentos = medicamentos.mostrar();
            formpa.setListaMedicamentos(listaMedicamentos);
            request.setAttribute("listaMedicamentos", listaMedicamentos);

            MantenimientoClinicas clinica = new MantenimientoClinicas();
            List<Clinicas> listaClinicas = clinica.mostrar();
            formpa.setListaClinicas(listaClinicas);
            request.setAttribute("listaClinicas", listaClinicas);
            return mapping.findForward(agregar);
        }

        if (action.equals("Agregar")) {
            String advertencia = "";

            if (idClinica == null || idClinica.equals("")) {
                advertencia = "favor ingrese dato en el campo vacio";
            }

            if (idMedicamento == null || idMedicamento.equals("")) {
                advertencia = "favor ingrese dato en el campo vacio";
            }

            if (nombre == null || nombre.equals("")) {
                advertencia = "favor ingrese dato en el campo vacio";
            }

            if (apellido == null || apellido.equals("")) {
                advertencia = "favor ingrese dato en el campo vacio";
            }

            if (sexo == null || sexo.equals("")) {
                advertencia = "favor ingrese dato en el campo vacio";
            }

            if (fecha_nacimiento == null || fecha_nacimiento.equals("")) {
                advertencia = "favor ingrese dato en el campo vacio";
            }

            if (telefono == null || telefono.equals("")) {
                advertencia = "favor ingrese dato en el campo vacio";
            }

            if (direccion == null || direccion.equals("")) {
                advertencia = "favor ingrese dato en el campo vacio";
            }

            if (!advertencia.equals("")) {
                formpa.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            MantenimientoPacientes pacientes = new MantenimientoPacientes();
            MantenimientoClinicas clinicas = new MantenimientoClinicas();
            MantenimientoMedicamentos medicamentos = new MantenimientoMedicamentos();
            String respuesta = pacientes.guardar(idPaciente, idMedicamento, idClinica, nombre, apellido, sexo, fecha_nacimiento, telefono, direccion);
            if (respuesta.equals("")) {
                formpa.setError("ocurrio un error al guardar");
                return mapping.findForward(Error);
            }
            List<Clinicas> listaClinicas = clinicas.mostrar();
            formpa.setListaClinicas(listaClinicas);
            request.setAttribute("listaClinicas", listaClinicas);
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> Los pacientes han sido guardados.\n</div>");
            request.setAttribute("advertencia", advertencia);

            List<Medicamentos> listaMedicamentos = medicamentos.mostrar();
            formpa.setListaMedicamentos(listaMedicamentos);
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> El paciente ha sido guardado.\n</div>");
            request.setAttribute("advertencia", advertencia);
            return mapping.findForward(guardado);

        }

        if (action.equals("Consultar_Pacientes")) {
            MantenimientoPacientes pacientes = new MantenimientoPacientes();
            List<Pacientes> lista = pacientes.mostrar();
            if (lista == null) {
                formpa.setError("<span style='color:white'>Error al consultar el listado de pacientes" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formpa.setListaPacientes(lista);
                String message = "";
                if (!LoginAction.acceso.equals("Admin")) {
                    message = "style=\"display: none\"";
                }
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
            MantenimientoPacientes pacientes = new MantenimientoPacientes();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            String advertencia = "";

            if (pacientes.eliminar(idRecibido) == 0) {
                formpa.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Pacientes> lista = pacientes.mostrar();
                formpa.setListaPacientes(lista);
                formpa.setIdPaciente(idRecibido);
                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro eliminado:</strong> El paciente ha sido eliminado del registro.\n</div>");
                request.setAttribute("advertencia", advertencia);
            }
            return mapping.findForward(Eliminar);

        }

        if (action.equals("BuscarId")) {
            MantenimientoPacientes pacientes = new MantenimientoPacientes();
            Integer idRecibido = (Integer.parseInt(request.getParameter("id")));
            Pacientes p = pacientes.buscarById(idRecibido);
            formpa.setIdPaciente(p.getIdPaciente());
            formpa.setIdClinica(p.getClinicas().getIdClinica());
            formpa.setIdMedicamento(p.getMedicamentos().getIdMedicamento());
            formpa.setNombre(p.getNombre());
            formpa.setApellido(p.getApellido());
            formpa.setSexo(p.getSexo());
            formpa.setFecha_nacimiento(p.getFechaNacimiento());
            formpa.setTelefono(p.getTelefono());
            formpa.setDireccion(p.getDireccion());
            return mapping.findForward(confirmarID);

        }

        if (action.equals("Modificar")) {
            String advertencia = "";
            Pacientes p = new Pacientes();
            p.setIdPaciente(idPaciente);
            Clinicas c = new Clinicas();
            c.setIdClinica(idClinica);
            Medicamentos m = new Medicamentos();
            m.setIdMedicamento(idMedicamento);
            p.setClinicas(c);
            p.setMedicamentos(m);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setSexo(sexo);
            p.setFechaNacimiento(fecha_nacimiento);
            p.setTelefono(telefono);
            p.setDireccion(direccion);

            MantenimientoPacientes pacientes = new MantenimientoPacientes();
            pacientes.modificar(idPaciente, idMedicamento, idClinica, nombre, apellido, sexo, fecha_nacimiento, telefono, direccion);
            formpa.setError("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> los pacientes han sido modificados.\n</div>");
            formpa.setIdClinica(p.getClinicas().getIdClinica());
            formpa.setIdMedicamento(p.getMedicamentos().getIdMedicamento());
            formpa.setNombre(p.getNombre());
            formpa.setApellido(p.getApellido());
            formpa.setSexo(p.getSexo());
            formpa.setFecha_nacimiento(p.getFechaNacimiento());
            formpa.setTelefono(p.getTelefono());
            formpa.setDireccion(p.getDireccion());

            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> los pacientes han sido modificados.\n</div>");
            request.setAttribute("advertencia", advertencia);
            List<Pacientes> listp = pacientes.mostrar();
            formpa.setListaPacientes(listp);
            return mapping.findForward(consultar);
        }

        if (action.equals("irModificar")) {
            System.out.println("estoy en irModificar");
            String id = request.getParameter("id");
            idPaciente = Integer.parseInt(id);
            System.out.println(id);
            MantenimientoPacientes pac = new MantenimientoPacientes();
            Pacientes pacien = pac.buscarById(idPaciente);

            formpa.setIdPaciente(pacien.getIdPaciente());
            formpa.setNombre(pacien.getNombre());
            formpa.setApellido(pacien.getApellido());
            formpa.setSexo(pacien.getSexo());
            formpa.setFecha_nacimiento(pacien.getFechaNacimiento());
            formpa.setTelefono(pacien.getTelefono());
            formpa.setDireccion(pacien.getDireccion());

            return mapping.findForward(irmodificar);
        }

        return mapping.findForward(Confirmar);
    }
}
