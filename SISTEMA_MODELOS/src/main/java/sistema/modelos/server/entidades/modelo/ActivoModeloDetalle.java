/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import sistema.modelos.server.entidades.empresa.Activo;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "ACTIVO_MODELO")
public class ActivoModeloDetalle implements Serializable{
   

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIVO_MODELO_SEQ")
    @SequenceGenerator(name = "ACTIVO_MODELO_SEQ", sequenceName = "ACTIVO_MODELO_SEQ",allocationSize = 1)
    @Column(name="ID_MODELO_ACTIVO")
    private Long idActivoModelo;
    
    
    @Column(name = "CANTIDAD")
    private Long cantidad;
    
    @Column(name="VALOR_COMPRA")
    private Long valorCompra;
    
    @Column(name="HORAS_PRODUCCION")
    private Long horasProdu;
    
    @Column(name="COSTO_MAQ_HOR")
    private Long costoMaqHora;
    
    @Column(name="ANO_VIDA")
    private Long anoVida;
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO")
    private Modelo modelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_ACTIVO", referencedColumnName = "ID_ACTIVO")
    private Activo activo;
    
    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
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

    public Activo getActivo() {
        if (activo == null){
            activo = new Activo();
        }
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public Long getIdActivoModelo() {
        return idActivoModelo;
    }

    public void setIdActivoModelo(Long idActivoModelo) {
        this.idActivoModelo = idActivoModelo;
    }

    
    
    
}


