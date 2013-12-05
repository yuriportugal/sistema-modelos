/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.facade.empresa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.facade.general.AbstractFacade;

/**
 *
 * @author YURI
 */
@Stateless
public class InsumoFacade extends AbstractFacade<Insumo> {

    @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  InsumoFacade(){
            super(Insumo.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
   public int countActivoByCode(String codigo, Long id) {
        Query q = getEntityManager().createQuery("Select i from Insumo i where i.codigo = :cod"+(id!=null?" and i.idInsumo <> :id":""));
        q.setParameter("cod", codigo);
        if (id != null)
        q.setParameter("id", id);
        
        int i = q.getResultList().size();
        System.out.println("tamano:"+i+codigo);
        return i;
    }
    
}
