package action;

import actionforms.ActionFormConsultorios;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;

import mantenimiento.MantenimientoConsultorios;
import persistencia.Consultorios;

public class ActionConsultorios extends org.apache.struts.action.Action {

    private static final String Confirmar = "nuevoConsultorio";
    private static final String guardado = "guardadoConsultorio";
    private static final String Eliminar = "eliminarConsultorio";
    private static final String Error = "errorConsultorio";
    private static final String confirmarID = "consultaId";
    private static final String consultar = "consultarConsultorio";
    private static final String modificar = "modificarConsultorios";
    private static final String irmodificar = "irmodificarConsultorios";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormConsultorios formcon = (ActionFormConsultorios) form;
        Integer idConsultorio = formcon.getIdConsultorio();
        Integer numero = formcon.getNumero();
        String area = formcon.getArea();
        String action = formcon.getAction();

        if (formcon == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar")) {
            String advertencia = "";

            if (numero == null || numero.equals("")) {
                advertencia = "*Es necesario agragar el numero<br>";
            }

            if (area == null || area.equals("")) {
                advertencia = "*se necesita ingresar el area<br>";
            }

            if (!advertencia.equals("")) {
                formcon.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            MantenimientoConsultorios con = new MantenimientoConsultorios();
            String respuesta = con.guardar(idConsultorio, numero, area);
//            if (respuesta.equals("")) {
//                return mapping.findForward(Confirmar);
//            } else {
//                formcon.setError("ocurrio un problema al guardar");
//                return mapping.findForward(Error);
//            }

            if (respuesta.equals("")) {
                formcon.setError("Ocurrio un error al insertar.");
                return mapping.findForward(Error);
            }
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> El Consultorio ha sido guardado.\n</div>");
            request.setAttribute("advertencia", advertencia);
            //return mapping.findForward(mensaje);
            return mapping.findForward(guardado);
        }

        if (action.equals("Consultar_Consultorios")) {
            MantenimientoConsultorios con = new MantenimientoConsultorios();
            List<Consultorios> lista = con.mostrarConsultorio();
            if (lista == null) {
                formcon.setError("<span style='color:white'>Consultorio ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formcon.setListaConsultorio(lista);
                String message = "";
                if (!LoginAction.acceso.equals("Admin")) {
                    message = "style=\"display: none\"";
                }
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
            MantenimientoConsultorios con = new MantenimientoConsultorios();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));

            if (con.eliminar(idRecibido) == 0) {
                formcon.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Consultorios> lista = con.mostrarConsultorio();
                formcon.setListaConsultorio(lista);
                formcon.setIdConsultorio(idRecibido);
            }
            return mapping.findForward(Eliminar);
        }

        if (action.equals("BuscarId")) {
            MantenimientoConsultorios con = new MantenimientoConsultorios();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));

            if (con.consultarId(idRecibido) == 0) {
                formcon.setError("<spam style='color:red'> El Registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                formcon.setIdConsultorio(idRecibido);
                return mapping.findForward(confirmarID);
            }

        }

        if (action.equals("Modificar")) {
            System.out.println("estoy en modificar");
            MantenimientoConsultorios con = new MantenimientoConsultorios();
            System.out.println(idConsultorio + numero + area);

            int confirmacion = con.modificar(idConsultorio, numero, area);
            System.out.println(confirmacion);
            //------------------------------------------------------
            List<Consultorios> lista = con.mostrarConsultorio();
            formcon.setListaConsultorio(lista);
            return mapping.findForward(consultar);
        }
        if (action.equals("irModificar")) {
            System.out.println("estoy en irModificar");
            String id = request.getParameter("id");
            idConsultorio = Integer.parseInt(id);
            System.out.println(id);
            MantenimientoConsultorios con = new MantenimientoConsultorios();
            Consultorios consult = con.consultaId(idConsultorio);

            formcon.setIdConsultorio(consult.getIdConsultorio());
            formcon.setNumero(consult.getNumero());
            formcon.setArea(consult.getArea());

            return mapping.findForward(irmodificar);
        }
        return mapping.findForward(Confirmar);
    }

}
