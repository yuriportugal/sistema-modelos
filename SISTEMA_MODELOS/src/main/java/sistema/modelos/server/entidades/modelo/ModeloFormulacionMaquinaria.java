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
import sistema.modelos.server.entidades.empresa.Insumo;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "MODELO_FORMULACION_MAQUINARIA")
public class ModeloFormulacionMaquinaria implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMULACION_MAQUINARIA_SEQ")
    @SequenceGenerator(name = "FORMULACION_MAQUINARIA_SEQ", sequenceName = "FORMULACION_MAQUINARIA_SEQ",allocationSize = 1)
    @Column(name="ID_FORMULACION_MAQUINARIA")
    private Long idModeloFormulacionMaquinaria;
    
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO_PRODUCTO", referencedColumnName = "ID_MODELO_PRODUCTO")
    private ProductoModeloDetalle productoModelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_ACTIVO", referencedColumnName = "ID_ACTIVO")
    private Activo activo;

    @Column(name = "HORA_MAQUINA")
    private Long horaMaquina;

    public Activo getActivo() {
        if (activo == null){
            activo = new Activo();
        }
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public Long getHoraMaquina() {
        if (horaMaquina == null){
            horaMaquina = 0L;
        }
        return horaMaquina;
    }

    public void setHoraMaquina(Long horaMaquina) {
        this.horaMaquina = horaMaquina;
    }

    public Long getIdModeloFormulacionMaquinaria() {
        return idModeloFormulacionMaquinaria;
    }

    public void setIdModeloFormulacionMaquinaria(Long idModeloFormulacionMaquinaria) {
        this.idModeloFormulacionMaquinaria = idModeloFormulacionMaquinaria;
    }

    public ProductoModeloDetalle getProductoModelo() {
        return productoModelo;
    }

    public void setProductoModelo(ProductoModeloDetalle productoModelo) {
        this.productoModelo = productoModelo;
    }

    

}


