/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.empresa;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.empresa.Unidad;
import sistema.modelos.server.entidades.empresa.facade.InsumoFacade;
import sistema.modelos.server.entidades.empresa.facade.UnidadFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "insumoControlador")
@SessionScoped
public class InsumoControlador implements Serializable {
    
    
    @EJB
    private UnidadFacade unidadFacade;
    
    @EJB
    private InsumoFacade insumoFacade;

    public List<Unidad> listaUnidad;
    Long idInsumo;
    List<Insumo> lstInsumo;
    
    public Insumo currentInsumo;
    
    public InsumoControlador() {
        System.out.println("A VER INSTANCIANDOOOWW");
      
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
    
    public List<Unidad> getLstUnidad() {
        listaUnidad = unidadFacade.findAll();
        System.out.print("tamano:::"+listaUnidad.size());
        return listaUnidad;
    }

    public List<Unidad> getListaUnidad() {
        return listaUnidad;
    }
    
    public Insumo getInsumo(){
        if (currentInsumo == null){
            currentInsumo = new Insumo();
        }
        return currentInsumo;
    }
    
    public void persist(){
        System.out.println(currentInsumo.getNombre());
        if (currentInsumo.getIdInsumo() == null) {
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
    
    public void editar(){
        currentInsumo = insumoFacade.find(currentInsumo.getIdInsumo());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("cruForm:panelcrud");
        
    }
    
   
    

    
}
