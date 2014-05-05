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
import javax.validation.constraints.Null;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "INSUMO")
public class Insumo implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSUMO_SEQ")
    @SequenceGenerator(name = "INSUMO_SEQ", sequenceName = "INSUMO_SEQ",allocationSize = 1)
    @Column(name="ID_INSUMO")
    private Long idInsumo;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CODIGO")
    private String codigo;

    @ManyToOne
    @JoinColumn(name="ID_EMPRESA")
    private Empresa empresa;
    
    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Long getIdInsumo() {
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

    public Empresa getEmpresa() {
        
        if (empresa == null){
            empresa = new Empresa();
        }
        
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
