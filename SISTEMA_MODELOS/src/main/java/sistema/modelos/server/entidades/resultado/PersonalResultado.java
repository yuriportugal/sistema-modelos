/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import sistema.modelos.server.entidades.modelo.CargoModeloDetalle;
import sistema.modelos.server.entidades.modelo.InsumoModeloDetalle;
import sistema.modelos.server.entidades.util.ConstantesGenerales;
import sistema.modelos.vista.controlador.util.ColumnModel;

/**
 *
 * @author Orci
 */
public class PersonalResultado extends ResultadoGeneral{
    
    DecimalFormat df = new DecimalFormat("###,###");
    DecimalFormat dfDecimal = new DecimalFormat("###,###.000");
    //Dependencia
   private double [] VarProyPersonal;
   private double [] VarProySalarial; //VariacionesPeriodo
   private List<FormulacionDetalle> personalDetFormulacion; //Formulacion
   private List<CargoModeloDetalle> lstCargoModeloDet;
    //Resultados
   private List<TablaResultado> variacionPersonalxPeriodo;
   private List<TablaResultado> variacionSueldoUnitarioMensual;
   private List<TablaResultado> variacionSueldoUnitarioAnual;
   private List<TablaResultadoExt> costoModProduccion;
   private List<TablaResultado> costoMoiProduccion;   
   
   private List<TablaResultado> sueldoNoRelacionadoProd;
   private List<TablaResultado> sueldoNoRelacionadoProdxArea;

   int mesesxAnio;
   
    public List<CargoModeloDetalle> getLstCargoModeloDet() {
        return lstCargoModeloDet;
    }

    public void setLstCargoModeloDet(List<CargoModeloDetalle> lstCargoModeloDet) {
        this.lstCargoModeloDet = lstCargoModeloDet;
    }

    public PersonalResultado(double [] VarProyPersonal,List<CargoModeloDetalle> lstCargoModeloDet,double [] VarProySalarial) {
        this.VarProyPersonal = VarProyPersonal;
        this.lstCargoModeloDet = lstCargoModeloDet;
        this.VarProySalarial = VarProySalarial;
        this.mesesxAnio = 12;
    }

    public double[] getVarProyPersonal() {
        return VarProyPersonal;
    }

    public void setVarProyPersonal(double[] VarProyPersonal) {
        this.VarProyPersonal = VarProyPersonal;
    }

   
   
    public List<TablaResultadoExt> getCostoModProduccion() {
        return costoModProduccion;
    }

    public List<TablaResultado> getCostoMoiProduccion() {
        return costoMoiProduccion;
    }

    public List<FormulacionDetalle> getPersonalDetFormulacion() {
        return personalDetFormulacion;
    }

    public List<TablaResultado> getSueldoNoRelacionadoProd() {
        return sueldoNoRelacionadoProd;
    }

    public List<TablaResultado> getSueldoNoRelacionadoProdxArea() {
        return sueldoNoRelacionadoProdxArea;
    }

    public double[] getVarProySalarial() {
        return VarProySalarial;
    }

    public List<TablaResultado> getVariacionPersonalxPeriodo() {
        return variacionPersonalxPeriodo;
    }

    public List<TablaResultado> getVariacionSueldoUnitarioAnual() {
        return variacionSueldoUnitarioAnual;
    }

    public List<TablaResultado> getVariacionSueldoUnitarioMensual() {
        return variacionSueldoUnitarioMensual;
    }

    public void setCostoModProduccion(List<TablaResultadoExt> costoModProduccion) {
        this.costoModProduccion = costoModProduccion;
    }

    public void setCostoMoiProduccion(List<TablaResultado> costoMoiProduccion) {
        this.costoMoiProduccion = costoMoiProduccion;
    }

    public void setPersonalDetFormulacion(List<FormulacionDetalle> personalDetFormulacion) {
        this.personalDetFormulacion = personalDetFormulacion;
    }

    public void setSueldoNoRelacionadoProd(List<TablaResultado> sueldoNoRelacionadoProd) {
        this.sueldoNoRelacionadoProd = sueldoNoRelacionadoProd;
    }

    public void setSueldoNoRelacionadoProdxArea(List<TablaResultado> sueldoNoRelacionadoProdxArea) {
        this.sueldoNoRelacionadoProdxArea = sueldoNoRelacionadoProdxArea;
    }

    public void setVarProySalarial(double[] VarProySalarial) {
        this.VarProySalarial = VarProySalarial;
    }

    public void setVariacionPersonalxPeriodo(List<TablaResultado> variacionPersonalxPeriodo) {
        this.variacionPersonalxPeriodo = variacionPersonalxPeriodo;
    }

    public void setVariacionSueldoUnitarioAnual(List<TablaResultado> variacionSueldoUnitarioAnual) {
        this.variacionSueldoUnitarioAnual = variacionSueldoUnitarioAnual;
    }

    public void setVariacionSueldoUnitarioMensual(List<TablaResultado> variacionSueldoUnitarioMensual) {
        this.variacionSueldoUnitarioMensual = variacionSueldoUnitarioMensual;
    }

    public void generarPersonalResultado(int anio, int horizonte) {
       setArrVariacionProyeccion(VarProyPersonal);
       List<Object> lstObjeto = new ArrayList<Object>();
       for (CargoModeloDetalle cargoDet :  lstCargoModeloDet ){
           lstObjeto.add(cargoDet);
       }
       setLstObjetoAProyectar(lstObjeto);
       generarProyeccion(anio, horizonte,true,1);
       variacionPersonalxPeriodo = lstResultadoProyectado;
       setArrVariacionProyeccion(VarProySalarial);
       generarProyeccion(anio, horizonte, true, 2);
       variacionSueldoUnitarioMensual = lstResultadoProyectado;
       variacionSueldoUnitarioAnual = proyectarTabla(variacionSueldoUnitarioMensual, 3);
       //lstResultadoProyectado = new ArrayList<TablaResultado>();
        
//        //generarColumna(anio,horizonte);
//        variacionPersonalxPeriodo = new ArrayList<TablaResultado>();
//        for (int i = 0; i < getLstCargoModeloDet().size();i++){
//            TablaResultado tablaResultado = new TablaResultado();
//            tablaResultado.setObjeto(getLstCargoModeloDet().get(i));
//            double [] valores = new double[horizonte];
//            String [] sValores = new String[horizonte];
//            for (int j = 0; j < horizonte;j++){
//                if (j == 0){
//                    valores[j] = getLstCargoModeloDet().get(i).getCantidad().doubleValue();
//                }else{
//                    valores[j] = valores[j-1]*(1+getVarProyPersonal()[j]/100);
//                }
//                
//                valores[j] = Math.round(valores[j]-0.5d);
//                sValores[j] = df.format(valores[j]); 
//            }
//            tablaResultado.setValores(valores);
//            tablaResultado.setValValores(sValores);
//            variacionPersonalxPeriodo.add(tablaResultado);
//        }
//        TablaResultado tablaResultado = new TablaResultado();
//        tablaResultado.setObjeto("Total");
//        double [] valores = new double[horizonte];
//        String [] sValores = new String[horizonte];
//        for (int i = 0; i < horizonte;i++){
//            double suma = 0d;
//            for (int j = 0; j < variacionPersonalxPeriodo.size();j++){
//                suma += variacionPersonalxPeriodo.get(j).getValores()[i];
//            }
//            valores[i] = suma;
//            sValores[i] = df.format(valores[i]); 
//        }
//        
//        tablaResultado.setValValores(sValores);
//        tablaResultado.setValores(valores);
//        variacionPersonalxPeriodo.add(tablaResultado);
    }

    @Override
    protected void generarColumna(int anio, int horizonte) {
       columnaTabla = new ArrayList<ColumnModel>();
        for (int i = 0; i <= horizonte; i++){
            ColumnModel column = new ColumnModel();
            switch (i){
                case 0:  {column.setHeader("Cargo");
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

    

    @Override
    public double obtenerValorInicial(Object obj, int numTabla) {
        switch(numTabla){
            case 1  : return ((CargoModeloDetalle)obj).getCantidad().doubleValue();
            case 2  : return ((CargoModeloDetalle)obj).getSueldo().doubleValue();
            default : return 0d;    
        }
        
    }

    @Override
    public double obtenerTipoProyeccion(double[] valores, int i, int j, int numTabla) {
        switch(numTabla){
            case 2  :
            case 1  : return valores[j-1]*(1+arrVariacionProyeccion[j]/100);
            default : return 0d;    
        }
    }

    @Override
    public double redondearProyeccion(double valores, int numTabla) {
        switch(numTabla){
            case 2  : return Math.round(valores*100.0)/100.0;
            case 1  : return Math.round(valores-0.5d);
            default : return 0d;    
        }
        
    }

    @Override
    public String formatearRedondeo(double valores, int numTabla) {
        switch(numTabla){
            case 3  :
            case 2  : return df.format(valores+0.1d);
            case 1  : return df.format(valores); 
            default : return "0";    
        }
        
    }

    @Override
    public double obtenerValorProyectado(double valor) {
        return valor*(mesesxAnio+2)*(1+ConstantesGenerales.PORC_ESSALUD/100.00);
    }
   
}
