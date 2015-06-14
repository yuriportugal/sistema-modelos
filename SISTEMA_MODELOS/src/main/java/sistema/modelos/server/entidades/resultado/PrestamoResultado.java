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
import org.apache.poi.ss.formula.functions.Finance;
import sistema.modelos.server.entidades.modelo.PrestamoModeloDetalle;
import sistema.modelos.vista.controlador.util.ColumnModel;

/**
 *
 * @author Orci
 */
public class PrestamoResultado {
    DecimalFormat df;
    List<PrestamoModeloDetalle> lstPrestamoModeloDetalle;
    List<TablaResultado> flujoPrestamo;
     public List<ColumnModel> columnaTabla;
    public List<TablaResultado> getFlujoPrestamo() {
        return flujoPrestamo;
    } 

    public List<ColumnModel> getColumnaTabla() {
        return columnaTabla;
    }
     
    
    
    public PrestamoResultado(List<PrestamoModeloDetalle> lstPrestamoModeloDetalle) {
        this.lstPrestamoModeloDetalle = lstPrestamoModeloDetalle;
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US); 
        this.df = (DecimalFormat)nf;
        df.applyPattern("###,###");
    }

    public void generarPrestamoResultado(int anio, int horizonte) {
        generarColumnaTabla(anio,horizonte);
        generarEsquemaPrestamo(lstPrestamoModeloDetalle.get(0).getCantPeriodos().intValue());
        generarFlujoDePago(lstPrestamoModeloDetalle.get(0));
    }

    private void generarEsquemaPrestamo(int cuotas) {
        flujoPrestamo = new ArrayList<TablaResultado>();
        for (int i = 0; i < 6;i++){
            TablaResultado tabla = new TablaResultado();
            String object = "";
            switch (i){
                case 0: {object = "Saldo inicial"; break;}
                case 1: {object = "Amortización"; break;}
                case 2: {object = "Interes"; break;}
                case 3: {object = "Cuota (Amortiz. + Interes)"; break;}
                case 4: {object = "Saldo Final (Saldo Inicial - Amortiz.)"; break;}
                case 5: {object = "Amortización Acumulada"; break;}
                default:{object = ""; break;}
            }
            tabla.setObjeto(object);
            tabla.setValValores(new String[cuotas]);
            tabla.setValores(new double[cuotas]);
            flujoPrestamo.add(tabla);
        }
    }

    private void generarFlujoDePago(PrestamoModeloDetalle prestamo) {
        Finance finance = new Finance();
        for (int i = 0; i < prestamo.getCantPeriodos().intValue();i++){
            double saldoIni         = 0d;
            double amort            = 0d;
            double interes          = 0d;
            double cuota            = 0d;
            double saldoFinal       = 0d;
            double amortAcumulada   = 0d;
            switch (i){
                   case 0:{  saldoIni = prestamo.getMonto().doubleValue();
                             amort = Finance.ppmt(prestamo.getInteres().doubleValue()*0.01,i+1,prestamo.getCantPeriodos().intValue(),prestamo.getMonto().doubleValue()*-1d);
                             interes = Finance.ipmt(prestamo.getInteres().doubleValue()*0.01,i+1,prestamo.getCantPeriodos().intValue(),prestamo.getMonto().doubleValue()*-1d);
                             cuota = amort+interes;
                             saldoFinal = saldoIni-amort;
                             amortAcumulada = amort;
                             break;}
                   default:{ saldoIni = flujoPrestamo.get(4).getValores()[i-1];
                             amort = Finance.ppmt(prestamo.getInteres().doubleValue()*0.01,i+1,prestamo.getCantPeriodos().intValue(),prestamo.getMonto().doubleValue()*-1d);
                             interes = Finance.ipmt(prestamo.getInteres().doubleValue()*0.01,i+1,prestamo.getCantPeriodos().intValue(),prestamo.getMonto().doubleValue()*-1d);
                             cuota = amort+interes;
                             saldoFinal = saldoIni-amort;
                             amortAcumulada = amort+flujoPrestamo.get(5).getValores()[i-1];;
                             break;}
                   
            }
            flujoPrestamo.get(0).getValores()[i] = saldoIni;
            flujoPrestamo.get(1).getValores()[i] = amort;
            flujoPrestamo.get(2).getValores()[i] = interes;
            flujoPrestamo.get(3).getValores()[i] = cuota;
            flujoPrestamo.get(4).getValores()[i] = saldoFinal;
            flujoPrestamo.get(5).getValores()[i] = amortAcumulada;
            for (int j = 0; j < 6;j++)
                flujoPrestamo.get(j).getValValores()[i] = df.format(flujoPrestamo.get(j).getValores()[i]);
       }
    }

    private void generarColumnaTabla(int anio, int horizonte) {
        columnaTabla = new ArrayList<ColumnModel>();
        for (int i = 0; i <= horizonte; i++){
           ColumnModel column = new ColumnModel();
           switch (i){
              case 0:  {column.setHeader("Periodos");
                        column.setProperty("objeto");
                        break;}
              default:  {column.setHeader(""+(anio+i-1));
                         column.setProperty("valores");
                         break;}    
           }
          columnaTabla.add(column);   
       }
    }
    
    
    
    
}
