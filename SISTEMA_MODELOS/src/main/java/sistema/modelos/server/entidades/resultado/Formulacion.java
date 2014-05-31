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
public class Formulacion {
    
    List<FormulacionDetalle> insumoDetFormulacion; //Plan de Compras
    List<FormulacionDetalle> personalDetFormulacion; //Personal
    List<FormulacionDetalle> activoDetFormulacion; //Activo
    public List<FormulacionDetalle> getInsumoDetFormulacion() {
        return insumoDetFormulacion;
    }

    public void setInsumoDetFormulacion(List<FormulacionDetalle> insumoDetFormulacion) {
        this.insumoDetFormulacion = insumoDetFormulacion;
    }

    public List<FormulacionDetalle> getPersonalDetFormulacion() {
        return personalDetFormulacion;
    }

    public void setPersonalDetFormulacion(List<FormulacionDetalle> personalDetFormulacion) {
        this.personalDetFormulacion = personalDetFormulacion;
    }

    public List<FormulacionDetalle> getActivoDetFormulacion() {
        return activoDetFormulacion;
    }

    public void setActivoDetFormulacion(List<FormulacionDetalle> activoDetFormulacion) {
        this.activoDetFormulacion = activoDetFormulacion;
    }
    
}
