/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.modelo.InsumoModeloDetalle;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;



public class PlanCompras {
    
    List<InsumoModeloDetalle> lstMaestroInsumoModeloDetalle;

    List<TablaResultado> lstResumenNecesidadInsumo;
    
    List<TablaResultadoExt> lstInventarioInsumos;
    
    
        DecimalFormat df = new DecimalFormat("###,###,###");
    public List<InsumoModeloDetalle> getLstMaestroInsumoModeloDetalle() {
        if (lstMaestroInsumoModeloDetalle == null){
            lstMaestroInsumoModeloDetalle = new ArrayList<InsumoModeloDetalle>();
        }
        return lstMaestroInsumoModeloDetalle;
    }

    public void setLstMaestroInsumoModeloDetalle(List<InsumoModeloDetalle> lstMaestroInsumoModeloDetalle) {
        this.lstMaestroInsumoModeloDetalle = lstMaestroInsumoModeloDetalle;
    }

    public List<TablaResultado> getLstResumenNecesidadInsumo() {
        if (lstResumenNecesidadInsumo == null){
            lstResumenNecesidadInsumo = new ArrayList<TablaResultado>();
        }
        return lstResumenNecesidadInsumo;
    }

    public void setLstResumenNecesidadInsumo(List<TablaResultado> lstResumenNecesidadInsumo) {
        this.lstResumenNecesidadInsumo = lstResumenNecesidadInsumo;
    }

    public List<TablaResultadoExt> getLstInventarioInsumos() {
        if (lstInventarioInsumos == null){
            lstInventarioInsumos = new ArrayList<TablaResultadoExt>();
        }
        return lstInventarioInsumos;
    }

    public void setLstInventarioInsumos(List<TablaResultadoExt> lstInventarioInsumos) {
        this.lstInventarioInsumos = lstInventarioInsumos;
    }
    
    

    public void generarPlanDeCompras() {
        generarInventarioInsumosProd();
    }

    private void generarInventarioInsumosProd() {
         inicializarValoresInvInsProd();
         generarValoresInventarioInsumosProd();
    }
    
    private void generarValoresInventarioInsumosProd() {
          for (int i =0; i < getLstInventarioInsumos().size();i++){
            TablaResultadoExt tablaResultadoExtActual = getLstInventarioInsumos().get(i);
            InsumoModeloDetalle insumoModeloDetalle = (InsumoModeloDetalle)getLstInventarioInsumos().get(i).getObjetoExt();
            TablaResultado  tbStockIni = tablaResultadoExtActual.lstTablaResultado.get(0);
            TablaResultado  tbCompras = tablaResultadoExtActual.lstTablaResultado.get(1);
            TablaResultado  tbConsumo = tablaResultadoExtActual.lstTablaResultado.get(2);
            TablaResultado  tbStockFin = tablaResultadoExtActual.lstTablaResultado.get(3);
            TablaResultado  tbStockFinTeo = tablaResultadoExtActual.lstTablaResultado.get(4);
            TablaResultado  tbCompraTeorica = tablaResultadoExtActual.lstTablaResultado.get(5);
                
            for (int j = 0;j < tablaResultadoExtActual.lstTablaResultado.get(0).getValores().length; j++){
                
                if (j == 0){
                    tbStockIni.valores[j] = insumoModeloDetalle.getStockInicial();
                }else{
                    tbStockIni.valores[j] = tbStockFin.valores[j-1];
                }
                
                for (int h = 0; h < lstResumenNecesidadInsumo.size(); h++){
                    if (insumoModeloDetalle.getInsumo().getIdInsumo().equals(((Insumo)lstResumenNecesidadInsumo.get(h).getObjeto()).getIdInsumo())){
                            tbConsumo.valores[j] = lstResumenNecesidadInsumo.get(h).valores[j];
                            if (j <tablaResultadoExtActual.lstTablaResultado.get(0).getValores().length-  1)
                            tbConsumo.valores[j+1] = lstResumenNecesidadInsumo.get(h).valores[j+1]; 
                    }
                }
                
                if (j ==tablaResultadoExtActual.lstTablaResultado.get(0).getValores().length-  1){
                    tbStockFinTeo.valores[j] = Math.max(insumoModeloDetalle.getPoliticaStockMin(),tbConsumo.valores[j]*insumoModeloDetalle.getPoliticaDias()/312);
                }else{
                    tbStockFinTeo.valores[j] = Math.max(insumoModeloDetalle.getPoliticaStockMin(),tbConsumo.valores[j+1]*insumoModeloDetalle.getPoliticaDias()/312);
                }
                
                
                tbCompraTeorica.valores[j] = tbConsumo.valores[j]+tbStockFinTeo.valores[j]-tbStockIni.valores[j];
                tbCompras.valores[j] = tbCompraTeorica.valores[j]<=0?0:tbCompraTeorica.valores[j];
                tbStockFin.valores[j] = tbCompras.valores[j]+tbStockIni.valores[j]-tbConsumo.valores[j];
                
                tbCompras.valValores[j] = df.format(tbCompras.valores[j]);
                tbStockIni.valValores[j] = df.format(tbStockIni.valores[j]);
                tbConsumo.valValores[j] = df.format(tbConsumo.valores[j]);
                tbStockFin.valValores[j] = df.format(tbStockFin.valores[j]);
                tbStockFinTeo.valValores[j] = df.format(tbStockFinTeo.valores[j]);
                tbCompraTeorica.valValores[j] = df.format(tbCompraTeorica.valores[j]);
            }
            
            tablaResultadoExtActual.lstTablaResultado = new ArrayList<TablaResultado>();
            tablaResultadoExtActual.lstTablaResultado.add(0,tbStockIni);
             tablaResultadoExtActual.lstTablaResultado.add(1,tbCompras);
             tablaResultadoExtActual.lstTablaResultado.add(2,tbConsumo);
             tablaResultadoExtActual.lstTablaResultado.add(3,tbStockFin);
             tablaResultadoExtActual.lstTablaResultado.add(4,tbStockFinTeo);
             tablaResultadoExtActual.lstTablaResultado.add(5,tbCompraTeorica);
            
        } 
    }
    
     public void inicializarValoresInvInsProd(){
        lstInventarioInsumos = new ArrayList<TablaResultadoExt> ();
        for (int i = 0; i < getLstResumenNecesidadInsumo().size(); i++){
            TablaResultadoExt tablaResultExt = new TablaResultadoExt();
            Insumo insumo = (Insumo) getLstResumenNecesidadInsumo().get(i).getObjeto();
            InsumoModeloDetalle insumoModelDet = InsumoModeloDetalle.getByInsumo(getLstMaestroInsumoModeloDetalle(),insumo);
            tablaResultExt.setObjetoExt(insumoModelDet);
            List<TablaResultado> lstTablaResultInvInsProd = new ArrayList<TablaResultado>();
            for (int j = 0; j < 6; j++){
                TablaResultado tablaResultado = new TablaResultado();
                tablaResultado.setValores(new double[getLstResumenNecesidadInsumo().get(0).valores.length-1]);
                tablaResultado.setValValores(new String[getLstResumenNecesidadInsumo().get(0).valores.length-1]);
                switch (j){
                    case 0:{
                        tablaResultado.setObjeto("Stock Inicial");
                        break;
                    }
                    case 1:{
                        tablaResultado.setObjeto("Compras (Ingresos)");
                        break;
                    }
                    case 2:{
                        tablaResultado.setObjeto("Consumo (Salidas))");
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
                        tablaResultado.setObjeto("Compra Teórica");
                        break;
                    }    
              }
              
              lstTablaResultInvInsProd.add(tablaResultado);
                
            }
            tablaResultExt.setLstTablaResultado(lstTablaResultInvInsProd);
            getLstInventarioInsumos().add(tablaResultExt);
        }
        
    }

  
    
    
    
    
    
    
    
}
