/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.empresa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "AREA")
public class Area implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_SEQ")
    @SequenceGenerator(name = "AREA_SEQ", sequenceName = "AREA_SEQ",allocationSize = 1)
    @Column(name="ID_AREA")
    private Long idArea;
    
    @Column(name = "NOMBRE")
    private String nombre;

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
