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

    private static final String Confirmar = "confirmarMedicos";
    private static final String Eliminar = "eliminarMedico";
    private static final String Error = "errorMedico";
    private static final String guardado = "guardadoMedicos";
    private static final String confirmarID = "consultaIdMedicos";
    private static final String AGREGAR = "irAgregarMedico";
    private static final String consultar = "consultarMedicos";
    private static final String modificar = "modificarMedico";
    private static final String irmodificar = "irmodificarMedico";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormMedicos formMedi = (ActionFormMedicos) form;
        Integer idMedico = formMedi.getIdMedico();
        Integer idEspecialidad = formMedi.getIdEspecialidad();
        String nombre = formMedi.getNombre();
        String apellido = formMedi.getApellido();
        String telefono = formMedi.getTelefono();
        String action = formMedi.getAction();

        if (formMedi == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar Medico")) {

            MantenimientoEspecialidades manEspe = new MantenimientoEspecialidades();
            List<Especialidades> listaEspecialidades = manEspe.consultar();
            formMedi.setListaEspecialidad(listaEspecialidades);
            request.setAttribute("listaEspecialidades", listaEspecialidades);
            return mapping.findForward(AGREGAR);
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

            if (!advertencia.equals("")) {
                formMedi.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            MantenimientoMedicos medi = new MantenimientoMedicos();
            MantenimientoEspecialidades manEspe = new MantenimientoEspecialidades();
            String respuesta = medi.guardar(idMedico, idEspecialidad, nombre, apellido, telefono);

            if (respuesta.equals("")) {
                formMedi.setError("<span style='color:red'> ocurrio un error al guardar la informacion " + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            List<Especialidades> listaEspecialidades = manEspe.consultar();
            formMedi.setListaEspecialidad(listaEspecialidades);
            request.setAttribute("listaEspecialidades", listaEspecialidades);
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> El médico ha sido guardado en el registro.\n</div>");
            request.setAttribute("advertencia", advertencia);
            return mapping.findForward(guardado);
        }

        if (action.equals("Consultar_Medicos")) {
            MantenimientoMedicos medi = new MantenimientoMedicos();
            List<Medicos> lista = medi.consultar();
            if (lista == null) {
                formMedi.setError("<span style='color:white'>Usuario ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formMedi.setListaMedicos(lista);
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
             String advertencia = "";
            MantenimientoMedicos medi = new MantenimientoMedicos();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            if (medi.eliminar(idRecibido) == 0) {
                formMedi.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                System.out.println("Estoy aqui");
                List<Medicos> listaMedicos = medi.consultar();
                formMedi.setListaMedicos(listaMedicos);
                formMedi.setIdMedico(idRecibido);
                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro eliminado:</strong> El medico ha sido eliminado del registro.\n</div>");
                request.setAttribute("advertencia", advertencia);
            }
            return mapping.findForward(Eliminar);
        }

        if (action.equals("BuscarId")) {
            MantenimientoMedicos medi = new MantenimientoMedicos();
            Integer idRecibido = (Integer.parseInt(request.getParameter("id")));
            Medicos med = medi.consultarById(idRecibido);

            /*if (med == null) {
                formMedi.setError("<spam style='color:red'> El Registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {*/
                formMedi.setIdMedico(med.getIdMedico());
                formMedi.setIdEspecialidad(med.getEspecialidades().getIdEspecialidad());
                formMedi.setNombre(med.getNombre());
                formMedi.setApellido(med.getApellido());
                formMedi.setTelefono(med.getTelefono());
               
            //}
             return mapping.findForward(confirmarID);

        }

        if (action.equals("Modificar")) {
            String advertencia = "";
            Medicos m = new Medicos();
            m.setIdMedico(idMedico);
            
            Especialidades espe = new Especialidades();
            espe.setIdEspecialidad(idEspecialidad);
            m.setEspecialidades(espe);
            
            m.setNombre(nombre);
            m.setApellido(apellido);
            m.setTelefono(telefono);

            MantenimientoMedicos medi = new MantenimientoMedicos();
            medi.modificar(idMedico, idEspecialidad, nombre, apellido, telefono);
            formMedi.setError("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> El medico ha sido modificado.\n</div>");
            
            formMedi.setIdEspecialidad(m.getEspecialidades().getIdEspecialidad());
            formMedi.setNombre(m.getNombre());
            formMedi.setApellido(m.getApellido());
            formMedi.setTelefono(m.getTelefono());

            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> El medico ha sido modificado.\n</div>");
            request.setAttribute("advertencia", advertencia);
            List<Medicos> listMedicos = medi.consultar();
            formMedi.setListaMedicos(listMedicos);
            return mapping.findForward(consultar);
        }

        if (action.equals("irModificarMedicos")) {
            
            System.out.println("Estoy en irmodificar");
            String id = request.getParameter("id");
            idMedico = Integer.parseInt(id);
            
            System.out.println(id);
            MantenimientoMedicos Medicos = new MantenimientoMedicos();
            Medicos med = Medicos.consultarById(idMedico);

            formMedi.setIdMedico(med.getIdMedico());
            formMedi.setIdEspecialidad(idEspecialidad);
            formMedi.setNombre(med.getNombre());
            formMedi.setApellido(med.getApellido());
            formMedi.setTelefono(med.getTelefono());
            
            return mapping.findForward(irmodificar);
        }

        return mapping.findForward(Confirmar);
    }
}
