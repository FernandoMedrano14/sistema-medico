package action;

import actionforms.ActionFormEspecialidades;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;
import persistencia.Especialidades;
import mantenimiento.MantenimientoEspecialidades;

public class ActionEspecialidades extends org.apache.struts.action.Action {

    private static final String Confirmar = "nuevaEspecialidad";
    private static final String Eliminar = "eliminarEspecialidades";
    private static final String Error = "errorEspecialidades";
    private static final String guardado = "guardadoEspecialidades";
    private static final String confirmarID = "consultaIdEspecialidades";
    private static final String consultar = "consultarEspecialidades";
    private static final String modificar = "modificarEspecialidades";
    private static final String irmodificar = "irmodificarEspecialidades";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormEspecialidades formEspe = (ActionFormEspecialidades) form;
        Integer idEspecialidad = formEspe.getIdEspecialidad();
        String tipo = formEspe.getTipo();
        String action = formEspe.getAction();

        if (formEspe == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar")) {
            String advertencia = "";

            if (tipo == null || tipo.equals("")) {
                advertencia = "*Es necesario agregar el tipo de Especialidad<br>";
            }

            if (!advertencia.equals("")) {
                formEspe.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            MantenimientoEspecialidades espe = new MantenimientoEspecialidades();

            String respuesta = espe.guardar(idEspecialidad, tipo);
//            if("".equals(respuesta)){
//                return mapping.findForward(Confirmar);
//            } else {
//                formEspe.setError("ocurrio un error al insertar");
//                return mapping.findForward(Error);
//            }     
            if (respuesta.equals("")) {
                formEspe.setError("Ocurrio un error al insertar.");
                return mapping.findForward(Error);
            }
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> El Consultorio ha sido guardado.\n</div>");
            request.setAttribute("advertencia", advertencia);
            //return mapping.findForward(mensaje);
            return mapping.findForward(guardado);
        }

        if (action.equals("Consultar_Especialidades")) {
            MantenimientoEspecialidades espe = new MantenimientoEspecialidades();
            List<Especialidades> lista = espe.consultar();
            if (lista == null) {
                formEspe.setError("<span style='color:white'>Usuario ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formEspe.setListaEspe(lista);
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
            MantenimientoEspecialidades espe = new MantenimientoEspecialidades();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));

            if (espe.eliminar(idRecibido) == 0) {
                formEspe.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Especialidades> lista = espe.consultar();
                formEspe.setListaEspe(lista);
                formEspe.setIdEspecialidad(idRecibido);
            }
            return mapping.findForward(Eliminar);
        }

        if (action.equals("BuscarId")) {
            MantenimientoEspecialidades espe = new MantenimientoEspecialidades();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            Especialidades especialidad = espe.consultarId(idRecibido);
            if (especialidad == null) {
                formEspe.setError("<spam style='color:red'> El Registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                formEspe.setIdEspecialidad(idEspecialidad);
                formEspe.setTipo(tipo);
                return mapping.findForward(confirmarID);
            }
        }

        if (action.equals("Modificar")) {
            MantenimientoEspecialidades espe = new MantenimientoEspecialidades();
             String advertencia = "";
            espe.modificar(idEspecialidad, tipo);
            System.out.println("error al modificar");
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> La Especialidad ha sido modificada.\n</div>");
            request.setAttribute("advertencia", advertencia);
            List<Especialidades> lista = espe.consultar();
            formEspe.setListaEspe(lista);
            return mapping.findForward(consultar);
        }
        
        if (action.equals("irModificar")) {
            System.out.println("estoy en irModificar");
            String id = request.getParameter("id");
            idEspecialidad = Integer.parseInt(id);
            System.out.println(id);
            MantenimientoEspecialidades espe = new MantenimientoEspecialidades();
            Especialidades especialidad = espe.consultarId(idEspecialidad);

            formEspe.setIdEspecialidad(especialidad.getIdEspecialidad());
            formEspe.setTipo(especialidad.getTipo());
            
            return mapping.findForward(irmodificar);
        }
        return mapping.findForward(Confirmar);
    }

}
