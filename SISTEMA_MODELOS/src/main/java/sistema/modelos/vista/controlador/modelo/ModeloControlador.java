    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.modelo;

import sistema.modelos.vista.controlador.empresa.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.context.RequestContext;
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.entidades.empresa.Area;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.empresa.TipoActivo;
import sistema.modelos.server.entidades.modelo.Ano;
import sistema.modelos.server.entidades.modelo.Modelo;
import sistema.modelos.server.entidades.modelo.TipoPeriodo;
import sistema.modelos.server.facade.empresa.ActivoFacade;
import sistema.modelos.server.facade.empresa.AreaFacade;
import sistema.modelos.server.facade.empresa.InsumoFacade;
import sistema.modelos.server.facade.empresa.TipoActivoFacade;
import sistema.modelos.server.facade.modelo.AnoFacade;
import sistema.modelos.server.facade.modelo.TipoPeriodoFacade;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "modeloControlador")
@SessionScoped
public class ModeloControlador implements Serializable {
  
    @EJB
    private TipoPeriodoFacade tipoPeriodoFacade;
    
    @EJB
    private AnoFacade anoFacade;
    
    private Modelo currentModelo;
    
    public void crearTablaTC() {
        Long size = currentModelo.getHorizonte();
       
       System.out.println(size+"TAMA{{ÑO");
    }
    
    
    public List<TipoPeriodo> getLstTipoPeriodo(){
        return tipoPeriodoFacade.findAll();
    }
    
    public List<Ano> getLstAno(){
        return anoFacade.findAll();
    }
    
  

    public TipoPeriodoFacade getTipoPeriodoFacade() {
        return tipoPeriodoFacade;
    }

    public void setTipoPeriodoFacade(TipoPeriodoFacade tipoPeriodoFacade) {
        this.tipoPeriodoFacade = tipoPeriodoFacade;
    }

    public AnoFacade getAnoFacade() {
        return anoFacade;
    }

    public void setAnoFacade(AnoFacade anoFacade) {
        this.anoFacade = anoFacade;
    }

    public Modelo getCurrentModelo() {
       if (currentModelo == null)
           currentModelo = new Modelo();
        return currentModelo;
    }

    public void setCurrentModelo(Modelo currentModelo) {
        this.currentModelo = currentModelo;
    }
    
    
}
