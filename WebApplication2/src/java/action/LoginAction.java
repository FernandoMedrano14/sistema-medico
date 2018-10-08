package action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import actionforms.ActionFormUsuarios;
import actionforms.LoginForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.MantenimientoUsuarios;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencia.Usuarios;

/**
 *
 * @author Admin110
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String loginError = "loginError";
    private static final String agregarUsuario = "agregarUsuario";
    private static final String recuperar = "recuperar";
    private static final String cambiar_contra = "cambiar_contra";
    private static final String redirecciondenegada = "";

    /* User Session */
    private static String acceso;
    private String mensaje;
//    private String mensaje2;
//    private String mensaje3;
    private int intentos;

    public LoginAction() {
        acceso = "";
        this.mensaje = "";
//        this.mensaje2 = "";
//        this.mensaje3 = "";
        this.intentos = 0;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginForm loginform = (LoginForm) form;
        MantenimientoUsuarios mantenimientoUsuarios = new MantenimientoUsuarios();
        List<Usuarios> listaUsuarios = null;
        //
//        String name = loginform.getUsername();
//        String pass = loginform.getPassword();
//        
//        MantenimientoUsuarios man = new MantenimientoUsuarios();
//        Usuarios u = man.login(name, pass);
//        if(u!=null){
//            return mapping.findForward(SUCCESS);
//        }else{
//            return mapping.findForward("failure");
//        }
//
        switch (loginform.getAction()) {
            case "Iniciar Sesion":
                listaUsuarios = mantenimientoUsuarios.consultarTodoUsuario();
//                for (Usuarios usuarios : listaUsuarios) {
//                    if ((loginform.getUsername().equals(usuarios.getNombre()) || loginform.getUsername().equals(usuarios.getCorreo())) && loginform.getPassword().equals(usuarios.getContra())) {
//                        acceso = usuarios.getTipo();
//                    }
//                }
                if (loginform.getNombre().equals("") || loginform.getContra().equals("")) {
                    mensaje = "<div class=\"alert alert-warning\" style=\"text-align: center\">Falta usuario o contraseña<br/><strong>Complete los campos<strong/></div>";
                    request.setAttribute("mensaje", mensaje);
                    return mapping.findForward(loginError);
                }
                listaUsuarios.stream().filter((usuarios) -> ((loginform.getNombre().equals(usuarios.getNombre()) || loginform.getNombre().equals(usuarios.getCorreo())) && loginform.getContra().equals(usuarios.getContra()))).forEachOrdered((usuarios) -> {
                    acceso = usuarios.getTipo();
                });
                if (acceso.equals("")) {
                    mensaje = "<div class=\"alert alert-warning\" style=\"text-align: center\">Usuario o contraseña incorrecta</div>";
                    request.setAttribute("mensaje", mensaje);
                    intentos++;
                    if (intentos > 3) {
                        mensaje = "<div class=\"alert alert-warning\" style=\"text-align: center\">¡Usuario o contraseña incorrecta!<br/><br/>¿Olvidaste tu contraseña?<br/>Recuperala<a class=\"btn btn-link\" href=\"MantenimientoUsuarios.do?action=Recuperar contraseña\">Aquí</a></div>";
                        request.setAttribute("mensaje", mensaje);
                    }
                    return mapping.findForward(loginError);
                }
                if (acceso.equals("Admin") || acceso.equals("Usuario")) {
                    return mapping.findForward(SUCCESS);
                }
                break;
            case "Cerrar Sesion":
                if (!acceso.equals("")) {
                    acceso = "";
                    mensaje = "<div class=\"alert alert-info\" style=\"text-align: center\">Sesion cerrada</div>";
                    request.setAttribute("mensaje", mensaje);
                    return mapping.findForward(loginError);
                }
                break;
            case "Agregar Usuario":
                if (acceso.equals("")) {
                    mensaje = "<div class=\"alert alert-warning\" style=\"text-align: center\">Acceso no permitido<br/><strong>Inicie sesion<strong/></div>";
                    request.setAttribute("mensaje", mensaje);
                    return mapping.findForward(loginError);
                }
                if (acceso.equals("Usuario")) {
//                    mensaje = "<div class=\"alert alert-warning\" style=\"text-align: center\">Acceso no permitido<br/><strong>Inicie sesion como administrador<strong/></div>";
                    mensaje = "onload=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\"";
                    request.setAttribute("mensaje", mensaje);
                    return mapping.findForward(SUCCESS);
                }
                if (acceso.equals("Admin")) {
                    return mapping.findForward(agregarUsuario);
                }
                break;
//            case "Recuperar contraseña":
//                mensaje = "";
//                request.setAttribute("mensaje", mensaje);
//                mensaje2 = "";
//                request.setAttribute("mensaje2", mensaje2);
//                mensaje3 = "style=\"visibility: hidden\"";
//                request.setAttribute("mensaje3", mensaje3);
//                if (true) {
//                    return mapping.findForward(recuperar);
//                }
//                break;
//            case "Ingresar":
//                if ((loginform.getNombre() == null || loginform.getNombre().equals("")) || (loginform.getCorreo() == null || loginform.getCorreo().equals(""))) {
//                    mensaje = "<div class=\"form-row\"><div class=\"form-group col-md-2\"></div><div class=\"alert alert-warning form-group col-md-8\" style=\"text-align: center\">Usuario y Correo son campos requeridos</div><div class=\"form-group col-md-2\"></div></div>";
//                    request.setAttribute("mensaje", mensaje);
//                    mensaje2 = "";
//                    request.setAttribute("mensaje2", mensaje2);
//                    mensaje3 = "style=\"visibility: hidden\"";
//                    request.setAttribute("mensaje3", mensaje3);
//                    return mapping.findForward(recuperar);
//                }
//                listaUsuarios = mantenimientoUsuarios.consultarTodoUsuario();
//                for (Usuarios usuarios : listaUsuarios) {
//                    if (loginform.getNombre().equals(usuarios.getNombre()) && loginform.getCorreo().equals(usuarios.getCorreo())) {
//                        loginform.setIdUsuario(usuarios.getIdUsuario());
//                        loginform.setNombre(usuarios.getNombre());
//                        loginform.setCorreo(usuarios.getCorreo());
//                        loginform.setPregunta(usuarios.getPregunta());
//                        mensaje = "";
//                        request.setAttribute("mensaje", mensaje);
//                        mensaje2 = "style=\"visibility: hidden\"";
//                        request.setAttribute("mensaje2", mensaje2);
//                        mensaje3 = "";
//                        request.setAttribute("mensaje3", mensaje3);
//                        return mapping.findForward(recuperar);
//                    }
//                }
//                if (true) {
//                    mensaje = "<div class=\"form-row\"><div class=\"form-group col-md-2\"></div><div class=\"alert alert-warning form-group col-md-8\" style=\"text-align: center\">El Usuario o Correo no se encontro.<br/>Ambos campos deben de coinsidir</div><div class=\"form-group col-md-2\"></div></div>";
//                    request.setAttribute("mensaje", mensaje);
//                    mensaje2 = "";
//                    request.setAttribute("mensaje2", mensaje2);
//                    mensaje3 = "style=\"visibility: hidden\"";
//                    request.setAttribute("mensaje3", mensaje3);
//                    return mapping.findForward(recuperar);
//                }
//                break;
//            case "Enviar":
//                Usuarios usuario = mantenimientoUsuarios.consultaId(loginform.getIdUsuario());
//                boolean answer = false;
//                if (loginform.getRespuesta().equals(usuario.getRespuesta())) {
//                    ActionFormUsuarios afu = new ActionFormUsuarios();
//                    afu.setIdUsuario(usuario.getIdUsuario());
//                    afu.setNombre(usuario.getNombre());
//                    afu.setCorreo(usuario.getCorreo());
//                    afu.setContra(usuario.getContra());
//                    afu.setGenero(usuario.getGenero());
//                    afu.setTipo(usuario.getTipo());
//                    afu.setPregunta(usuario.getPregunta());
//                    afu.setRespuesta(usuario.getRespuesta());                    
//                    answer = true;
//                } else {
//                    mensaje = "<div class=\"form-row\"><div class=\"form-group col-md-2\"></div><div class=\"alert alert-warning form-group col-md-8\" style=\"text-align: center\">La respuesta a la pregunta es incorrecta</div><div class=\"form-group col-md-2\"></div></div>";
//                    request.setAttribute("mensaje", mensaje);
//                    mensaje2 = "style=\"visibility: hidden\"";
//                    request.setAttribute("mensaje2", mensaje2);
//                    mensaje3 = "";
//                    request.setAttribute("mensaje3", mensaje3);
//                    return mapping.findForward(recuperar);
//                }
//                if (answer) {
//                    System.out.println("Informacion usuario: "+usuario.toString());
//                    return mapping.findForward(cambiar_contra);
//                }
//                break;
            case "":
                break;
        }
        mensaje = "<div class=\"alert alert-warning\" style=\"text-align: center\">Error desconocido</div>";
        request.setAttribute("mensaje", mensaje);
        return mapping.findForward(loginError);

//        if (name.equals("Admin") && pass.equals("admin")) {
//            
//        }
    }
}
