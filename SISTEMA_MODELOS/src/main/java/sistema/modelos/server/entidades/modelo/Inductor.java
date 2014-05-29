/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "INDUCTOR")
public class Inductor implements Serializable{
   
    @Id
    @Column(name="ID_INDUCTOR")
    private Long idInductor;
    
    @Column(name = "NOMBRE")
    private String nombre;

    public Long getIdInductor() {
        return idInductor;
    }

    public void setIdInductor(Long idInductor) {
        this.idInductor = idInductor;
    }

    public String getNombre() {
        if (nombre == null){
            nombre = "";
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

}
