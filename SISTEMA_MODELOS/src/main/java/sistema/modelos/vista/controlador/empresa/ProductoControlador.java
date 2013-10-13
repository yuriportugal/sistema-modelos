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
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.modelos.server.facade.empresa.ProductoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "productoControlador")
@SessionScoped
public class ProductoControlador implements Serializable {
    @EJB
    private ProductoFacade productoFacade;
    
    Long idProducto;
    List<Producto> lstProducto;
    
    public Producto currentProducto;
    
    public ProductoControlador() {
        System.out.println("A VER INSTANCIANDOOO PRODUCTOOOO");
    }

    public Producto getCurrentProducto() {
        return currentProducto;
    }

    public void setCurrentProducto(Producto currentProducto) {
        this.currentProducto = currentProducto;
    }
    
    public List<Producto> getLstProductos() {
        lstProducto = productoFacade.findAll();
        return lstProducto;
    }
    
    public Producto getProducto(){
        if (currentProducto == null){
            currentProducto = new Producto();
        }
        return currentProducto;
    }
    
    public void persist(){
        System.out.println(currentProducto.getNombre());
        if (currentProducto.getIdproducto().equals(-1L)) {
            productoFacade.create(currentProducto);
        }
        else {
            productoFacade.edit(currentProducto);
        }
        RequestContext context = RequestContext.getCurrentInstance();  

        lstProducto = getLstProductos();
        currentProducto = new Producto();
        context.update("miform:tablaProducto");
        context.update("cruForm:panelcrud");
        
    } 
    
    public void getEditarInsumo(){
        System.out.println("ID:::xx "+idProducto);
        currentProducto = productoFacade.find(idProducto);
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("cruForm:panelcrud");
        
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void agregar(){        
        System.out.println(" ENTRO A AGREGAR PRODUCTO");
        currentProducto = new Producto();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaProducto");
        context.update("cruForm:panelcrud");
    }
    
    public void editar(){
        System.out.println(" ENTRO A EDITAR PRODUCTO");
        currentProducto = productoFacade.find(currentProducto.getIdproducto());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaInsumo");
        context.update("cruForm:panelcrud");
        
    }
    
    public void eliminar(){
        System.out.println(" ENTRO A ELIMINAR PRODUCTO");
        productoFacade.remove(currentProducto);
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaInsumo");
        context.update("cruForm:panelcrud");
        agregar();
    }
}
