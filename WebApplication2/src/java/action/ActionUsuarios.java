package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormUsuarios;
import java.util.List;
import mantenimiento.MantenimientoUsuarios;
import persistencia.Usuarios;

public class ActionUsuarios extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmacionNuevoUsuario";
    private static final String Eliminar = "confirmacionEliminarUsuario";
    private static final String Error = "errorMantenimientoUsuario";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormUsuarios formBean = (ActionFormUsuarios) form;
        Integer idUsuario = formBean.getIdUsuario();
        String nombre = formBean.getNombre();
        String correo = formBean.getCorreo();
        String contra = formBean.getContra();
        String genero = formBean.getGenero();
        String tipo = formBean.getTipo();
        String pregunta = formBean.getPregunta();
        String respuesta = formBean.getRespuesta();
        String action = formBean.getAction();

        if (formBean == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar")) {
            String advertencia = "";

            if (nombre == null || nombre.equals("")) {
                advertencia = "*Es necesario ingresar nombre<br>";
            }

            if (correo == null || correo.equals("")) {
                advertencia += "*Se necesita un correo<br>";
            }

            if (contra == null || contra.equals("")) {
                advertencia += "*Es necesaria una contraseña<br>";
            }

            if (genero == null || genero.equals(nombre)) {
                advertencia += "*Definir genero del usuario<br>";
            }

            if (tipo == null || tipo.equals("")) {
                advertencia = "*Definir si es administrador o usuario<br>";
            }
            
            if (pregunta == null || pregunta.equals("")) {
                advertencia = "*Definir pregunta<br>";
            }
            
            if (respuesta == null || respuesta.equals("")) {
                advertencia = "*Definir respuesta<br>";
            }

            if (!advertencia.equals("")) {
                formBean.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }
            MantenimientoUsuarios usuarios = new MantenimientoUsuarios();
            List<Usuarios> listaUsuarios;
            listaUsuarios = usuarios.consultarTodoUsuario();
            for (Usuarios usuario : listaUsuarios) {
                if (formBean.getCorreo().equals(usuario.getCorreo())) {
                    advertencia = "<div class=\"alert alert-warning\"><strong>El corrreo esta en uso</strong>, ingrese uno diferente</div>";
                    request.setAttribute("advertencia", advertencia);
                    return mapping.findForward(Error);
                }
            }
            int respue = usuarios.guardarUsuario(idUsuario, nombre, correo, contra, genero, tipo, pregunta, respuesta);
            if (respue == 1) {
                return mapping.findForward(Confirmar);
            } else {
                formBean.setError("Ocurrio un error al insertar.");
                return mapping.findForward(Error);
            }

        }

        if (action.equals("Consultar")) {
            MantenimientoUsuarios usuarios = new MantenimientoUsuarios();
            List<Usuarios> lista = usuarios.consultarTodoUsuario();
            if (lista == null) {
                formBean.setError("<span style='color:white'>Usuario ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formBean.setListaUsuarios(lista);
                return mapping.findForward(Error);
            }
        }

        if (action.equals("Eliminar")) {
            MantenimientoUsuarios usuarios = new MantenimientoUsuarios();
            usuarios.eliminarUsuario(idUsuario);
            return mapping.findForward(Eliminar);
        }

        if (action.equals("ConsultarId")) {
            MantenimientoUsuarios usuarios = new MantenimientoUsuarios();
            Usuarios usuario = usuarios.consultarId(idUsuario);
            if (usuarios == null) {
                formBean.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                formBean.setIdUsuario(usuario.getIdUsuario());
                formBean.setNombre(usuario.getNombre());
                formBean.setCorreo(usuario.getCorreo());
                formBean.setContra(usuario.getContra());
                formBean.setGenero(usuario.getGenero());
                formBean.setTipo(usuario.getTipo());
                formBean.setPregunta(pregunta);
                formBean.setRespuesta(respuesta);
                return mapping.findForward(Confirmar);
            }
        }

        if (action.equals("modificar")) {
            MantenimientoUsuarios usuarios = new MantenimientoUsuarios();
            usuarios.modificar(idUsuario, nombre, correo, contra, genero, tipo , pregunta ,respuesta);
            System.out.println("error al modificar");
        }

        return mapping.findForward(Confirmar);
    }

}
