
package actionforms;


import java.util.List;
import persistencia.Especialidades;
import persistencia.Medicos;

public class ActionFormMedicos extends org.apache.struts.action.ActionForm   {
    


     private Integer idMedico;
     private Integer idEspecialidad;
     private String nombre;
     private String apellido;
     private String especialidad;
     private String telefono;
     private String action;
     private String error;
     private List<Medicos> listamedi;
     private List<Especialidades> listaEspecialidad;

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public List<Especialidades> getListaEspecialidad() {
        return listaEspecialidad;
    }

    public void setListaEspecialidad(List<Especialidades> listaEspecilidad) {
        this.listaEspecialidad = listaEspecilidad;
    }

    public List<Medicos> getListamedi() {
        return listamedi;
    }

    public void setListamedi(List<Medicos> listamedi) {
        this.listamedi = listamedi;
    }
     
     
}


