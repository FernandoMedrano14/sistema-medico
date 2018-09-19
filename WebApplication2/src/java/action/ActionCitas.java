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

public class ActionCitas extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmacionNuevaCita";
    private static final String Eliminar = "confirmacionEliminarCita";
    private static final String Error = "errorMantenimientoCita";
    private static final String guardado = "guardadoCita";
    private static final String confirmarID = "consultaId";
    private static final String consultar = "consultarCitas";
    private static final String modificar = "modificarCitas";
    private static final String irmodificar = "irmodificarCitas";

    MantenimientoCitas cita = new MantenimientoCitas();

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

        if (formci == null || action == null) {
            return mapping.findForward(Error);
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
            String respuesta = cita.guardar(idCita, idConsultorio, idPaciente, idMedico, fecha_cita, hora_cita);
            String advertencia = "";
            if (respuesta.equals("")) {
                formci.setError("Ocurrio un error al guardar");
                return mapping.findForward(Error);
            }
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> La cita ha sido guardada.\n</div>");
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
                formci.setIdCita(idCita);
            }
            //cita.eliminar(idCita);
            return mapping.findForward(Eliminar);
        }

        if (action.equals("BuscarId")) {
            //int citas = cita.consutarId(idCita);
            MantenimientoCitas citas = new MantenimientoCitas();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            if (citas.consultarId(idRecibido) == 0) {
                formci.setError("<spam style='color:red'> El Registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                formci.setIdCita(idRecibido);
                formci.setIdConsultorio(idConsultorio);
                formci.setIdPaciente(idPaciente);
                formci.setIdMedico(idMedico);
                formci.setFecha_cita(fecha_cita);
                formci.setHora_cita(hora_cita);
                return mapping.findForward(confirmarID);
            }
        }

        if (action.equals("Modificar")) {
            System.out.println("Estoy en conchetumadre");
            MantenimientoCitas citas = new MantenimientoCitas();
            System.out.println(idCita + idPaciente + idMedico + fecha_cita + hora_cita);
            //cita.modificar(idCita, idConsultorio, idPaciente, idMedico, fecha_cita, hora_cita);
            int confirmación = citas.modificar(idCita, idConsultorio, idPaciente, idMedico, fecha_cita, hora_cita);
            System.out.println(confirmación);
            
            List<Citas> lista = citas.mostrar();
            formci.setListaCitas(lista);
            return mapping.findForward(consultar);
        }
        
        
        return mapping.findForward(Confirmar);
    }

}
