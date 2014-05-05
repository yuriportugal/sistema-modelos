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
@Table(name = "ACTIVO")
public class Activo implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIVO_SEQ")
    @SequenceGenerator(name = "ACTIVO_SEQ", sequenceName = "ACTIVO_SEQ",allocationSize = 1)
    @Column(name="ID_ACTIVO")
    private Long idActivo;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CODIGO")
    private String codigo;

    @ManyToOne
    @JoinColumn(name="ID_EMPRESA")
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name="ID_TIPO_ACTIVO")
    private TipoActivo tipoActivo;
 
    @ManyToOne
    @JoinColumn(name="ID_AREA")
    private Area area;

    
    public Long getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(Long idActivo) {
        this.idActivo = idActivo;
    }
    
    

    public TipoActivo getTipoActivo() {
         if (tipoActivo == null){
            tipoActivo = new TipoActivo();
        }
        
        return tipoActivo;
    }

    public void setTipoActivo(TipoActivo tipoActivo) {
        this.tipoActivo = tipoActivo;
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
