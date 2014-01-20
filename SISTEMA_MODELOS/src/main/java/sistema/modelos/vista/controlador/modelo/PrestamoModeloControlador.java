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
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Servicio;
import sistema.modelos.server.entidades.modelo.PrestamoModeloDetalle;
import sistema.modelos.server.entidades.modelo.ServicioModeloDetalle;
import sistema.modelos.server.entidades.modelo.TipoPrestamo;
import sistema.modelos.server.facade.empresa.ServicioFacade;
import sistema.modelos.server.facade.modelo.TipoPrestamoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "prestamoModeloControlador")
@SessionScoped
public class PrestamoModeloControlador implements Serializable {
  
    private List<PrestamoModeloDetalle> lstPrestamoModeloDetalle;
    
    private PrestamoModeloDetalle currentPrestamoModeloDetalle;
       
    private List<TipoPrestamo> lstTipoPrestamo;
    
    @EJB
    private TipoPrestamoFacade tipoPrestamoFacade;
    
    private boolean isEditPrestMod;

    private Long maxId = -1L;
    
    public PrestamoModeloDetalle getCurrentPrestamoModeloDetalle() {
        if (currentPrestamoModeloDetalle == null){
            currentPrestamoModeloDetalle = new PrestamoModeloDetalle();
        }
        return currentPrestamoModeloDetalle;
    }

    public void setCurrentPrestamoModeloDetalle(PrestamoModeloDetalle currentPrestamoModeloDetalle) {
        this.currentPrestamoModeloDetalle = currentPrestamoModeloDetalle;
    }

    public List<PrestamoModeloDetalle> getLstPrestamoModeloDetalle() {
        if (lstPrestamoModeloDetalle == null){
            lstPrestamoModeloDetalle = new ArrayList<PrestamoModeloDetalle>();
        }
        return lstPrestamoModeloDetalle;
    }

    public void setIsEditPrestMod(boolean isEditPrestMod) {
        this.isEditPrestMod = isEditPrestMod;
    }

    public List<TipoPrestamo> getLstTipoPrestamo() {
        return tipoPrestamoFacade.findAll();
    }

    public void setLstPrestamoModeloDetalle(List<PrestamoModeloDetalle> lstPrestamoModeloDetalle) {
        this.lstPrestamoModeloDetalle = lstPrestamoModeloDetalle;
    }

    public TipoPrestamoFacade getTipoPrestamoFacade() {
        return tipoPrestamoFacade;
    }

    public void setLstTipoPrestamo(List<TipoPrestamo> lstTipoPrestamo) {
        this.lstTipoPrestamo = lstTipoPrestamo;
    }

    public boolean isIsEditPrestMod() {
        return isEditPrestMod;
    }

    public void setTipoPrestamoFacade(TipoPrestamoFacade tipoPrestamoFacade) {
        this.tipoPrestamoFacade = tipoPrestamoFacade;
    }

    
    
    //CRUD DE ACTIVO
    
    public void nuevoPrestamoModelo(){
        isEditPrestMod = false;
        currentPrestamoModeloDetalle = new PrestamoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelPrestamoMod");
           }
      
    public void editarPrestamoModelo(){
        isEditPrestMod = true;
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelPrestamoMod");
    } 
    
    public void agregarPrestamoModelo(){
   //TODO VER COMO AGREGAR A REFERENCIA AL MODELO getCurrentProductoModeloDetalle().setModelo(getCurrentModelo());
        
        if (!isEditPrestMod){
            getCurrentPrestamoModeloDetalle().setTipoPrestamo(tipoPrestamoFacade.find(currentPrestamoModeloDetalle.getTipoPrestamo().getIdTipoPrestamo()));
            getCurrentPrestamoModeloDetalle().setIdModeloPrestamo(maxId--);
            getLstPrestamoModeloDetalle().add(getCurrentPrestamoModeloDetalle());
           
        }else{
            
            int pos = 0;
            for (int i = 0; i < getLstPrestamoModeloDetalle().size();i++){
                if (getLstPrestamoModeloDetalle().get(i).getIdModeloPrestamo().equals(getCurrentPrestamoModeloDetalle().getIdModeloPrestamo())){
                    pos = i;
                    break;
                }
            }
            getLstPrestamoModeloDetalle().remove(pos);
            getLstPrestamoModeloDetalle().add(getCurrentPrestamoModeloDetalle());
        }
        
        isEditPrestMod = false;
        currentPrestamoModeloDetalle = new PrestamoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaPrestamoModelo");
        context.update("modeloForm:tabViewModelo:panelPrestamoMod");
        
    } 
    
    
     public void eliminarPrestamoModelo(){
        int pos = 0;
        for (int i = 0; i < getLstPrestamoModeloDetalle().size();i++){
                if (getLstPrestamoModeloDetalle().get(i).getIdModeloPrestamo().equals(getCurrentPrestamoModeloDetalle().getIdModeloPrestamo())){
                    pos = i;
                    break;
                }
            }
            getLstPrestamoModeloDetalle().remove(pos);
 
        currentPrestamoModeloDetalle = new PrestamoModeloDetalle();
        
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaPrestamoModelo");
        context.update("modeloForm:tabViewModelo:panelPrestamoMod");
        isEditPrestMod = false;
    } 
    
}
