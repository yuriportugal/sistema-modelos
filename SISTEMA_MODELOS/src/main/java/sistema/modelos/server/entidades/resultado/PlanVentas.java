/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;

/**
 *
 * @author YURI
 */
public class PlanVentas {
    
    DecimalFormat df = new DecimalFormat("###,###,###");
    private double varAnualVentas = 0.02;
    private double varPrecioVenta = 0.02;
    List<TablaResultado> planVentasProyeccion = new ArrayList<TablaResultado>();
    List<TablaResultado> valorVentaSinIGV = new ArrayList<TablaResultado>();
    List<TablaResultado> planVentaValorizado = new ArrayList<TablaResultado>();
    List<TablaResultado> planVentaValorizadoIGV = new ArrayList<TablaResultado>();
    
    public void generarValorVentaSinIGV(List<ProductoModeloDetalle> lstProductos, int numPeriodos){
        for (int i = 0; i < lstProductos.size(); i++){
            TablaResultado tabla = new TablaResultado();
            tabla.setObjeto(lstProductos.get(i));
            double [] valores = new double[numPeriodos];
            String [] desValores = new String[numPeriodos];
            for (int j = 0; j < numPeriodos; j++){
                double valorAnt = j==0?lstProductos.get(i).getPrecioVenta():valores[j-1];
                valores[j] = j==0?valorAnt:valorAnt*(1+varPrecioVenta);                            
                desValores[j] = df.format(valores[j]);
            }
            tabla.setValores(valores);
            tabla.setValValores(desValores);
            valorVentaSinIGV.add(tabla);
        }
    }
    
    public void generarPlanVentasProy(List<ProductoModeloDetalle> lstProductos, int numPeriodos){
        for (int i = 0; i < lstProductos.size(); i++){
            TablaResultado tabla = new TablaResultado();
            tabla.setObjeto(lstProductos.get(i));
            double [] valores = new double[numPeriodos];
            String [] valValores = new String[numPeriodos];
            for (int j = 0; j < numPeriodos; j++){
                double valorAnt = j==0?lstProductos.get(i).getVolumenVenta():valores[j-1];
                valores[j] = j==0?valorAnt:valorAnt*(1+varAnualVentas);
                valValores[j] = df.format(valores[j]);
            }
            tabla.setValores(valores);
            tabla.setValValores(valValores);
            planVentasProyeccion.add(tabla);
        }
    }
    
    public void generarPlanVentasValorizado(){
        for (TablaResultado tablaResul : planVentasProyeccion){
            ProductoModeloDetalle prodProy = (ProductoModeloDetalle) tablaResul.objeto;
            for (TablaResultado tablaResulVent : valorVentaSinIGV){
                ProductoModeloDetalle prodVent = (ProductoModeloDetalle) tablaResulVent.objeto;
                if (prodProy.getProducto().getIdproducto().equals(prodVent.getProducto().getIdproducto())){
                    double [] valores = new double[tablaResulVent.valores.length];
                    String [] valValores = new String[tablaResulVent.valores.length];
                    for (int i = 0; i < tablaResulVent.valores.length;i++){
                        valores[i] = tablaResulVent.valores[i]*tablaResul.valores[i];
                        valValores[i] = df.format(valores[i]);
                    }
                    TablaResultado productoValorizado = new TablaResultado();
                    productoValorizado.setObjeto(prodVent);
                    productoValorizado.setValores(valores);
                    productoValorizado.setValValores(valValores);
                    planVentaValorizado.add(productoValorizado);
                }
            }
        }
    }
    
    public void generarPlanVentasValorizadoConIGV(){
        for (TablaResultado tablaResulValorizado : planVentaValorizado){
            TablaResultado tablaResulValorizadoIGV = new TablaResultado();
            tablaResulValorizadoIGV.setObjeto(tablaResulValorizado.objeto);
            double [] valores = tablaResulValorizado.getValores();
            String [] desValores = new String[valores.length];
            for (int i = 0; i < valores.length; i++) {
                valores[i] = valores[i]*1.18;
                desValores[i] = df.format(valores[i]);
            }
            tablaResulValorizadoIGV.setValores(valores);
            tablaResulValorizadoIGV.setValValores(desValores);
            planVentaValorizadoIGV.add(tablaResulValorizado);
        }
                
        
    }

    public List<TablaResultado> getPlanVentasProyeccion() {
        return planVentasProyeccion;
    }

    public void setPlanVentasProyeccion(List<TablaResultado> planVentasProyeccion) {
        this.planVentasProyeccion = planVentasProyeccion;
    }

    public List<TablaResultado> getPlanVentaValorizado() {
        return planVentaValorizado;
    }

    public List<TablaResultado> getPlanVentaValorizadoIGV() {
        return planVentaValorizadoIGV;
    }

    public List<TablaResultado> getValorVentaSinIGV() {
        return valorVentaSinIGV;
    }
    
    
    
    
    
    
}
