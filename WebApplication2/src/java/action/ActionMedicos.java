package action;

import actionforms.ActionFormMedicos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;
import mantenimiento.MantenimientoEspecialidades;
import mantenimiento.MantenimientoMedicos;
import persistencia.Especialidades;
import persistencia.Medicos;

public class ActionMedicos extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmarMedico";
    private static final String Eliminar = "eliminarMedico";
    private static final String Error = "errorMedico";
    private static final String guardado = "guardadoMedicos";
    private static final String confirmarID = "consultaId";
    private static final String agregar = "irAgregar";
    private static final String consultar = "consultarMedicos";
    private static final String modificar = "modificarMedicos";
    private static final String irmodificar = "irmodificarMedicos";

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

        if (action.equals("Agregar Medico")) {
            MantenimientoEspecialidades manEspe = new MantenimientoEspecialidades();
            List<Especialidades> listaEspecialidad = manEspe.consultar();
            formMedi.setListaEspecilidad(listaEspecialidad);
            request.setAttribute("listaEspecialidad", listaEspecialidad);
            return mapping.findForward(agregar);
        }

        if (action.equals("Agregar")) {
            String advertencia = "";

            if (nombre == null || nombre.equals("")) {
                advertencia = "*Es necesario agregar el nombre del medico <br>";
            }
            
            if (apellido == null || apellido.equals("")) {
                advertencia = "*Es necesario agregar el apellido del medico <br>";
            }
            
            if (telefono == null || telefono.equals("")) {
                advertencia = "*Es necesario agregar el telefono del medico <br>";
            }
            
            if(especialidad == null || especialidad.equals("")){
                advertencia = "*Es necesario agregar el especialidad del medico <br>";
            }

            if (!advertencia.equals("")) {
                formMedi.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            MantenimientoMedicos medi = new MantenimientoMedicos();
            MantenimientoEspecialidades manEspe = new MantenimientoEspecialidades();
            String respuesta = medi.guardar(idMedico, idEspecialidad, nombre, apellido, especialidad, telefono);

            if (respuesta.equals("")) {
                formMedi.setError("<span style='color:red'> ocurrio un error al guardar la informacion " + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            List<Especialidades> listaEspecialidades = manEspe.consultar();
            formMedi.setListaEspecilidad(listaEspecialidades);
            request.setAttribute("listaEspecialidades", listaEspecialidades);
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> La Clinica ha sido guardada.\n</div>");
            request.setAttribute("advertencia", advertencia);
            return mapping.findForward(guardado);
        }

        if (action.equals("Consultar")) {
            MantenimientoMedicos medi = new MantenimientoMedicos();
            List<Medicos> lista = medi.consultar();
            if (lista == null) {
                formMedi.setError("<span style='color:white'>Usuario ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formMedi.setListamedi(lista);
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
            MantenimientoMedicos medi = new MantenimientoMedicos();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            if (medi.eliminar(idRecibido) == 0) {
                formMedi.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Medicos> listaMedicos = medi.consultar();
                formMedi.setListamedi(listaMedicos);
                formMedi.setIdMedico(idRecibido);
            }
            return mapping.findForward(Eliminar);
        }

        if (action.equals("BuscarId")) {
            MantenimientoMedicos medi = new MantenimientoMedicos();

            Integer idRecibido = (Integer.parseInt(request.getParameter("id")));
            Medicos med = medi.consultarById(idRecibido);

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
                return mapping.findForward(confirmarID);
            }

        }

        if (action.equals("Modificar")) {
            String advertencia = "Error en el inicio";
            Medicos m = new Medicos();
            m.setIdMedico(idMedico);
            Especialidades espe = new Especialidades();
            espe.setIdEspecialidad(idEspecialidad);
            m.setEspecialidades(espe);
            m.setNombre(nombre);
            m.setApellido(apellido);
            m.setTelefono(telefono);
            
            MantenimientoMedicos medi = new MantenimientoMedicos();
            medi.modificar(idMedico, idEspecialidad, nombre, apellido, especialidad, telefono);
            formMedi.setError("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> La clinica ha sido modificada.\n</div>");
            formMedi.setIdEspecialidad(m.getEspecialidades().getIdEspecialidad());
            formMedi.setNombre(m.getNombre());
            formMedi.setApellido(m.getApellido());
            formMedi.setEspecialidad(m.getEspecialidad());
            formMedi.setTelefono(m.getTelefono());
            
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> La clinica ha sido modificada.\n</div>");
            request.setAttribute("advertencia", advertencia);
            List<Medicos> listMedicos = medi.consultar();
            formMedi.setListamedi(listMedicos);
            return mapping.findForward(consultar);
        }
        
        if(action.equals("irModificar")){
            String id = request.getParameter("id");
            idMedico = Integer.parseInt(id);
            System.out.println(id);
            MantenimientoMedicos mMedicos = new MantenimientoMedicos();
            Medicos med = new Medicos();
            
            formMedi.setIdMedico(idMedico);
            formMedi.setIdEspecialidad(idEspecialidad);
            formMedi.setNombre(nombre);
            formMedi.setApellido(apellido);
            formMedi.setEspecialidad(especialidad);
            formMedi.setTelefono(telefono);
            return mapping.findForward(irmodificar);
        }
        
        return mapping.findForward(Confirmar);
    }
}
