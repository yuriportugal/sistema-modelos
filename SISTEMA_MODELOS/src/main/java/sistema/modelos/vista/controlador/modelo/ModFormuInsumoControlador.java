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
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;
import sistema.modelos.server.entidades.modelo.Unidad;
import sistema.modelos.server.facade.empresa.InsumoFacade;
import sistema.modelos.server.facade.modelo.UnidadFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "modFormuInsumoControlador")
@SessionScoped
public class ModFormuInsumoControlador implements Serializable {
  
    private ProductoModeloDetalle currentProductoModeloDetalle;

    public ProductoModeloDetalle getCurrentProductoModeloDetalle() {
        if (currentProductoModeloDetalle == null){
            currentProductoModeloDetalle = new ProductoModeloDetalle();
        }
        return currentProductoModeloDetalle;
    }

    public void setCurrentProductoModeloDetalle(ProductoModeloDetalle currentProductoModeloDetalle) {
        this.currentProductoModeloDetalle = currentProductoModeloDetalle;
    }


    
    void openPopUP() {
        RequestContext.getCurrentInstance().execute("formularioDlg.show()");
     RequestContext context = RequestContext.getCurrentInstance();  
        context.update("tabViewModelo:tabViewFormulacion:FormularioInsumoDlg:panelpopup");
    }
    
    public void editarProdModelFormuInsumo(){
     
        
        System.out.print("Lo logramos"+getCurrentProductoModeloDetalle().getProducto().getNombre());
        openPopUP();
    }
            
    
    
    
    
}
