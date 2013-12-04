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
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.facade.empresa.InsumoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "insumoControlador")
@SessionScoped
public class InsumoControlador implements Serializable {
    @EJB
    private InsumoFacade insumoFacade;
    
    Long idInsumo;
    List<Insumo> lstInsumo;
    
    public Insumo currentInsumo;
    
    public InsumoControlador() {
        
      
    }

    public Insumo getCurrentInsumo() {
        return currentInsumo;
    }

    public void setCurrentInsumo(Insumo currentInsumo) {
        this.currentInsumo = currentInsumo;
    }
    
    public List<Insumo> getLstInsumos() {
        lstInsumo = insumoFacade.findAll();
        
        return lstInsumo;
    }
    
    public Insumo getInsumo(){
        if (currentInsumo == null){
            currentInsumo = new Insumo();
        }
        return currentInsumo;
    }
    
    public void persist(){
        
        String mensaje = "";
             System.out.println(currentInsumo.getNombre());
             
             if (currentInsumo.getCodigo().equals(""))
                mensaje += "Debe ingresar el código del Insumo <br/>";
             if (currentInsumo.getNombre().equals(""))
                mensaje += "Debe ingresar el nombre del Insumo <br/>";
             if (currentInsumo.getDescripcion().equals(""))
                mensaje += "Debe ingresar la descripcion del Insumo <br/>";
             
             if (!mensaje.equals("")){    
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensaje,""));  
                return;
             }
             
             if (insumoFacade.countActivoByCode(currentInsumo.getCodigo())>0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya se encuentra registrado un insumo con el mismo código",""));  
                return;
             }
            
            if (currentInsumo.getIdInsumo()==null) {
                insumoFacade.create(currentInsumo);
            }
            else {
                insumoFacade.edit(currentInsumo);
            }
            RequestContext context = RequestContext.getCurrentInstance();  

            lstInsumo = getLstInsumos();
            currentInsumo = new Insumo();
            context.update("miform:tablaInsumo");
            context.update("cruForm:panelcrud");
          
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Insumo grabado correctamente",""));  
    
    } 
    
    public void getEditarInsumo(){
        System.out.println("ID:::xx "+idInsumo);
        currentInsumo = insumoFacade.find(idInsumo);
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("cruForm:panelcrud");
        
    }

    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Long getIdInsumo() {
        return idInsumo;
    }
    
    public void agregar(){
        currentInsumo = new Insumo();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaInsumo");
        context.update("cruForm:panelcrud");
    
    }
    
    public void editar(){
        currentInsumo = insumoFacade.find(currentInsumo.getIdInsumo());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaInsumo");
        context.update("cruForm:panelcrud");
        
    }
    
    public void eliminar(){
        insumoFacade.remove(currentInsumo);
        agregar();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Insumo eliminado correctamente",""));  
      }
}
