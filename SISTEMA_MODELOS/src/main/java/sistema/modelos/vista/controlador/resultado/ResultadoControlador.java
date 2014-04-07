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
import sistema.modelos.server.entidades.resultado.Resultado;
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
   
   private boolean detalle;

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
    
    
    
    public void generarResultado(Modelo modelo){
        
        
        generarColumna(Integer.valueOf(modelo.getHorizonte().toString()));
        Resultado resultado = new Resultado();
        //Vista plan de ventas
        resultado.getPlanVentas().generarPlanVentasProy(modelo.getLstProductoModeloDetalle(),Integer.valueOf(modelo.getHorizonte().toString()));
        System.out.println("---"+resultado.getPlanVentas().getPlanVentasProyeccion().size());
        resultado.getPlanVentas().generarValorVentaSinIGV(modelo.getLstProductoModeloDetalle(),Integer.valueOf(modelo.getHorizonte().toString()));
        resultado.getPlanVentas().generarPlanVentasValorizado();
        resultado.getPlanVentas().generarPlanVentasValorizadoConIGV();
        //Vista de plan de producción
        resultado.getPlanProduccion().llenarPlanVentasProyeccion(resultado.getPlanVentas().getPlanVentasProyeccion());
        System.out.println("PlanProduccion llenarPlanVentas");
        resultado.getPlanProduccion().inicializarValores();
        System.out.println("PlanProduccion Inicializar Valores");
        resultado.getPlanProduccion().generarValoresProductosTerminados();
        System.out.println("PlanProduccion productos terminados");
        resultado.getPlanProduccion().generarResumenes();
        System.out.println("PlanProduccion generar resumenes");
        setResultado(resultado);
        DecimalFormat df = new DecimalFormat("###,###,###");
       
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
    
    
    
    public String mostrarPlanVentasDetalle(){
        detalle = true;
        return "/RESULTADO/PLANVENTAS";
    }
    
    public String mostrarPlanProduccionDetalle(){
        detalle = true;
        return "/RESULTADO/PLANPRODUCCION";
    }
   
    
}
