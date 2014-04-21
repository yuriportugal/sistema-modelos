/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

/**
 *
 * @author YURI
 */
public class Resultado {
    
    private PlanVentas planVentas;
    private PlanProduccion planProduccion;
    private NecesidadInsumo necesidadInsumo;
    private PlanCompras planCompras;
    
    public PlanVentas getPlanVentas() {
        if (planVentas == null){
            System.out.println("--- hola mundo");
            planVentas = new PlanVentas();
        }
        return planVentas;
    }

    public void setPlanVentas(PlanVentas planVentas) {
        this.planVentas = planVentas;
    }

    public void copiarValores() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public PlanProduccion getPlanProduccion() {
        if (planProduccion == null){
            planProduccion = new PlanProduccion();
        }
        return planProduccion;
    }

    public void setPlanProduccion(PlanProduccion planProduccion) {
        this.planProduccion = planProduccion;
    }

    public NecesidadInsumo getNecesidadInsumo() {
        if (necesidadInsumo == null){
            necesidadInsumo = new NecesidadInsumo();
        }
        return necesidadInsumo;
    }

    public void setNecesidadInsumo(NecesidadInsumo necesidadInsumo) {
        this.necesidadInsumo = necesidadInsumo;
    }

    public PlanCompras getPlanCompras() {
        if (planCompras == null){
            planCompras = new PlanCompras();
        }
        return planCompras;
    }

    public void setPlanCompras(PlanCompras planCompras) {
        this.planCompras = planCompras;
    }
    
    
    
    
}
