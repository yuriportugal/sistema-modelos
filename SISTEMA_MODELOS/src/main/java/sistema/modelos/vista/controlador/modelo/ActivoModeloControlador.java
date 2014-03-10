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
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.entidades.modelo.ActivoModeloDetalle;
import sistema.modelos.server.facade.empresa.ActivoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "activoModeloControlador")
@SessionScoped
public class ActivoModeloControlador implements Serializable {
  
    private List<ActivoModeloDetalle> lstActivoModeloDetalle;
    
    private ActivoModeloDetalle currentActivoModeloDetalle;
       
    private List<Activo> lstActivo;
    
    @EJB
    private ActivoFacade activoFacade;
    
    private boolean isEditActMod;

    public void limpiarVariables(){
        lstActivoModeloDetalle = null;
        currentActivoModeloDetalle = null;
    }
    
    
    public List<ActivoModeloDetalle> getLstActivoModeloDetalle() {
        if (lstActivoModeloDetalle == null){
            lstActivoModeloDetalle = new ArrayList<ActivoModeloDetalle>();
        }
        return lstActivoModeloDetalle;
    }

    public void setLstActivoModeloDetalle(List<ActivoModeloDetalle> lstActivoModeloDetalle) {
        this.lstActivoModeloDetalle = lstActivoModeloDetalle;
    }

    public ActivoModeloDetalle getCurrentActivoModeloDetalle() {
        if (currentActivoModeloDetalle == null){
            currentActivoModeloDetalle = new ActivoModeloDetalle();
        }
        return currentActivoModeloDetalle;
    }

    public void setCurrentActivoModeloDetalle(ActivoModeloDetalle currentActivoModeloDetalle) {
        this.currentActivoModeloDetalle = currentActivoModeloDetalle;
    }

    public List<Activo> getLstActivo() {
        return activoFacade.findAll();
    }

    public void setLstActivo(List<Activo> lstActivo) {
        this.lstActivo = lstActivo;
    }

    public ActivoFacade getActivoFacade() {
        return activoFacade;
    }

    public void setActivoFacade(ActivoFacade activoFacade) {
        this.activoFacade = activoFacade;
    }

    public boolean isIsEditActMod() {
        return isEditActMod;
    }

    public void setIsEditActMod(boolean isEditActMod) {
        this.isEditActMod = isEditActMod;
    }
    //CRUD DE ACTIVO
    
    public void nuevoActivoModelo(){
        isEditActMod = false;
        currentActivoModeloDetalle = new ActivoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelActivoMod");
           }
      
    public void editarActivoModelo(){
        isEditActMod = true;
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelActivoMod");
    } 
    
    public void agregarActivoModelo(){
   //TODO VER COMO AGREGAR A REFERENCIA AL MODELO getCurrentProductoModeloDetalle().setModelo(getCurrentModelo());
        
        System.out.println("Empezamos a ver isEditInsMod: "+isEditActMod);
        if (!isEditActMod){
            getCurrentActivoModeloDetalle().setActivo(activoFacade.find(getCurrentActivoModeloDetalle().getActivo().getIdActivo()));
            getLstActivoModeloDetalle().add(getCurrentActivoModeloDetalle());
            System.out.println("Tamaño: "+getLstActivoModeloDetalle().size());
        }else{
            int pos = 0;
            for (int i = 0; i < getLstActivoModeloDetalle().size();i++){
                if (getLstActivoModeloDetalle().get(i).getActivo().getIdActivo().equals(getCurrentActivoModeloDetalle().getActivo().getIdActivo())){
                    pos = i;
                    break;
                }
            }
            getLstActivoModeloDetalle().remove(pos);
            getLstActivoModeloDetalle().add(getCurrentActivoModeloDetalle());
        }
        
        isEditActMod = false;
        currentActivoModeloDetalle = new ActivoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaActivoModelo");
        context.update("modeloForm:tabViewModelo:panelActivoMod");
        
    } 
    
    
     public void eliminarActivoModelo(){
        int pos = 0;
        for (int i = 0; i < getLstActivoModeloDetalle().size();i++){
                if (getLstActivoModeloDetalle().get(i).getActivo().getIdActivo().equals(getCurrentActivoModeloDetalle().getActivo().getIdActivo())){
                    pos = i;
                    break;
                }
            }
            getLstActivoModeloDetalle().remove(pos);
 
        currentActivoModeloDetalle = new ActivoModeloDetalle();
        
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaActivoModelo");
        context.update("modeloForm:tabViewModelo:panelActivoMod");
        isEditActMod = false;
    } 
    
}
