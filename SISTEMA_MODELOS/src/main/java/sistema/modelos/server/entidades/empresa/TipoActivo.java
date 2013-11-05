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
@Table(name = "TIPO_ACTIVO")
public class TipoActivo implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_ACTIVO_SEQ")
    @SequenceGenerator(name = "TIPO_ACTIVO_SEQ", sequenceName = "TIPO_ACTIVO_SEQ",allocationSize = 1)
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
