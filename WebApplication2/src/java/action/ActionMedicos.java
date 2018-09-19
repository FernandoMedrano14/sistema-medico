package action;

import actionforms.ActionFormMedicos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;
import mantenimiento.MantenimientoMedicos;
import persistencia.Medicos;

public class ActionMedicos extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmacionNuevoMedico";
    private static final String Eliminar = "confirmacionEliminarMedico";
    private static final String Error = "errorMantenimientoMedico";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormMedicos formMedi = (ActionFormMedicos) form;
        Integer idMedico = formMedi.getIdMedico();
        Integer idEspecialidad = formMedi.getIdEspecialidad();
        String nombre = formMedi.getNombre();
        String apellido = formMedi.getApellido();
        String especialidad = formMedi.getEspecialidad();
        String telefono = formMedi.getTelefono();
        String action = formMedi.getAction();

        if (formMedi == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar")) {
            String advertencia = "";

            if (nombre == null || nombre.equals("")) {
                advertencia = "*Es necesario agregar el nombre del medico <br>";
            }

            if (!advertencia.equals("")) {
                formMedi.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            MantenimientoMedicos medi = new MantenimientoMedicos();

            String respuesta = medi.guardar(idMedico, idEspecialidad, nombre, apellido, especialidad, telefono);
            return mapping.findForward(Confirmar);
        }

        if (action.equals("Consultar")) {
            MantenimientoMedicos medi = new MantenimientoMedicos();
            List<Medicos> lista = medi.consultar();
            if (lista == null) {
                formMedi.setError("<span style='color:white'>Usuario ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formMedi.setListamedi(lista);
                return mapping.findForward(Error);
            }
        }

        if (action.equals("Eliminar")) {
            MantenimientoMedicos medi = new MantenimientoMedicos();
            medi.eliminar(idMedico);
            return mapping.findForward(Eliminar);
        }

        if (action.equals("BuscarId")) {
            MantenimientoMedicos medi = new MantenimientoMedicos();
            Medicos med = medi.consultarById(idMedico);

            if (med == null) {
                formMedi.setError("<spam style='color:red'> El Registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                formMedi.setIdMedico(idMedico);
                formMedi.setIdEspecialidad(idEspecialidad);
                formMedi.setNombre(nombre);
                formMedi.setApellido(apellido);
                formMedi.setEspecialidad(med.getEspecialidad());
                formMedi.setTelefono(telefono);
                return mapping.findForward(Confirmar);
            }

        }

        if (action.equals("Modificar")) {
            MantenimientoMedicos medi = new MantenimientoMedicos();
            medi.modificar(idMedico, idEspecialidad, nombre, apellido, especialidad, telefono);
            System.out.println("error al modificar");
        }
        return mapping.findForward(Confirmar);
    }
}
