/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import sistema.modelos.server.entidades.empresa.Producto;

/**
 *
 * @author Orci
 */
public class ProductoFormulacion {
    
    private Producto producto;
    private double cantidad;

    public double getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
