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
@Table(name = "CARGO_MODELO")
public class CargoModeloDetalle implements Serializable{
   
    @EmbeddedId
    private CargoModeloPK cargoModeloPK;
    
    private Long cantidad;
    
    private Long sueldo;
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO", insertable = false, updatable = false)
    private Modelo modelo;
    
    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getSueldo() {
        return sueldo;
    }

    public void setSueldo(Long sueldo) {
        this.sueldo = sueldo;
    }

    public CargoModeloPK getCargoModeloPK() {
        return cargoModeloPK;
    }

    public void setCargoModeloPK(CargoModeloPK cargoModeloPK) {
        this.cargoModeloPK = cargoModeloPK;
    }

    
    
    
    
}


