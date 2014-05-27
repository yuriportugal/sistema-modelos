    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.modelo;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.modelo.Ano;
import sistema.modelos.server.entidades.modelo.Modelo;
import sistema.modelos.server.entidades.modelo.TipoPeriodo;
import sistema.modelos.server.entidades.resultado.TablaResultado;
import sistema.modelos.server.facade.empresa.EmpresaFacade;
import sistema.modelos.server.facade.modelo.AnoFacade;
import sistema.modelos.server.facade.modelo.ModeloFacade;
import sistema.modelos.server.facade.modelo.TipoPeriodoFacade;
import sistema.modelos.server.facade.util.UsuarioFacade;
import sistema.modelos.vista.controlador.resultado.ResultadoControlador;
import sistema.modelos.vista.controlador.util.ColumnModel;
import sistema.modelos.vista.controlador.util.UsuarioControlador;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "modeloControlador")
@SessionScoped
public class ModeloControlador implements Serializable {
  
    @ManagedProperty(value="#{productoModeloControlador}")
    private ProductoModeloControlador productoModeloControlador;
    
    @ManagedProperty(value="#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;
    
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
    
    @ManagedProperty(value="#{resultadoControlador}")
    private ResultadoControlador resultadoControlador;
    
    
    private List<ColumnModel> lstColumnModel;
    
    private List<Double> lstTipoCambio;
     
    @EJB
    private TipoPeriodoFacade tipoPeriodoFacade;
    
    @EJB
    private AnoFacade anoFacade;
    
    @EJB
    private ModeloFacade modeloFacade;
    
     @EJB
    private EmpresaFacade empresaFacade;
    
    private Modelo currentModelo;
    
    private List<Modelo> lstModelo;
    
    private List<Modelo> lstCorridasModelo;

    public List<ColumnModel> getLstColumnModel() {
        if (lstColumnModel == null){
            lstColumnModel = new ArrayList<ColumnModel>();
        }
        return lstColumnModel;
    }

    public void setLstColumnModel(List<ColumnModel> lstColumnModel) {
        this.lstColumnModel = lstColumnModel;
    }

    public List<Double> getLstTipoCambio() {
        if (lstTipoCambio == null){
            lstTipoCambio = new ArrayList<Double>();
        }
        return lstTipoCambio;
    }

    public void setLstTipoCambio(List<Double> lstTipoCambio) {
        this.lstTipoCambio = lstTipoCambio;
    }
    
    
    
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

    public List<Modelo> getLstCorridasModelo() {
        return modeloFacade.findCorridasByEmpresa(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa());
    }

    public void setLstCorridasModelo(List<Modelo> lstCorridasModelo) {
        this.lstCorridasModelo = lstCorridasModelo;
    }

    public List<Modelo> getLstModelo() {
        return modeloFacade.findModelosByEmpresa(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa());
    }
    
    
//    public List<Modelo> getLstModelo() {
//        return modeloFacade.findAll();
//    }

    public void setLstModelo(List<Modelo> lstModelo) {
        this.lstModelo = lstModelo;
    }

    public ActivoModeloControlador getActivoModeloControlador() {
        return activoModeloControlador;
    }

    public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }

    public void setActivoModeloControlador(ActivoModeloControlador activoModeloControlador) {
        this.activoModeloControlador = activoModeloControlador;
    }

    public ResultadoControlador getResultadoControlador() {
        return resultadoControlador;
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
    
    public void generarColumnasTiempo(){
       int tam = Integer.valueOf(currentModelo.getHorizonte().toString());
       getLstColumnModel().clear();
       for (int i = 1; i < tam; i++){
           ColumnModel columnModel = new ColumnModel();
           columnModel.setHeader(String.valueOf(i));
           //columnModel.setSize(String.valueOf(i));
           getLstColumnModel().add(columnModel);
       }
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
        System.out.println("Vamos a grabar el mierdelo");
        System.out.println("Tipo periodo"+currentModelo.getTipoPeriodo().getIdTipoPeriodo());
        //Seteando los productos
        currentModelo.setEmpresa(empresaFacade.find(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa()));
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
    
    public void limpiarReferenciasModeloPadre(){
        for (int i = 0; i < currentModelo.getLstActivoModeloDetalle().size();i++){
            currentModelo.getLstActivoModeloDetalle().get(i).setModelo(currentModelo);
            currentModelo.getLstActivoModeloDetalle().get(i).setIdActivoModelo(null);
        }
        
        for (int i = 0; i < currentModelo.getLstCargoModeloDetalle().size();i++){
            currentModelo.getLstCargoModeloDetalle().get(i).setModelo(currentModelo);
            currentModelo.getLstCargoModeloDetalle().get(i).setIdCargoModelo(null);
        }
         for (int i = 0; i < currentModelo.getLstInsumoModeloDetalle().size();i++){
            currentModelo.getLstInsumoModeloDetalle().get(i).setModelo(currentModelo);
            currentModelo.getLstInsumoModeloDetalle().get(i).setIdInsumoModelo(null);
        }
          for (int i = 0; i < currentModelo.getLstPrestamoModeloDetalle().size();i++){
            currentModelo.getLstPrestamoModeloDetalle().get(i).setModelo(currentModelo);
            currentModelo.getLstPrestamoModeloDetalle().get(i).setIdModeloPrestamo((long)-1);
        }
          for (int i = 0; i < currentModelo.getLstProductoModeloDetalle().size();i++){
            currentModelo.getLstProductoModeloDetalle().get(i).setModelo(currentModelo);
            currentModelo.getLstProductoModeloDetalle().get(i).setIdProductoModelo(null);
            for (int j = 0; j < currentModelo.getLstProductoModeloDetalle().get(i).getLstModeloFormulacionInsumoDetalle().size(); j++){
                currentModelo.getLstProductoModeloDetalle().get(i).getLstModeloFormulacionInsumoDetalle().get(j).setIdModeloFormulacionInsumo(null);
                currentModelo.getLstProductoModeloDetalle().get(i).getLstModeloFormulacionInsumoDetalle().get(j).setProductoModelo(currentModelo.getLstProductoModeloDetalle().get(i));
            }
            
            for (int j = 0; j < currentModelo.getLstProductoModeloDetalle().get(i).getLstModeloFormulacionMaquinariaDetalle().size(); j++){
                currentModelo.getLstProductoModeloDetalle().get(i).getLstModeloFormulacionMaquinariaDetalle().get(j).setIdModeloFormulacionMaquinaria(null);
                currentModelo.getLstProductoModeloDetalle().get(i).getLstModeloFormulacionMaquinariaDetalle().get(j).setProductoModelo(currentModelo.getLstProductoModeloDetalle().get(i));
            }
            
            for (int j = 0; j < currentModelo.getLstProductoModeloDetalle().get(i).getLstModeloFormulacionPersonalDetalle().size(); j++){
                currentModelo.getLstProductoModeloDetalle().get(i).getLstModeloFormulacionPersonalDetalle().get(j).setIdModeloFormulacionPersonal(null);
                currentModelo.getLstProductoModeloDetalle().get(i).getLstModeloFormulacionPersonalDetalle().get(j).setProductoModelo(currentModelo.getLstProductoModeloDetalle().get(i));
            }
            
        }
          for (int i = 0; i < currentModelo.getLstServicioModeloDetalle().size();i++){
            currentModelo.getLstServicioModeloDetalle().get(i).setModelo(currentModelo);
            currentModelo.getLstServicioModeloDetalle().get(i).setIdModeloServicio(null);
        }
            
    }
    
    public String generarCorrida(){
        Modelo modeloPadre = modeloFacade.find(currentModelo.getIdModelo());
        currentModelo = modeloFacade.find(currentModelo.getIdModelo());
        currentModelo.setParentModelo(modeloPadre);
        currentModelo.setIdModelo(null);
        limpiarReferenciasModeloPadre();
        limpiarVariables(false);
        setearVariables();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("modeloForm");
        System.out.println("Valores que salen para el current modelo");
        System.out.println("Tipo periodo"+currentModelo.getTipoPeriodo().getIdTipoPeriodo());
        return "/MODELO/CREARMODELO";
    }
    
    public String generarResultado(){
        System.out.print("EMPEZAMOS A GENERAR");
        Modelo corrida = modeloFacade.find(currentModelo.getIdModelo());
        getResultadoControlador().generarResultado(corrida);
        return "/RESULTADO/MOSTRARRESULTADO";
    
    }

    public void setResultadoControlador(ResultadoControlador resultadoControlador) {
        this.resultadoControlador = resultadoControlador;
    }
    
    
    private int numTabla;

    public int getNumTabla() {
        return numTabla;
    }

    public void setNumTabla(int numTabla) {
        this.numTabla = numTabla;
    }
    
    private List<ColumnModel> columnas;

    public List<ColumnModel> getColumnas() {
        if (columnas == null){
            columnas = new ArrayList<ColumnModel>();
        }
        return columnas;
    }

    public void setColumnas(List<ColumnModel> columnas) {
        this.columnas = columnas;
    }
    
    private TablaResultado tablaResulVar;

    public TablaResultado getTablaResulVar() {
        if (tablaResulVar == null){
            tablaResulVar = new TablaResultado();
        }
        return tablaResulVar;
    }

    public void setTablaResulVar(TablaResultado tablaResulVar) {
        this.tablaResulVar = tablaResulVar;
    }
    
     public void generarColumnasVariacion(int size){
       columnas = new ArrayList<ColumnModel>();
        for (int i = 0; i < size; i++){
            ColumnModel column = new ColumnModel();
                column.setHeader("Periodo "+i);
                column.setProperty("valores");
            
           columnas.add(column);        
                    
        }
    }
    
    
    
    public void generarResultadosVariacion(){
            if (currentModelo.getHorizonte() != null){
                if (currentModelo.getHorizonte().compareTo(0L)>0){
                    generarColumnasVariacion(currentModelo.getHorizonte().intValue());
                    RequestContext context = RequestContext.getCurrentInstance();  
                    double inicial = 0.1;
                    double variacion = 2;
                    switch (numTabla){
                        case 1: {
                            inicial = currentModelo.getVARPorcInicialPrecioCompra();
                            variacion = currentModelo.getVARIndPrecioCompra();
                            break;
                        }
                        case 2: {
                            
                            inicial = currentModelo.getVARPorcInicialPrecioVenta();
                            variacion = currentModelo.getVARIndPrecioVenta();
                            break;
                        }
                        case 3: {
                            inicial = currentModelo.getVARPorcInicialVenta();
                            variacion = currentModelo.getVARIndVenta();
                            break;

                        }
                        case 4: {
                            inicial = currentModelo.getVARPorcInicialMantenimiento();
                            variacion = currentModelo.getVARIndMantenimiento();
                            break;

                        }
                        case 5: {
                            inicial = currentModelo.getVARPorcInicialSalarial();
                            variacion = currentModelo.getVARPorcInicialSalarial();
                            break;
                            
                        }
                        case 6: {
                            inicial = currentModelo.getVARPorcInicialGastos();
                            variacion = currentModelo.getVARIndGastos();
                            break;
                        }
                            
                            
                    }
                    generarVariacion(inicial,variacion,currentModelo.getHorizonte().intValue());
                    context.update("modeloForm:tabViewModelo:varTab_"+numTabla);
        
                }
            }
           System.out.println("modeloForm:tabViewModelo:varTab_"+numTabla);
    }

    private void generarVariacion(double inicial, double variacion, int numTabla) {
        double [] valores = new double[numTabla];
        String [] sValores = new String[numTabla];
        for (int i = 0; i < numTabla;i++){
            if (i == 0)
                valores[i] = inicial;
            else
                valores[i] = valores[i-1]*(1+variacion/100);
            sValores[i] = String.valueOf(valores[i]);
        }
        
        tablaResulVar = new TablaResultado();
        tablaResulVar.setValores(valores);
        tablaResulVar.setValValores(sValores);
    }
    
    
    
}
