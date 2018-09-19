package actionforms;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.upload.MultipartRequestHandler;
import persistencia.Farmacias;

public class ActionFormFarmacias extends org.apache.struts.action.ActionForm {

    private Integer idFarmacia;
    private String direccion;
    private String error;
    private String action;
    private String mensaje;
    private List<Farmacias> listaFarmacias;

    public Integer getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(Integer idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public List<Farmacias> getListaFarmacias() {
        return listaFarmacias;
    }

    public void setListaFarmacias(List<Farmacias> listaFarmacias) {
        this.listaFarmacias = listaFarmacias;
    }
    
    
    

}
