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
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;
import sistema.modelos.server.facade.general.AbstractFacade;

/**
 *
 * @author YURI
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "com.mycompany_SISTEMA_MODELOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

     public  ProductoFacade(){
            super(Producto.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
   public int countActivoByCode(String codigo,Long id) {
        Query q = getEntityManager().createQuery("Select p from Producto p where p.codigo = :cod"+(id!=null?" and p.idproducto <> :id ":""));
        q.setParameter("cod", codigo);
        if (id != null)
        q.setParameter("id", id);
        int i = q.getResultList().size();
        System.out.println("tamano:"+i+codigo);
        return i;
    }

    public List<Producto> findAllWithFilter(List<ProductoModeloDetalle> lstProductoModeloDetalle) {
        String idFormat = "";
        for (int i = 0; i < lstProductoModeloDetalle.size();i++){
            if (i < 0){
                
                idFormat += ","+lstProductoModeloDetalle.get(i).getProducto().getIdproducto();
            }else{
                idFormat += lstProductoModeloDetalle.get(i).getProducto().getIdproducto();
            }
        }
        Query q = getEntityManager().createQuery("Select p from Producto p"+(lstProductoModeloDetalle.size()>0?" where p.idproducto NOT IN ("+idFormat+")":""));
        return q.getResultList();
        
    }
    
        public List<Producto> findAllByEmpresa(Long idEmpresa){
        Query q = getEntityManager().createQuery("Select p from Producto p where p.empresa.idEmpresa = :idEmpresa");
        q.setParameter("idEmpresa", idEmpresa);
        return q.getResultList();
        
    }

    
    
}
