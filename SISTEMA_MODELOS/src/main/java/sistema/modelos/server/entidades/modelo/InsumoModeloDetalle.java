/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
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
import sistema.modelos.server.entidades.empresa.Insumo;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "MODELO_INSUMO")
public class InsumoModeloDetalle implements Serializable{
   
  @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODELO_INSUMO_SEQ")
    @SequenceGenerator(name = "MODELO_INSUMO_SEQ", sequenceName = "MODELO_INSUMO_SEQ",allocationSize = 1)
    @Column(name="ID_MODELO_INSUMO")
    private Long idInsumoModelo;
    
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO")
    private Modelo modelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_INSUMO", referencedColumnName = "ID_INSUMO")
    private Insumo insumo;

    @Column(name = "PRECIO_COMPRA")
    private BigDecimal precioCompra;
    
    @Column(name = "STOCK_INICIAL")
    private BigDecimal stockInicial;
    
    @Column(name = "POLITICA_DIAS")
    private BigDecimal politicaDias;
    
    @Column(name = "POLITICA_STOCK_MIN")
    private BigDecimal politicaStockMin;
    
    @ManyToOne
    @JoinColumn(name="UNIDAD")
    private Unidad unidad;

    public Insumo getInsumo() {
       if (insumo == null){
           insumo = new Insumo();
       } 
        return insumo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public BigDecimal getPoliticaDias() {
        return politicaDias;
    }

    public BigDecimal getPoliticaStockMin() {
        return politicaStockMin;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public BigDecimal getStockInicial() {
        return stockInicial;
    }

    public Unidad getUnidad() {
        if (unidad == null){
            unidad = new Unidad();
        }
        
        return unidad;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }


    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setPoliticaDias(BigDecimal politicaDias) {
        this.politicaDias = politicaDias;
    }

    public void setPoliticaStockMin(BigDecimal politicaStockMin) {
        this.politicaStockMin = politicaStockMin;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setStockInicial(BigDecimal stockInicial) {
        this.stockInicial = stockInicial;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Long getIdInsumoModelo() {
        return idInsumoModelo;
    }

    public void setIdInsumoModelo(Long idInsumoModelo) {
        this.idInsumoModelo = idInsumoModelo;
    }
    
    public static InsumoModeloDetalle getByInsumo(List<InsumoModeloDetalle> lstInsumo, Insumo insumo){
        for (int i = 0; i < lstInsumo.size(); i++){
            if (lstInsumo.get(i).getInsumo().getIdInsumo().equals(insumo.getIdInsumo())){
                return lstInsumo.get(i);
            }
        }
        return null;
        
    }

    @Override
    public String toString() {
        return getInsumo().getNombre();
    }
    
    
    
}


