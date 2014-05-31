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
public class InsumoResultado {
    
    //Dependencias variaciones
    double [] VarProyPrecioCompra;
    //Resultado
    List<TablaResultado> lstPrecioCompraInsumoProy;

    public List<TablaResultado> getLstPrecioCompraInsumoProy() {
        return lstPrecioCompraInsumoProy;
    }

    public void setLstPrecioCompraInsumoProy(List<TablaResultado> lstPrecioCompraInsumoProy) {
        this.lstPrecioCompraInsumoProy = lstPrecioCompraInsumoProy;
    }
    
    
}
