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
@Table(name = "TIPO_PRESTAMO")
public class TipoPrestamo implements Serializable{
   
    @Id
    @Column(name="ID_TIPO_PRESTAMO")
    private Long idTipoPrestamo;
    
    @Column(name = "NOMBRE")
    private String nombre;

    public Long getIdTipoPrestamo() {
        return idTipoPrestamo;
    }

    public void setIdTipoPrestamo(Long idTipoPrestamo) {
        this.idTipoPrestamo = idTipoPrestamo;
    }

 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
