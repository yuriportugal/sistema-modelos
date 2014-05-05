    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.util;

import java.io.IOException;
import sistema.modelos.vista.controlador.empresa.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.entidades.empresa.Area;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.empresa.TipoActivo;
import sistema.modelos.server.entidades.util.Usuario;
import sistema.modelos.server.facade.empresa.ActivoFacade;
import sistema.modelos.server.facade.empresa.AreaFacade;
import sistema.modelos.server.facade.empresa.InsumoFacade;
import sistema.modelos.server.facade.empresa.TipoActivoFacade;
import sistema.modelos.server.facade.util.UsuarioFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {
    @EJB
    private UsuarioFacade usuarioFacade;
    
    private Usuario currentUsuario;

    public Usuario getCurrentUsuario() {
        if (currentUsuario == null){
            currentUsuario = new Usuario();
        }
        return currentUsuario;
    }

    public void setCurrentUsuario(Usuario currentUsuario) {
        this.currentUsuario = currentUsuario;
    }
    
    public String validarUsuario(){
        Usuario usuarioComp = usuarioFacade.findByCode(currentUsuario.getCodUsuario());
        if (usuarioComp.getPassUsuario().equals(currentUsuario.getPassUsuario())){
            currentUsuario = usuarioComp;
            return "/inicio";
        }else{
            return "";
        }
    }
    
   public void validarSesion() throws IOException{
       if (currentUsuario != null && currentUsuario.getIdUsuario() != null
           && currentUsuario.getIdUsuario() != 0){
       //FacesContext.getC
       }
   }
}
