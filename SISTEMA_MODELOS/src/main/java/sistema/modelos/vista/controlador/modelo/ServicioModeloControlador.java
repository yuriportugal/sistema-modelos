    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Servicio;
import sistema.modelos.server.entidades.modelo.ServicioModeloDetalle;
import sistema.modelos.server.facade.empresa.ServicioFacade;
import sistema.modelos.vista.controlador.util.UsuarioControlador;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "servicioModeloControlador")
@SessionScoped
public class ServicioModeloControlador implements Serializable {
  
    private List<ServicioModeloDetalle> lstServicioModeloDetalle;
    
    private ServicioModeloDetalle currentServicioModeloDetalle;
       
    private List<Servicio> lstServicio;
    
    public void limpiarVariables(){
        lstServicioModeloDetalle = null;
        currentServicioModeloDetalle = null;
    }
    
    @EJB
    private ServicioFacade servicioFacade;
    
    private boolean isEditServMod;

    @ManagedProperty(value="#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;

    public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }
    
    
    
    public ServicioModeloDetalle getCurrentServicioModeloDetalle() {
        if ( currentServicioModeloDetalle == null){
            currentServicioModeloDetalle = new ServicioModeloDetalle();
        }
        return currentServicioModeloDetalle;
    }

    public void setCurrentServicioModeloDetalle(ServicioModeloDetalle currentServicioModeloDetalle) {
        this.currentServicioModeloDetalle = currentServicioModeloDetalle;
    }

    public List<Servicio> getLstServicio() {
        return servicioFacade.findAllByEmpresa(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa());
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public List<ServicioModeloDetalle> getLstServicioModeloDetalle() {
        if (lstServicioModeloDetalle == null){
            lstServicioModeloDetalle = new ArrayList<ServicioModeloDetalle>();
        }
        
        return lstServicioModeloDetalle;
    }

    public void setIsEditServMod(boolean isEditServMod) {
        this.isEditServMod = isEditServMod;
    }

    public ServicioFacade getServicioFacade() {
        return servicioFacade;
    }

    public void setLstServicioModeloDetalle(List<ServicioModeloDetalle> lstServicioModeloDetalle) {
        this.lstServicioModeloDetalle = lstServicioModeloDetalle;
    }

    public void setServicioFacade(ServicioFacade servicioFacade) {
        this.servicioFacade = servicioFacade;
    }

    public boolean isIsEditServMod() {
        return isEditServMod;
    }

    
    
    
    
    //CRUD DE ACTIVO
    
    public void nuevoServicioModelo(){
        isEditServMod = false;
        currentServicioModeloDetalle = new ServicioModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelServicioMod");
           }
      
    public void editarServicioModelo(){
        isEditServMod = true;
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelServicioMod");
    } 
    
    public void agregarServicioModelo(){
   //TODO VER COMO AGREGAR A REFERENCIA AL MODELO getCurrentProductoModeloDetalle().setModelo(getCurrentModelo());
        
        if (!isEditServMod){
            getCurrentServicioModeloDetalle().setServicio(servicioFacade.find(getCurrentServicioModeloDetalle().getServicio().getIdServicio()));
            getLstServicioModeloDetalle().add(getCurrentServicioModeloDetalle());
           
        }else{
            int pos = 0;
            for (int i = 0; i < getLstServicioModeloDetalle().size();i++){
                if (getLstServicioModeloDetalle().get(i).getServicio().getIdServicio().equals(getCurrentServicioModeloDetalle().getServicio().getIdServicio())){
                    pos = i;
                    break;
                }
            }
            getLstServicioModeloDetalle().remove(pos);
            getLstServicioModeloDetalle().add(getCurrentServicioModeloDetalle());
        }
        
        isEditServMod = false;
        currentServicioModeloDetalle = new ServicioModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaServicioModelo");
        context.update("modeloForm:tabViewModelo:panelServicioMod");
        
    } 
    
    
     public void eliminarActivoModelo(){
        int pos = 0;
        for (int i = 0; i < getLstServicioModeloDetalle().size();i++){
                if (getLstServicioModeloDetalle().get(i).getServicio().getIdServicio().equals(getCurrentServicioModeloDetalle().getServicio().getIdServicio())){
                    pos = i;
                    break;
                }
            }
            getLstServicioModeloDetalle().remove(pos);
 
        currentServicioModeloDetalle = new ServicioModeloDetalle();
        
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaServicioModelo");
        context.update("modeloForm:tabViewModelo:panelServicioMod");
        isEditServMod = false;
    } 
    
}
