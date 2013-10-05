/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.empresa;

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

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "INSUMO")
public class Insumo implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSUMO_ID_INSUMO_SEQ")
    @SequenceGenerator(name = "INSUMO_ID_INSUMO_SEQ", sequenceName = "INSUMO_ID_INSUMO_SEQ",allocationSize = 1)
    @Column(name="ID_INSUMO")
    private Long idInsumo;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CODIGO")
    private String codigo;

    @ManyToOne
    @JoinColumn(name="ID_UNIDAD")
    private Unidad unidad;
    
    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Long getIdInsumo() {
        
        if (idInsumo == null)
            idInsumo = -1L;
        
        return idInsumo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Unidad getUnidad() {
        
        if (unidad == null)
            unidad = new Unidad();
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    
    
    
}
