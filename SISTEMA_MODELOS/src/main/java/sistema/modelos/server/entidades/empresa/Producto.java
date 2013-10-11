/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.empresa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTO_ID_PRODUCTO_SEQ")
    @Column(name = "IDPRODUCTO")
    private Long idproducto;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "CODIGO")
    private String codigo;
  
    @Column(name = "NOMBRE")
    private String nombre;
      
//    public Producto() {
//    }
//
//    public Producto(Long idproducto) {
//        this.idproducto = idproducto;
//    }

//    public Producto(Long idproducto, String descripcion, long precio) {
//        this.idproducto = idproducto;
//        this.descripcion = descripcion;
//    }

    public Long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNOMBRE() {
        return nombre;
    }

    public void setNOMBRE(String nombre) {
        this.nombre = nombre;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

   
}
