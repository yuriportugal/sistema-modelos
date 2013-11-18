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
@Table(name = "TIPO_PERIODO")
public class TipoPeriodo implements Serializable{
   
    @Id
    @Column(name="ID_TIPO_PERIODO")
    private Long idTipoPeriodo;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name="NUM_PER_ANO")
    private Long numPerAno;

    public Long getIdTipoPeriodo() {
        return idTipoPeriodo;
    }

    public void setIdTipoPeriodo(Long idTipoPeriodo) {
        this.idTipoPeriodo = idTipoPeriodo;
    }
    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getNumPerAno() {
        return numPerAno;
    }

    public void setNumPerAno(Long numPerAno) {
        this.numPerAno = numPerAno;
    }

    
    
    

}
