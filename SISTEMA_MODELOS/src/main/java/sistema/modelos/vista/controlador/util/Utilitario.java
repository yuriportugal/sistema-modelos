/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.vista.controlador.util;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author YURI
 */
public class Utilitario {
    public static String clear(final String parentComponentId) {
        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent fc = view.findComponent(parentComponentId);
                if (fc instanceof UIInput) {
                    UIInput input = (UIInput) fc;
                    // JSF 1.1+ 
//                input.setSubmittedValue(null);
//                input.setValue(null);
//                input.setLocalValueSet(false);
//                input.setValid(true);
                    // JSF 1.2+
                    input.resetValue();
                }
                
            
        return null;
    }
}
