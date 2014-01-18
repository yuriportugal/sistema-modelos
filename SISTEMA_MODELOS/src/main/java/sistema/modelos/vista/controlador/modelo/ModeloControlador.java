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
    
    @EJB
    private TipoPeriodoFacade tipoPeriodoFacade;
    
    @EJB
    private AnoFacade anoFacade;
    
    @EJB
    private ModeloFacade modeloFacade;
    
    private Modelo currentModelo;
    
    private List<Modelo> lstModelo;

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
        
        
        
        if (currentModelo.getIdModelo() != null && currentModelo.getIdModelo()>0){
        modeloFacade.edit(currentModelo);    
        }else{
        modeloFacade.create(currentModelo);  
        }
        currentModelo = new Modelo();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm");
     }
     
    public String editarModelo(){
        getProductoModeloControlador().setLstProductoModeloDetalle(getCurrentModelo().getLstProductoModeloDetalle());
        return "/MODELO/CREARMODELO";
    }
    
    public void eliminarModelo(){
        
    }
    
}
