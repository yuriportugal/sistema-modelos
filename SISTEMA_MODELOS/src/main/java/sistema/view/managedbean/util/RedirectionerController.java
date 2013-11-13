/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.view.managedbean.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "redirectionerController")
@RequestScoped
public class RedirectionerController {

    
    public RedirectionerController() {
    }
    
    public String insumo(){
        return "/EMPRESA/INSUMO/INSUMO";
    }
    
    public String producto(){
        return "/EMPRESA/PRODUCTO/PRODUCTO";
    }
    
     public String activo(){
        return "/EMPRESA/ACTIVO/ACTIVO";
    }
     
     public String cargo(){
        return "/EMPRESA/CARGO/CARGO";
    }
     
    public String servicio(){
        return "/EMPRESA/SERVICIO/SERVICIO";
    }
}
