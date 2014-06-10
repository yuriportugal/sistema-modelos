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
    private BigDecimal cantidad;
    
    @Column(name="SUELDO")
    private BigDecimal sueldo;
    
    @Column(name="RELACION_PRODUCCION")
    private String esRelacionadoProduccion;
    
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

    public String getEsRelacionadoProduccion() {
        return esRelacionadoProduccion;
    }

    public void setEsRelacionadoProduccion(String esRelacionadoProduccion) {
        this.esRelacionadoProduccion = esRelacionadoProduccion;
    }
    

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
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


