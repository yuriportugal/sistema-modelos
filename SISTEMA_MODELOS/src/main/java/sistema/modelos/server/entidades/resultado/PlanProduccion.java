/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.text.DecimalFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;

/**
 *
 * @author YURI
 */
public class PlanProduccion {
    
    DecimalFormat df = new DecimalFormat("###,###,###");
    
    List<TablaResultado> planVentasProyeccion = null;
    List<TablaResultadoExt> arrLstInventarioProdTerminados = null;
    List<TablaResultado> consolidadoPlanProd = null;
    List<TablaResultado> consolidadoStockFinalesProd = null;
    public void llenarPlanVentasProyeccion(List<TablaResultado> planVentasProyeccion){
        List planVentasProyeccionNuevo = new ArrayList<TablaResultado>();
        for (int i =0; i <= planVentasProyeccion.size();i++){
            TablaResultado tablaNueva = new TablaResultado();
            TablaResultado tablaCopia = i ==planVentasProyeccion.size()?planVentasProyeccion.get(i-1):planVentasProyeccion.get(i);
            tablaNueva.setObjeto(tablaCopia.getObjeto());
            tablaNueva.setValValores(tablaCopia.getValValores());
            tablaNueva.setValores(tablaCopia.getValores());
            planVentasProyeccionNuevo.add(tablaNueva);
        }
        this.planVentasProyeccion = planVentasProyeccionNuevo;
    }
    
    public void generarResumenes(){
        consolidadoPlanProd = new ArrayList<TablaResultado>();
        consolidadoStockFinalesProd = new ArrayList<TablaResultado>();
        for (int i = 0; i < arrLstInventarioProdTerminados.size()-1;i++){
            TablaResultado tablaPlanProd = new TablaResultado();
            TablaResultado tablaStockFinProd = new TablaResultado();
            tablaPlanProd.setObjeto(arrLstInventarioProdTerminados.get(i).getObjetoExt());
            tablaStockFinProd.setObjeto(arrLstInventarioProdTerminados.get(i).getObjetoExt());
            TablaResultado tbPlanProdCP = arrLstInventarioProdTerminados.get(i).getLstTablaResultado().get(1);
            TablaResultado tbStockFinCP = arrLstInventarioProdTerminados.get(i).getLstTablaResultado().get(3);
            
            tablaPlanProd.setValValores(new String[tbPlanProdCP.getValValores().length]);
            tablaPlanProd.setValores(new double[tbPlanProdCP.getValores().length]);
            
            tablaStockFinProd.setValValores(new String[tbStockFinCP.getValValores().length]);
            tablaStockFinProd.setValores(new double[tbStockFinCP.getValores().length]);
            
            for (int j = 0; j < tbPlanProdCP.getValores().length;j++){
                tablaPlanProd.getValores()[j] = tbPlanProdCP.getValores()[j];
                tablaPlanProd.getValValores()[j] = df.format(tbPlanProdCP.getValores()[j]);
            }
            
            for (int j = 0; j < tbStockFinCP.getValores().length;j++){
                tablaStockFinProd.getValores()[j] = tbStockFinCP.getValores()[j];
                tablaStockFinProd.getValValores()[j] = df.format(tbStockFinCP.getValores()[j]);
            }
            consolidadoPlanProd.add(tablaPlanProd);
            consolidadoStockFinalesProd.add(tablaStockFinProd);
        }
        
        arrLstInventarioProdTerminados.remove(arrLstInventarioProdTerminados.size()-1);
    }
    
    
    public void generarValoresProductosTerminados(){
        for (int i =0; i < arrLstInventarioProdTerminados.size();i++){
            TablaResultadoExt tablaResultadoExtActual = arrLstInventarioProdTerminados.get(i);
            ProductoModeloDetalle productoModeloDetalle = (ProductoModeloDetalle)planVentasProyeccion.get(i).getObjeto();
            TablaResultado  tbStockIni = tablaResultadoExtActual.lstTablaResultado.get(0);
            TablaResultado  tbProduccion = tablaResultadoExtActual.lstTablaResultado.get(1);
            TablaResultado  tbVentas = tablaResultadoExtActual.lstTablaResultado.get(2);
            TablaResultado  tbStockFin = tablaResultadoExtActual.lstTablaResultado.get(3);
            TablaResultado  tbStockFinTeo = tablaResultadoExtActual.lstTablaResultado.get(4);
            TablaResultado  tbProdTeorica = tablaResultadoExtActual.lstTablaResultado.get(5);
                
            for (int j = 0;j < tablaResultadoExtActual.lstTablaResultado.get(0).getValores().length; j++){
                if (j == tablaResultadoExtActual.lstTablaResultado.get(0).getValores().length-1 ) break;
                tbVentas.valores[j] = planVentasProyeccion.get(i).valores[j];   
                System.out.println("tbVentas.valores[j] = planVentasProyeccion.get(i).valores[j];   "+j);
                
                tbVentas.valores[j+1] = j ==  planVentasProyeccion.get(i).valores.length-1?tbVentas.valores[j]:planVentasProyeccion.get(i).valores[j+1];
                System.out.println("tbVentas.valores[j+1] = planVentasProyeccion.get(i).valores[j+1];   "+j);
                tbStockFinTeo.valores[j] = Math.max(productoModeloDetalle.getPoliticaStockMin(),tbVentas.valores[j+1]*productoModeloDetalle.getPoliticaDias()/312);
                if (j == 0){
                    tbStockIni.valores[j] = ((ProductoModeloDetalle)tablaResultadoExtActual.getObjetoExt()).getStockInicial();
                }else{
                    tbStockIni.valores[j] = tbStockFin.getValores()[j-1];
                }
                tbProdTeorica.valores[j] = tbVentas.valores[j]+tbStockFinTeo.valores[j]-tbStockIni.valores[j];
                tbProduccion.valores[j] = tbProdTeorica.valores[j];
                tbStockFin.valores[j] = tbProduccion.valores[j]+tbStockIni.valores[j]-tbVentas.valores[j];
                
                tbVentas.valValores[j] = df.format(tbVentas.valores[j]);
                tbStockIni.valValores[j] = df.format(tbStockIni.valores[j]);
                tbProduccion.valValores[j] = df.format(tbProduccion.valores[j]);
                tbStockFin.valValores[j] = df.format(tbStockFin.valores[j]);
                tbStockFinTeo.valValores[j] = df.format(tbStockFinTeo.valores[j]);
                tbProdTeorica.valValores[j] = df.format(tbProdTeorica.valores[j]);
            }
            
            tablaResultadoExtActual.lstTablaResultado = new ArrayList<TablaResultado>();
            tablaResultadoExtActual.lstTablaResultado.add(0,tbStockIni);
             tablaResultadoExtActual.lstTablaResultado.add(1,tbProduccion);
             tablaResultadoExtActual.lstTablaResultado.add(2,tbVentas);
             tablaResultadoExtActual.lstTablaResultado.add(3,tbStockFin);
             tablaResultadoExtActual.lstTablaResultado.add(4,tbStockFinTeo);
             tablaResultadoExtActual.lstTablaResultado.add(5,tbProdTeorica);
            
        }
    }
    
    
    public void inicializarValores(){
        arrLstInventarioProdTerminados = new ArrayList<TablaResultadoExt> ();
        for (int i = 0; i < planVentasProyeccion.size(); i++){
            TablaResultadoExt tablaResultExt = new TablaResultadoExt();
            tablaResultExt.setObjetoExt(planVentasProyeccion.get(i).getObjeto());
            List<TablaResultado> lstTablaResultProdTerm = new ArrayList<TablaResultado>();
            for (int j = 0; j < 6; j++){
                TablaResultado tablaResultado = new TablaResultado();
                tablaResultado.setValores(new double[planVentasProyeccion.get(0).valores.length+1]);
                tablaResultado.setValValores(new String[planVentasProyeccion.get(0).valores.length+1]);
                switch (j){
                    case 0:{
                        tablaResultado.setObjeto("StockInicial");
                        break;
                    }
                    case 1:{
                        tablaResultado.setObjeto("Producción (Ingresos)");
                        break;
                    }
                    case 2:{
                        tablaResultado.setObjeto("Ventas (Salidas)");
                        break;
                    }
                    case 3:{
                        tablaResultado.setObjeto("Stock Final");
                        break;
                    }
                    case 4:{
                        tablaResultado.setObjeto("Stock Final Teorico");
                        break;
                    }
                    case 5:{
                        tablaResultado.setObjeto("Producción Teorica");
                        break;
                    }    
              }
              
              lstTablaResultProdTerm.add(tablaResultado);
                
            }
            tablaResultExt.setLstTablaResultado(lstTablaResultProdTerm);
            arrLstInventarioProdTerminados.add(tablaResultExt);
        }
        
    }
    
    public List<TablaResultado> getPlanVentasProyeccion() {
        return planVentasProyeccion;
    }

    public void setPlanVentasProyeccion(List<TablaResultado> planVentasProyeccion) {
        this.planVentasProyeccion = planVentasProyeccion;
    }

    public List<TablaResultadoExt> getArrLstInventarioProdTerminados() {
        return arrLstInventarioProdTerminados;
    }

    public void setArrLstInventarioProdTerminados(List<TablaResultadoExt> arrLstInventarioProdTerminados) {
        this.arrLstInventarioProdTerminados = arrLstInventarioProdTerminados;
    }

    public List<TablaResultado> getConsolidadoPlanProd() {
        return consolidadoPlanProd;
    }

    public void setConsolidadoPlanProd(List<TablaResultado> consolidadoPlanProd) {
        this.consolidadoPlanProd = consolidadoPlanProd;
    }

    public List<TablaResultado> getConsolidadoStockFinalesProd() {
        return consolidadoStockFinalesProd;
    }

    public void setConsolidadoStockFinalesProd(List<TablaResultado> consolidadoStockFinalesProd) {
        this.consolidadoStockFinalesProd = consolidadoStockFinalesProd;
    }
    
    



    
    
    
}
