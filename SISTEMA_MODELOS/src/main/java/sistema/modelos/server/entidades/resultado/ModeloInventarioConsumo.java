/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.util.List;

public class ModeloInventarioConsumo {
    //Dependencias
    ModeloInventarioUnidades modeloInventarioUnidades; //PlanComprasValorizadoUnidades, Requerimientos
    //Resultados
    List<TablaResultadoExt> modeloInventarioConsumo;
    List<TablaResultado> valoresConsumoSinIGV;
    List<TablaResultado> stockFinalValorizado;
    List<TablaResultadoExt> varloresConsumoInsxProd;
    
    
}