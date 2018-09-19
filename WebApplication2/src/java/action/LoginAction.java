package action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import actionforms.LoginForm;
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
        String name = loginform.getUsername();
        String pass = loginform.getPassword();
        
        MantenimientoUsuarios man = new MantenimientoUsuarios();
        Usuarios u = man.login(name, pass);
        if(u!=null){
            return mapping.findForward(SUCCESS);
        }else{
            return mapping.findForward("failure");
        }
        
//        if (name.equals("Admin") && pass.equals("admin")) {
//            
//        }
        
    }
}
