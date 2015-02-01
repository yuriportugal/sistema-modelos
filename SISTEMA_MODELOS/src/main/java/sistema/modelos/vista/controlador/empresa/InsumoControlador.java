/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.empresa;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.facade.empresa.EmpresaFacade;
import sistema.modelos.server.facade.empresa.InsumoFacade;
import sistema.modelos.vista.controlador.util.UsuarioControlador;
import sistema.modelos.vista.controlador.util.Utilitario;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "insumoControlador")
@SessionScoped
public class InsumoControlador implements Serializable {
    @EJB
    private InsumoFacade insumoFacade;
    
    @EJB
    private EmpresaFacade empresaFacade;
    
    @ManagedProperty(value="#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;
    
    
    Long idInsumo;
    List<Insumo> lstInsumo;
    
    public Insumo currentInsumo;
    
    public InsumoControlador() {
        
      
    }

    public Insumo getCurrentInsumo() {
        return currentInsumo;
    }

    public void setCurrentInsumo(Insumo currentInsumo) {
        this.currentInsumo = currentInsumo;
    }
    
    public List<Insumo> getLstInsumos() {
        lstInsumo = insumoFacade.findAllByEmpresa(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa());
        
        return lstInsumo;
    }
    
    public Insumo getInsumo(){
        if (currentInsumo == null){
            currentInsumo = new Insumo();
        }
        return currentInsumo;
    }
    
    public void persist(){
        currentInsumo.setEmpresa(empresaFacade.find(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa()));     
        if (insumoFacade.countActivoByCode(currentInsumo.getCodigo(),currentInsumo.getIdInsumo())>0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya se encuentra registrado un insumo con el mismo código",""));  
                return;
             }
            System.out.println("Entramos veremos que pasa");
            if (currentInsumo.getIdInsumo()==null) {
                insumoFacade.create(currentInsumo);
            }
            else {
                insumoFacade.edit(currentInsumo);
            }
            RequestContext context = RequestContext.getCurrentInstance();  

            lstInsumo = getLstInsumos();
            currentInsumo = new Insumo();
            context.update("miform:tablaInsumo");
            context.update("cruForm:panelcrud");
          
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Insumo grabado correctamente",""));  
    
    } 
    
    public void getEditarInsumo(){
        System.out.println("ID:::xx "+idInsumo);
        currentInsumo = insumoFacade.find(idInsumo);
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("cruForm:panelcrud");
        
    }

    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Long getIdInsumo() {
        return idInsumo;
    }
    
    public void agregar(){
        
        Utilitario.clear("cruForm:nombre");
        Utilitario.clear("cruForm:codigo");
        Utilitario.clear("cruForm:descripcion");
        currentInsumo = new Insumo();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaInsumo");
        context.update("cruForm:panelcrud");
    
    }
    
    public void editar(){
        Utilitario.clear("cruForm:nombre");
        Utilitario.clear("cruForm:codigo");
        Utilitario.clear("cruForm:descripcion");
        currentInsumo = insumoFacade.find(currentInsumo.getIdInsumo());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaInsumo");
        context.update("cruForm:panelcrud");
        
    }
    
    public void eliminar(){
        currentInsumo = insumoFacade.find(currentInsumo.getIdInsumo());
        insumoFacade.remove(currentInsumo);
        RequestContext.getCurrentInstance().execute("ConfirmDlg.hide()");
        agregar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Insumo eliminado correctamente",""));  
      }
    
    public void showConfirm(){
       RequestContext.getCurrentInstance().execute("ConfirmDlg.show()");
      }
    
    
    public void closeConfirm(){
       RequestContext.getCurrentInstance().execute("ConfirmDlg.hide()");
    }

    public InsumoFacade getInsumoFacade() {
        return insumoFacade;
    }

    public void setInsumoFacade(InsumoFacade insumoFacade) {
        this.insumoFacade = insumoFacade;
    }
     public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }
    
}
