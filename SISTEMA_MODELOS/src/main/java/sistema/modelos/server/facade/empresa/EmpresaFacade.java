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
import sistema.modelos.server.entidades.empresa.Empresa;
import sistema.modelos.server.entidades.empresa.Servicio;
import sistema.modelos.server.facade.general.AbstractFacade;
 
/**
 *
 * @author YURI
 */
@Stateless
public class EmpresaFacade extends AbstractFacade<Empresa> {

    @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  EmpresaFacade(){
            super(Empresa.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}
