package action;

import actionforms.ActionFormMedicamentos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;

import persistencia.Medicamentos;
import mantenimiento.MantenimientoMedicamentos;

public class ActionMedicamentos extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmarMedicamentos";
    private static final String Eliminar = "eliminarMedicamentos";
    private static final String Error = "errorMedicamentos";

    MantenimientoMedicamentos med = new MantenimientoMedicamentos();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormMedicamentos formed = (ActionFormMedicamentos) form;
        Integer idMedicamento = formed.getIdMedicamento();
        Integer idFarmacia = formed.getIdFarmacia();
        Integer idProveedor = formed.getIdProveedor();
        String nombre = formed.getNombre();
        String tipo = formed.getTipo();
        String action = formed.getAction();

        if (formed == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar")) {
            String adver = "";

            if (idFarmacia == null || idFarmacia.equals("")) {
                adver = "Es imprescindible agregar el Id de Farmacia";
            }
            if (idProveedor == null || idProveedor.equals("")) {
                adver = "Es imprescindible agregar el Id de Proveedores";
            }
            if (nombre == null || nombre.equals("")) {
                adver = "por favor agrege el nombre del medicamento";
            }
            if (tipo == null || tipo.equals("")) {
                adver = "por favor agregue el tipo de medicamento no sea Nerwin";
            }
            if (!adver.equals("")) {
                formed.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + adver + "</span>");
                return mapping.findForward(Error);
            }
            String respuesta = med.guardar(idMedicamento, idFarmacia, idProveedor, nombre, tipo);
            if (respuesta.equals("")) {
                return mapping.findForward(Confirmar);
            } else {
                formed.setError("hat problemas al insertar");
                return mapping.findForward(Error);
            }
        }

        if (action.equals("Eliminar")) {
            med.eliminar(idMedicamento);
            return mapping.findForward(Eliminar);
        }

        if (action.equals("Consultar")) {
            List<Medicamentos> lista = med.mostrar();
            if (lista == null) {
                formed.setError("<span style='color:white'>Usuario ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formed.setListaMedicamentos(lista);
                return mapping.findForward(Error);
            }
        }
        if (action.equals("BuscarId")) {
            Medicamentos medi = new Medicamentos();
            if (medi == null) {
                formed.setError("<spam style='color:red'> El Registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                formed.setIdMedicamento(idMedicamento);
                formed.setIdFarmacia(idFarmacia);
                formed.setIdProveedor(idProveedor);
                formed.setNombre(nombre);
                formed.setTipo(tipo);
                return mapping.findForward(Confirmar);
            }
        }
        if(action.equals("Modificar")){
            med.modificar(idMedicamento, idFarmacia, idProveedor, nombre, tipo);
            return mapping.findForward(Error);
        }
        return mapping.findForward(Confirmar);
    }

}
