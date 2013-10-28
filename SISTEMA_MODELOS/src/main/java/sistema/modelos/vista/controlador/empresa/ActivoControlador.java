/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.empresa;

import java.io.Serializable;
import java.util.List;
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
import sistema.modelos.server.facade.empresa.ActivoFacade;
import sistema.modelos.server.facade.empresa.AreaFacade;
import sistema.modelos.server.facade.empresa.InsumoFacade;
import sistema.modelos.server.facade.empresa.TipoActivoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "activoControlador")
@SessionScoped
public class ActivoControlador implements Serializable {
    @EJB
    private ActivoFacade activoFacade;
    
    @EJB
    private TipoActivoFacade tipoActivoFacade;
    
    @EJB
    private AreaFacade areaFacade;
    
    
    Long idActivo;
    List<Activo> lstActivo;
    List<Area> lstArea;
    
    public Activo currentActivo;
    
    public ActivoControlador() {
        
      
    }

    public Activo getCurrentActivo() {
        if (currentActivo == null){
            currentActivo = new Activo();
        }
        return currentActivo;
    }

    public void setCurrentActivo(Activo currentActivo) {
        this.currentActivo = currentActivo;
    }
    public List<Activo> getLstActivo() {
        lstActivo = activoFacade.findAll();
        return lstActivo;
    }
    public List<TipoActivo> getLstTipoActivo(){
        return tipoActivoFacade.findAll();
    }

    public List<Area> getLstArea() {
        return areaFacade.findAll();
    }
    
     public void persist(){
        if (currentActivo.getIdActivo()==null) {
            System.out.print("Area "+currentActivo.getArea().getIdArea()+"Tipo "+currentActivo.getTipoActivo().getIdTipoActivo());
            activoFacade.create(currentActivo);
        }
        else {
            System.out.print("Area "+currentActivo.getArea().getIdArea()+"Tipo "+currentActivo.getTipoActivo().getIdTipoActivo());
            currentActivo.setArea(areaFacade.find(currentActivo.getArea().getIdArea()));
            currentActivo.setTipoActivo(tipoActivoFacade.find(currentActivo.getTipoActivo().getIdTipoActivo()));
            activoFacade.edit(currentActivo);
        }
        RequestContext context = RequestContext.getCurrentInstance();  

        lstActivo = getLstActivo();
        currentActivo = new Activo();
        context.update("miform:tablaActivo");
        context.update("cruForm:panelcrud");
             
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Activo grabado correctamente",""));  
    
    }
    
    public void agregar(){
        currentActivo = new Activo();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaActivo");
        context.update("cruForm:panelcrud");
    
    }
     
    public void editar(){
        currentActivo = activoFacade.find(currentActivo.getIdActivo());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaActivo");
        context.update("cruForm:panelcrud");
        
    } 
    
    public void eliminar(){
        activoFacade.remove(currentActivo);
        agregar();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Activo eliminado correctamente",""));  
      }
    
    public ActivoFacade getActivoFacade() {
        return activoFacade;
    }
}
