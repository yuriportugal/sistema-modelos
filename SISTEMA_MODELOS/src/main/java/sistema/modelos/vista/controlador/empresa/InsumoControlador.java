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
    
    public InsumoControlador() {
        System.out.println("A VER INSTANCIANDOOOWW");
      
    }
    
    public List<Insumo> getLstInsumos() {
        lstInsumo = insumoFacade.findAll();
        
        return lstInsumo;
    }
    
    public List<Unidad> getLstUnidad() {
        listaUnidad = unidadFacade.findAll();
        
        return listaUnidad;
    }

    public List<Unidad> getListaUnidad() {
        return listaUnidad;
    }
    
    
    
}
