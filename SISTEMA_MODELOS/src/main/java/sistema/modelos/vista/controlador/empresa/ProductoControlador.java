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
import sistema.modelos.server.entidades.empresa.Producto;
import sistema.modelos.server.facade.empresa.EmpresaFacade;
import sistema.modelos.server.facade.empresa.ProductoFacade;
import sistema.modelos.vista.controlador.util.UsuarioControlador;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "productoControlador")
@SessionScoped
public class ProductoControlador implements Serializable {
    @EJB
    private ProductoFacade productoFacade;
    
    @EJB
    private EmpresaFacade empresaFacade;
    
    @ManagedProperty(value="#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;
    
    
    Long idProducto;
    
    List<Producto> lstProductos;
    
    public Producto currentProducto;
    
    public ProductoControlador() {
        System.out.println("A VER INSTANCIANDOOO PRODUCTOOOO");
    }

    public Producto getCurrentProducto() {
        return currentProducto;
    }

    public void setCurrentProducto(Producto currentProducto) {
        this.currentProducto = currentProducto;
    }
    
    
    
    public List<Producto> getLstProductos() {
        lstProductos = productoFacade.findAllByEmpresa(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa());
        return lstProductos;
    }
    
    public Producto getProducto(){
        if (currentProducto == null){
            currentProducto = new Producto();
        }
        return currentProducto;
    }
    
    public void persist(){
        
             String mensaje = "";
             System.out.println(currentProducto.getNombre());
             currentProducto.setEmpresa(empresaFacade.find(getUsuarioControlador().getCurrentUsuario().getEmpresa().getIdEmpresa()));
             if (currentProducto.getNombre().equals(""))
                mensaje += "Debe ingresar el nombre del Producto <br/>";
             if (currentProducto.getCodigo().equals(""))
                mensaje += "Debe ingresar el código del Producto <br/>";
             if (currentProducto.getDescripcion().equals(""))
                mensaje += "Debe ingresar la descripcion del Producto <br/>";
             
             if (!mensaje.equals("")){    
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensaje,""));  
                return;
             }
             
             if (productoFacade.countActivoByCode(currentProducto.getCodigo(),currentProducto.getIdproducto())>0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya se encuentra registrado un producto con el mismo código",""));  
                return;
             }
                                      
            if (currentProducto.getIdproducto()==null) {
                productoFacade.create(currentProducto);
            }
            else {
                productoFacade.edit(currentProducto);
            }
        RequestContext context = RequestContext.getCurrentInstance();  

        lstProductos = getLstProductos();
        currentProducto = new Producto();
        context.update("miform:tablaProducto");
        context.update("cruForm:panelcrud");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto grabado correctamente",""));  

    } 
    
    public void getEditarInsumo(){
        System.out.println("ID:::xx "+idProducto);
        currentProducto = productoFacade.find(idProducto);
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("cruForm:panelcrud");
        
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void agregar(){        
        System.out.println(" ENTRO A AGREGAR PRODUCTO");
        currentProducto = new Producto();
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaProducto");
        context.update("cruForm:panelcrud");
    }
    
    public void editar(){
        System.out.println(" ENTRO A EDITAR PRODUCTO");
        currentProducto = productoFacade.find(currentProducto.getIdproducto());
        RequestContext context = RequestContext.getCurrentInstance();  
        context.update("miform:tablaInsumo");
        context.update("cruForm:panelcrud");
        
    }
    
    public void eliminar(){
        System.out.println(" ENTRO A ELIMINAR PRODUCTO");
        currentProducto = productoFacade.find(currentProducto.getIdproducto());
        productoFacade.remove(currentProducto);
        RequestContext.getCurrentInstance().execute("ConfirmDlg.hide()");
        agregar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto eliminado correctamente","")); 
    }
    
    public void showConfirm(){
       RequestContext.getCurrentInstance().execute("ConfirmDlg.show()");
      }
    
    
    public void closeConfirm(){
       RequestContext.getCurrentInstance().execute("ConfirmDlg.hide()");
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }
    
     public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }
    
    
}
