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
public class ActivoResultado {
    
    //Dependencia
    
    //Resultados
    List<TablaResultado> depreciacionActivoFijo;
    List<TablaResultado> amortizacionActivoIntangible;
    List<TablaResultado> depreciacionAcumuladaActivoFijo;
    List<TablaResultado> amortizacionAcumuladaActivoIntangible;
    List<TablaResultado> valoresLibrosActivosFijos;
    List<TablaResultado> valoresLibrosActivosIntangibles;
    
    List<TablaResultadoExt> mantenimientoActivosProduccion;
    List<TablaResultadoExt> mantenimientoActivosNoProduccion;
    
    
}
