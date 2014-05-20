/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.facade.util;

import sistema.modelos.server.facade.empresa.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.entidades.empresa.Servicio;
import sistema.modelos.server.entidades.util.Usuario;
import sistema.modelos.server.facade.general.AbstractFacade;
 
/**
 *
 * @author YURI
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  UsuarioFacade(){
            super(Usuario.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Usuario findByCode(String codUsuario) {
        Query q = getEntityManager().createQuery("Select u from Usuario u where u.codUsuario = :cod");
        q.setParameter("cod", codUsuario);
        return (Usuario)q.getResultList().get(0);
    }


}
  