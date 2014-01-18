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
import sistema.modelos.server.entidades.empresa.Cargo;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "CARGO_MODELO")
public class CargoModeloDetalle implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARGO_MODELO_SEQ")
    @SequenceGenerator(name = "CARGO_MODELO_SEQ", sequenceName = "CARGO_MODELO_SEQ",allocationSize = 1)
    @Column(name="ID_CARGO_MODELO")
    private Long idCargoModelo;
    
    @Column(name="CANTIDAD")
    private Long cantidad;
    
    @Column(name="SUELDO")
    private Long sueldo;
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO")
    private Modelo modelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    private Cargo cargo;
    
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

    public Cargo getCargo() {
        if (cargo == null){
            cargo = new Cargo();
        }
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Long getIdCargoModelo() {
        return idCargoModelo;
    }

    public void setIdCargoModelo(Long idCargoModelo) {
        this.idCargoModelo = idCargoModelo;
    }

   
    
}


