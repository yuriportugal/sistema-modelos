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
import org.primefaces.context.RequestContext;
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
    
    List<Insumo> lstInsumo;
    
    public Insumo currentInsumo;
    
    public InsumoControlador() {
        System.out.println("A VER INSTANCIANDOOOWW");
      
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
        insumoFacade.create(currentInsumo);
      
        RequestContext context = RequestContext.getCurrentInstance();  

        lstInsumo = getLstInsumos();
        
        context.update("miform:tablaInsumo");
        context.scrollTo("miform:tablaInsumo");
       System.out.println("RENDERIZA PLISS T.,T"+lstInsumo.size());
        currentInsumo = new Insumo();
    }

}
