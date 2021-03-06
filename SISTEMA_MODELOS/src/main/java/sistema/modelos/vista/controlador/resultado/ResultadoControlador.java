/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.resultado;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.modelos.server.entidades.modelo.Modelo;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;
import sistema.modelos.server.entidades.resultado.ActivoResultado;
import sistema.modelos.server.entidades.resultado.InsumoResultado;
import sistema.modelos.server.entidades.resultado.PersonalResultado;
import sistema.modelos.server.entidades.resultado.PrestamoResultado;
import sistema.modelos.server.entidades.resultado.Resultado;
import sistema.modelos.server.entidades.resultado.VariacionesPeriodo;
import sistema.modelos.vista.controlador.util.ColumnModel;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "resultadoControlador")
@SessionScoped
public class ResultadoControlador {
    
   private Resultado resultado;
   
   private List<ColumnModel> columnas;
   
   private List<ColumnModel> columnasInsumo;
   
   private boolean detalle;

    public List<ColumnModel> getColumnasInsumo() {
        if (columnasInsumo == null){
            columnasInsumo = new ArrayList<ColumnModel>();
        }
        return columnasInsumo;
    }

    public void setColumnas(List<ColumnModel> columnas) {
        this.columnas = columnas;
    }
   
    public boolean isDetalle() {
        return detalle;
    }

    public void setDetalle(boolean detalle) {
        this.detalle = detalle;
    }

   
   
    public Resultado getResultado() {
        if (resultado == null){
            resultado = new Resultado();
        }
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    
     public void generarColumnaNecesiadesInsumo(int size){
       columnasInsumo = new ArrayList<ColumnModel>();
        for (int i = 0; i <= size; i++){
            ColumnModel column = new ColumnModel();
            if (i == 0) {
                column.setHeader("Insumos");
                column.setProperty("objeto");
            }    
            else {
                column.setHeader("Periodo "+i);
                column.setProperty("valores");
            }
            
            getColumnasInsumo().add(column);        
                    
        }
    }
    
    public void generarColumna(int size){
       columnas = new ArrayList<ColumnModel>();
        for (int i = 0; i <= size; i++){
            ColumnModel column = new ColumnModel();
            if (i == 0) {
                column.setHeader("Productos");
                column.setProperty("objeto");
            }    
            else {
                column.setHeader("Periodo "+i);
                column.setProperty("valores");
            }
            
            getColumnas().add(column);        
                    
        }
    }

    public List<ColumnModel> getColumnas() {
        if (columnas == null){
            columnas = new ArrayList<ColumnModel>();
        }
        return columnas;
    }
    
    PersonalResultado personalResultado;
    
    InsumoResultado insumoResultado;
    
    ActivoResultado activoResultado;

    PrestamoResultado prestamoResultado;
    
    public ActivoResultado getActivoResultado() {
        return activoResultado;
    }
    
    
    public PersonalResultado getPersonalResultado() {
        return personalResultado;
    }

    public void setPersonalResultado(PersonalResultado personalResultado) {
        this.personalResultado = personalResultado;
    }
    
    public void setColumnasInsumo(List<ColumnModel> columnasInsumo) {
        this.columnasInsumo = columnasInsumo;
    }
    
    

    public InsumoResultado getInsumoResultado() {
        return insumoResultado;
    }

    public void setInsumoResultado(InsumoResultado insumoResultado) {
        this.insumoResultado = insumoResultado;
    }

    public void setActivoResultado(ActivoResultado activoResultado) {
        this.activoResultado = activoResultado;
    }

    public void setPrestamoResultado(PrestamoResultado prestamoResultado) {
        this.prestamoResultado = prestamoResultado;
    }

    public PrestamoResultado getPrestamoResultado() {
        return prestamoResultado;
    }
    
    
    

    public void generarResultado(Modelo modelo){
          
          //Generacion de Variaciones
          VariacionesPeriodo variacionesPeriodo = new VariacionesPeriodo();
          variacionesPeriodo.generarVariaciones(modelo);
          //Insumo y Materiales
          InsumoResultado insumoResultado2 = new InsumoResultado(variacionesPeriodo.getVarProyPrecioCompra(),modelo.getLstInsumoModeloDetalle());
         insumoResultado2.generarInsumoResultado(modelo.getAno().getIdAno().intValue(),modelo.getHorizonte().intValue());
          setInsumoResultado(insumoResultado2);
          //OK YA SE PROBO
          PersonalResultado personalResultado2 = new PersonalResultado(variacionesPeriodo.getVarProyPersonal(),modelo.getLstCargoModeloDetalle(),variacionesPeriodo.getVarProySalarial());
          personalResultado2.generarPersonalResultado(modelo.getAno().getIdAno().intValue(),modelo.getHorizonte().intValue());
          setPersonalResultado(personalResultado2);
          //Probando personal
          ActivoResultado activoResultado2 = new ActivoResultado(modelo.getLstActivoModeloDetalle());
          activoResultado2.generarActivoResultado(modelo.getAno().getIdAno().intValue(),modelo.getHorizonte().intValue());
          setActivoResultado(activoResultado2);
          //Prestamo
          PrestamoResultado prestamoResultado2 = new PrestamoResultado(modelo.getLstPrestamoModeloDetalle());
          prestamoResultado2.generarPrestamoResultado(modelo.getAno().getIdAno().intValue(),modelo.getHorizonte().intValue()); 
          setPrestamoResultado(prestamoResultado2);
//insumoResultado.generarInsumoFor
          //aCTIVOS
         // ActivoResultado
//        generarColumna(Integer.valueOf(modelo.getHorizonte().toString()));
//        generarColumnaNecesiadesInsumo(Integer.valueOf(modelo.getHorizonte().toString()));
//        Resultado resultado = new Resultado();
//        //Vista plan de ventas
//        resultado.getPlanVentas().generarPlanVentasProy(modelo.getLstProductoModeloDetalle(),Integer.valueOf(modelo.getHorizonte().toString()));
//        System.out.println("---"+resultado.getPlanVentas().getPlanVentasProyeccion().size());
//        resultado.getPlanVentas().generarValorVentaSinIGV(modelo.getLstProductoModeloDetalle(),Integer.valueOf(modelo.getHorizonte().toString()));
//        resultado.getPlanVentas().generarPlanVentasValorizado();
//        resultado.getPlanVentas().generarPlanVentasValorizadoConIGV();
//        //Vista de plan de producción
//        resultado.getPlanProduccion().llenarPlanVentasProyeccion(resultado.getPlanVentas().getPlanVentasProyeccion());
//        resultado.getPlanProduccion().inicializarValores();
//        resultado.getPlanProduccion().generarValoresProductosTerminados();
//        resultado.getPlanProduccion().generarResumenes();
//        //Vista para necesidades de insumo...
//        resultado.getNecesidadInsumo().setConsolidadoPlanProd(resultado.getPlanProduccion().getConsolidadoPlanProd());
//        resultado.getNecesidadInsumo().generarNecesidadInsumoxProducto();
//        resultado.getNecesidadInsumo().generarResumen();
//        setResultado(resultado);
//        //Vista de plan de compras
//        resultado.getPlanCompras().setLstMaestroInsumoModeloDetalle(modelo.getLstInsumoModeloDetalle());
//        resultado.getPlanCompras().setLstResumenNecesidadInsumo(resultado.getNecesidadInsumo().getListaResumenNecesidadesInsumo());
//        resultado.getPlanCompras().generarPlanDeCompras();
//        
//        DecimalFormat df = new DecimalFormat("###,###,###");
//       
        
        
        
        //        System.out.println("Proyección de plan de ventas");
//        for (int i = 0; i <resultado.getPlanVentas().getPlanVentasProyeccion().size();i++){
//            Producto prod = (Producto)resultado.getPlanVentas().getPlanVentasProyeccion().get(i).getObjeto();
//            System.out.println("Producto : "+prod.getNombre());
//            for (int j = 0; j < resultado.getPlanVentas().getPlanVentasProyeccion().get(i).getValores().length; j++ ){
//                System.out.print(j+""+df.format(resultado.getPlanVentas().getPlanVentasProyeccion().get(i).getValores()[j]));
//            }
//            System.out.println("-----------------");
//        }
//        System.out.println("Proyección de valor de venta");
//        for (int i = 0; i <resultado.getPlanVentas().getValorVentaSinIGV().size();i++){
//            Producto prod = (Producto)resultado.getPlanVentas().getValorVentaSinIGV().get(i).getObjeto();
//            System.out.println("Producto : "+prod.getNombre());
//            for (int j = 0; j < resultado.getPlanVentas().getValorVentaSinIGV().get(i).getValores().length; j++ ){
//                System.out.print(j+" - "+df.format(resultado.getPlanVentas().getValorVentaSinIGV().get(i).getValores()[j]));
//            }
//            System.out.println("-----------------");
//        }
//        
//        System.out.println("Proyección de plan de ventas valorizado sin igv");
//        for (int i = 0; i <resultado.getPlanVentas().getPlanVentaValorizado().size();i++){
//            Producto prod = (Producto)resultado.getPlanVentas().getPlanVentaValorizado().get(i).getObjeto();
//            System.out.println("Producto : "+prod.getNombre());
//            for (int j = 0; j < resultado.getPlanVentas().getPlanVentaValorizado().get(i).getValores().length; j++ ){
//                System.out.print(j+"-"+df.format(resultado.getPlanVentas().getPlanVentaValorizado().get(i).getValores()[j]));
//            }
//            System.out.println("-----------------");
//        }
//        
//         System.out.println("Proyección de plan de ventas valorizado con igv");
//        for (int i = 0; i <resultado.getPlanVentas().getPlanVentaValorizadoIGV().size();i++){
//            Producto prod = (Producto)resultado.getPlanVentas().getPlanVentaValorizadoIGV().get(i).getObjeto();
//            System.out.println("Producto : "+prod.getNombre());
//            for (int j = 0; j < resultado.getPlanVentas().getPlanVentaValorizadoIGV().get(i).getValores().length; j++ ){
//                System.out.print(j+"-"+df.format(resultado.getPlanVentas().getPlanVentaValorizadoIGV().get(i).getValores()[j]));
//            }
//            System.out.println("-----------------");
//        }
//                
//                
//        System.out.println("TAMAÑO: "+resultado.getPlanVentas().getPlanVentasProyeccion().size());
    }
    
    
    
    public String mostrarInsumoMaterial(){
        detalle = true;
        return "/RESULTADO/INSUMOMATERIAL";
    }
    
    public String mostrarPersonalDetalle(){
        detalle = true;
        return "/RESULTADO/PERSONAL";
    }
    
     public String mostrarActivoDetalle(){
        detalle = true;
        return "/RESULTADO/ACTIVO";
    }
    
    public String mostrarPlanVentasDetalle(){
        detalle = true;
        return "/RESULTADO/PLANVENTAS";
    }
    
    public String mostrarPlanProduccionDetalle(){
        detalle = true;
        return "/RESULTADO/PLANPRODUCCION";
    }
    
    public String mostrarNecesidadesInsumoDetalle(){
        detalle = true;
        return "/RESULTADO/NECESIDADINSUMO";
    }
    
   public String mostrarPlandeComprasDetalle(){
        detalle = true;
        return "/RESULTADO/PLANCOMPRAS";
    }
    
   public String mostrarPrestamoDetalle(){
        detalle = true;
        return "/RESULTADO/PRESTAMO";
    }
}
