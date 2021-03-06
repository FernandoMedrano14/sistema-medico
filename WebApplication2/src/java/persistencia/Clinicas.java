package persistencia;
// Generated 08-21-2018 10:52:14 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Clinicas generated by hbm2java
 */
public class Clinicas  implements java.io.Serializable {


     private Integer idClinica;
     private Farmacias farmacias;
     private String direccion;
     private String horario;
     private Set pacienteses = new HashSet(0);

    public Clinicas() {
    }

    public Clinicas(Farmacias farmacias, String direccion, String horario, Set pacienteses) {
       this.farmacias = farmacias;
       this.direccion = direccion;
       this.horario = horario;
       this.pacienteses = pacienteses;
    }
   
    public Integer getIdClinica() {
        return this.idClinica;
    }
    
    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
    }
    public Farmacias getFarmacias() {
        return this.farmacias;
    }
    
    public void setFarmacias(Farmacias farmacias) {
        this.farmacias = farmacias;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getHorario() {
        return this.horario;
    }
    
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public Set getPacienteses() {
        return this.pacienteses;
    }
    
    public void setPacienteses(Set pacienteses) {
        this.pacienteses = pacienteses;
    }




}


