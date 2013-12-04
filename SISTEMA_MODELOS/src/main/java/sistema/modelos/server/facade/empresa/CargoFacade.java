/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.facade.empresa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sistema.modelos.server.entidades.empresa.Cargo;
import sistema.modelos.server.facade.general.AbstractFacade;

/**
 *
 * @author YURI
 */
@Stateless
public class CargoFacade extends AbstractFacade<Cargo> {

    @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  CargoFacade(){
            super(Cargo.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public int countActivoByCode(String codigo) {
        Query q = getEntityManager().createQuery("Select c from Cargo c where c.codigo = :cod ");
        q.setParameter("cod", codigo);
        int i = q.getResultList().size();
        System.out.println("tamano:"+i+codigo);
        return i;
    }
    
}