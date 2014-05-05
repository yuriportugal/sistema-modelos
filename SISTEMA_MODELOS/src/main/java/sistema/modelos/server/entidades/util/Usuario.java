/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.util;

import sistema.modelos.server.entidades.empresa.*;
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
@Table(name = "USUARIO")
public class Usuario implements Serializable{
   
    @Id
    @Column(name="ID_USUARIO")
    private Long idUsuario;

    @Column(name = "NOMBRE")
    private String nombres;
    
    @Column(name = "APE_PATERNO")
    private String apellidoPaterno;
    
    @Column(name = "APE_MATERNO")
    private String apellidoMaterno;
    
    @Column(name = "CODIGO_USUARIO")
    private String codUsuario;
    
    @Column(name = "PASS_USUARIO")
    private String passUsuario;

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }
    
    
    
    public String getCodUsuario() {
        if (codUsuario == null){
            codUsuario = new String();
        }
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    
    
    @ManyToOne
    @JoinColumn(name="ID_EMPRESA")
    private Empresa empresa;

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    
}
