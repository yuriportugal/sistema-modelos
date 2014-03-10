    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.modelo;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.modelo.Ano;
import sistema.modelos.server.entidades.modelo.Modelo;
import sistema.modelos.server.entidades.modelo.TipoPeriodo;
import sistema.modelos.server.facade.modelo.AnoFacade;
import sistema.modelos.server.facade.modelo.ModeloFacade;
import sistema.modelos.server.facade.modelo.TipoPeriodoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "modeloControlador")
@SessionScoped
public class ModeloControlador implements Serializable {
  
    @ManagedProperty(value="#{productoModeloControlador}")
    private ProductoModeloControlador productoModeloControlador;
    
    @ManagedProperty(value="#{insumoModeloControlador}")
    private InsumoModeloControlador insumoModeloControlador;
        
    @ManagedProperty(value="#{activoModeloControlador}")
    private ActivoModeloControlador activoModeloControlador;
    
    @ManagedProperty(value="#{cargoModeloControlador}")
    private CargoModeloControlador cargoModeloControlador;
    
    @ManagedProperty(value="#{servicioModeloControlador}")
    private ServicioModeloControlador servicioModeloControlador;
    
    @ManagedProperty(value="#{prestamoModeloControlador}")
    private PrestamoModeloControlador prestamoModeloControlador;
    
    
    
    
    @EJB
    private TipoPeriodoFacade tipoPeriodoFacade;
    
    @EJB
    private AnoFacade anoFacade;
    
    @EJB
    private ModeloFacade modeloFacade;
    
    private Modelo currentModelo;
    
    private List<Modelo> lstModelo;

    public void setPrestamoModeloControlador(PrestamoModeloControlador prestamoModeloControlador) {
        this.prestamoModeloControlador = prestamoModeloControlador;
    }

    public PrestamoModeloControlador getPrestamoModeloControlador() {
        return prestamoModeloControlador;
    }

    public ServicioModeloControlador getServicioModeloControlador() {
        return servicioModeloControlador;
    }

    public void setServicioModeloControlador(ServicioModeloControlador servicioModeloControlador) {
        this.servicioModeloControlador = servicioModeloControlador;
    }

    
    
    public List<Modelo> getLstModelo() {
        return modeloFacade.findAll();
    }

    public void setLstModelo(List<Modelo> lstModelo) {
        this.lstModelo = lstModelo;
    }

    public ActivoModeloControlador getActivoModeloControlador() {
        return activoModeloControlador;
    }

    public void setActivoModeloControlador(ActivoModeloControlador activoModeloControlador) {
        this.activoModeloControlador = activoModeloControlador;
    }

    public CargoModeloControlador getCargoModeloControlador() {
        return cargoModeloControlador;
    }

    public void setCargoModeloControlador(CargoModeloControlador cargoModeloControlador) {
        this.cargoModeloControlador = cargoModeloControlador;
    }
    
    
    public ProductoModeloControlador getProductoModeloControlador() {
        return productoModeloControlador;
    }

    public void setProductoModeloControlador(ProductoModeloControlador productoModeloControlador) {
        this.productoModeloControlador = productoModeloControlador;
    }

    public InsumoModeloControlador getInsumoModeloControlador() {
        return insumoModeloControlador;
    }

    public void setInsumoModeloControlador(InsumoModeloControlador insumoModeloControlador) {
        this.insumoModeloControlador = insumoModeloControlador;
    }
    
    
    
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
    
    public void grabarModelo(){
        
        //Seteando los productos
        for (int i = 0; i < getProductoModeloControlador().getLstProductoModeloDetalle().size();i++){
            getProductoModeloControlador().getLstProductoModeloDetalle().get(i).setModelo(currentModelo);
        }
        currentModelo.setLstProductoModeloDetalle(getProductoModeloControlador().getLstProductoModeloDetalle());
        //Seteando los insumos
        for (int i = 0; i < getInsumoModeloControlador().getLstInsumoModeloDetalle().size();i++){
            getInsumoModeloControlador().getLstInsumoModeloDetalle().get(i).setModelo(currentModelo);
        }
        currentModelo.setLstInsumoModeloDetalle(getInsumoModeloControlador().getLstInsumoModeloDetalle());
        //Seteando los activos
        for (int i = 0; i < getActivoModeloControlador().getLstActivoModeloDetalle().size();i++){
            getActivoModeloControlador().getLstActivoModeloDetalle().get(i).setModelo(currentModelo);
        }
        currentModelo.setLstActivoModeloDetalle(getActivoModeloControlador().getLstActivoModeloDetalle());
        //Seteando los cargos
        for (int i = 0; i < getCargoModeloControlador().getLstCargoModeloDetalle().size();i++){
            getCargoModeloControlador().getLstCargoModeloDetalle().get(i).setModelo(currentModelo);
        }
        currentModelo.setLstCargoModeloDetalle(getCargoModeloControlador().getLstCargoModeloDetalle());
        //Seteando los servicios
        for (int i = 0; i < getServicioModeloControlador().getLstServicioModeloDetalle().size();i++){
            getServicioModeloControlador().getLstServicioModeloDetalle().get(i).setModelo(currentModelo);
        }
        currentModelo.setLstServicioModeloDetalle(getServicioModeloControlador().getLstServicioModeloDetalle());
        //Seteando los prestamos
        for (int i = 0; i < getPrestamoModeloControlador().getLstPrestamoModeloDetalle().size();i++){
            getPrestamoModeloControlador().getLstPrestamoModeloDetalle().get(i).setModelo(currentModelo);
            if (getPrestamoModeloControlador().getLstPrestamoModeloDetalle().get(i).getIdModeloPrestamo().compareTo(1L)<0){
                getPrestamoModeloControlador().getLstPrestamoModeloDetalle().get(i).setIdModeloPrestamo(null);
            }
        }
        currentModelo.setLstPrestamoModeloDetalle(getPrestamoModeloControlador().getLstPrestamoModeloDetalle());
        
        
        
        if (currentModelo.getIdModelo() != null && currentModelo.getIdModelo()>0){
        modeloFacade.edit(currentModelo);    
        }else{
        modeloFacade.create(currentModelo);  
        }
        limpiarVariables(true);
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm");
     }
    
    public void limpiarVariables(boolean limpiarModelo){
        if (limpiarModelo){
            currentModelo = new Modelo();
        }
        getActivoModeloControlador().limpiarVariables();
        getCargoModeloControlador().limpiarVariables();
        getInsumoModeloControlador().limpiarVariables();
        getPrestamoModeloControlador().limpiarVariables();
        getProductoModeloControlador().limpiarVariables();
        getServicioModeloControlador().limpiarVariables();
        
    }
     
    public void setearVariables(){
        getActivoModeloControlador().setLstActivoModeloDetalle(getCurrentModelo().getLstActivoModeloDetalle());
        getCargoModeloControlador().setLstCargoModeloDetalle(getCurrentModelo().getLstCargoModeloDetalle());
        getInsumoModeloControlador().setLstInsumoModeloDetalle(getCurrentModelo().getLstInsumoModeloDetalle());
        getPrestamoModeloControlador().setLstPrestamoModeloDetalle(getCurrentModelo().getLstPrestamoModeloDetalle());
        getProductoModeloControlador().setLstProductoModeloDetalle(getCurrentModelo().getLstProductoModeloDetalle());
        getServicioModeloControlador().setLstServicioModeloDetalle(getCurrentModelo().getLstServicioModeloDetalle());
        
    }
    
    public String editarModelo(){
        limpiarVariables(false);
        setearVariables();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm");
        return "/MODELO/CREARMODELO";
    }
    
    public void eliminarModelo(){
        
    }
    
}
