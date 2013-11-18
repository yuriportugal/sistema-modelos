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
@Table(name = "ANO")
public class Ano implements Serializable{
   
    @Id
    @Column(name="ID_ANO")
    private Long idAno;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Long getIdAno() {
        return idAno;
    }

    public void setIdAno(Long idAno) {
        this.idAno = idAno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    

}
