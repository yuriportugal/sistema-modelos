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
public class DetailPVPK implements Serializable {
    
    
    
    @Column(name = "ID_MODELO")
    private Long idModelo;
    
    @Column(name = "ID_ANO")
    private Long idAno;                
    
    @Column(name = "ID_MES")
    private Long idMes;        

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public Long getIdAno() {
        return idAno;
    }

    public void setIdAno(Long idAno) {
        this.idAno = idAno;
    }

    public Long getIdMes() {
        return idMes;
    }

    public void setIdMes(Long idMes) {
        this.idMes = idMes;
    }

    
    
    
}
