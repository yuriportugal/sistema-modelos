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
public class PersonalResultado {
    
    //Dependencia
   private double [] VarProySalarial; //VariacionesPeriodo
   private List<FormulacionDetalle> personalDetFormulacion; //Formulacion
    //Resultados
   private List<TablaResultado> variacionPersonalxPeriodo;
   private List<TablaResultado> variacionSueldoUnitarioMensual;
   private List<TablaResultado> variacionSueldoUnitarioAnual;
   private List<TablaResultadoExt> costoModProduccion;
   private List<TablaResultado> costoMoiProduccion;   
   
   private List<TablaResultado> sueldoNoRelacionadoProd;
   private List<TablaResultado> sueldoNoRelacionadoProdxArea;

    public List<TablaResultadoExt> getCostoModProduccion() {
        return costoModProduccion;
    }

    public List<TablaResultado> getCostoMoiProduccion() {
        return costoMoiProduccion;
    }

    public List<FormulacionDetalle> getPersonalDetFormulacion() {
        return personalDetFormulacion;
    }

    public List<TablaResultado> getSueldoNoRelacionadoProd() {
        return sueldoNoRelacionadoProd;
    }

    public List<TablaResultado> getSueldoNoRelacionadoProdxArea() {
        return sueldoNoRelacionadoProdxArea;
    }

    public double[] getVarProySalarial() {
        return VarProySalarial;
    }

    public List<TablaResultado> getVariacionPersonalxPeriodo() {
        return variacionPersonalxPeriodo;
    }

    public List<TablaResultado> getVariacionSueldoUnitarioAnual() {
        return variacionSueldoUnitarioAnual;
    }

    public List<TablaResultado> getVariacionSueldoUnitarioMensual() {
        return variacionSueldoUnitarioMensual;
    }

    public void setCostoModProduccion(List<TablaResultadoExt> costoModProduccion) {
        this.costoModProduccion = costoModProduccion;
    }

    public void setCostoMoiProduccion(List<TablaResultado> costoMoiProduccion) {
        this.costoMoiProduccion = costoMoiProduccion;
    }

    public void setPersonalDetFormulacion(List<FormulacionDetalle> personalDetFormulacion) {
        this.personalDetFormulacion = personalDetFormulacion;
    }

    public void setSueldoNoRelacionadoProd(List<TablaResultado> sueldoNoRelacionadoProd) {
        this.sueldoNoRelacionadoProd = sueldoNoRelacionadoProd;
    }

    public void setSueldoNoRelacionadoProdxArea(List<TablaResultado> sueldoNoRelacionadoProdxArea) {
        this.sueldoNoRelacionadoProdxArea = sueldoNoRelacionadoProdxArea;
    }

    public void setVarProySalarial(double[] VarProySalarial) {
        this.VarProySalarial = VarProySalarial;
    }

    public void setVariacionPersonalxPeriodo(List<TablaResultado> variacionPersonalxPeriodo) {
        this.variacionPersonalxPeriodo = variacionPersonalxPeriodo;
    }

    public void setVariacionSueldoUnitarioAnual(List<TablaResultado> variacionSueldoUnitarioAnual) {
        this.variacionSueldoUnitarioAnual = variacionSueldoUnitarioAnual;
    }

    public void setVariacionSueldoUnitarioMensual(List<TablaResultado> variacionSueldoUnitarioMensual) {
        this.variacionSueldoUnitarioMensual = variacionSueldoUnitarioMensual;
    }
   
}
