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
import sistema.modelos.server.entidades.empresa.Insumo;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "MODELO_FORMULACION_INSUMO")
public class ModeloFormulacionInsumo implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMULACION_INSUMO_SEQ")
    @SequenceGenerator(name = "FORMULACION_INSUMO_SEQ", sequenceName = "FORMULACION_INSUMO_SEQ",allocationSize = 1)
    @Column(name="ID_FORMULACION_INSUMO")
    private Long idModeloFormulacionInsumo;
    
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO_PRODUCTO", referencedColumnName = "ID_MODELO_PRODUCTO")
    private ProductoModeloDetalle productoModelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_INSUMO", referencedColumnName = "ID_INSUMO")
    private Insumo insumo;

    @Column(name = "CANTIDAD")
    private Long cantidad;

    public Long getIdModeloFormulacionInsumo() {
        return idModeloFormulacionInsumo;
    }

    public void setIdModeloFormulacionInsumo(Long idModeloFormulacionInsumo) {
        this.idModeloFormulacionInsumo = idModeloFormulacionInsumo;
    }

    public Long getCantidad() {
        if (cantidad == null){
            cantidad = 0L;
        }
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        if (insumo == null){
            insumo = new Insumo();
        }
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public ProductoModeloDetalle getProductoModelo() {
        return productoModelo;
    }

    public void setProductoModelo(ProductoModeloDetalle productoModelo) {
        this.productoModelo = productoModelo;
    }
    
    
    
    
}


