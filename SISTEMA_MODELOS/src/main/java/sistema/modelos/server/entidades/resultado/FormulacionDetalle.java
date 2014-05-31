/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.util.List;

/**
 *
 * @author Orci
 */
public class FormulacionDetalle {
    
    private Object detalle;
    
    private List<ProductoFormulacion> lstProdFormulacion;

    public Object getDetalle() {
        return detalle;
    }

    public List<ProductoFormulacion> getLstProdFormulacion() {
        return lstProdFormulacion;
    }

    public void setDetalle(Object detalle) {
        this.detalle = detalle;
    }

    public void setLstProdFormulacion(List<ProductoFormulacion> lstProdFormulacion) {
        this.lstProdFormulacion = lstProdFormulacion;
    }
    
    
}
