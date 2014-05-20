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
import sistema.modelos.server.entidades.empresa.Cargo;
import sistema.modelos.server.entidades.modelo.CargoModeloDetalle;
import sistema.modelos.server.facade.empresa.CargoFacade;
import sistema.modelos.vista.controlador.util.UsuarioControlador;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "cargoModeloControlador")
@SessionScoped
public class CargoModeloControlador implements Serializable {
  
    private List<CargoModeloDetalle> lstCargoModeloDetalle;
    
    private CargoModeloDetalle currentCargoModeloDetalle;
       
    private List<Cargo> lstCargo;
    
    @ManagedProperty(value="#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;
    
    @EJB
    private CargoFacade cargoFacade;
    
    private boolean relProduccion;

    public boolean isRelProduccion() {
        return relProduccion;
    }

    public void setRelProduccion(boolean relProduccion) {
        this.relProduccion = relProduccion;
    }
    
    private boolean isEditCargoMod;

      public void limpiarVariables(){
        lstCargoModeloDetalle = null;
        currentCargoModeloDetalle = null;
    }

    public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }
    
      
      
    public List<CargoModeloDetalle> getLstCargoModeloDetalle() {
        if (lstCargoModeloDetalle == null){
            lstCargoModeloDetalle = new ArrayList<CargoModeloDetalle>();
        }
        return lstCargoModeloDetalle;
    }

    public void setLstCargoModeloDetalle(List<CargoModeloDetalle> lstCargoModeloDetalle) {
        this.lstCargoModeloDetalle = lstCargoModeloDetalle;
    }

    public CargoModeloDetalle getCurrentCargoModeloDetalle() {
        if (currentCargoModeloDetalle == null){
            currentCargoModeloDetalle = new CargoModeloDetalle();
        }
        return currentCargoModeloDetalle;
    }

    public void setCurrentCargoModeloDetalle(CargoModeloDetalle currentCargoModeloDetalle) {
        this.currentCargoModeloDetalle = currentCargoModeloDetalle;
    }

    public CargoFacade getCargoFacade() {
        return cargoFacade;
    }

    public void setCargoFacade(CargoFacade cargoFacade) {
        this.cargoFacade = cargoFacade;
    }

    public List<Cargo> getLstCargo() {
        lstCargo = cargoFacade.findAllByEmpresa(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa());
        return lstCargo;
    }

    public void setIsEditCargoMod(boolean isEditCargoMod) {
        this.isEditCargoMod = isEditCargoMod;
    }

    public boolean isIsEditCargoMod() {
        return isEditCargoMod;
    }

    
    
    //CRUD DE ACTIVO
    
    public void nuevoCargoModelo(){
        isEditCargoMod = false;
        currentCargoModeloDetalle = new CargoModeloDetalle();
        setRelProduccion(false);
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelCargoMod");
           }
      
    public void editarCargoModelo(){
        isEditCargoMod = true;
        setRelProduccion(getCurrentCargoModeloDetalle().getEsRelacionadoProduccion().equals("1")?true:false);
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelCargoMod");
    } 
    
    public void agregarCargoModelo(){
   //TODO VER COMO AGREGAR A REFERENCIA AL MODELO getCurrentProductoModeloDetalle().setModelo(getCurrentModelo());
        
        System.out.println("Empezamos a ver isEditInsMod: "+isEditCargoMod);
        if (!isEditCargoMod){
            getCurrentCargoModeloDetalle().setCargo(cargoFacade.find(getCurrentCargoModeloDetalle().getCargo().getIdCargo()));
            getCurrentCargoModeloDetalle().setEsRelacionadoProduccion(isRelProduccion()?"1":"0");
            getLstCargoModeloDetalle().add(getCurrentCargoModeloDetalle());
            System.out.println("Tamaño: "+getLstCargoModeloDetalle().size());
        }else{
            int pos = 0;
            for (int i = 0; i < getLstCargoModeloDetalle().size();i++){
                if (getLstCargoModeloDetalle().get(i).getCargo().getIdCargo().equals(getCurrentCargoModeloDetalle().getCargo().getIdCargo())){
                    pos = i;
                    break;
                }
            }
            getLstCargoModeloDetalle().remove(pos);
            getCurrentCargoModeloDetalle().setEsRelacionadoProduccion(isRelProduccion()?"1":"0");
            getLstCargoModeloDetalle().add(getCurrentCargoModeloDetalle());
        }
        
        isEditCargoMod = false;
        currentCargoModeloDetalle = new CargoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaCargoModelo");
        context.update("modeloForm:tabViewModelo:panelCargoMod");
        
    } 
    
    
     public void eliminarCargoModelo(){
        int pos = 0;
        for (int i = 0; i < getLstCargoModeloDetalle().size();i++){
                if (getLstCargoModeloDetalle().get(i).getCargo().getIdCargo().equals(getCurrentCargoModeloDetalle().getCargo().getIdCargo())){
                    pos = i;
                    break;
                }
            }
            getLstCargoModeloDetalle().remove(pos);
 
        currentCargoModeloDetalle = new CargoModeloDetalle();
        
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaCargoModelo");
        context.update("modeloForm:tabViewModelo:panelCargoMod");
        isEditCargoMod = false;
    } 
    
}
