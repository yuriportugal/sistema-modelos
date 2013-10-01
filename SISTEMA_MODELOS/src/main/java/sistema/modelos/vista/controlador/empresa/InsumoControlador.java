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
import sistema.modelos.server.entidades.empresa.facade.InsumoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "insumoControlador")
@SessionScoped
public class InsumoControlador implements Serializable {
    @EJB
    private InsumoFacade insumoFacade;

    List<Insumo> lstInsumos;
    
    public InsumoControlador() {
        System.out.println("A VER INSTANCIANDOOOWW");
      
    }
    
    public List<Insumo> getLstInsumos() {
        System.out.println("Antes del findAll");
        List<Insumo> lstInsumo = insumoFacade.findAll();
        System.out.println(lstInsumo.size()+"TAMANOO");
        
        return lstInsumo;
    }
    
    
    
}
