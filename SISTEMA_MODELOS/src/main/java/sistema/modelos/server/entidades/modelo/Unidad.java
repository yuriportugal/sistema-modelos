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
@Table(name = "UNIDAD")
public class Unidad implements Serializable{
   
    @Id
    @Column(name="UNIDAD")
    private Long idUnidad;
    
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "NOMBRE_ABREV")
    private String nombreAbrev;

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAbrev() {
        return nombreAbrev;
    }

    public void setNombreAbrev(String nombreAbrev) {
        this.nombreAbrev = nombreAbrev;
    }

}
