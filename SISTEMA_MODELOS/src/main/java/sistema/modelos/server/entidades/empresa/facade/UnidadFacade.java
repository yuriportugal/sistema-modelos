/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.empresa.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.empresa.Unidad;
import sistema.modelos.server.entidades.general.AbstractFacade;

/**
 *
 * @author YURI
 */
@Stateless
public class UnidadFacade extends AbstractFacade<Unidad> {

    @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  UnidadFacade(){
            super(Unidad.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
   
    
}
