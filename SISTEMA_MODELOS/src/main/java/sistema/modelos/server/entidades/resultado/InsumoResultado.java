/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import sistema.modelos.server.entidades.modelo.InsumoModeloDetalle;
import sistema.modelos.vista.controlador.util.ColumnModel;

/**
 *
 * @author Orci
 */
public class InsumoResultado extends ResultadoGeneral{
    
    DecimalFormat df = new DecimalFormat("###,###.00");
    
    //Dependencias variaciones
    private double [] VarProyPrecioCompra;
    //Resultado
    private List<TablaResultado> lstPrecioCompraInsumoProy;

    private List<InsumoModeloDetalle> lstInsumosDetalle;
    
    private List<FormulacionDetalle> insumoDetFormulacion; //Plan de Compras

    
    
    public InsumoResultado(  double [] VarProyPrecioCompra, List<InsumoModeloDetalle> lstInsumosDetalle) {
        this.VarProyPrecioCompra = VarProyPrecioCompra;
        this.lstInsumosDetalle = lstInsumosDetalle;
    }
    
    
    
    
    public List<TablaResultado> getLstPrecioCompraInsumoProy() {
        return lstPrecioCompraInsumoProy;
    }

    public void setLstPrecioCompraInsumoProy(List<TablaResultado> lstPrecioCompraInsumoProy) {
        this.lstPrecioCompraInsumoProy = lstPrecioCompraInsumoProy;
    }

    public List<FormulacionDetalle> getInsumoDetFormulacion() {
        return insumoDetFormulacion;
    }

    public void setInsumoDetFormulacion(List<FormulacionDetalle> insumoDetFormulacion) {
        this.insumoDetFormulacion = insumoDetFormulacion;
    }

    public double[] getVarProyPrecioCompra() {
        return VarProyPrecioCompra;
    }

    public void setVarProyPrecioCompra(double[] VarProyPrecioCompra) {
        this.VarProyPrecioCompra = VarProyPrecioCompra;
    }

    public List<InsumoModeloDetalle> getLstInsumosDetalle() {
        return lstInsumosDetalle;
    }

    public void setLstInsumosDetalle(List<InsumoModeloDetalle> lstInsumosDetalle) {
        this.lstInsumosDetalle = lstInsumosDetalle;
    }

    @Override
    protected void generarColumna(int anio, int horizonte) {
        columnaTabla = new ArrayList<ColumnModel>();
        for (int i = 0; i <= horizonte; i++){
            ColumnModel column = new ColumnModel();
            switch (i){
                case 0:  {column.setHeader("Insumo");
                          column.setProperty("objeto");
                          break;}
//                case 1:  {column.setHeader("Descripción");
//                          column.setProperty("objeto");
//                          break;}
//                case 2:  {column.setHeader("Unidad");
//                          column.setProperty("objeto");
//                          break;}
                default: {column.setHeader(""+(anio+i-1));
                          column.setProperty("valores");
                          break;}    
                    
            }
            
            columnaTabla.add(column);        
                    
        }
    }
    
   public void generarInsumoResultado(int anio, int horizonte){
       setArrVariacionProyeccion(VarProyPrecioCompra);
       List<Object> lstObjeto = new ArrayList<Object>();
       for (InsumoModeloDetalle insumoDet :  lstInsumosDetalle ){
           lstObjeto.add(insumoDet);
       }
       setLstObjetoAProyectar(lstObjeto);
       generarProyeccion(anio, horizonte,false,-1);
       lstPrecioCompraInsumoProy = lstResultadoProyectado;
   }
    
//    public void generarInsumoResultado(int anio, int horizonte){
//        generarColumna(anio,horizonte);
//        lstPrecioCompraInsumoProy = new ArrayList<TablaResultado>();
//        for (int i = 0; i < getLstInsumosDetalle().size();i++){
//            TablaResultado tablaResultado = new TablaResultado();
//            tablaResultado.setObjeto(getLstInsumosDetalle().get(i));
//            double [] valores = new double[horizonte];
//            String [] sValores = new String[horizonte];
//            for (int j = 0; j < horizonte;j++){
//                if (j == 0){
//                    valores[j] = getLstInsumosDetalle().get(i).getPrecioCompra().doubleValue();
//                }else{
//                    valores[j] = valores[0]*(1+getVarProyPrecioCompra()[j]/100);
//                }
//                
//                valores[j] = Math.round(valores[j]*100.0)/100.0;
//                sValores[j] = df.format(valores[j]); 
//            }
//            tablaResultado.setValores(valores);
//            tablaResultado.setValValores(sValores);
//            lstPrecioCompraInsumoProy.add(tablaResultado);
//        }
//        
//    }

    @Override
    public double obtenerValorInicial(Object obj, int numTabla) {
        InsumoModeloDetalle insumoDetalle = (InsumoModeloDetalle) obj;
        return insumoDetalle.getPrecioCompra().doubleValue();
    }

    @Override
    public double obtenerTipoProyeccion(double[] valores, int i, int j, int numTabla) {
        return valores[0]*(1+arrVariacionProyeccion[j]/100);
    }

    @Override
    public double redondearProyeccion(double valor, int numTabla) {
       return Math.round(valor*100.0)/100.0;
    }

    @Override
    public String formatearRedondeo(double valores, int numTabla) {
      return df.format(valores); 
    }

    @Override
    public double obtenerValorProyectado(double valor) {
        return 0d;
    }
    
}
