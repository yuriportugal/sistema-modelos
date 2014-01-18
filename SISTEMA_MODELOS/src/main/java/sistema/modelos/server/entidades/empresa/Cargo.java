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
@Table(name = "CARGO")
public class Cargo implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARGO_SEQ")
    @SequenceGenerator(name = "CARGO_SEQ", sequenceName = "CARGO_SEQ",allocationSize = 1)
    @Column(name="ID_CARGO")
    private Long idCargo;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CODIGO")
    private String codigo;

    @ManyToOne
    @Null 
    @JoinColumn(name="ID_EMPRESA")
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name="ID_AREA")
    private Area area;

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

      
    
    public void setCodigo(String codigo) {
        
        System.out.println("Saving from entity cod"+codigo);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        System.out.println("Saving from entity"+nombre);
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

    public Area getArea() {
      if (area == null){
          area = new Area();
      }  
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
   
}
