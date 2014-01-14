/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author YURI
 */
@Embeddable
public class InsumoModeloPK implements Serializable {
    
    
    
    @Column(name = "ID_MODELO")
    private Long idModelo;
    
    @Column(name = "ID_INSUMO")
    private Long idInsumo;
    
    
    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public Long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    
}
