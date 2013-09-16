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
    
    public String Listarproducto(){
       System.out.println("Imprimiendo");
        return "/producto/List";
    }
    
    public String crearProducto(){
        return "/producto/Create";
    }
}
