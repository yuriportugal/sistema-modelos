/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import java.math.BigDecimal;
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
    private BigDecimal cantidad;
    
    @Column(name="VALOR_COMPRA")
    private BigDecimal valorCompra;
    
    @Column(name="DEPRE_ACUMULADA")
    private BigDecimal depAcumulada;
  
    
    @Column(name="COSTO_MAQ_HOR")
    private BigDecimal costoMaqHora;
    
    @Column(name="ANO_VIDA")
    private BigDecimal anoVida;
    
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

    public BigDecimal getAnoVida() {
        return anoVida;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public BigDecimal getCostoMaqHora() {
        return costoMaqHora;
    }


    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public BigDecimal getDepAcumulada() {
        return depAcumulada;
    }

    public void setDepAcumulada(BigDecimal depAcumulada) {
        this.depAcumulada = depAcumulada;
    }

    public void setAnoVida(BigDecimal anoVida) {
        this.anoVida = anoVida;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public void setCostoMaqHora(BigDecimal costoMaqHora) {
        this.costoMaqHora = costoMaqHora;
    }


    public void setValorCompra(BigDecimal valorCompra) {
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

    @Override
    public String toString() {
        return getActivo().getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}


