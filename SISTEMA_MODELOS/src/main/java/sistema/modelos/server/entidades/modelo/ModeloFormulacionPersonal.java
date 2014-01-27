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
import sistema.modelos.server.entidades.empresa.Insumo;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "MODELO_FORMULACION_PERSONAL")
public class ModeloFormulacionPersonal implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMULACION_PERSONAL_SEQ")
    @SequenceGenerator(name = "FORMULACION_PERSONAL_SEQ", sequenceName = "FORMULACION_PERSONAL_SEQ",allocationSize = 1)
    @Column(name="ID_FORMULACION_PERSONAL")
    private Long idModeloFormulacionPersonal;
    
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO_PRODUCTO", referencedColumnName = "ID_MODELO_PRODUCTO")
    private ProductoModeloDetalle productoModelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    private Cargo cargo;

    @Column(name = "HORAS_HOMBRE")
    private Long horaHombre;

    public Long getIdModeloFormulacionPersonal() {
        return idModeloFormulacionPersonal;
    }

    public void setIdModeloFormulacionPersonal(Long idModeloFormulacionPersonal) {
        this.idModeloFormulacionPersonal = idModeloFormulacionPersonal;
    }

    public Long getHoraHombre() {
        return horaHombre;
    }

    public void setHoraHombre(Long horaHombre) {
        this.horaHombre = horaHombre;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public ProductoModeloDetalle getProductoModelo() {
        if (productoModelo == null){
            productoModelo = new ProductoModeloDetalle();
        }
        return productoModelo;
    }

    public void setProductoModelo(ProductoModeloDetalle productoModelo) {
        this.productoModelo = productoModelo;
    }
    
    

    
    
}


