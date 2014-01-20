/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.facade.modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistema.modelos.server.entidades.modelo.TipoPeriodo;
import sistema.modelos.server.entidades.modelo.TipoPrestamo;
import sistema.modelos.server.facade.general.AbstractFacade;

/**
 *
 * @author YURI
 */
@Stateless
public class TipoPrestamoFacade extends AbstractFacade<TipoPrestamo> {
     @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  TipoPrestamoFacade(){
            super(TipoPrestamo.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
