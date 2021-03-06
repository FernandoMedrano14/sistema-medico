package actionforms;

import java.util.List;
import persistencia.Farmacias;
import persistencia.Medicamentos;
import persistencia.Proveedores;

public class ActionFormMedicamentos extends org.apache.struts.action.ActionForm {

    private Integer idMedicamento;
    private Integer idProveedor;
    private Integer idFarmacia;
    private String nombre;
    private String tipo;
    private String action;
    private String error;
    private List<Medicamentos> listaMedicamentos;
    private List<Farmacias> listaFarmacias;
    private List<Proveedores> listaProveedores;

    public List<Farmacias> getListaFarmacias() {
        return listaFarmacias;
    }

    public void setListaFarmacias(List<Farmacias> listaFarmacias) {
        this.listaFarmacias = listaFarmacias;
    }

    public List<Proveedores> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedores> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(Integer idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<Medicamentos> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(List<Medicamentos> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

}
