/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "TIPO_MODELO")
public class TipoModelo implements Serializable{
   
    @Id
    @Column(name="ID_TIPO_MODELO")
    private Long idTipoModelo;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Long getIdTipoModelo() {
        return idTipoModelo;
    }

    public void setIdTipoModelo(Long idTipoModelo) {
        this.idTipoModelo = idTipoModelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    

}
