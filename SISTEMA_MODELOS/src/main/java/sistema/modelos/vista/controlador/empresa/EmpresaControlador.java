/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.empresa;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Empresa;
import sistema.modelos.server.facade.empresa.EmpresaFacade;
import sistema.modelos.vista.controlador.util.UsuarioControlador;

/**
 *
 * @author Orci
 */
@ManagedBean(name = "empresaControlador")
@SessionScoped
public class EmpresaControlador {
    
    @EJB
    private EmpresaFacade empresaFacade;

    @ManagedProperty(value="#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;

    public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }
    
    public Empresa currentEmpresa;
    
    
    public Empresa getCurrentEmpresa() {
       if (currentEmpresa == null)
           currentEmpresa = new Empresa();
        return currentEmpresa;
    }

    public void setCurrentEmpresa(Empresa currentEmpresa) {
        this.currentEmpresa = currentEmpresa;
    }
    
    
    public void grabarBalance(){
    
        System.out.println("Vamos a grabar el balance inicial");
        System.out.println(" Valor Caja Banco - usuario : " + usuarioControlador.getCurrentUsuario().getEmpresa().getBiCajaBancos().toString());
        
        empresaFacade.edit(usuarioControlador.getCurrentUsuario().getEmpresa());
        
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("cruForm:panelcrud");             
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo grabado correctamente",""));  
    }
}
