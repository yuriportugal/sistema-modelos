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
import sistema.modelos.server.entidades.modelo.ModeloFormulacionInsumo;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;

public class NecesidadInsumo {
    
    List<TablaResultado> consolidadoPlanProd = null;
    DecimalFormat df = new DecimalFormat("###,###,###");
    List<TablaResultadoExt> lstNecesidadInsumoxProducto;
    List<TablaResultado> listaResumenNecesidadesInsumo;
    public void generarNecesidadInsumoxProducto() {
        for (TablaResultado tabPlanProd : consolidadoPlanProd){
            TablaResultadoExt currentNecesidadInsumoxProd = new TablaResultadoExt();
            ProductoModeloDetalle prodModelDet = (ProductoModeloDetalle)tabPlanProd.getObjeto();
            currentNecesidadInsumoxProd.setObjetoExt(prodModelDet);
            for (ModeloFormulacionInsumo modFormInsumo : prodModelDet.getLstModeloFormulacionInsumoDetalle()){
                TablaResultado tablaResult = new TablaResultado();
                double [] arrResult = new double[tabPlanProd.valores.length];
                String [] arrResultVal = new String[tabPlanProd.valores.length];
                for (int i = 0; i < tabPlanProd.valores.length; i++){
                    arrResult[i] = tabPlanProd.valores[i]*modFormInsumo.getCantidad()/100;
                    arrResultVal[i] = df.format(tabPlanProd.valores[i]*modFormInsumo.getCantidad()/100);
                }
                tablaResult.setObjeto(modFormInsumo);
                tablaResult.setValores(arrResult);
                tablaResult.setValValores(arrResultVal);
                currentNecesidadInsumoxProd.getLstTablaResultado().add(tablaResult);
            }
            getLstNecesidadInsumoxProducto().add(currentNecesidadInsumoxProd);
        }
    }
    
    public void generarResumen(){
        List<Insumo> lstInsumo = incializarInsumo(lstNecesidadInsumoxProducto);
        listaResumenNecesidadesInsumo = generarBody(lstInsumo);
        for (int i = 0; i < listaResumenNecesidadesInsumo.size(); i++){
            Insumo insumo= (Insumo) listaResumenNecesidadesInsumo.get(i).getObjeto();
            listaResumenNecesidadesInsumo.get(i).setValores(obtenerValoresxInsumo(insumo,lstNecesidadInsumoxProducto,listaResumenNecesidadesInsumo.get(i).getValValores().length));
            for (int j = 0; j < listaResumenNecesidadesInsumo.get(i).getValores().length;j++){
                listaResumenNecesidadesInsumo.get(i).getValValores()[j] = df.format(listaResumenNecesidadesInsumo.get(i).getValores()[j]);
            }
        }
    }
    
    private double[] obtenerValoresxInsumo(Insumo insumo, List<TablaResultadoExt> lstNecesidadInsumoxProducto, int numPer) {
        double[] val = new double[numPer];
        for (TablaResultadoExt tbExt : lstNecesidadInsumoxProducto){
            for (TablaResultado tbResult : tbExt.getLstTablaResultado()){
                if (((ModeloFormulacionInsumo)tbResult.getObjeto()).getInsumo().getIdInsumo().equals(insumo.getIdInsumo())){
                    for (int i = 0; i < val.length;i++){
                        val[i] += tbResult.valores[i];
                    }
                }
            }
            
        }
        return val;
    }
    
    
    private List<TablaResultado> generarBody(List<Insumo> lstInsumo) {
        List<TablaResultado> lstTbResult = new ArrayList<TablaResultado>();
        for (Insumo insumo : lstInsumo){
            TablaResultado tabResult = new TablaResultado();
            tabResult.setObjeto(insumo);
            tabResult.setValValores(new String [lstNecesidadInsumoxProducto.get(0).lstTablaResultado.get(0).valores.length]);
            tabResult.setValores(new double[lstNecesidadInsumoxProducto.get(0).lstTablaResultado.get(0).valores.length]);
            for (int i = 0; i < tabResult.getValores().length;i++){
                tabResult.getValores()[i] = 0;
                tabResult.getValValores()[i] = "";
            }
            
            lstTbResult.add(tabResult);
        }
        return lstTbResult;
        
    }
    
    public List<Insumo> incializarInsumo(List<TablaResultadoExt> lstNecesidadInsumoxProducto){
        List<Insumo> lstInsumo = new ArrayList<Insumo>();
        for (TablaResultadoExt necesidadInsumoxProd : lstNecesidadInsumoxProducto){
             ProductoModeloDetalle prodModDet = (ProductoModeloDetalle)necesidadInsumoxProd.getObjetoExt();
             for (ModeloFormulacionInsumo modelFormins : prodModDet.getLstModeloFormulacionInsumoDetalle()){
                 Insumo insumo = modelFormins.getInsumo();
                 boolean insumoExists = false;
                 for (int i = 0; i < lstInsumo.size(); i++){
                     if (lstInsumo.get(i).getIdInsumo().equals(insumo.getIdInsumo())){
                         insumoExists = true;
                         break;
                     }
                 }
                 if (!insumoExists){
                     lstInsumo.add(insumo);
                 }
             }
        }
        return lstInsumo;
    }

    public List<TablaResultado> getListaResumenNecesidadesInsumo() {
        return listaResumenNecesidadesInsumo;
    }

    public void setListaResumenNecesidadesInsumo(List<TablaResultado> listaResumenNecesidadesInsumo) {
        this.listaResumenNecesidadesInsumo = listaResumenNecesidadesInsumo;
    }
    
    
    
    public List<TablaResultado> getConsolidadoPlanProd() {
        if (consolidadoPlanProd == null){
            consolidadoPlanProd = new ArrayList<TablaResultado>();
        }
        return consolidadoPlanProd;
    }

    public void setConsolidadoPlanProd(List<TablaResultado> consolidadoPlanProd) {
        this.consolidadoPlanProd = consolidadoPlanProd;
    }

    public List<TablaResultadoExt> getLstNecesidadInsumoxProducto() {
        if (lstNecesidadInsumoxProducto == null){
            lstNecesidadInsumoxProducto = new ArrayList<TablaResultadoExt>();
        }
        return lstNecesidadInsumoxProducto;
    }

    public void setLstNecesidadInsumoxProducto(List<TablaResultadoExt> lstNecesidadInsumoxProducto) {
        this.lstNecesidadInsumoxProducto = lstNecesidadInsumoxProducto;
    }

  


    

    
    
    
}
