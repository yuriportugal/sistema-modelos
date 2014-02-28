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
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.modelos.server.entidades.modelo.ModeloFormulacionInsumo;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;
import sistema.modelos.server.entidades.modelo.Unidad;
import sistema.modelos.server.facade.empresa.InsumoFacade;
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
    
    private ProductoModeloDetalle currentProdModDetFormInsumo;
    
    private ProductoModeloDetalle currentProdModDetFormPersonal;
    
    private ProductoModeloDetalle currentProdModDetFormMaquinaria;
    
    private List<Producto> lstProducto;
    
    
    @ManagedProperty(value="#{modFormuInsumoControlador}")
    private ModFormuInsumoControlador modFormuInsumoControlador;
    
    
    private List<Unidad> lstUnidad;
    
    @EJB
    private ProductoFacade productoFacade;
    
    @EJB
    private UnidadFacade unidadFacade;
    
    @EJB
    private InsumoFacade insumoFacade;
    
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

    public ModFormuInsumoControlador getModFormuInsumoControlador() {
        return modFormuInsumoControlador;
    }

    public void setModFormuInsumoControlador(ModFormuInsumoControlador modFormuInsumoControlador) {
        this.modFormuInsumoControlador = modFormuInsumoControlador;
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

    public ProductoModeloDetalle getCurrentProdModDetFormMaquinaria() {
        if (currentProdModDetFormMaquinaria == null){
            currentProdModDetFormMaquinaria = new ProductoModeloDetalle();
        }
        return currentProdModDetFormMaquinaria;
    }

    public void setCurrentProdModDetFormMaquinaria(ProductoModeloDetalle currentProdModDetFormMaquinaria) {
        this.currentProdModDetFormMaquinaria = currentProdModDetFormMaquinaria;
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

   

    public ProductoModeloDetalle getCurrentProdModDetFormInsumo() {
        if (currentProdModDetFormInsumo == null){
            currentProdModDetFormInsumo = new ProductoModeloDetalle();
        }
        return currentProdModDetFormInsumo;
    }

    public void setCurrentProdModDetFormInsumo(ProductoModeloDetalle currentProdModDetFormInsumo) {
        this.currentProdModDetFormInsumo = currentProdModDetFormInsumo;
    }

    public ProductoModeloDetalle getCurrentProdModDetFormPersonal() {
        if (currentProdModDetFormPersonal == null){
            currentProdModDetFormPersonal = new ProductoModeloDetalle();
        }
        return currentProdModDetFormPersonal;
    }

    public void setCurrentProdModDetFormPersonal(ProductoModeloDetalle currentProdModDetFormPersonal) {
        this.currentProdModDetFormPersonal = currentProdModDetFormPersonal;
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
        context.update("modeloForm:tabViewModelo:tabViewFormulacion");
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
        context.update("modeloForm:tabViewModelo:tabViewFormulacion");
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
        context.update("modeloForm:tabViewModelo:tabViewFormulacion");
        isEditProdMod = false;
    } 
    
     //Formulacion
     
    
     public void editarProdModelFormuInsumo(){
          RequestContext.getCurrentInstance().execute("formularioDlgProd.show()");
    } 
       
    public void editarProdModelFormuMaquinaria(){
         RequestContext.getCurrentInstance().execute("FormularioMaquinariaDlg.show()");
    }
    
     public void editarProdModelFormuPersonal(){
         RequestContext.getCurrentInstance().execute("FormularioPersonalDlg.show()");
    }
    
     
     
     
     
     
     
     //CRUD DE FORMULACION INSUMO
     
     private List<ModeloFormulacionInsumo> lstModFormInsumo;
     private ModeloFormulacionInsumo currentModFormInsumo;
     private boolean isEditFormInsumo;

    public ModeloFormulacionInsumo getCurrentModFormInsumo() {
        if (currentModFormInsumo == null){
            currentModFormInsumo = new ModeloFormulacionInsumo();
        }
        return currentModFormInsumo;
    }

    public void setCurrentModFormInsumo(ModeloFormulacionInsumo currentModFormInsumo) {
        this.currentModFormInsumo = currentModFormInsumo;
    }


     public List<ModeloFormulacionInsumo> getLstModFormInsumo() {
        if (lstModFormInsumo == null){
            lstModFormInsumo = new ArrayList<ModeloFormulacionInsumo>();
        }
        return lstModFormInsumo;
    }
    
    public void setLstModFormInsumo(List<ModeloFormulacionInsumo> lstModFormInsumo) {
        this.lstModFormInsumo = lstModFormInsumo;
    }

    public boolean isIsEditFormInsumo() {
        return isEditFormInsumo;
    }

    public void setIsEditFormInsumo(boolean isEditFormInsumo) {
        this.isEditFormInsumo = isEditFormInsumo;
    }
     
    public void agregarFormulacionInsumo(){
//        System.out.println("Grabando: ");
//        System.out.println("idInsumo: "+getCurrentModFormInsumo().getInsumo().getIdInsumo());
//        System.out.println("cantidad: "+getCurrentModFormInsumo().getCantidad());
           if (!isEditFormInsumo){
            getCurrentModFormInsumo().setInsumo(insumoFacade.find(getCurrentModFormInsumo().getInsumo().getIdInsumo()));
            getCurrentModFormInsumo().setProductoModelo(getCurrentProductoModeloDetalle());
            getCurrentProductoModeloDetalle().getLstModeloFormulacionInsumoDetalle().add(getCurrentModFormInsumo());
        }else{
            System.out.println("Estos editando brother");
            int pos = 0;
            for (int i = 0; i < getCurrentProductoModeloDetalle().getLstModeloFormulacionInsumoDetalle().size();i++){
                System.out.println(i+"idInsumo:"+getCurrentProductoModeloDetalle().getLstModeloFormulacionInsumoDetalle().get(i).getInsumo().getIdInsumo()  );
                if (getCurrentProductoModeloDetalle().getLstModeloFormulacionInsumoDetalle().get(i).getInsumo().getIdInsumo().equals(getCurrentModFormInsumo().getInsumo().getIdInsumo())){
                    pos = i;
                    break;
                }
            }
            getCurrentProductoModeloDetalle().getLstModeloFormulacionInsumoDetalle().remove(pos);
            getCurrentProductoModeloDetalle().getLstModeloFormulacionInsumoDetalle().add(getCurrentModFormInsumo());
        }
        
        isEditFormInsumo = false;
        currentModFormInsumo = new ModeloFormulacionInsumo();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelFormInsumoGrid");
        context.update("modeloForm:tabViewModelo:tablaInsumoFormModelo");
    } 
    
        public void editarInsumoFormModel(){
            isEditFormInsumo = true;
            System.out.println("Prueba inutil en edicion ");
            System.out.println("idInsumo: "+getCurrentModFormInsumo().getInsumo().getIdInsumo());
            System.out.println("cantidad: "+getCurrentModFormInsumo().getCantidad());
            RequestContext context = RequestContext.getCurrentInstance();  
            context.update("modeloForm:tabViewModelo:panelFormInsumoGrid");
            context.update("modeloForm:tabViewModelo:tablaInsumoFormModelo");
        } 
        
     
     public void eliminarFormularioInsModelo(){
        int pos = 0;
        for (int i = 0; i < getCurrentProductoModeloDetalle().getLstModeloFormulacionInsumoDetalle().size();i++){
                
                if (getCurrentProductoModeloDetalle().getLstModeloFormulacionInsumoDetalle().get(i).getInsumo().getIdInsumo().equals(getCurrentModFormInsumo().getInsumo().getIdInsumo())){
                    pos = i;
                    break;
                }
            }
            getCurrentProductoModeloDetalle().getLstModeloFormulacionInsumoDetalle().remove(pos);


        isEditFormInsumo = false;
        currentModFormInsumo = new ModeloFormulacionInsumo();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm:tabViewModelo:panelFormInsumoGrid");
        context.update("modeloForm:tabViewModelo:tablaInsumoFormModelo");
    }    
}
