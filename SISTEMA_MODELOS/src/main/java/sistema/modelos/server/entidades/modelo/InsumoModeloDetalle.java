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
@Table(name = "MODELO_INSUMO")
public class InsumoModeloDetalle implements Serializable{
   
    @EmbeddedId
    private InsumoModeloPK insumoModeloPK;
    
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO", insertable = false, updatable = false)
    private Modelo modelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_INSUMO", referencedColumnName = "ID_INSUMO", insertable = false, updatable = false)
    private Insumo insumo;

    @Column(name = "PRECIO_COMPRA")
    private Long precioCompra;
    
    @Column(name = "STOCK_INICIAL")
    private Long stockInicial;
    
    @Column(name = "POLITICA_DIAS")
    private Long politicaDias;
    
    @Column(name = "POLITICA_STOCK_MIN")
    private Long politicaStockMin;
    
    @ManyToOne
    @JoinColumn(name="UNIDAD")
    private Unidad unidad;

    public Insumo getInsumo() {
        return insumo;
    }

    public InsumoModeloPK getInsumoModeloPK() {
        return insumoModeloPK;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Long getPoliticaDias() {
        return politicaDias;
    }

    public Long getPoliticaStockMin() {
        return politicaStockMin;
    }

    public Long getPrecioCompra() {
        return precioCompra;
    }

    public Long getStockInicial() {
        return stockInicial;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public void setInsumoModeloPK(InsumoModeloPK insumoModeloPK) {
        this.insumoModeloPK = insumoModeloPK;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setPoliticaDias(Long politicaDias) {
        this.politicaDias = politicaDias;
    }

    public void setPoliticaStockMin(Long politicaStockMin) {
        this.politicaStockMin = politicaStockMin;
    }

    public void setPrecioCompra(Long precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setStockInicial(Long stockInicial) {
        this.stockInicial = stockInicial;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    
}


