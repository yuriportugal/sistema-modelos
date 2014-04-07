/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.util.List;

/**
 *
 * @author YURI
 */
public class TablaResultado {
    Object objeto;
    
    
    double [] valores;
    
    String [] valValores;

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public double[] getValores() {
        return valores;
    }

    public void setValores(double[] valores) {
        this.valores = valores;
    }

    public String[] getValValores() {
        return valValores;
    }

    public void setValValores(String[] valValores) {
        this.valValores = valValores;
    }
    
    
    
    public String obtenerValorTabla(String i){
        int j = Integer.valueOf(i);
        if (j == 0){
            return objeto.toString();
        }else{
            return String.valueOf(valores[j-1]);
        }
    }
    
   public String getObtenerValorTablas(String i){
        int j = Integer.valueOf(i);
        if (j == 0){
            return objeto.toString();
        }else{
            return String.valueOf(valores[j-1]);
        }
    }

}
