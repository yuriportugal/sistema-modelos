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
@Table(name = "TIPO_ACTIVO")
public class TipoActivo implements Serializable{
   
    @Id
    @Column(name="ID_TIPO_ACTIVO")
    private Long idTipoActivo;
    
    @Column(name = "NOMBRE")
    private String nombre;

        
    @Column(name = "VIDA_UTIL")
    private Long vidaUtil;

    public Long getIdTipoActivo() {
        return idTipoActivo;
    }

    public void setIdTipoActivo(Long idTipoActivo) {
        this.idTipoActivo = idTipoActivo;
    }

    public String getNombre() {
        if (nombre == null)
            nombre = "";
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Long vidaUtil) {
        this.vidaUtil = vidaUtil;
    }
    

}
