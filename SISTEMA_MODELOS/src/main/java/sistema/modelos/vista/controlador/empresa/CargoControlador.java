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
import sistema.modelos.server.entidades.empresa.Area;
import sistema.modelos.server.entidades.empresa.Cargo;
import sistema.modelos.server.facade.empresa.AreaFacade;
import sistema.modelos.server.facade.empresa.CargoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "cargoControlador")
@SessionScoped
public class CargoControlador implements Serializable {
    @EJB
    private AreaFacade areaFacade;
    
    @EJB
    private CargoFacade cargoFacade;
        
    
    List<Cargo> lstCargo;
    List<Area> lstArea;
    
    public Cargo currentCargo;
    public Area currentArea;
    
    public CargoControlador() {
              
    }

    public Cargo getCurrentCargo() {
        if (currentCargo == null){
            currentCargo = new Cargo();
        }
        return currentCargo;
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
        

    public void setCurrentCargo(Cargo currentCargo) {
        this.currentCargo = currentCargo;
    }
    public List<Cargo> getLstCargo() {
        lstCargo = cargoFacade.findAll();
        return lstCargo;
    }
    
    public List<Area> getLstArea() {
        return areaFacade.findAll();
    }
    
     public void persist(){
         String mensaje = "";
         
         if (currentCargo.getNombre().equals(""))
                mensaje += "Debe ingresar el nombre del Cargo <br/>";
                System.out.println(mensaje);
         if (currentCargo.getCodigo().equals(""))
                mensaje += "Debe ingresar el código del Cargo<br/>";
                System.out.println(mensaje);
         if (currentCargo.getArea().getIdArea() == null)
                mensaje += "Debe seleccionar un Area<br/>";
                System.out.println(mensaje);
         
         if (!mensaje.equals("")){    
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensaje,""));  
            return;
         }
         
         if (cargoFacade.countActivoByCode(currentCargo.getCodigo(),currentCargo.getIdCargo())>0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya se encuentra registrado un cargo con el mismo código",""));  
            return;
        }
                          
         if (currentCargo.getIdCargo()==null) {
            cargoFacade.create(currentCargo);
        }
        else {
            currentCargo.setArea(areaFacade.find(currentCargo.getArea().getIdArea()));
            cargoFacade.edit(currentCargo);
        }
        RequestContext context = RequestContext.getCurrentInstance();  

        lstCargo = getLstCargo();
        currentCargo = new Cargo();
        context.update("miform:tablaCargo");
        context.update("cruForm:panelcrud");             
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo grabado correctamente",""));  
    
    }
    
    public void agregar(){
        currentCargo = new Cargo();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaCargo");
        context.update("cruForm:panelcrud");
    
    }
     
    public void editar(){
        currentCargo = cargoFacade.find(currentCargo.getIdCargo());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaCargo");
        context.update("cruForm:panelcrud");
        
    } 
    
    public void eliminar(){
        cargoFacade.remove(currentCargo);
        agregar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo eliminado correctamente",""));  
      }
    
    
}
