package action;

import actionforms.ActionFormCitas;
import actionforms.ActionFormCitas;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;
import persistencia.Citas;
import mantenimiento.MantenimientoCitas;
import mantenimiento.MantenimientoConsultorios;
import mantenimiento.MantenimientoMedicos;
import mantenimiento.MantenimientoPacientes;
import persistencia.Consultorios;
import persistencia.Medicos;
import persistencia.Pacientes;

public class ActionCitas extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmacionNuevaCita";
    private static final String Eliminar = "EliminarCita";
    private static final String Error = "errorMantenimientoCita";
    private static final String guardado = "guardadoCita";
    private static final String AGREGAR = "irAgregarCita";
    private static final String confirmarID = "consultaIdCita";
    private static final String consultar = "consultarCitas";
    private static final String modificar = "modificarCitas";
    private static final String irmodificar = "irmodificarCitas";

    MantenimientoCitas cita = new MantenimientoCitas();
    MantenimientoMedicos medicos = new MantenimientoMedicos();
    MantenimientoPacientes pacientes = new MantenimientoPacientes();
    MantenimientoConsultorios consultorios = new MantenimientoConsultorios();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormCitas formci = (ActionFormCitas) form;
        Integer idCita = formci.getIdCita();
        Integer idConsultorio = formci.getIdConsultorio();
        Integer idPaciente = formci.getIdPaciente();
        Integer idMedico = formci.getIdMedico();
        String fecha_cita = formci.getFecha_cita();
        String hora_cita = formci.getHora_cita();
        String action = formci.getAction();
        
        System.out.println("El valor de Action es = "+action);
        
        if (formci == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("irAgregar")) {
            
            System.out.println(" en ir Agregar");
            
            List<Consultorios> listaConsultorio = consultorios.mostrarConsultorio();
            formci.setListaConsultorio(listaConsultorio);
            request.setAttribute("listaConsultorios", listaConsultorio);
            
            System.out.println("luego de lista consultorios ");
            List<Pacientes> listaPacientes = pacientes.mostrar();
            formci.setListaPacientes(listaPacientes);
            request.setAttribute("listaPacientes", listaPacientes);
            
            System.out.println("luego de lista pacientes ");
            List<Medicos> listamedi = medicos.consultar();
            System.out.println("Lista Medicos "+listamedi.toString());
            formci.setListamedi(listamedi);
            request.setAttribute("listaMedicos", listamedi);
            
            System.out.println("luego de lista medicos ");
            
            return mapping.findForward(AGREGAR);

        }

        if (action.equals("Agregar")) {
            String adver = "";

            if (idConsultorio == null || idConsultorio.equals("")) {
                adver = "Es necesario agregar el campo";
            }

            if (idPaciente == null || idPaciente.equals("")) {
                adver = "Es necesario agregar el campo";
            }

            if (idMedico == null || idMedico.equals("")) {
                adver = "Es necesario agregar el campo";
            }

            if (fecha_cita == null || fecha_cita.equals("")) {
                adver = "Es necesario agregar el campo";
            }

            if (hora_cita == null || hora_cita.equals("")) {
                adver = "Es necesario agregar el campo";
            }

            if (!adver.equals("")) {
                formci.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + adver + "</span>");
                return mapping.findForward(Error);
            }

            MantenimientoCitas citas = new MantenimientoCitas();
            MantenimientoConsultorios consultorios = new MantenimientoConsultorios();
            MantenimientoPacientes pacientes = new MantenimientoPacientes();
            MantenimientoMedicos medicos = new MantenimientoMedicos();
            String respuesta = cita.guardar(idCita, idConsultorio, idPaciente, idMedico, fecha_cita, hora_cita);
            String advertencia = "";
            if (respuesta.equals("")) {
                formci.setError("Ocurrio un error al guardar");
                return mapping.findForward(Error);
            }
            List<Consultorios> listaConsultorio = consultorios.mostrarConsultorio();
            formci.setListaConsultorio(listaConsultorio);
            request.setAttribute("listaConsultorio", listaConsultorio);
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> Las citas han sido guardadas.\n</div>");
            request.setAttribute("advertencia", advertencia);

            List<Pacientes> listaPacientes = pacientes.mostrar();
            formci.setListaPacientes(listaPacientes);
            request.setAttribute("listaPacientes", listaPacientes);
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> Las citas han sido guardadas.\n</div>");
            request.setAttribute("advertencia", advertencia);

            List<Medicos> listamedi = medicos.consultar();
            formci.setListamedi(listamedi);
            request.setAttribute("listamedi", listamedi);
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> La nueva cita ha sido guardada.\n</div>");
            request.setAttribute("advertencia", advertencia);
            return mapping.findForward(guardado);
        }

        if (action.equals("Consultar_Citas")) {
            MantenimientoCitas citas = new MantenimientoCitas();
            List<Citas> lista = cita.mostrar();
            if (lista == null) {
                formci.setError("no logramos hacer la consulta");
                return mapping.findForward(Error);
            } else {
                formci.setListaCitas(lista);
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
            MantenimientoCitas citas = new MantenimientoCitas();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));

            if (citas.eliminar(idRecibido) == 0) {
                formci.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Citas> lista = citas.mostrar();
                formci.setListaCitas(lista);
                formci.setIdCita(idRecibido);
            }
            //cita.eliminar(idCita);
            return mapping.findForward(Eliminar);
        }

        if (action.equals("BuscarId")) {
            //int citas = cita.consutarId(idCita);
            MantenimientoCitas citas = new MantenimientoCitas();
            Integer idRecibido = (Integer.parseInt(request.getParameter("id")));
            Citas c = citas.consultarId(idRecibido);
            formci.setIdCita(c.getIdCita());
            formci.setIdConsultorio(c.getConsultorios().getIdConsultorio());
            formci.setIdPaciente(c.getPacientes().getIdPaciente());
            formci.setIdMedico(c.getMedicos().getIdMedico());
            formci.setFecha_cita(c.getFechaCita());
            formci.setHora_cita(c.getHoraCita());
            return mapping.findForward(confirmarID);
        }

        if (action.equals("Modificar")) {
            String advertencia = "";
            Citas c = new Citas();
            c.setIdCita(idCita);
            Consultorios con = new Consultorios();
            con.setIdConsultorio(idConsultorio);
            Pacientes p = new Pacientes();
            p.setIdPaciente(idPaciente);
            Medicos med = new Medicos();
            med.setIdMedico(idMedico);
            c.setConsultorios(con);
            c.setPacientes(p);
            c.setMedicos(med);
            c.setFechaCita(fecha_cita);
            c.setHoraCita(hora_cita);

            MantenimientoCitas citas = new MantenimientoCitas();
            citas.modificar(idCita, idConsultorio, idPaciente, idMedico, fecha_cita, hora_cita);
            formci.setError("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> las citas han sido modificadas.\n</div>");
            formci.setIdConsultorio(c.getConsultorios().getIdConsultorio());
            formci.setIdPaciente(c.getPacientes().getIdPaciente());
            formci.setIdMedico(c.getMedicos().getIdMedico());
            formci.setFecha_cita(c.getFechaCita());
            formci.setHora_cita(c.getHoraCita());

            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> las citas han sido modificadas.\n</div>");
            request.setAttribute("advertencia", advertencia);
            List<Citas> listc = citas.mostrar();
            formci.setListaCitas(listc);
            return mapping.findForward(consultar);
        }

        if (action.equals("irModificar")) {
            System.out.println("estoy en irModificar");
            String id = request.getParameter("id");
            idCita = Integer.parseInt(id);
            System.out.println(id);
            MantenimientoCitas cit = new MantenimientoCitas();
            Citas citas = cit.consultarId(idCita);

            formci.setIdCita(citas.getIdCita());
            formci.setFecha_cita(citas.getFechaCita());
            formci.setHora_cita(citas.getHoraCita());

            return mapping.findForward(irmodificar);
        }

        return mapping.findForward(Confirmar);

    }
}
