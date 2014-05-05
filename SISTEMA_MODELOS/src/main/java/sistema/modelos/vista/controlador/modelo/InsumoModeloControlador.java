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
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.modelo.InsumoModeloDetalle;
import sistema.modelos.server.entidades.modelo.Unidad;
import sistema.modelos.server.facade.empresa.InsumoFacade;
import sistema.modelos.server.facade.modelo.UnidadFacade;
import sistema.modelos.vista.controlador.util.UsuarioControlador;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "insumoModeloControlador")
@SessionScoped
public class InsumoModeloControlador implements Serializable {
  
    private List<InsumoModeloDetalle> lstInsumoModeloDetalle;
    
    private InsumoModeloDetalle currentInsumoModeloDetalle;
       
    private List<Unidad> lstUnidad;
    
    private List<Insumo> lstInsumo;
    
    @EJB
    private UnidadFacade unidadFacade;
    
    @EJB
    private InsumoFacade insumoFacade;
    
    @ManagedProperty(value="#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;
    
    private boolean isEditInsMod;
    
     public void limpiarVariables(){
        currentInsumoModeloDetalle = null;
        lstInsumoModeloDetalle = null;
    }

    public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }
    
     
    
    public List<InsumoModeloDetalle> getLstInsumoModeloDetalle() {
        if (lstInsumoModeloDetalle == null){
            lstInsumoModeloDetalle = new ArrayList<InsumoModeloDetalle>();
        }
        System.out.println("Imprimiendo datos del combo de insumo");
        System.out.println("tamaño: "+lstInsumoModeloDetalle.size());
        for(InsumoModeloDetalle insumoMod : lstInsumoModeloDetalle){ 
            System.out.println("idInsumo: "+insumoMod.getInsumo().getIdInsumo());
        }
        return lstInsumoModeloDetalle;
    }

    public void setLstInsumoModeloDetalle(List<InsumoModeloDetalle> lstInsumoModeloDetalle) {
        this.lstInsumoModeloDetalle = lstInsumoModeloDetalle;
    }

    public InsumoModeloDetalle getCurrentInsumoModeloDetalle() {
        if (currentInsumoModeloDetalle == null){
            currentInsumoModeloDetalle = new InsumoModeloDetalle();
        }
        return currentInsumoModeloDetalle;
    }

    public void setCurrentInsumoModeloDetalle(InsumoModeloDetalle currentInsumoModeloDetalle) {
        this.currentInsumoModeloDetalle = currentInsumoModeloDetalle;
    }
    
    

    public List<Unidad> getLstUnidad() {
        lstUnidad = unidadFacade.findAll();
        return lstUnidad;
    }

    public void setLstUnidad(List<Unidad> lstUnidad) {
        this.lstUnidad = lstUnidad;
    }

    public boolean isIsEditInsMod() {
        return isEditInsMod;
    }

    public void setIsEditInsMod(boolean isEditInsMod) {
        this.isEditInsMod = isEditInsMod;
    }

    public UnidadFacade getUnidadFacade() {
        return unidadFacade;
    }

    public void setUnidadFacade(UnidadFacade unidadFacade) {
        this.unidadFacade = unidadFacade;
    }

    public InsumoFacade getInsumoFacade() {
        return insumoFacade;
    }

    public void setInsumoFacade(InsumoFacade insumoFacade) {
        this.insumoFacade = insumoFacade;
    }

    public List<Insumo> getLstInsumo() {
        lstInsumo = insumoFacade.findAllByEmpresa(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa());
        return lstInsumo;
    }

    public void setLstInsumo(List<Insumo> lstInsumo) {
        this.lstInsumo = lstInsumo;
    }
    
    
    
    
      //CRUD DE INSUMO
    
    public void nuevoInsumoModelo(){
        isEditInsMod = false;
        currentInsumoModeloDetalle = new InsumoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelInsumoMod");
           }
      
    public void editarInsumoModelo(){
        isEditInsMod = true;
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelInsumoMod");
    } 
    
    public void agregarInsumoModelo(){
   //TODO VER COMO AGREGAR A REFERENCIA AL MODELO getCurrentProductoModeloDetalle().setModelo(getCurrentModelo());
        
        System.out.println("Empezamos a ver isEditInsMod: "+isEditInsMod);
        if (!isEditInsMod){
            getCurrentInsumoModeloDetalle().setInsumo(insumoFacade.find(getCurrentInsumoModeloDetalle().getInsumo().getIdInsumo()));
            getCurrentInsumoModeloDetalle().setUnidad(unidadFacade.find(getCurrentInsumoModeloDetalle().getUnidad().getIdUnidad()));
            getLstInsumoModeloDetalle().add(getCurrentInsumoModeloDetalle());
            System.out.println("Tamaño: "+getLstInsumoModeloDetalle().size());
        }else{
            int pos = 0;
            for (int i = 0; i < getLstInsumoModeloDetalle().size();i++){
                if (getLstInsumoModeloDetalle().get(i).getInsumo().getIdInsumo().equals(getCurrentInsumoModeloDetalle().getInsumo().getIdInsumo())){
                    pos = i;
                    break;
                }
            }
            getLstInsumoModeloDetalle().remove(pos);
            getLstInsumoModeloDetalle().add(getCurrentInsumoModeloDetalle());
        }
        
        isEditInsMod = false;
        currentInsumoModeloDetalle = new InsumoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaInsumoModelo");
        context.update("modeloForm:tabViewModelo:panelInsumoMod");
        
    } 
    
    
     public void eliminarProductoModelo(){
        int pos = 0;
        for (int i = 0; i < getLstInsumoModeloDetalle().size();i++){
                if (getLstInsumoModeloDetalle().get(i).getInsumo().getIdInsumo().equals(getCurrentInsumoModeloDetalle().getInsumo().getIdInsumo())){
                    pos = i;
                    break;
                }
            }
            getLstInsumoModeloDetalle().remove(pos);
 
        currentInsumoModeloDetalle = new InsumoModeloDetalle();
        
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaInsumoModelo");
        context.update("modeloForm:tabViewModelo:panelInsumoMod");
        isEditInsMod = false;
    } 
    
}
