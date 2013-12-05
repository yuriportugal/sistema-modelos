    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.empresa;

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
import sistema.modelos.server.entidades.empresa.Servicio;
import sistema.modelos.server.entidades.empresa.TipoActivo;
import sistema.modelos.server.facade.empresa.ActivoFacade;
import sistema.modelos.server.facade.empresa.AreaFacade;
import sistema.modelos.server.facade.empresa.InsumoFacade;
import sistema.modelos.server.facade.empresa.ServicioFacade;
import sistema.modelos.server.facade.empresa.TipoActivoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "servicioControlador")
@SessionScoped
public class ServicioControlador implements Serializable {
    @EJB
    private ServicioFacade servicioFacade;
   
    @EJB
    private AreaFacade areaFacade;
    
    Long idActivo;
    List<Servicio> lstServicio;
    List<Area> lstArea;
    
    public Servicio currentServicio;
    public Area currentArea;
    
    public ServicioControlador() {
    }

    public Servicio getCurrentServicio() {
        if (currentServicio == null){
            currentServicio = new Servicio();
        }
        return currentServicio;
    }

    public Area getCurrentArea() {
        if (currentArea == null)
            currentArea = new Area();
        return currentArea;
    }

        public void persistArea(){
        System.out.print("Persistiendo el área");
        areaFacade.create(currentArea);
        lstArea = getLstArea();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("cruForm:panelcrud");
        currentArea = new Area();
        RequestContext.getCurrentInstance().execute("AreaDlg.hide()");
    }
        
        
        

    public void setCurrentServicio(Servicio currentServicio) {
        this.currentServicio = currentServicio;
    }

    public List<Servicio> getLstServicio() {
        lstServicio = servicioFacade.findAll();
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }
    
   public List<Area> getLstArea() {
        return areaFacade.findAll();
    }
    
     public void persist(){
             String mensaje = "";
            
            if (currentServicio.getNombre().equals(""))
                mensaje += "Debe ingresar el nombre del Servicio <br/>";
            if (currentServicio.getCodigo().equals(""))
                mensaje += "Debe ingresar el código del Servicio<br/>";
            
            if (currentServicio.getArea().getIdArea() == null)
                mensaje += "Debe seleccionar un Area<br/>";
        
            if (!mensaje.equals("")){    
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensaje,""));  
    
            return;
        }
        
        if (servicioFacade.countActivoByCode(currentServicio.getCodigo(),currentServicio.getIdServicio())>0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya se encuentra registrado un servicio con el mismo código",""));  
            return;
        }
            
        
        if (currentServicio.getIdServicio()==null) {
            servicioFacade.create(currentServicio);
        }
        else {
            currentServicio.setArea(areaFacade.find(currentServicio.getArea().getIdArea()));
            servicioFacade.edit(currentServicio);
        }
        RequestContext context = RequestContext.getCurrentInstance();  

        lstServicio = getLstServicio();
        currentServicio = new Servicio();
        context.update("miform:tablaServicio");
        context.update("cruForm:panelcrud");
             
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Servicio grabado correctamente",""));  
    
    }
    
    public void agregar(){
        currentServicio = new Servicio();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaServicio");
        context.update("cruForm:panelcrud");
    
    }
     
    public void editar(){
        currentServicio = servicioFacade.find(currentServicio.getIdServicio());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaServicio");
        context.update("cruForm:panelcrud");
        
    } 
    
    public void eliminar(){
        servicioFacade.remove(currentServicio);
        agregar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Activo eliminado correctamente",""));  
      }
    
    
}
