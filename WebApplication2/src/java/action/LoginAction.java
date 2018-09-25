package action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private static final String LoginError = "loginError";

    /* User Session */
    private static String acceso = "";
    private String mensaje = "";

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
                List<Usuarios> listaUsuarios = mantenimientoUsuarios.consultarTodoUsuario();
                for (Usuarios usuarios : listaUsuarios) {
                    if ((loginform.getUsername().equals(usuarios.getNombre()) || loginform.getUsername().equals(usuarios.getCorreo())) && loginform.getPassword().equals(usuarios.getContra())) {
                        acceso = usuarios.getTipo();
                    }
                }
                if (acceso.equals("")) {
                    mensaje = "<div class=\"alert alert-warning\" style=\"text-align: center\">No se encontro usuario</div>";
                    request.setAttribute("mensaje", mensaje);
                    return mapping.findForward(LoginError);
                }
                if (acceso.equals("Admin")) {
                    return mapping.findForward(SUCCESS);
                }
                break;
            case "":
                break;
        }
        return mapping.findForward(LoginError);

//        if (name.equals("Admin") && pass.equals("admin")) {
//            
//        }
    }
}
