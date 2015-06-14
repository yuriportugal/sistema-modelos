/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import sistema.modelos.vista.controlador.util.ColumnModel;

/**
 *
 * @author YURI
 */
public abstract class ResultadoGeneral {
    
    DecimalFormat dfTotal;
    
    public List<ColumnModel> columnaTabla;
    
    public List<List<ColumnModel>> lstColumnasTabla;
    
    public List<Object> lstObjetoAProyectar;
    
    public List<TablaResultado> lstResultadoProyectado;
    
    public double[] arrVariacionProyeccion;

    public double[] getArrVariacionProyeccion() {
        return arrVariacionProyeccion;
    }

    public List<List<ColumnModel>> getLstColumnasTabla() {
        if (lstColumnasTabla == null){
            lstColumnasTabla = new ArrayList<List<ColumnModel>>();
        }
        return lstColumnasTabla;
    }
    
    
    
    public void setArrVariacionProyeccion(double[] arrVariacionProyeccion) {
        this.arrVariacionProyeccion = arrVariacionProyeccion;
    }
    
    public List<Object> getLstObjetoAProyectar() {
        return lstObjetoAProyectar;
    }

    public void setLstObjetoAProyectar(List<Object> lstObjetoAProyectar) {
        this.lstObjetoAProyectar = lstObjetoAProyectar;
    }
    
    protected abstract void generarColumna(int anio, int horizonte,int numTabla);

    public List<ColumnModel> getColumnaTabla() {
        return columnaTabla;
    }

    public void setColumnaTabla(List<ColumnModel> columnaTabla) {
        this.columnaTabla = columnaTabla;
    }
    
    public abstract double obtenerValorInicial(Object obj, int numTabla);
    
    public abstract double obtenerTipoProyeccion(double [] valores,int i, int j, int numTabla, Object objetoProy);
    
    public abstract double redondearProyeccion(double valores, int numTabla);
    public abstract String formatearRedondeo(double valores, int numTabla);
    
    public abstract double obtenerValorProyectado(double valor);
    
    public void generarProyeccion(int anio, int horizonte, boolean mostrarTotal, int numTabla){
        generarColumna(anio,horizonte,numTabla);
        lstResultadoProyectado = new ArrayList<TablaResultado>();
        for (int i = 0; i < getLstObjetoAProyectar().size();i++){
            TablaResultado tablaResultado = new TablaResultado();
            tablaResultado.setObjeto(getLstObjetoAProyectar().get(i));
            double [] valores = new double[horizonte];
            String [] sValores = new String[horizonte];
            for (int j = 0; j < horizonte;j++){
                if (j == 0){
                    valores[j] = obtenerValorInicial(getLstObjetoAProyectar().get(i),numTabla);
                }else{
                    valores[j] = obtenerTipoProyeccion(valores,i,j,numTabla,getLstObjetoAProyectar().get(i));//valores[0]*(1+getVarProyPrecioCompra()[j]/100);
                }
                
                valores[j] = redondearProyeccion(valores[j],numTabla);//Math.round(valores[j]*100.0)/100.0;
                sValores[j] = formatearRedondeo(valores[j],numTabla);//df.format(valores[j]); 
            }
            tablaResultado.setValores(valores);
            tablaResultado.setValValores(sValores);
            lstResultadoProyectado.add(tablaResultado);
        }
        
        if (mostrarTotal){
            TablaResultado tablaResultado = new TablaResultado();
            tablaResultado.setObjeto("Total");
            double [] valores = new double[horizonte];
            String [] sValores = new String[horizonte];
            for (int i = 0; i < horizonte;i++){
                double suma = 0d;
                for (int j = 0; j < lstResultadoProyectado.size();j++){
                    suma += lstResultadoProyectado.get(j).getValores()[i];
                }
                valores[i] = suma;
                sValores[i] = getDfTotal().format(valores[i]); 
            }

            tablaResultado.setValValores(sValores);
            tablaResultado.setValores(valores);
            lstResultadoProyectado.add(tablaResultado);    

        }
        
    }
    
    public List<TablaResultado> proyectarTabla(List<TablaResultado> lstTablaBase,int numTabla){
        List<TablaResultado> lsTablaProyectada = new ArrayList<TablaResultado>();
        for (TablaResultado tablaBase : lstTablaBase){
            TablaResultado tablaNueva = new TablaResultado();
            tablaNueva.setObjeto(tablaBase.getObjeto());
            double [] valores = new double[tablaBase.getValores().length];
            String [] sValores = new String[tablaBase.getValores().length];
            for (int i = 0; i < tablaBase.getValores().length;i++){
                   valores[i] = obtenerValorProyectado(tablaBase.getValores()[i]); 
                   sValores[i] = formatearRedondeo(valores[i],numTabla);
            }
            tablaNueva.setValores(valores);
            tablaNueva.setValValores(sValores);
            lsTablaProyectada.add(tablaNueva);
        }
        return lsTablaProyectada;
    }

    public List<TablaResultado> sumAcumuladaTabla(List<TablaResultado> lstTablaBase,int numTabla,int anio, int horizonte){
        generarColumna(anio,horizonte,numTabla);
        List<TablaResultado> lsTablaProyectada = new ArrayList<TablaResultado>();
        for (TablaResultado tablaBase : lstTablaBase){
            TablaResultado tablaNueva = new TablaResultado();
            tablaNueva.setObjeto(tablaBase.getObjeto());
            double [] valores = new double[horizonte];
            String [] sValores = new String[horizonte];
            for (int i = 0; i < horizonte;i++){
                   valores[i] = obtenerValorSumado(i==0?0d:valores[i-1],tablaBase.getValores()[3]); 
                   sValores[i] = formatearRedondeo(valores[i],numTabla);
            }
            tablaNueva.setValores(valores);
            tablaNueva.setValValores(sValores);
            lsTablaProyectada.add(tablaNueva);
        }
        return lsTablaProyectada;
    }
    
    
    public DecimalFormat getDfTotal() {
        if (dfTotal == null){
             NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            dfTotal = (DecimalFormat)nf;
            dfTotal.applyPattern("###,###");
        }
        return dfTotal;
    }

    public abstract double obtenerValorSumado(double d1, double d2);
    
    
}
