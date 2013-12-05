/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.facade.empresa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.entidades.empresa.Servicio;
import sistema.modelos.server.facade.general.AbstractFacade;

/**
 *
 * @author YURI
 */
@Stateless
public class ServicioFacade extends AbstractFacade<Servicio> {

    @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  ServicioFacade(){
            super(Servicio.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public int countActivoByCode(String codigo,Long id) {
        Query q = getEntityManager().createQuery("Select s from Servicio s where s.codigo = :cod"+(id!=null?" and s.idServicio <> :id":""));
        q.setParameter("cod", codigo);
        if (id != null)
   q.setParameter("id", id);
        int i = q.getResultList().size();
        System.out.println("tamano:"+i+codigo+id+"111");
        return i;
    }
    
}
