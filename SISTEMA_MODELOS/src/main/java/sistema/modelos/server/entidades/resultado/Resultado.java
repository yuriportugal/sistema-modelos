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
    
    
    
   
    
}
