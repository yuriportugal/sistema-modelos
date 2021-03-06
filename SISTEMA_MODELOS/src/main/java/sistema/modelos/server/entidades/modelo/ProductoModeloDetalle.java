/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import sistema.modelos.server.entidades.empresa.Producto;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "MODELO_PRODUCTO")
public class ProductoModeloDetalle implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODELO_PRODUCTO_SEQ")
    @SequenceGenerator(name = "MODELO_PRODUCTO_SEQ", sequenceName = "MODELO_PRODUCTO_SEQ",allocationSize = 1)
    @Column(name="ID_MODELO_PRODUCTO")
    private Long idProductoModelo;
    
    @ManyToOne 
    @JoinColumn(name = "ID_MODELO",referencedColumnName="ID_MODELO")
    private Modelo modelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    private Producto producto;

    @Column(name = "PRECIO_VENTA")
    private BigDecimal precioVenta;
    
    @Column(name = "STOCK_INICIAL")
    private BigDecimal stockInicial;
    
    @Column(name = "VOL_VENTA")
    private BigDecimal volumenVenta;
    
    @Column(name = "POLITICA_DIAS")
    private BigDecimal politicaDias;
    
    @Column(name = "POLITICA_STOCK_MIN")
    private BigDecimal politicaStockMin;
    
    @Column(name = "EQUIVALENCIA")
    private BigDecimal equivalencia;
    
    @ManyToOne
    @JoinColumn(name="UNIDAD")
    private Unidad unidad;
    
    
    @ManyToOne
    @JoinColumn(name="UNIDAD_PRESENTACION")
    private Unidad unidadPresentacion;
    
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoModelo",orphanRemoval=true)
     private List<ModeloFormulacionInsumo> lstModeloFormulacionInsumoDetalle;

     @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoModelo",orphanRemoval=true)
     private List<ModeloFormulacionMaquinaria> lstModeloFormulacionMaquinariaDetalle;
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoModelo",orphanRemoval=true)
     private List<ModeloFormulacionPersonal> lstModeloFormulacionPersonalDetalle;
          
     public Producto getProducto() {
        if (producto == null){
            producto = new Producto();
        }
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Unidad getUnidad() {
        if (unidad == null){
            unidad = new Unidad();
        }
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getPoliticaDias() {
        return politicaDias;
    }

    public BigDecimal getPoliticaStockMin() {
        return politicaStockMin;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public BigDecimal getStockInicial() {
        return stockInicial;
    }

    public BigDecimal getVolumenVenta() {
        return volumenVenta;
    }

    public void setPoliticaDias(BigDecimal politicaDias) {
        this.politicaDias = politicaDias;
    }

    public void setPoliticaStockMin(BigDecimal politicaStockMin) {
        this.politicaStockMin = politicaStockMin;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setStockInicial(BigDecimal stockInicial) {
        this.stockInicial = stockInicial;
    }

    public void setVolumenVenta(BigDecimal volumenVenta) {
        this.volumenVenta = volumenVenta;
    }

    public Long getIdProductoModelo() {
        return idProductoModelo;
    }

    public void setIdProductoModelo(Long idProductoModelo) {
        this.idProductoModelo = idProductoModelo;
    }

    public List<ModeloFormulacionInsumo> getLstModeloFormulacionInsumoDetalle() {
        if (lstModeloFormulacionInsumoDetalle == null){
            lstModeloFormulacionInsumoDetalle = new ArrayList<ModeloFormulacionInsumo>();// <ModeloFormulacionInsumo>();
        }
        return lstModeloFormulacionInsumoDetalle;
    }

    public void setLstModeloFormulacionInsumoDetalle(List<ModeloFormulacionInsumo> lstModeloFormulacionInsumoDetalle) {
        this.lstModeloFormulacionInsumoDetalle = lstModeloFormulacionInsumoDetalle;
    }

    public List<ModeloFormulacionMaquinaria> getLstModeloFormulacionMaquinariaDetalle() {
        if (lstModeloFormulacionMaquinariaDetalle == null){
            lstModeloFormulacionMaquinariaDetalle = new ArrayList<ModeloFormulacionMaquinaria>();
        }
        return lstModeloFormulacionMaquinariaDetalle;
    }

    public void setLstModeloFormulacionMaquinariaDetalle(List<ModeloFormulacionMaquinaria> lstModeloFormulacionMaquinariaDetalle) {
        this.lstModeloFormulacionMaquinariaDetalle = lstModeloFormulacionMaquinariaDetalle;
    }

    public List<ModeloFormulacionPersonal> getLstModeloFormulacionPersonalDetalle() {
        if (lstModeloFormulacionPersonalDetalle == null){
            lstModeloFormulacionPersonalDetalle = new ArrayList<ModeloFormulacionPersonal>();
        }
        return lstModeloFormulacionPersonalDetalle;
    }

    public void setLstModeloFormulacionPersonalDetalle(List<ModeloFormulacionPersonal> lstModeloFormulacionPersonalDetalle) {
        this.lstModeloFormulacionPersonalDetalle = lstModeloFormulacionPersonalDetalle;
    }

    @Override
    public String toString() {
        return getProducto().toString();
    }

    public Unidad getUnidadPresentacion() {
        if (unidadPresentacion == null){
            unidadPresentacion = new Unidad();
        }
        return unidadPresentacion;
    }

    public void setUnidadPresentacion(Unidad unidadPresentacion) {
        this.unidadPresentacion = unidadPresentacion;
    }

    public BigDecimal getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(BigDecimal equivalencia) {
        this.equivalencia = equivalencia;
    }
    
    
    
    
}


