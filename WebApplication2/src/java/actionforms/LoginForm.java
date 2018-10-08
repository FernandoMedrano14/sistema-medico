package actionforms;



import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends org.apache.struts.action.ActionForm {
    
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contra;
    private String genero;
    private String tipo;
    private String pregunta;
    private String respuesta;
    private String action;
    private String nombrepagina;
    private String accesoagregar;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNombrepagina() {
        return nombrepagina;
    }

    public void setNombrepagina(String nombrepagina) {
        this.nombrepagina = nombrepagina;
    }

    public String getAccesoagregar() {
        return accesoagregar;
    }

    public void setAccesoagregar(String accesoagregar) {
        this.accesoagregar = accesoagregar;
    }
        
}
