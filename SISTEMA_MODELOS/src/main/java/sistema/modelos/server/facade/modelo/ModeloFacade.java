/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package sistema.modelos.server.facade.modelo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sistema.modelos.server.entidades.modelo.Modelo;
import sistema.modelos.server.facade.general.AbstractFacade;

/**
 *
 * @author YURI
 */
@Stateless
public class ModeloFacade extends AbstractFacade<Modelo> {
     @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  ModeloFacade(){
            super(Modelo.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Modelo> findCorridas(){
         Query q = getEntityManager().createQuery("Select m from Modelo m where m.parentModelo IS NOT NULL ");
         return q.getResultList();
       }
    
    public List<Modelo> findModelos(){
         Query q = getEntityManager().createQuery("Select m from Modelo m where m.parentModelo IS NULL ");
         return q.getResultList();
       }

    public List<Modelo> findCorridasByEmpresa(Long idEmpresa) {
        Query q = getEntityManager().createQuery("Select m from Modelo m where m.parentModelo IS NOT NULL and  m.empresa.idEmpresa = :idEmpresa ");
         q.setParameter("idEmpresa", idEmpresa); 
        return q.getResultList();
    }

    public List<Modelo> findModelosByEmpresa(Long idEmpresa) {
         Query q = getEntityManager().createQuery("Select m from Modelo m where m.parentModelo IS  NULL and  m.empresa.idEmpresa = :idEmpresa");
         q.setParameter("idEmpresa", idEmpresa);
         return q.getResultList();
    }
}
