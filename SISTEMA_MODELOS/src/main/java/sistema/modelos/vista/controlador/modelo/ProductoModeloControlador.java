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
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;
import sistema.modelos.server.entidades.modelo.Unidad;
import sistema.modelos.server.facade.empresa.ProductoFacade;
import sistema.modelos.server.facade.modelo.UnidadFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "productoModeloControlador")
@SessionScoped
public class ProductoModeloControlador implements Serializable {
  
    private List<ProductoModeloDetalle> lstProductoModeloDetalle;
    
    private ProductoModeloDetalle currentProductoModeloDetalle;
    
    private List<Producto> lstProducto;
    
    private List<Unidad> lstUnidad;
    
    @EJB
    private ProductoFacade productoFacade;
    
    @EJB
    private UnidadFacade unidadFacade;
    
    private boolean isEditProdMod;
    
    public List<ProductoModeloDetalle> getLstProductoModeloDetalle() {
        
        if (lstProductoModeloDetalle == null){
            lstProductoModeloDetalle = new ArrayList<ProductoModeloDetalle>();
        }
        
        return lstProductoModeloDetalle;
    }

    public void setLstProductoModeloDetalle(List<ProductoModeloDetalle> lstProductoModeloDetalle) {
        this.lstProductoModeloDetalle = lstProductoModeloDetalle;
    }

    public ProductoModeloDetalle getCurrentProductoModeloDetalle() {
        
        if (currentProductoModeloDetalle == null){
            currentProductoModeloDetalle = new ProductoModeloDetalle();
        }
        
        return currentProductoModeloDetalle;
    }

    public void setCurrentProductoModeloDetalle(ProductoModeloDetalle currentProductoModeloDetalle) {
        this.currentProductoModeloDetalle = currentProductoModeloDetalle;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public boolean isIsEditProdMod() {
        return isEditProdMod;
    }

    public void setIsEditProdMod(boolean isEditProdMod) {
        this.isEditProdMod = isEditProdMod;
    }

    public List<Producto> getLstProducto() {
        lstProducto = productoFacade.findAll();
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public List<Unidad> getLstUnidad() {
        lstUnidad = unidadFacade.findAll();
        return lstUnidad;
    }

    public void setLstUnidad(List<Unidad> lstUnidad) {
        this.lstUnidad = lstUnidad;
    }
    
    
    
    
      //CRUD DE PRODUCTO
    
    public void nuevoProductoModelo(){
        isEditProdMod = false;
        currentProductoModeloDetalle = new ProductoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelProductoMod");
           }
      
    public void editarProductoModelo(){
        isEditProdMod = true;
        System.out.println("Prueba inutil en edicion ");
        System.out.println("Producto: "+getCurrentProductoModeloDetalle().getProducto().getIdproducto());
        System.out.println("Precio Venta: "+getCurrentProductoModeloDetalle().getPrecioVenta());
        System.out.println("Stock Inicial: "+getCurrentProductoModeloDetalle().getStockInicial());
        System.out.println("Vol. Venta: "+getCurrentProductoModeloDetalle().getVolumenVenta());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelProductoMod");
    } 
    
    public void agregarProductoModelo(){
   //TODO VER COMO AGREGAR A REFERENCIA AL MODELO getCurrentProductoModeloDetalle().setModelo(getCurrentModelo());
        if (!isEditProdMod){
            getCurrentProductoModeloDetalle().setProducto(productoFacade.find(getCurrentProductoModeloDetalle().getProducto().getIdproducto()));
            getCurrentProductoModeloDetalle().setUnidad(unidadFacade.find(getCurrentProductoModeloDetalle().getUnidad().getIdUnidad()));
            getLstProductoModeloDetalle().add(getCurrentProductoModeloDetalle());
        }else{
            System.out.println("Estos editando brother");
            int pos = 0;
            for (int i = 0; i < getLstProductoModeloDetalle().size();i++){
                System.out.println(i+"idProducto:"+getLstProductoModeloDetalle().get(i).getProducto().getIdproducto());
                if (getLstProductoModeloDetalle().get(i).getProducto().getIdproducto().equals(getCurrentProductoModeloDetalle().getProducto().getIdproducto())){
                    pos = i;
                    break;
                }
            }
            getLstProductoModeloDetalle().remove(pos);
            getLstProductoModeloDetalle().add(getCurrentProductoModeloDetalle());
        }
        
        isEditProdMod = false;
        currentProductoModeloDetalle = new ProductoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaProductoModelo");
        context.update("modeloForm:tabViewModelo:panelProductoMod");
        
    } 
    
    
     public void eliminarProductoModelo(){
        int pos = 0;
        for (int i = 0; i < getLstProductoModeloDetalle().size();i++){
                System.out.println(i+"idProducto:"+getLstProductoModeloDetalle().get(i).getProducto().getIdproducto());
                if (getLstProductoModeloDetalle().get(i).getProducto().getIdproducto().equals(getCurrentProductoModeloDetalle().getProducto().getIdproducto())){
                    pos = i;
                    break;
                }
            }
            getLstProductoModeloDetalle().remove(pos);
 
        currentProductoModeloDetalle = new ProductoModeloDetalle();
        
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaProductoModelo");
        context.update("modeloForm:tabViewModelo:panelProductoMod");
        isEditProdMod = false;
    } 
    
}
