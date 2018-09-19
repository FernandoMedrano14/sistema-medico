
package actionforms;

import java.util.List;
import persistencia.Especialidades;

public class ActionFormEspecialidades extends org.apache.struts.action.ActionForm {
    
    private Integer idEspecialidad;
    private String tipo;
    private String action;
    private String error;
    private List <Especialidades> listaEspe;

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public List<Especialidades> getListaEspe() {
        return listaEspe;
    }

    public void setListaEspe(List<Especialidades> listaEspe) {
        this.listaEspe = listaEspe;
    }
    
}
