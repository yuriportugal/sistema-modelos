    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.empresa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.entidades.empresa.Area;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.empresa.Servicio;
import sistema.modelos.server.entidades.empresa.TipoActivo;
import sistema.modelos.server.facade.empresa.ActivoFacade;
import sistema.modelos.server.facade.empresa.AreaFacade;
import sistema.modelos.server.facade.empresa.EmpresaFacade;
import sistema.modelos.server.facade.empresa.InsumoFacade;
import sistema.modelos.server.facade.empresa.ServicioFacade;
import sistema.modelos.server.facade.empresa.TipoActivoFacade;
import sistema.modelos.vista.controlador.util.UsuarioControlador;
import sistema.modelos.vista.controlador.util.Utilitario;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "servicioControlador")
@SessionScoped
public class ServicioControlador implements Serializable {
    @EJB
    private ServicioFacade servicioFacade;
   
    @EJB
    private AreaFacade areaFacade;
    
    @EJB
    private EmpresaFacade empresaFacade;
    
    @ManagedProperty(value="#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;
    
    
    Long idActivo;
    List<Servicio> lstServicio;
    List<Area> lstArea;
    
    public Servicio currentServicio;
    public Area currentArea;
    
    public ServicioControlador() {
    }

    public Servicio getCurrentServicio() {
        if (currentServicio == null){
            currentServicio = new Servicio();
        }
        return currentServicio;
    }

    public Area getCurrentArea() {
        if (currentArea == null)
            currentArea = new Area();
        return currentArea;
    }

        public void persistArea(){
        System.out.print("Persistiendo el área");
        areaFacade.create(currentArea);
        lstArea = getLstArea();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("cruForm:panelcrud");
        currentArea = new Area();
        RequestContext.getCurrentInstance().execute("AreaDlg.hide()");
    }
        
        
        

    public void setCurrentServicio(Servicio currentServicio) {
        this.currentServicio = currentServicio;
    }

    public List<Servicio> getLstServicio() {
        lstServicio = servicioFacade.findAllByEmpresa(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa());
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }
    
   public List<Area> getLstArea() {
        return areaFacade.findAll();
    }
    
     public void persist(){
             
        currentServicio.setEmpresa(empresaFacade.find(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa()));     
        if (servicioFacade.countActivoByCode(currentServicio.getCodigo(),currentServicio.getIdServicio())>0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya se encuentra registrado un servicio con el mismo código",""));  
            return;
        }
            
        
        if (currentServicio.getIdServicio()==null) {
            servicioFacade.create(currentServicio);
        }
        else {
            currentServicio.setArea(areaFacade.find(currentServicio.getArea().getIdArea()));
            servicioFacade.edit(currentServicio);
        }
        RequestContext context = RequestContext.getCurrentInstance();  

        lstServicio = getLstServicio();
        currentServicio = new Servicio();
        context.update("miform:tablaServicio");
        context.update("cruForm:panelcrud");
             
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Servicio grabado correctamente",""));  
    
    }
    
    public void agregar(){
        Utilitario.clear("cruForm:nombre");
        Utilitario.clear("cruForm:codigo");
        Utilitario.clear("cruForm:area");
        currentServicio = new Servicio();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaServicio");
        context.update("cruForm:panelcrud");
    
    }
     
    public void editar(){
         Utilitario.clear("cruForm:nombre");
        Utilitario.clear("cruForm:codigo");
        Utilitario.clear("cruForm:area");
        currentServicio = servicioFacade.find(currentServicio.getIdServicio());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaServicio");
        context.update("cruForm:panelcrud");
        
    } 
    
    public void eliminar(){
        currentServicio = servicioFacade.find(currentServicio.getIdServicio());
        servicioFacade.remove(currentServicio);
        RequestContext.getCurrentInstance().execute("ConfirmDlg.hide()");
        agregar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Activo eliminado correctamente",""));  
      }
    
    public void showConfirm(){
       RequestContext.getCurrentInstance().execute("ConfirmDlg.show()");
      }
    
    
    public void closeConfirm(){
       RequestContext.getCurrentInstance().execute("ConfirmDlg.hide()");
    }
    
     public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }
}
