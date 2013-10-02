/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.empresa;

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
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="ID_UNIDAD")
    private Long idInsumo;
    
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "NOMBRE_ABREV")
    private String nombreAbrev;

    public Long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
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
