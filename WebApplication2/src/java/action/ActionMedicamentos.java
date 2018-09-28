package action;

import actionforms.ActionFormMedicamentos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;
import mantenimiento.MantenimientoFarmacias;

import persistencia.Medicamentos;
import mantenimiento.MantenimientoMedicamentos;
import mantenimiento.MantenimientoProveedores;
import persistencia.Farmacias;
import persistencia.Proveedores;

public class ActionMedicamentos extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmarMedicamentos";
    private static final String Eliminar = "eliminarMedicamentos";
    private static final String Error = "errorMedicamentos";
    private static final String guardado ="guardadoMedicamento";
    private static final String AGREGAR = "irAgregarMedicamento";
    private static final String confirmarID = "consultaIdMedicamento";
    private static final String consultar = "consultarMedicamentos";
    private static final String modificar = "modificarMedicamento";
    private static final String irmodificar = "irmodificarMedicamento";

    MantenimientoMedicamentos med = new MantenimientoMedicamentos();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormMedicamentos formed = (ActionFormMedicamentos) form;
        Integer idMedicamento = formed.getIdMedicamento();
        Integer idProveedor = formed.getIdProveedor();
        Integer idFarmacia = formed.getIdFarmacia();
        String nombre = formed.getNombre();
        String tipo = formed.getTipo();
        String action = formed.getAction();

        if (formed == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar Medicamentos")) {
            MantenimientoFarmacias farmacia = new MantenimientoFarmacias();
            List<Farmacias> listaFarmacias = farmacia.consultarTodoFarmacias();
            formed.setListaFarmacias(listaFarmacias);
            request.setAttribute("listaFarmacias", listaFarmacias);

            MantenimientoProveedores proveedores = new MantenimientoProveedores();
            List<Proveedores> listaProveedores = proveedores.consultarTodoProveedores();
            formed.setListaProveedores(listaProveedores);
            request.setAttribute("listaProveedores", listaProveedores);
            
            return mapping.findForward(AGREGAR);
        }
        if (action.equals("Agregar")) {
            String advertencia = "";
            if (idFarmacia == null || idFarmacia.equals("")) {
                advertencia = "Es necesario agregar el campo de farmacias";
            }
            if (idProveedor == null || idProveedor.equals("")) {
                advertencia = "Es necesario agregar el campo de proveedor";
            }
            if (nombre == null || nombre.equals("")) {
                advertencia = "es necesario agregar el nombre";
            }
            if (tipo == null || tipo.equals("")) {
                advertencia = "es imprescindible agregar el tipo";
            }
            if (!advertencia.equals("")) {
                formed.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            MantenimientoMedicamentos med = new MantenimientoMedicamentos();
            MantenimientoFarmacias farmacia = new MantenimientoFarmacias();
            MantenimientoProveedores proveedores = new MantenimientoProveedores();
            String respuesta = med.guardar(idMedicamento, idFarmacia, idProveedor, nombre, tipo);

            if (respuesta.equals("")) {
                formed.setError("Error al guardar");
                return mapping.findForward(Error);
            }
            List<Farmacias> listaFarmacias = farmacia.consultarTodoFarmacias();
            formed.setListaFarmacias(listaFarmacias);
            request.setAttribute("listaFarmacias", listaFarmacias);
            
            List<Proveedores>listaProveedores = proveedores.consultarTodoProveedores();
            formed.setListaProveedores(listaProveedores);
            request.setAttribute("listaProveedores", listaProveedores);
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> Los medicamentos han sido guardados.\n</div>");
            request.setAttribute("advertencia", advertencia);
            
            return mapping.findForward(guardado);
            
        }

        if (action.equals("Eliminar")) {
            MantenimientoMedicamentos medi = new MantenimientoMedicamentos();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));

            if (medi.eliminar(idRecibido) == 0) {
                formed.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Medicamentos> lista = medi.mostrar();
                formed.setListaMedicamentos(lista);
                formed.setIdMedicamento(idRecibido);
            }
            return mapping.findForward(Eliminar);
        }

        if (action.equals("Consultar_Medicamentos")) {
            MantenimientoMedicamentos med = new MantenimientoMedicamentos();
            List<Medicamentos> lista = med.mostrar();
            if (lista == null) {
                formed.setError("<span style='color:white'>Usuario ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formed.setListaMedicamentos(lista);
                return mapping.findForward(consultar);
            }
        }
        if (action.equals("BuscarId")) {
            MantenimientoMedicamentos medi = new MantenimientoMedicamentos();
            Integer idRecibido = (Integer.parseInt(request.getParameter("id")));
            Medicamentos m = medi.buscarById(idRecibido);
            formed.setIdMedicamento(m.getIdMedicamento());
            formed.setIdFarmacia(m.getFarmacias().getIdFarmacia());
            formed.setIdProveedor(m.getProveedores().getIdProveedor());
            formed.setNombre(m.getNombre());
            formed.setTipo(m.getTipo());
            return mapping.findForward(confirmarID);

        }
        if (action.equals("Modificar")) {
            String advertencia = "";
            Medicamentos m = new Medicamentos();
            m.setIdMedicamento(idMedicamento);
            
            Farmacias f = new Farmacias();
            f.setIdFarmacia(idFarmacia);
            
            Proveedores p = new Proveedores();
            p.setIdProveedor(idProveedor);
            
            m.setFarmacias(f);
            m.setProveedores(p);
            m.setNombre(nombre);
            m.setTipo(tipo);

            MantenimientoMedicamentos md = new MantenimientoMedicamentos();
            md.modificar(idMedicamento, idFarmacia, idProveedor, nombre, tipo);
            formed.setError("<div class=\"alert alert-danger\">\n<strong>Registro NO modificado:</strong> El medicamento no ha sido modificado.\n</div>");
            formed.setIdFarmacia(m.getFarmacias().getIdFarmacia());
            formed.setIdProveedor(m.getProveedores().getIdProveedor());
            formed.setNombre(m.getNombre());
            formed.setTipo(m.getTipo());

            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> El medicamento ha sido modificado.\n</div>");
            request.setAttribute("advertencia", advertencia);
            List<Medicamentos> listm = md.mostrar();
            formed.setListaMedicamentos(listm);
            return mapping.findForward(consultar);
        }

        if (action.equals("irModificarMedicamento")) {
            System.out.println("estoy en irModificar");
            String id = request.getParameter("id");
            idMedicamento = Integer.parseInt(id);
            System.out.println(id);
            MantenimientoMedicamentos medi = new MantenimientoMedicamentos();
            Medicamentos medicamentos = medi.buscarById(idMedicamento);

            formed.setIdFarmacia(medicamentos.getIdMedicamento());
            formed.setNombre(medicamentos.getNombre());
            formed.setTipo(medicamentos.getTipo());

            return mapping.findForward(irmodificar);
        }

        return mapping.findForward(Confirmar);

    }
}
