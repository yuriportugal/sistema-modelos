/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import sistema.modelos.server.entidades.empresa.Servicio;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "MODELO_SERVICIO")
public class ServicioModeloDetalle implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODELO_SERVICIO_SEQ")
    @SequenceGenerator(name = "MODELO_SERVICIO_SEQ", sequenceName = "MODELO_SERVICIO_SEQ",allocationSize = 1)
    @Column(name="ID_MODELO_SERVICIO")
    private Long idModeloServicio;
    
    @Column(name="MONTO")
    private Long monto;
    
    @ManyToOne
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO")
    private Modelo modelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "ID_SERVICIO")
    private Servicio servicio;

    public Long getIdModeloServicio() {
        return idModeloServicio;
    }

    public void setIdModeloServicio(Long idModeloServicio) {
        this.idModeloServicio = idModeloServicio;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Servicio getServicio() {
        if (servicio == null){
            servicio = new Servicio();
        }
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
   
    
}


