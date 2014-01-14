    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.modelo;

import sistema.modelos.vista.controlador.empresa.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.validation.ConstraintViolationException;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.entidades.empresa.Area;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.modelos.server.entidades.empresa.TipoActivo;
import sistema.modelos.server.entidades.modelo.Ano;
import sistema.modelos.server.entidades.modelo.Modelo;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;
import sistema.modelos.server.entidades.modelo.TipoPeriodo;
import sistema.modelos.server.entidades.modelo.Unidad;
import sistema.modelos.server.facade.empresa.ActivoFacade;
import sistema.modelos.server.facade.empresa.AreaFacade;
import sistema.modelos.server.facade.empresa.InsumoFacade;
import sistema.modelos.server.facade.empresa.ProductoFacade;
import sistema.modelos.server.facade.empresa.TipoActivoFacade;
import sistema.modelos.server.facade.modelo.AnoFacade;
import sistema.modelos.server.facade.modelo.ModeloFacade;
import sistema.modelos.server.facade.modelo.TipoPeriodoFacade;
import sistema.modelos.server.facade.modelo.UnidadFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "modeloControlador")
@SessionScoped
public class ModeloControlador implements Serializable {
  
    @EJB
    private TipoPeriodoFacade tipoPeriodoFacade;
    
    @EJB
    private AnoFacade anoFacade;
    
    @EJB
    private ProductoFacade productoFacade;
    
    @EJB
    private ModeloFacade modeloFacade;
    
    @EJB
    private UnidadFacade unidadFacade;
    
    private Modelo currentModelo;
    
    private ProductoModeloDetalle currentProdMod;
    
    private List<Producto> lstProducto;
    
    private List<Unidad> lstUnidad;
    
    
    private boolean isEditProdMod;
    
    
    public void crearTablaTC() {
        Long size = currentModelo.getHorizonte();
  
    }
    
    
    public List<TipoPeriodo> getLstTipoPeriodo(){
        return tipoPeriodoFacade.findAll();
    }
    
    public List<Ano> getLstAno(){
        return anoFacade.findAll();
    }
    
  

    public TipoPeriodoFacade getTipoPeriodoFacade() {
        return tipoPeriodoFacade;
    }

    public void setTipoPeriodoFacade(TipoPeriodoFacade tipoPeriodoFacade) {
        this.tipoPeriodoFacade = tipoPeriodoFacade;
    }

    public AnoFacade getAnoFacade() {
        return anoFacade;
    }

    public void setAnoFacade(AnoFacade anoFacade) {
        this.anoFacade = anoFacade;
    }

    public Modelo getCurrentModelo() {
       if (currentModelo == null)
           currentModelo = new Modelo();
        return currentModelo;
    }

    public void setCurrentModelo(Modelo currentModelo) {
        this.currentModelo = currentModelo;
    }

    public List<Unidad> getLstUnidad() {
        return unidadFacade.findAll();
    }

    public void setLstUnidad(List<Unidad> lstUnidad) {
        this.lstUnidad = lstUnidad;
    }
    
    
    
    
    public void grabarModelo(){
        System.out.println("Prueba inutil ");
        System.out.println("Periodo: "+currentModelo.getTipoPeriodo().getIdTipoPeriodo());
        System.out.println("Año: "+currentModelo.getAno().getIdAno());
        System.out.println("Horizonte: "+currentModelo.getHorizonte());
        System.out.println("Dias Trabajados: "+currentModelo.getDiasTrabajo());
        System.out.println("Nombre: "+currentModelo.getNombre());
        System.out.println("Codigo: "+currentModelo.getCodigo());
        System.out.println("Descripsao: "+currentModelo.getDescripcion());
                System.out.println("Lista de productos:--");
        
        for (int i = 0; i < getCurrentModelo().getLstProductoModeloDetalle().size();i++){
            System.out.println("Número : "+(i+1));
            System.out.println("Producto: "+getCurrentModelo().getLstProductoModeloDetalle().get(i).getProducto().getIdproducto());
            System.out.println("Precio Venta: "+getCurrentModelo().getLstProductoModeloDetalle().get(i).getPrecioVenta());
            System.out.println("Stock Inicial: "+getCurrentModelo().getLstProductoModeloDetalle().get(i).getStockInicial());
            System.out.println("Vol. Venta: "+getCurrentModelo().getLstProductoModeloDetalle().get(i).getVolumenVenta());
            System.out.println("Días (Póliticas): "+getCurrentModelo().getLstProductoModeloDetalle().get(i).getPoliticaDias());
            System.out.println("Stock Minimo (Póliticas) "+getCurrentModelo().getLstProductoModeloDetalle().get(i).getPoliticaStockMin());
            
            	
        
        }
        
      System.out.println("Antes de grabarsh");
        modeloFacade.create(currentModelo);
      System.out.println("Despues de grabarsh");  
    
      currentModelo = new Modelo();
      RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm");
     }

    public ProductoModeloDetalle getCurrentProdMod() {
        if (currentProdMod == null){
            currentProdMod = new ProductoModeloDetalle();
        }
        return currentProdMod;
    }

    public void setCurrentProdMod(ProductoModeloDetalle currentProdMod) {
        this.currentProdMod = currentProdMod;
    }

    public List<Producto> getLstProducto() {
       //TODO verificar esto...  lstProducto = productoFacade.findAllWithFilter(getCurrentModelo().getLstProductoModeloDetalle());
       return productoFacade.findAll();
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    
    
    
    //CRUD DE PRODUCTO
    
    public void nuevoProductoModelo(){
        isEditProdMod = false;
        currentProdMod = new ProductoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelProductoMod");
           }
      
    public void editarProductoModelo(){
        isEditProdMod = true;
        System.out.println("Prueba inutil en edicion ");
        System.out.println("Producto: "+getCurrentProdMod().getProducto().getIdproducto());
        System.out.println("Precio Venta: "+getCurrentProdMod().getPrecioVenta());
        System.out.println("Stock Inicial: "+getCurrentProdMod().getStockInicial());
        System.out.println("Vol. Venta: "+getCurrentProdMod().getVolumenVenta());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelProductoMod");
    } 
    
    public void agregarProductoModelo(){
   getCurrentProdMod().setModelo(getCurrentModelo());
        if (!isEditProdMod){
            getCurrentProdMod().setProducto(productoFacade.find(getCurrentProdMod().getProducto().getIdproducto()));
            getCurrentModelo().getLstProductoModeloDetalle().add(currentProdMod);
            System.out.println(getCurrentModelo().getLstProductoModeloDetalle().size());
            System.out.println(getCurrentModelo().getLstProductoModeloDetalle().get(getCurrentModelo().getLstProductoModeloDetalle().size()-1).getProducto().getIdproducto()+"DESPUES DE GRABARSH");
        }else{
            System.out.println("Estos editando brother");
            int pos = 0;
            for (int i = 0; i < getCurrentModelo().getLstProductoModeloDetalle().size();i++){
                System.out.println(i+"idProducto:"+getCurrentModelo().getLstProductoModeloDetalle().get(i).getProducto().getIdproducto());
                if (getCurrentModelo().getLstProductoModeloDetalle().get(i).getProducto().getIdproducto().equals(getCurrentProdMod().getProducto().getIdproducto())){
                    pos = i;
                    break;
                }
            }
            getCurrentModelo().getLstProductoModeloDetalle().remove(pos);
            getCurrentModelo().getLstProductoModeloDetalle().add(currentProdMod);
            System.out.println(getCurrentModelo().getLstProductoModeloDetalle().size());
        }
        
        isEditProdMod = false;
        currentProdMod = new ProductoModeloDetalle();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaProductoModelo");
        context.update("modeloForm:tabViewModelo:panelProductoMod");
        
    } 
    
    
     public void eliminarProductoModelo(){
        int pos = 0;
        for (int i = 0; i < getCurrentModelo().getLstProductoModeloDetalle().size();i++){
                System.out.println(i+"idProducto:"+getCurrentModelo().getLstProductoModeloDetalle().get(i).getProducto().getIdproducto());
                if (getCurrentModelo().getLstProductoModeloDetalle().get(i).getProducto().getIdproducto().equals(getCurrentProdMod().getProducto().getIdproducto())){
                    pos = i;
                    break;
                }
            }
            getCurrentModelo().getLstProductoModeloDetalle().remove(pos);
 
        currentProdMod = new ProductoModeloDetalle();
        
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:tablaProductoModelo");
        context.update("modeloForm:tabViewModelo:panelProductoMod");
        isEditProdMod = false;
    } 
    
    
    //CRUD DE INSUMO
   
    
}
