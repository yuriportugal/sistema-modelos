/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import sistema.modelos.server.entidades.modelo.ActivoModeloDetalle;
import sistema.modelos.vista.controlador.util.ColumnModel;

/**
 *
 * @author Orci
 */
public class ActivoResultado extends ResultadoGeneral{
    DecimalFormat df = new DecimalFormat("###,###");
    //Dependencia
    List<ActivoModeloDetalle> lstActivoModelo;
    //Resultados
    List<TablaResultado> depreciacionActivoFijo;
    List<TablaResultado> depreciacionActivoFijoNoProd;
    List<TablaResultado> depreciacionActivoIntangible;
    List<TablaResultado> amortizacionActivoIntangible;
    List<TablaResultado> depreciacionAcumuladaActivoFijo;
    List<TablaResultado> depreciacionAcumuladaActivoFijoNoProd;
    List<TablaResultado> amortizacionAcumuladaActivoIntangible;
    List<TablaResultado> valoresLibrosActivosFijos;
    List<TablaResultado> valoresLibrosActivosIntangibles;
    
    List<TablaResultadoExt> mantenimientoActivosProduccion;
    List<TablaResultadoExt> mantenimientoActivosNoProduccion;

    public List<TablaResultado> getDepreciacionAcumuladaActivoFijo() {
        return depreciacionAcumuladaActivoFijo;
    }

    public List<TablaResultado> getDepreciacionAcumuladaActivoFijoNoProd() {
        return depreciacionAcumuladaActivoFijoNoProd;
    }
    
    
    
    public ActivoResultado(List<ActivoModeloDetalle> lstActivoModelo) {
        this.lstActivoModelo = lstActivoModelo;
         NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        this.df = (DecimalFormat)nf;
        df.applyPattern("###,###");
    }

    public List<TablaResultado> getDepreciacionActivoFijo() {
        return depreciacionActivoFijo;
    }

    public List<TablaResultado> getDepreciacionActivoFijoNoProd() {
        return depreciacionActivoFijoNoProd;
    }

    public List<TablaResultado> getDepreciacionActivoIntangible() {
        return depreciacionActivoIntangible;
    }
    
    
    
    public void generarActivoResultado(int anio, int horizonte) {
       List<Object> lstObjeto = new ArrayList<Object>();
       for (ActivoModeloDetalle activoModeloDet : lstActivoModelo){
           if (activoModeloDet.getActivo().getArea().getIdArea().equals(1L))
           lstObjeto.add(activoModeloDet);
       }
        setLstObjetoAProyectar(lstObjeto);
        generarProyeccion(anio, 6, true, 1); //Tabla Nro 2 - 1
        depreciacionActivoFijo = lstResultadoProyectado;
        lstObjeto = new ArrayList<Object>();
       for (ActivoModeloDetalle activoModeloDet : lstActivoModelo){
           if (!activoModeloDet.getActivo().getArea().getIdArea().equals(1L)&&!activoModeloDet.getActivo().getTipoActivo().getIdTipoActivo().equals(5L))
           lstObjeto.add(activoModeloDet);
       }
        setLstObjetoAProyectar(lstObjeto);
        generarProyeccion(anio, 6, true, 2); //Tabla Nro 2 - 1
        depreciacionActivoFijoNoProd = lstResultadoProyectado;
        lstObjeto = new ArrayList<Object>();
       for (ActivoModeloDetalle activoModeloDet : lstActivoModelo){
           if (activoModeloDet.getActivo().getTipoActivo().getIdTipoActivo().equals(5L))
           lstObjeto.add(activoModeloDet);
       }
        setLstObjetoAProyectar(lstObjeto);
        generarProyeccion(anio, 6, true, 3); //Tabla Nro 2 - 2
        depreciacionActivoIntangible = lstResultadoProyectado;
        depreciacionAcumuladaActivoFijo =  sumAcumuladaTabla(depreciacionActivoFijo,4,anio,horizonte);
        depreciacionAcumuladaActivoFijoNoProd = sumAcumuladaTabla(depreciacionActivoFijoNoProd,5,anio,horizonte);
//        setArrVariacionProyeccion(VarProyPersonal);
//       List<Object> lstObjeto = new ArrayList<Object>();
//       for (CargoModeloDetalle cargoDet :  lstCargoModeloDet ){
//           lstObjeto.add(cargoDet);
//       }
//       setLstObjetoAProyectar(lstObjeto);
//       generarProyeccion(anio, horizonte,true,1);
//       variacionPersonalxPeriodo = lstResultadoProyectado;
//       setArrVariacionProyeccion(VarProySalarial);
//       generarProyeccion(anio, horizonte, true, 2);
//       variacionSueldoUnitarioMensual = lstResultadoProyectado;
//       variacionSueldoUnitarioAnual = proyectarTabla(variacionSueldoUnitarioMensual, 3);
//       lstResultadoProyectado = new ArrayList<TablaResultado>();
    }

    @Override
    protected void generarColumna(int anio, int numCols, int numTabla) {
        List<ColumnModel> columnaTabla = new ArrayList<ColumnModel>();
        switch (numTabla){
            case 3:
            case 2:
            case 1:{
                    for (int i = 0; i <= numCols; i++){
                        ColumnModel column = new ColumnModel();
                        switch (i){
                            case 0:  {column.setHeader((numTabla==1?"Relacionados a la producción":"No relacionados a la producción"));
                                      column.setProperty("objeto");
                                      break;}
                            case 1:  {column.setHeader("Valor inicial unitaría");
                                      column.setProperty("valores");
                                      break;}    
                            case 2:  {column.setHeader("Cantidad");
                                      column.setProperty("valores");
                                      break;}    
                            case 3:  {column.setHeader("Años de vida");
                                      column.setProperty("valores");
                                      break;}    
                            case 4:  {column.setHeader("Depreciación Anual");
                                      column.setProperty("valores");
                                      break;}    
                            case 5:  {column.setHeader("Depreciación Anual Unitaría");
                                      column.setProperty("valores");
                                      break;}    
                            case 6:  {column.setHeader("Valor en libros inicial total");
                                      column.setProperty("valores");
                                      break;}    
                         }
                        columnaTabla.add(column);   
                    }
                    getLstColumnasTabla().add(columnaTabla);
                    break;
            }
            case 5:
            case 4:{
                    for (int i = 0; i <= numCols; i++){
                        ColumnModel column = new ColumnModel();
                        switch (i){
                            case 0:  {column.setHeader(numTabla==4?"Relacionados a la producción":"No relacionados a la produccion");
                                      column.setProperty("objeto");
                                      break;}
                            default:  {column.setHeader(""+(anio+i-1));
                                       column.setProperty("valores");
                                      break;}    
                                
                         }
                        columnaTabla.add(column);   
                    }
                    getLstColumnasTabla().add(columnaTabla);
                    break;
                
            }
            
        }
     }
    

    @Override
    public double obtenerValorInicial(Object obj, int numTabla) {
        switch (numTabla){
            case 3:
            case 2:
            case 1:{ActivoModeloDetalle activoModDetalle = (ActivoModeloDetalle)obj;
                    return activoModDetalle.getValorCompra().doubleValue();
                    }
        }
        return 0d;
    }

    @Override
    public double obtenerTipoProyeccion(double[] valores, int i, int j, int numTabla, Object objetoProy) {
        switch (numTabla){
            case 3:
            case 2:
            case 1:{ActivoModeloDetalle activoModDetalle = (ActivoModeloDetalle)objetoProy;
                    System.out.println(activoModDetalle.getActivo().getNombre()+" - "+j);
                    switch (j){
                        case 1:{return activoModDetalle.getCantidad().doubleValue();}
                        case 2:{return activoModDetalle.getAnoVida().doubleValue();}
                        case 3:{if (activoModDetalle.getAnoVida().equals(new BigDecimal(-1))){
                                 return  0d;
                                }else{
                                return activoModDetalle.getCantidad().multiply(activoModDetalle.getValorCompra()).divide(activoModDetalle.getAnoVida(),RoundingMode.HALF_UP).doubleValue();
                        }}
                        case 4:{ if (activoModDetalle.getAnoVida().equals(new BigDecimal(-1))){
                                 return  0d;
                                    }else{
                                 return activoModDetalle.getValorCompra().divide(activoModDetalle.getAnoVida(),RoundingMode.HALF_UP).doubleValue();}
                                }
                        case 5:{return activoModDetalle.getCantidad().multiply(activoModDetalle.getValorCompra()).doubleValue();}
                        default: return 0d;
                     }
                    }
        }
        return 0d;
    }

    @Override
    public double redondearProyeccion(double valores, int numTabla) {
        return Math.round(valores);
    }

    @Override
    public String formatearRedondeo(double valores, int numTabla) {
        return df.format(valores);
    }

    @Override
    public double obtenerValorProyectado(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double obtenerValorSumado(double d1, double d2) {
       return d1+d2;
    }


}
