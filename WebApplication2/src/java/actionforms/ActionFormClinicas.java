package actionforms;

import java.util.List;
import persistencia.Clinicas;
import persistencia.Farmacias;

public class ActionFormClinicas extends org.apache.struts.action.ActionForm {

    private Integer idClinica;
    private Integer idFarmacia;
    private String direccion;
    private String horario;
    private String error;
    private String action;
    private String Mensaje;
    private List<Clinicas> listaClinicas;
    private List<Farmacias> listaFarmacias;

    public List<Farmacias> getListaFarmacias() {
        return listaFarmacias;
    }

    public void setListaFarmacias(List<Farmacias> listaFarmacias) {
        this.listaFarmacias = listaFarmacias;
    }
    

    public Integer getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    public List<Clinicas> getListaClinicas() {
        return listaClinicas;
    }

    public void setListaClinicas(List<Clinicas> listaClinicas) {
        this.listaClinicas = listaClinicas;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    
}
