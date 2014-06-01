/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.resultado;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import sistema.modelos.server.entidades.empresa.Activo;
import sistema.modelos.server.entidades.empresa.Cargo;
import sistema.modelos.server.entidades.empresa.Insumo;
import sistema.modelos.server.entidades.modelo.ModeloFormulacionInsumo;
import sistema.modelos.server.entidades.modelo.ModeloFormulacionMaquinaria;
import sistema.modelos.server.entidades.modelo.ModeloFormulacionPersonal;
import sistema.modelos.server.entidades.modelo.ProductoModeloDetalle;

/**
 *
 * @author Orci
 */
public class Formulacion {
    
    private List<FormulacionDetalle> insumoDetFormulacion; //Plan de Compras
    private List<FormulacionDetalle> personalDetFormulacion; //Personal
    private List<FormulacionDetalle> activoDetFormulacion; //Activo
    public List<FormulacionDetalle> getInsumoDetFormulacion() {
        return insumoDetFormulacion;
    }

    public void setInsumoDetFormulacion(List<FormulacionDetalle> insumoDetFormulacion) {
        this.insumoDetFormulacion = insumoDetFormulacion;
    }

    public List<FormulacionDetalle> getPersonalDetFormulacion() {
        return personalDetFormulacion;
    }

    public void setPersonalDetFormulacion(List<FormulacionDetalle> personalDetFormulacion) {
        this.personalDetFormulacion = personalDetFormulacion;
    }

    public List<FormulacionDetalle> getActivoDetFormulacion() {
        return activoDetFormulacion;
    }

    public void setActivoDetFormulacion(List<FormulacionDetalle> activoDetFormulacion) {
        this.activoDetFormulacion = activoDetFormulacion;
    }
    
    
    public void llenarDetFormulacion(List<ProductoModeloDetalle> lstProductoModeloDetalle){
            insumoDetFormulacion = new ArrayList<FormulacionDetalle>(); //Plan de Compras
            personalDetFormulacion = new ArrayList<FormulacionDetalle>(); //Personal
            activoDetFormulacion = new ArrayList<FormulacionDetalle>();
            crearEstructura(lstProductoModeloDetalle);
            llenarDetalle(lstProductoModeloDetalle);
            
    }

    private void crearEstructura(List<ProductoModeloDetalle> lstProductoModeloDetalle) {
        for (int i = 0; i < lstProductoModeloDetalle.size();i++){
                //Insumo
                for (int j = 0; j < lstProductoModeloDetalle.get(i).getLstModeloFormulacionInsumoDetalle().size();j++){
                    ModeloFormulacionInsumo modeloFormInsumo = lstProductoModeloDetalle.get(i).getLstModeloFormulacionInsumoDetalle().get(j);
                    boolean agregar = true;
                    for (int n = 0; n < insumoDetFormulacion.size();n++){
                        if (modeloFormInsumo.getInsumo().getIdInsumo().equals(((Insumo)insumoDetFormulacion.get(i).getDetalle()).getIdInsumo())){
                            agregar = false;
                        }
                    }
                    FormulacionDetalle formDet = new FormulacionDetalle();
                    formDet.setDetalle(modeloFormInsumo.getInsumo());
                    if (agregar) insumoDetFormulacion.add(formDet);
               }
                
                //Personal
                for (int p = 0; p < lstProductoModeloDetalle.get(i).getLstModeloFormulacionPersonalDetalle().size();p++){
                    ModeloFormulacionPersonal modeloFormPersonal = lstProductoModeloDetalle.get(i).getLstModeloFormulacionPersonalDetalle().get(p);
                    boolean agregar = true;
                    for (int n = 0; n < personalDetFormulacion.size();n++){
                        if (modeloFormPersonal.getCargo().getIdCargo().equals(((Cargo)personalDetFormulacion.get(i).getDetalle()).getIdCargo())){
                            agregar = false;
                        }
                    }
                    FormulacionDetalle formDet = new FormulacionDetalle();
                    formDet.setDetalle(modeloFormPersonal.getCargo());
                    if (agregar) personalDetFormulacion.add(formDet);
                }
                //Activo
                for (int a = 0; a < lstProductoModeloDetalle.get(i).getLstModeloFormulacionMaquinariaDetalle().size();a++){
                    ModeloFormulacionMaquinaria modeloActivo = lstProductoModeloDetalle.get(i).getLstModeloFormulacionMaquinariaDetalle().get(a);
                    boolean agregar = true;
                    for (int n = 0; n < activoDetFormulacion.size();n++){
                        if (modeloActivo.getActivo().getIdActivo().equals(((Activo)activoDetFormulacion.get(i).getDetalle()).getIdActivo())){
                            agregar = false;
                        }
                    }
                    FormulacionDetalle formDet = new FormulacionDetalle();
                    formDet.setDetalle(modeloActivo.getActivo());
                    if (agregar) activoDetFormulacion.add(formDet);
                }
                
            }
    }

    
    
    private void llenarDetalle(List<ProductoModeloDetalle> lstProductoModeloDetalle) {
        for (int i = 0; i < insumoDetFormulacion.size();i++){
            List<ProductoFormulacion> lstProdForm= filtrarxInsumo(lstProductoModeloDetalle,(Insumo)insumoDetFormulacion.get(i).getDetalle());
            insumoDetFormulacion.get(i).setLstProdFormulacion(lstProdForm);
        }
        for (int p = 0; p < personalDetFormulacion.size();p++){
            List<ProductoFormulacion> lstProdForm= filtrarxPersonal(lstProductoModeloDetalle,(Cargo)personalDetFormulacion.get(p).getDetalle());
            personalDetFormulacion.get(p).setLstProdFormulacion(lstProdForm);
        }
        for (int a = 0; a < activoDetFormulacion.size();a++){
            List<ProductoFormulacion> lstProdForm= filtrarxActivo(lstProductoModeloDetalle,(Activo)activoDetFormulacion.get(a).getDetalle());
            insumoDetFormulacion.get(a).setLstProdFormulacion(lstProdForm);
        }
        
    }

    private List<ProductoFormulacion> filtrarxInsumo(List<ProductoModeloDetalle> lstProductoModeloDetalle, Insumo insumo) {
        List<ProductoFormulacion> lstProdForm = new ArrayList<ProductoFormulacion>();
        for (ProductoModeloDetalle prodModDet : lstProductoModeloDetalle){
            for (ModeloFormulacionInsumo modFormInsumo : prodModDet.getLstModeloFormulacionInsumoDetalle()){
                if (insumo.getIdInsumo().equals(modFormInsumo.getInsumo().getIdInsumo())){
                    ProductoFormulacion prodForm = new ProductoFormulacion();
                    prodForm.setProducto(prodModDet.getProducto());
                    prodForm.setCantidad(prodForm.getCantidad());
                    lstProdForm.add(prodForm);
                }
            }
        }
        return lstProdForm;
    }

    private List<ProductoFormulacion> filtrarxPersonal(List<ProductoModeloDetalle> lstProductoModeloDetalle, Cargo cargo) {
        List<ProductoFormulacion> lstProdForm = new ArrayList<ProductoFormulacion>();
        for (ProductoModeloDetalle prodModDet : lstProductoModeloDetalle){
            for (ModeloFormulacionPersonal modFormPersonal : prodModDet.getLstModeloFormulacionPersonalDetalle()){
                if (cargo.getIdCargo().equals(modFormPersonal.getCargo().getIdCargo())){
                    ProductoFormulacion prodForm = new ProductoFormulacion();
                    prodForm.setProducto(prodModDet.getProducto());
                    prodForm.setCantidad(modFormPersonal.getHoraHombre());
                    lstProdForm.add(prodForm);
                }
            }
        }
        return lstProdForm;
    }

    private List<ProductoFormulacion> filtrarxActivo(List<ProductoModeloDetalle> lstProductoModeloDetalle, Activo activo) {
       List<ProductoFormulacion> lstProdForm = new ArrayList<ProductoFormulacion>();
        for (ProductoModeloDetalle prodModDet : lstProductoModeloDetalle){
            for (ModeloFormulacionMaquinaria modFormActivo : prodModDet.getLstModeloFormulacionMaquinariaDetalle()){
                if (activo.getIdActivo().equals(modFormActivo.getActivo().getIdActivo())){
                    ProductoFormulacion prodForm = new ProductoFormulacion();
                    prodForm.setProducto(prodModDet.getProducto());
                    prodForm.setCantidad(modFormActivo.getHoraMaquina());
                    lstProdForm.add(prodForm);
                }
            }
        }
        return lstProdForm;
    }
    
}
