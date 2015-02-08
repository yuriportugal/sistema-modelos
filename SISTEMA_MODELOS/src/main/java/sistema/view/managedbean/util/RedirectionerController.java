/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.view.managedbean.util;

import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import sistema.modelos.vista.controlador.modelo.ModeloControlador;
import sistema.modelos.vista.controlador.util.UsuarioControlador;

/**
 *
 * @author YURI
 */
@ManagedBean(name = "redirectionerController")
@RequestScoped
public class RedirectionerController {
    
    @ManagedProperty(value="#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;
    
    @ManagedProperty(value="#{modeloControlador}")
    private ModeloControlador modeloControlador;
    
    
    public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }

    public ModeloControlador getModeloControlador() {
        return modeloControlador;
    }

    public void setModeloControlador(ModeloControlador modeloControlador) {
        this.modeloControlador = modeloControlador;
    }
    
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
    public String balanceInicial(){
        return "/EMPRESA/BALANCE_INICIAL/BALANCEINICIAL";
    }
    
     public String crearModelo(){
         
     getModeloControlador().getCurrentModelo().setACCajaBanco(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiCajaBancos()));
     getModeloControlador().getCurrentModelo().setACCredFiscal(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiCreditoFiscal()));
     getModeloControlador().getCurrentModelo().setACCuentaxCobrar(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiCuentasXCobrar()));
     getModeloControlador().getCurrentModelo().setACInsumos(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiExistInsumos()));
     getModeloControlador().getCurrentModelo().setACProductosTerminados(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiExistProdTerminados()));
     getModeloControlador().getCurrentModelo().setANCActivoFijo(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiActivosFijos()));
     getModeloControlador().getCurrentModelo().setANCAmortAcumulada(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiAmortAcumulada()));
     getModeloControlador().getCurrentModelo().setANCDepreciacionAcum(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiDeprecAcumulada()));
     getModeloControlador().getCurrentModelo().setANCIntangible(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiIntangibles()));
     getModeloControlador().getCurrentModelo().setANCValNegociable(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiValoresNegociables()));
     getModeloControlador().getCurrentModelo().setPCCuentaxCobrarProveedores(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiCuentasXPagarProv()));
     getModeloControlador().getCurrentModelo().setPCCuentaxCobrarSobregiro(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiCuentasxPagarSobregiro()));
     getModeloControlador().getCurrentModelo().setPCDirBuenaGest(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiDirecBuenaGestion()));
     getModeloControlador().getCurrentModelo().setPCDividendoxPag(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiDividendos()));
     getModeloControlador().getCurrentModelo().setPCIGVxPagar(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiIGV()));
     getModeloControlador().getCurrentModelo().setPCImpuestoRenta(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiImpuestoRenta()));
     getModeloControlador().getCurrentModelo().setPCPartixPagar(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiParticipaciones()));
     getModeloControlador().getCurrentModelo().setPCPrestxPagarCortoPlazo(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiPrestamosCortoPlazo()));
     getModeloControlador().getCurrentModelo().setPNCDeudaLargoPlazo(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiDeudasLargoPlazo()));
     getModeloControlador().getCurrentModelo().setPATCapitalSocial(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiCapitalSocial()));
     getModeloControlador().getCurrentModelo().setPATReservaLegal(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiReservaLegalAcum()));
     getModeloControlador().getCurrentModelo().setPATResultadoAcumulado(new BigDecimal(getUsuarioControlador().getCurrentUsuario().getEmpresa().getBiResultAcumulados()));
     
     
                     
           
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         
        return "/MODELO/CREARMODELO";
    }
    public String listarModelo(){
        return "/MODELO/LISTARMODELO";
    }
     
}
