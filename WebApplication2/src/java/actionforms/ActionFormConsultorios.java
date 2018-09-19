
package actionforms;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.upload.MultipartRequestHandler;

import persistencia.Consultorios;

public class ActionFormConsultorios extends org.apache.struts.action.ActionForm {
    
    private Integer idConsultorio;
    private Integer numero;
    private String area;
    private String action;
    private String error;
    private List<Consultorios> listaConsultorio;

    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Consultorios> getListaConsultorio() {
        return listaConsultorio;
    }

    public void setListaConsultorio(List<Consultorios> listaConsultorio) {
        this.listaConsultorio = listaConsultorio;
    }
}
