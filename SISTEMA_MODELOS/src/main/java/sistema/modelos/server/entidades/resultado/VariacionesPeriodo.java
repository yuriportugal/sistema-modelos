/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

/**
 *
 * @author Orci
 */
public class VariacionesPeriodo {
    
    // Proyeccion de precio de venta
    double [] VarProyPrecioVenta;
    // Proyeccion de ventas
    double [] VarProyVenta;
    // Proyeccion de precio de compras
    double [] VarProyPrecioCompra;
    // Proyeccion salarial
   double [] VarProySalarial;

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
   
   
    
    
}
