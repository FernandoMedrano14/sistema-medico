package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormFarmacias;
import java.util.List;
import static java.util.stream.Collectors.mapping;
import mantenimiento.MantenimientoFarmacias;
import persistencia.Farmacias;

public class ActionFarmacias extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmacionNuevaFarmacia";
    private static final String Eliminar = "eliminarFarmacia";
    private static final String Error = "errorMantenimientoFarmacias";
    private static final String guardado = "guardadoFarmacia";
    private static final String confirmarID = "confirmacionConsultaIdFarmacia";
    private static final String consultar = "consultarFarmacia";
    private static final String modificar = "modificarFarmacia";
    private static final String irmodificar = "irmodificarFarmacia";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormFarmacias formBean = (ActionFormFarmacias) form;
        Integer idFarmacia = formBean.getIdFarmacia();
        String direccion = formBean.getDireccion();
        String action = formBean.getAction();

        if (formBean == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar")) {
            String advertencia = "";

            if (direccion == null || direccion.equals("")) {
                advertencia = "*Es necesario ingresar direccion<br>";
            }

            if (!advertencia.equals("")) {
                formBean.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }
            MantenimientoFarmacias farmacias = new MantenimientoFarmacias();

            String respuesta = farmacias.guardarFarmacia(idFarmacia, direccion);
            System.out.println("Agregar " + respuesta);
            if (respuesta.equals("")) {
                formBean.setError("Ocurrio un error al insertar.");
                return mapping.findForward(Error);

            }
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> La Farmacia ha sido guardada.\n</div>");
            request.setAttribute("advertencia", advertencia);
            //return mapping.findForward(mensaje);
            return mapping.findForward(guardado);

        }

        if (action.equals("Consultar_Farmacias")) {
            MantenimientoFarmacias farmacias = new MantenimientoFarmacias();
            List<Farmacias> lista = farmacias.consultarTodoFarmacias();
            if (lista == null) {
                formBean.setError("<span style='color:white'>Farmacia ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formBean.setListaFarmacias(lista);
                String message = "";
                if (!LoginAction.acceso.equals("Admin")) {
                    message = "style=\"display: none\"";
                }
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
            String advertencia = "";
            MantenimientoFarmacias farmacias = new MantenimientoFarmacias();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            String recibido = request.getParameter("direccion");

            if (farmacias.eliminarFarmacias(idRecibido) == 0) {
                formBean.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Farmacias> lista = farmacias.consultarTodoFarmacias();
                formBean.setListaFarmacias(lista);
                formBean.setIdFarmacia(idRecibido);
                advertencia = ("<div class=\"alert alert-danger\">\n<strong>Registro eliminado:</strong> La Farmacia ha sido eliminada.\n</div>");
                request.setAttribute("advertencia", advertencia);
            }
            return mapping.findForward(Eliminar);
        }

        if (action.equals("Consulta")) {
            MantenimientoFarmacias farmacias = new MantenimientoFarmacias();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            //String Recibinido = request.getParameter("direccion");

            if (farmacias.consultarId(idRecibido) == 0) {
                formBean.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                formBean.setIdFarmacia(idRecibido);
                formBean.setMensaje("<spam style='color:green'> Ha sido modificado con exito");
                return mapping.findForward(confirmarID);
            }
        }

       /* if (action.equals("Modificar")) {
            MantenimientoFarmacias farmacias = new MantenimientoFarmacias();
            String advertencia = "";
            farmacias.modificar(idFarmacia, direccion);
            System.out.println("error al modificar");
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> La Farmacia ha sido modificada.\n</div>");
            request.setAttribute("advertencia", advertencia);
            List<Farmacias> listaFarmacias = farmacias.consultarTodoFarmacias();
            formBean.setListaFarmacias(listaFarmacias);
            /*List<Especialidades> lista = espe.consultar();
            formEspe.setListaEspe(lista)
            return mapping.findForward(consultar);
        }*/

        /*  if(action.equals("irModificar")){
            System.out.println("Estoy en irmodificar");
            String id =request.getParameter("id");
            System.out.println(id);
            MantenimientoFarmacias farmacias = new MantenimientoFarmacias();
            formBean.setDireccion(farmacias.getDireccion());
        }*/
        
        if(action.equals("Modificar")){
            System.out.println("estoy en modificar");
            MantenimientoFarmacias farmacia = new MantenimientoFarmacias();
            System.out.println(idFarmacia + direccion);
            
            int confirmar = farmacia.modificar(idFarmacia, direccion);
            System.out.println(confirmar);
            
            List<Farmacias> lista = farmacia.consultarTodoFarmacias();
            formBean.setListaFarmacias(lista);
            return mapping.findForward(consultar);
        }
        
        if(action.equals("irModificar")){
            System.out.println("estoy en ir modificar");
            String id = request.getParameter("id");
            idFarmacia = Integer.parseInt(id);
            System.out.println(id);
            MantenimientoFarmacias farmacia = new MantenimientoFarmacias();
            Farmacias far = farmacia.consultaId(idFarmacia);
            
            formBean.setIdFarmacia(far.getIdFarmacia());
            formBean.setDireccion(far.getDireccion());
            return mapping.findForward(irmodificar);
        }
        
        return mapping.findForward(Confirmar);
    }
}
