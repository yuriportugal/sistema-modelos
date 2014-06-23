/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import sistema.modelos.server.entidades.modelo.Modelo;

/**
 *
 * @author Orci
 */
public class VariacionesPeriodo {
    
    // Proyeccion de precio de venta --1
    double [] VarProyPrecioVenta;
    // Proyeccion de ventas -- 2
    double [] VarProyVenta;
    // Proyeccion de precio de compras --3
    double [] VarProyPrecioCompra; 
    // Proyeccion salarial --4
   double [] VarProySalarial;
   // Proyeccion salarial --5
   double [] VarProyPersonal;

    public double[] getVarProyPersonal() {
        return VarProyPersonal;
    }

    public void setVarProyPersonal(double[] VarProyPersonal) {
        this.VarProyPersonal = VarProyPersonal;
    }

   
   
    public double[] getVarProyPrecioCompra() {
        return VarProyPrecioCompra;
    }

    public double[] getVarProyPrecioVenta() {
        return VarProyPrecioVenta;
    }

    public double[] getVarProySalarial() {
        return VarProySalarial;
    }

    public double[] getVarProyVenta() {
        return VarProyVenta;
    }

    public void setVarProyPrecioCompra(double[] VarProyPrecioCompra) {
        this.VarProyPrecioCompra = VarProyPrecioCompra;
    }

    public void setVarProyPrecioVenta(double[] VarProyPrecioVenta) {
        this.VarProyPrecioVenta = VarProyPrecioVenta;
    }

    public void setVarProySalarial(double[] VarProySalarial) {
        this.VarProySalarial = VarProySalarial;
    }

    public void setVarProyVenta(double[] VarProyVenta) {
        this.VarProyVenta = VarProyVenta;
    }
   
   public void generarVariaciones(Modelo modelo){
       generarVariacion(modelo.getVARIndPrecioCompra().doubleValue(), modelo.getVARPorcInicialPrecioCompra().doubleValue(),3, modelo.getHorizonte().intValue());
       generarVariacion(modelo.getVARIndPersonal().doubleValue(), modelo.getVARPorcInicialPersonal().doubleValue(),5, modelo.getHorizonte().intValue());
       generarVariacion(modelo.getVARIndSalarial().doubleValue(), modelo.getVARPorcInicialSalarial().doubleValue(),4, modelo.getHorizonte().intValue());
   }
    
    public void generarVariacion(double variacion, double valorInicial, int opcion,int horizonte){
        double [] arrResultado;
        switch (opcion){
            case 3: {    
                        VarProyPrecioCompra = new double[horizonte];
                        arrResultado = VarProyPrecioCompra;
                        break;}
            case 4: {
                        VarProySalarial = new double[horizonte];
                        arrResultado = VarProySalarial;
                        break;
            }
            case 5: {
                        VarProyPersonal = new double[horizonte];
                        arrResultado = VarProyPersonal;
                        break;
            }    
            default: {
                        arrResultado = new double[horizonte];}
        }
        
        for (int i = 0; i < horizonte; i++){
             arrResultado[i] = i ==0? valorInicial:(arrResultado[i-1]*(1+variacion/100));
             arrResultado[i] = Math.round(arrResultado[i]*100.0)/100.0;
        }
        
        switch (opcion){
            case 3: {   VarProyPrecioCompra = arrResultado;
                        break;}
            case 4: {   VarProySalarial = arrResultado;
                        break;}
            case 5: {   VarProyPersonal = arrResultado;
                        break;
            }
        }
        
        
    }
    
}
