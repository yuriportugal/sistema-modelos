/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.facade.empresa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistema.modelos.server.entidades.empresa.TipoActivo;
import sistema.modelos.server.facade.general.AbstractFacade;

/**
 *
 * @author YURI
 */
@Stateless
public class TipoActivoFacade extends AbstractFacade<TipoActivo> {

    @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  TipoActivoFacade(){
            super(TipoActivo.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
