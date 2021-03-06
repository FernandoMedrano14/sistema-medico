package persistencia;
// Generated 08-21-2018 10:52:14 AM by Hibernate Tools 4.3.1



/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer idUsuario;
     private String nombre;
     private String correo;
     private String contra;
     private String genero;
     private String tipo;
     private String pregunta;
     private String respuesta;

    public Usuarios() {
    }

    public Usuarios(String nombre, String correo, String contra, String genero, String tipo ,String pregunta,String respuesta) {
       this.nombre = nombre;
       this.correo = correo;
       this.contra = contra;
       this.genero = genero;
       this.tipo = tipo;
       this.pregunta = pregunta;
       this.respuesta = respuesta;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContra() {
        return this.contra;
    }
    
    public void setContra(String contra) {
        this.contra = contra;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getTipo() {
        return this.tipo;
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

    @Override
    public String toString() {
        return "Usuarios{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", correo=" + correo + ", contra=" + contra + ", genero=" + genero + ", tipo=" + tipo + ", pregunta=" + pregunta + ", respuesta=" + respuesta + '}';
    }
    
}


