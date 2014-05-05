/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.facade.empresa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.facade.general.AbstractFacade;

/**
 *
 * @author YURI
 */
@Stateless
public class ActivoFacade extends AbstractFacade<Activo> {

    @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  ActivoFacade(){
            super(Activo.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public int countActivoByCode(String codigo,Long id) {
        Query q = getEntityManager().createQuery("Select a from Activo a where a.codigo = :cod"+(id!=null?" and a.idActivo <> :id":""));
        q.setParameter("cod", codigo);
        if (id != null)
        q.setParameter("id", id);
        int i = q.getResultList().size();
        System.out.println("tamano:"+i+codigo+id+"111");
        return i;
    }
    
    public List<Activo> findAllByEmpresa(Long idEmpresa){
        Query q = getEntityManager().createQuery("Select a from Activo a where a.empresa.idEmpresa = :idEmpresa");
        q.setParameter("idEmpresa", idEmpresa);
        return q.getResultList();
        
    }
    
}
