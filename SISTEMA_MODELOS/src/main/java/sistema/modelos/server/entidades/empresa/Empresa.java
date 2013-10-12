/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.empresa;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable{
   
    @Id
    @Column(name="ID_EMPRESA")
    private Long idEmpresa;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "RUC")
    private String ruc;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;
    
    @Column(name = "TELEFONO")
    private String telefono;
    
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "PAGINA_WEB")
    private String paginaWeb;
    
    @ManyToOne
    @JoinColumn(name="ID_RUBRO")
    private Rubro rubro;

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    
}
