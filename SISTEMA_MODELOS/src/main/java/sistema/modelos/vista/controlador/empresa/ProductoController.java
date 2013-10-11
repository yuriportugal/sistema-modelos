package sistema.modelos.vista.controlador.empresa;

import java.io.IOException;
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.view.managedbean.util.JsfUtil;
import sistema.view.managedbean.util.PaginationHelper;
import sistema.modelos.server.facade.empresa.ProductoFacade;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "productoControlador")
@SessionScoped
public class ProductoController implements Serializable {
    @EJB
    private ProductoFacade productoFacade;
    
    List<Producto> lstProducto;
    
    public ProductoController() {
        System.out.println("A VER INSTANCIANDOOO PRODUCTOOO");
    }

    
    public List<Producto> getLstProducto() {
        System.out.println("A VER LISTA PRODUCTOOO");
        lstProducto = productoFacade.findAll();
          return lstProducto;
    }
    
}
