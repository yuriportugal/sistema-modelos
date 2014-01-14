/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.empresa.Producto;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "ACTIVO_MODELO")
public class ActivoModeloDetalle implements Serializable{
   
    @EmbeddedId
    private ActivoModeloPK activoModeloPK;
    
    private Long cantidad;
    
    private Long valorCompra;
    
    private Long horasProdu;
    
    private Long costoMaqHora;
    
    private Long anoVida;
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO", insertable = false, updatable = false)
    private Modelo modelo;
    
    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public ActivoModeloPK getActivoModeloPK() {
        return activoModeloPK;
    }

    public Long getAnoVida() {
        return anoVida;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public Long getCostoMaqHora() {
        return costoMaqHora;
    }

    public Long getHorasProdu() {
        return horasProdu;
    }

    public Long getValorCompra() {
        return valorCompra;
    }

    public void setActivoModeloPK(ActivoModeloPK activoModeloPK) {
        this.activoModeloPK = activoModeloPK;
    }

    public void setAnoVida(Long anoVida) {
        this.anoVida = anoVida;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public void setCostoMaqHora(Long costoMaqHora) {
        this.costoMaqHora = costoMaqHora;
    }

    public void setHorasProdu(Long horasProdu) {
        this.horasProdu = horasProdu;
    }

    public void setValorCompra(Long valorCompra) {
        this.valorCompra = valorCompra;
    }

    
    
}


