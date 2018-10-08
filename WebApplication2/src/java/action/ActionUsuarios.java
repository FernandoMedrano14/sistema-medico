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
    private static final String Eliminar = "eliminarUsuario";
    private static final String Error = "errorMantenimientoUsuario";
    private static final String guardado = "guardadoUsuario";//
    private static final String AGREGAR = "irAgregarUsuario";//
    private static final String confirmarID = "consultaIdUsuario";//
    private static final String consultar = "consultarUsuario";//
    private static final String modificar = "modificarUsuario";//
    private static final String irmodificar = "irmodificarUsuario";//
    //recuperacion
    private static final String recuperar = "recuperar";
    private static final String cambiar_contra = "cambiar_contra";

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
            if (respue == 0) {
                return mapping.findForward(guardado);
            } else {
                formBean.setError("Ocurrio un error al insertar.");
                return mapping.findForward(Error);
            }

        }

        if (action.equals("Consultar_Usuarios")) {
            MantenimientoUsuarios usuarios = new MantenimientoUsuarios();
            List<Usuarios> lista = usuarios.consultarTodoUsuario();
            if (lista == null) {
                formBean.setError("<span style='color:white'>Usuario ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formBean.setListaUsuarios(lista);
                String message = "";
                if (!LoginAction.acceso.equals("Admin")) {
                    message = "style=\"display: none\"";
                }
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
            String advertencia = "";
            MantenimientoUsuarios usuarios = new MantenimientoUsuarios();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));

            if (usuarios.eliminarUsuario(idRecibido) == 0) {
                formBean.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Usuarios> lista = usuarios.consultarTodoUsuario();
                formBean.setListaUsuarios(lista);
                formBean.setIdUsuario(idRecibido);
                advertencia = ("<div class=\"alert alert-danger\">\n<strong>Registro eliminado:</strong> El usuario ha sido eliminado.\n</div>");
                request.setAttribute("advertencia", advertencia);
            }
            return mapping.findForward(Eliminar);
        }

        if (action.equals("ConsultarId")) {
            MantenimientoUsuarios usuarios = new MantenimientoUsuarios();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));

            if (usuarios.consultarId(idRecibido) == 0) {
                formBean.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {

                formBean.setIdUsuario(idRecibido);
                formBean.setMensaje("<spam style='color:green'> Ha sido modificado con exito");

                /*formBean.setIdUsuario(usuario.getIdUsuario());
                formBean.setNombre(usuario.getNombre());
                formBean.setCorreo(usuario.getCorreo());
                formBean.setContra(usuario.getContra());
                formBean.setGenero(usuario.getGenero());
                formBean.setTipo(usuario.getTipo());
                formBean.setPregunta(pregunta);
                formBean.setRespuesta(respuesta);*/
                return mapping.findForward(confirmarID);
            }
        }

        if (action.equals("Modificar")) {
            MantenimientoUsuarios usuarios = new MantenimientoUsuarios();

            int confirmar = usuarios.modificar(idUsuario, nombre, correo, contra, genero, tipo, pregunta, respuesta);
            //usuarios.modificar(idUsuario, nombre, correo, contra, genero, tipo, pregunta, respuesta);
            System.out.println(confirmar);

            List<Usuarios> lista = usuarios.consultarTodoUsuario();
            formBean.setListaUsuarios(lista);
            return mapping.findForward(consultar);
        }

        if (action.equals("irModificar")) {
            System.out.println("estoy en ir modificar");
            String id = request.getParameter("id");
            idUsuario = Integer.parseInt(id);
            System.out.println(id);
            MantenimientoUsuarios usuario = new MantenimientoUsuarios();
            Usuarios usuarios = usuario.consultaId(idUsuario);

            formBean.setIdUsuario(usuarios.getIdUsuario());
            formBean.setNombre(usuarios.getNombre());
            formBean.setCorreo(usuarios.getCorreo());
            formBean.setContra(usuarios.getContra());
            formBean.setGenero(usuarios.getGenero());
            formBean.setTipo(usuarios.getTipo());
            formBean.setPregunta(usuarios.getPregunta());
            formBean.setRespuesta(usuarios.getRespuesta());
            return mapping.findForward(irmodificar);
        }
        
        //Recuperacion de contraseña
        
        MantenimientoUsuarios mantenimientoUsuarios = new MantenimientoUsuarios();
        List<Usuarios> listaUsuarios = null;
        String mensaje;
        String mensaje2;
        String mensaje3;

        System.out.println("action: " + formBean.getAction());
        switch (formBean.getAction()) {
            case "Recuperar contraseña":
                mensaje = "";
                request.setAttribute("mensaje", mensaje);
                mensaje2 = "";
                request.setAttribute("mensaje2", mensaje2);
                mensaje3 = "style=\"visibility: hidden\"";
                request.setAttribute("mensaje3", mensaje3);
                if (true) {
                    return mapping.findForward(recuperar);
                }
                break;
            case "Ingresar":
                if ((formBean.getNombre() == null || formBean.getNombre().equals("")) || (formBean.getCorreo() == null || formBean.getCorreo().equals(""))) {
                    mensaje = "<div class=\"form-row\"><div class=\"form-group col-md-2\"></div><div class=\"alert alert-warning form-group col-md-8\" style=\"text-align: center\">Usuario y Correo son campos requeridos</div><div class=\"form-group col-md-2\"></div></div>";
                    request.setAttribute("mensaje", mensaje);
                    mensaje2 = "";
                    request.setAttribute("mensaje2", mensaje2);
                    mensaje3 = "style=\"visibility: hidden\"";
                    request.setAttribute("mensaje3", mensaje3);
                    return mapping.findForward(recuperar);
                }
                listaUsuarios = mantenimientoUsuarios.consultarTodoUsuario();
                for (Usuarios usuarios : listaUsuarios) {
                    if (formBean.getNombre().equals(usuarios.getNombre()) && formBean.getCorreo().equals(usuarios.getCorreo())) {
                        formBean.setIdUsuario(usuarios.getIdUsuario());
                        formBean.setNombre(usuarios.getNombre());
                        formBean.setCorreo(usuarios.getCorreo());
                        formBean.setPregunta(usuarios.getPregunta());
                        mensaje = "";
                        request.setAttribute("mensaje", mensaje);
                        mensaje2 = "style=\"visibility: hidden\"";
                        request.setAttribute("mensaje2", mensaje2);
                        mensaje3 = "";
                        request.setAttribute("mensaje3", mensaje3);
                        return mapping.findForward(recuperar);
                    }
                }
                if (true) {
                    mensaje = "<div class=\"form-row\"><div class=\"form-group col-md-2\"></div><div class=\"alert alert-warning form-group col-md-8\" style=\"text-align: center\">El Usuario o Correo no se encontro.<br/>Ambos campos deben de coinsidir</div><div class=\"form-group col-md-2\"></div></div>";
                    request.setAttribute("mensaje", mensaje);
                    mensaje2 = "";
                    request.setAttribute("mensaje2", mensaje2);
                    mensaje3 = "style=\"visibility: hidden\"";
                    request.setAttribute("mensaje3", mensaje3);
                    return mapping.findForward(recuperar);
                }
                break;
            case "Enviar":
                Usuarios usuario = mantenimientoUsuarios.consultaId(formBean.getIdUsuario());
                boolean answer = false;
                if (formBean.getRespuesta().equals(usuario.getRespuesta())) {                    
                    formBean.setIdUsuario(usuario.getIdUsuario());
                    formBean.setNombre(usuario.getNombre());
                    formBean.setCorreo(usuario.getCorreo());
                    formBean.setContra(usuario.getContra());
                    formBean.setGenero(usuario.getGenero());
                    formBean.setTipo(usuario.getTipo());
                    formBean.setPregunta(usuario.getPregunta());
                    formBean.setRespuesta(usuario.getRespuesta());
                    answer = true;
                } else {
                    mensaje = "<div class=\"form-row\"><div class=\"form-group col-md-2\"></div><div class=\"alert alert-warning form-group col-md-8\" style=\"text-align: center\">La respuesta a la pregunta es incorrecta</div><div class=\"form-group col-md-2\"></div></div>";
                    request.setAttribute("mensaje", mensaje);
                    mensaje2 = "style=\"visibility: hidden\"";
                    request.setAttribute("mensaje2", mensaje2);
                    mensaje3 = "";
                    request.setAttribute("mensaje3", mensaje3);
                    return mapping.findForward(recuperar);
                }
                if (answer) {
                    System.out.println("Informacion usuario: " + usuario.toString());
                    System.out.println("Informacion usuarioForm: " + formBean.toString());
                    return mapping.findForward(cambiar_contra);
                }
                break;
                case "Reestablecer":
                    usuario = new Usuarios();
                    
                    usuario.setIdUsuario(formBean.getIdUsuario());
                    usuario.setNombre(formBean.getNombre());
                    
                    System.out.println("Informacion usuario: " + usuario.toString());
                    System.out.println("Informacion usuarioForm: " + formBean.toString());
                    
                    if (mantenimientoUsuarios.modificar(idUsuario, nombre, correo, contra, genero, tipo, pregunta, respuesta) == 1) {
                        mensaje = "<div class=\"form-row\"><div class=\"form-group col-md-3\"></div><div class=\"alert alert-primary form-group col-6\" style=\"text-align: center\">Su contraseña fue reestablecida correctamente</div><div class=\"form-group col-md-3\"></div></div>";
                        request.setAttribute("mensaje", mensaje);
                    } else {
                        mensaje = "<div class=\"form-row\"><div class=\"form-group col-md-3\"></div><div class=\"alert alert-danger form-group col-6\" style=\"text-align: center\">Su contraseña no pudo ser reestablecida</div><div class=\"form-group col-md-3\"></div></div>";
                        request.setAttribute("mensaje", mensaje);
                    }
                    if (true) {
                        return mapping.findForward(cambiar_contra);
                    }
                    break;
        }

        return mapping.findForward(Confirmar);
    }

}
