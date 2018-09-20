package action;

import actionforms.ActionFormProveedores;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.MantenimientoProveedores;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencia.Proveedores;

public class ActionProveedores extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmacionNuevoProveedor";
    private static final String guardado = "guardadoProveedor";
    private static final String Eliminar = "eliminarProveedor";
    private static final String Error = "errorMantenimientoProveedores";
    private static final String ConfirmarID = "confirmacionConsultaIdProveedor";
    private static final String consultar = "consultarProveedor";
    private static final String modificar = "modificarProveedor";
    private static final String irmodificar = "irmodificarProveedor";

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormProveedores formBean = (ActionFormProveedores) form;
        Integer idProveedor = formBean.getIdProveedor();
        String rubro = formBean.getRubro();
        String encargado = formBean.getEncargado();
        String action = formBean.getAction();

        if (formBean == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar")) {
            String advertencia = "";

            if (rubro == null || rubro.equals("")) {
                advertencia = "*Campo requerido<br>";
            }
            if (encargado == null || encargado.equals("")) {
                advertencia = "*Campo requerido<br>";
            }
            if (!advertencia.equals("")) {
                formBean.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }
            MantenimientoProveedores proveedores = new MantenimientoProveedores();

            int respuesta = proveedores.guardarProveedor(idProveedor, rubro, encargado);
            String mensaje = "";
            System.out.println("Agregar " + respuesta);

            if (respuesta == 6) {
                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> El proveedor ha sido guardado.\n</div>");
            } else if (respuesta == 1) {
                advertencia = ("<div class=\"alert alert-success\">\n<strong>Error al registrar:</strong> El proveedor no ha sido guardado.\n</div>");
            }
            request.setAttribute("advertencia", advertencia);
            return mapping.findForward(guardado);

        }

        if (action.equals("Consultar_Proveedores")) {
            MantenimientoProveedores proveedores = new MantenimientoProveedores();
            List<Proveedores> lista = proveedores.consultarTodoProveedores();
            if (lista == null) {
                formBean.setError("<span style='color:white'>Proveedor ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formBean.setListaProveedores(lista);
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
            MantenimientoProveedores proveedores = new MantenimientoProveedores();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));

            if (proveedores.eliminarProveedor(idRecibido) == 0) {
                formBean.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Proveedores> lista = proveedores.consultarTodoProveedores();
                formBean.setListaProveedores(lista);
                formBean.setIdProveedor(idRecibido);
            }
            return mapping.findForward(Eliminar);
        }

        if (action.equals("Consulta")) {
            MantenimientoProveedores proveedores = new MantenimientoProveedores();
            //int idRecibido = (Integer.parseInt(request.getParameter("id")));
            /*String rubroRecibido = request.getParameter("rubro");
            String encargadoRecibido = request.getParameter("encargado");*/

//            if (proveedores.consultarId(idRecibido)==0) {
//                formBean.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
//                return mapping.findForward(Error);
//            } else {
//                formBean.setIdProveedor(idRecibido);
//               /* formBean.setRubro(rubroRecibido);
//                formBean.setEncargado(encargadoRecibido);*/
//                return mapping.findForward(ConfirmarID);
//            }
            List<Proveedores> lista = proveedores.consultarTodoProveedores();
            if (lista == null) {
                formBean.setError("<span style='color:white'>Consultorio ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formBean.setListaProveedores(lista);
                return mapping.findForward(consultar);
            }
        }

//        if (action.equals("Modificar")) {
//            MantenimientoProveedores proveedores = new MantenimientoProveedores();
//            proveedores.modificar(idProveedor, rubro, encargado);
//            System.out.println("error al modificar");
//            return mapping.findForward(modificar);
//        }
        if (action.equals("Modificar")) {
            System.out.println("estoy en modificar");
            MantenimientoProveedores pro = new MantenimientoProveedores();
            System.out.println(idProveedor + rubro + encargado);
            int confirmacion = pro.modificar(idProveedor, rubro, encargado);
            System.out.println(confirmacion);
            List<Proveedores> listaPro = pro.consultarTodoProveedores();
            formBean.setListaProveedores(listaPro);
            return mapping.findForward(consultar);
        }

        if (action.equals("irModificar")) {
            System.out.println("estoy en irModificar");
            String id = request.getParameter("id");
            idProveedor = Integer.parseInt(id);
            System.out.println(id);

            MantenimientoProveedores pro = new MantenimientoProveedores();
            Proveedores prov = pro.consultaId(idProveedor);

            formBean.setIdProveedor(prov.getIdProveedor());
            formBean.setRubro(prov.getRubro());
            formBean.setEncargado(prov.getEncargado());
            return mapping.findForward(irmodificar);
        }

        return mapping.findForward(Confirmar);
    }
}
