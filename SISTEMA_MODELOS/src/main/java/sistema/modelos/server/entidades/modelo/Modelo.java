/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;

import sistema.modelos.server.entidades.empresa.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Null;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "MODELO")
public class Modelo implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODELO_SEQ")
    @SequenceGenerator(name = "MODELO_SEQ", sequenceName = "MODELO_SEQ",allocationSize = 1)
    @Column(name="ID_MODELO")
    private Long idModelo;

    @Column(name="CODIGO")
    private String codigo;

    @ManyToOne
    @Null 
    @JoinColumn(name="ID_EMPRESA")
    private Empresa empresa;

    @ManyToOne
    @Null 
    @JoinColumn(name="ID_TIPO_MODELO")
    private TipoModelo tipoModelo;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="DESCRIPCION")
    private String descripcion;   
    
    @Column(name="FECHA_CREACION")
    @Null 
    private Date fechaCreacion;
    
    @ManyToOne
    @JoinColumn(name="ID_TIPO_PERIODO")
    private TipoPeriodo tipoPeriodo;
    
    @Column(name="HORIZONTE")
    private Long horizonte;
    
    @Column(name="DIAS_TRABAJO")
    private Long diasTrabajo;
    
    @ManyToOne 
    @JoinColumn(name="ID_ANO")
    private Ano ano;
    
    
    @ManyToOne
    @Null 
    @JoinColumn(name="ID_MES")
    private Mes mes;
    
//     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
//     private List<TipoCambioDetalle> lstTcDetalle;
//    
//    
//     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
//     private List<PorcentajeVentaDetalle> lstPcVenta;
//    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
     private List<ProductoModeloDetalle> lstProductoModeloDetalle;
//    
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
     private List <InsumoModeloDetalle> lstInsumoModeloDetalle;
//
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
     private List<ActivoModeloDetalle> lstActivoModeloDetalle;
//
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
     private List<CargoModeloDetalle> lstCargoModeloDetalle;
 
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
     private List<ServicioModeloDetalle> lstServicioModeloDetalle;
 
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
     private List<PrestamoModeloDetalle> lstPrestamoModeloDetalle;
 
     //Cobranzas
     @Column(name="PORC_VENTAS_CONTADO")
     private Long porcVentasContado;
     @Column(name="PORC_VENTAS_CREDITO")
     private Long porcVentasCredito;
     @Column(name="PORC_VENTAS_INCOBRABLES")        
     private Long porcVentasIncobrables;
     @Column(name="PORC_DEUDA_COB_PER")
     private Long porcDeudaCobradaPeriodo;
     @Column(name="POR_DEU_COB_PER_SIG")
     private Long porcDeudaCobradaSgtePeriodo;
     //pagos
     @Column(name="PORC_COMPRAS_CONTADO")
     private Long porcComprasContado;
     @Column(name="PORC_COMPRAS_CRED")        
     private Long porcComprasCredito;
     @Column(name="PORC_COMP_PAG_PER")     
     private Long porcCompraPagadaPeriodo;
     @Column(name="PORC_COMP_PAG_PER_SGTE")   
     private Long porcCompraPagadaSgtePeriodo;       
     //Balance Inicial  
    
     //ACTIVO CORRIENTE
     
     @Column(name="AC_CAJA_BANCO")
     private Long ACCajaBanco;
     @Column(name="AC_CRED_FISCAL")
     private Long ACCredFiscal;
     @Column(name="AC_CTA_COBRAR")
     private Long ACCuentaxCobrar;
     @Column(name="AC_INSUMOS")
     private Long ACInsumos;
     @Column(name="AC_PRODUCTO_TERMINADO")
     private Long ACProductosTerminados;
     @Column(name="ANC_ACTIVO_FIJO")
     private Long ANCActivoFijo;
     @Column(name="ANC_DEPRE_ACUMU")
     private Long ANCDepreciacionAcum;
     @Column(name="ANC_INTANGIBLE")
     private Long ANCIntangible;
     @Column(name="ANC_AMORT_ACUMU")
     private Long ANCAmortAcumulada;
     @Column(name="ANC_VAL_NEGOCIABLE")
     private Long ANCValNegociable;
     @Column(name="PC_CCXPP_PROV")
     private Long PCCuentaxCobrarProveedores;
     @Column(name="PC_CCXPP_SOBREGIRO")
     private Long PCCuentaxCobrarSobregiro;
     @Column(name="PC_IGV_X_PAG")
     private Long PCIGVxPagar;
     @Column(name="PC_PREST_X_PAG_CORTO")
     private Long PCPrestxPagarCortoPlazo;
     @Column(name="PC_PART_X_PAGAR")
     private Long PCPartixPagar;
     @Column(name="PC_DIR_BUEN_GEST_X_PAG")
     private Long PCDirBuenaGest;
     @Column(name="PC_IMP_RENT_X_PAG")
     private Long PCImpuestoRenta;
     @Column(name="PC_DIV_X_PAGAR")
     private Long PCDividendoxPag;
     @Column(name="PNC_DEUD_LARG_PLAZO")
     private Long PNCDeudaLargoPlazo;
     @Column(name="PAT_CAP_SOCIAL")
     private Long PATCapitalSocial;
     @Column(name="PAT_RESER_LEGAL_ACUM")
     private Long PATReservaLegal;
     @Column(name="PT_RESUL_ACUM")
     private Long PATResultadoAcumulado;

    public Long getACCajaBanco() {
        return ACCajaBanco;
    }

    public Long getACCredFiscal() {
        return ACCredFiscal;
    }

    public Long getACCuentaxCobrar() {
        return ACCuentaxCobrar;
    }

    public Long getACInsumos() {
        return ACInsumos;
    }

    public Long getACProductosTerminados() {
        return ACProductosTerminados;
    }

    public Long getANCActivoFijo() {
        return ANCActivoFijo;
    }

    public Long getANCAmortAcumulada() {
        return ANCAmortAcumulada;
    }

    public Long getANCDepreciacionAcum() {
        return ANCDepreciacionAcum;
    }

    public Long getANCIntangible() {
        return ANCIntangible;
    }

    public Long getANCValNegociable() {
        return ANCValNegociable;
    }

    public Long getPATCapitalSocial() {
        return PATCapitalSocial;
    }

    public Long getPATReservaLegal() {
        return PATReservaLegal;
    }

    public Long getPATResultadoAcumulado() {
        return PATResultadoAcumulado;
    }

    public Long getPCCuentaxCobrarProveedores() {
        return PCCuentaxCobrarProveedores;
    }

    public Long getPCCuentaxCobrarSobregiro() {
        return PCCuentaxCobrarSobregiro;
    }

    public Long getPCDirBuenaGest() {
        return PCDirBuenaGest;
    }

    public Long getPCDividendoxPag() {
        return PCDividendoxPag;
    }

    public Long getPCIGVxPagar() {
        return PCIGVxPagar;
    }

    public Long getPCImpuestoRenta() {
        return PCImpuestoRenta;
    }

    public Long getPCPartixPagar() {
        return PCPartixPagar;
    }

    public Long getPCPrestxPagarCortoPlazo() {
        return PCPrestxPagarCortoPlazo;
    }

    public Long getPNCDeudaLargoPlazo() {
        return PNCDeudaLargoPlazo;
    }

    public void setACCajaBanco(Long ACCajaBanco) {
        this.ACCajaBanco = ACCajaBanco;
    }

    public void setACCredFiscal(Long ACCredFiscal) {
        this.ACCredFiscal = ACCredFiscal;
    }

    public void setACCuentaxCobrar(Long ACCuentaxCobrar) {
        this.ACCuentaxCobrar = ACCuentaxCobrar;
    }

    public void setACInsumos(Long ACInsumos) {
        this.ACInsumos = ACInsumos;
    }

    public void setACProductosTerminados(Long ACProductosTerminados) {
        this.ACProductosTerminados = ACProductosTerminados;
    }

    public void setANCActivoFijo(Long ANCActivoFijo) {
        this.ANCActivoFijo = ANCActivoFijo;
    }

    public void setANCAmortAcumulada(Long ANCAmortAcumulada) {
        this.ANCAmortAcumulada = ANCAmortAcumulada;
    }

    public void setANCDepreciacionAcum(Long ANCDepreciacionAcum) {
        this.ANCDepreciacionAcum = ANCDepreciacionAcum;
    }

    public void setANCIntangible(Long ANCIntangible) {
        this.ANCIntangible = ANCIntangible;
    }

    public void setANCValNegociable(Long ANCValNegociable) {
        this.ANCValNegociable = ANCValNegociable;
    }

    public void setPATCapitalSocial(Long PATCapitalSocial) {
        this.PATCapitalSocial = PATCapitalSocial;
    }

    public void setPATReservaLegal(Long PATReservaLegal) {
        this.PATReservaLegal = PATReservaLegal;
    }

    public void setPATResultadoAcumulado(Long PATResultadoAcumulado) {
        this.PATResultadoAcumulado = PATResultadoAcumulado;
    }

    public void setPCCuentaxCobrarProveedores(Long PCCuentaxCobrarProveedores) {
        this.PCCuentaxCobrarProveedores = PCCuentaxCobrarProveedores;
    }

    public void setPCCuentaxCobrarSobregiro(Long PCCuentaxCobrarSobregiro) {
        this.PCCuentaxCobrarSobregiro = PCCuentaxCobrarSobregiro;
    }

    public void setPCDirBuenaGest(Long PCDirBuenaGest) {
        this.PCDirBuenaGest = PCDirBuenaGest;
    }

    public void setPCDividendoxPag(Long PCDividendoxPag) {
        this.PCDividendoxPag = PCDividendoxPag;
    }

    public void setPCIGVxPagar(Long PCIGVxPagar) {
        this.PCIGVxPagar = PCIGVxPagar;
    }

    public void setPCImpuestoRenta(Long PCImpuestoRenta) {
        this.PCImpuestoRenta = PCImpuestoRenta;
    }

    public void setPCPartixPagar(Long PCPartixPagar) {
        this.PCPartixPagar = PCPartixPagar;
    }

    public void setPCPrestxPagarCortoPlazo(Long PCPrestxPagarCortoPlazo) {
        this.PCPrestxPagarCortoPlazo = PCPrestxPagarCortoPlazo;
    }

    public void setPNCDeudaLargoPlazo(Long PNCDeudaLargoPlazo) {
        this.PNCDeudaLargoPlazo = PNCDeudaLargoPlazo;
    }
     
     
    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoModelo getTipoModelo() {
        return tipoModelo;
    }

    public void setTipoModelo(TipoModelo tipoModelo) {
        this.tipoModelo = tipoModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public TipoPeriodo getTipoPeriodo() {
     if (tipoPeriodo == null)
         tipoPeriodo = new TipoPeriodo();
        return tipoPeriodo;
    }

    public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public Long getHorizonte() {
        return horizonte;
    }

    public void setHorizonte(Long horizonte) {
        this.horizonte = horizonte;
    }

    public Long getDiasTrabajo() {
        return diasTrabajo;
    }

    public void setDiasTrabajo(Long diasTrabajo) {
        this.diasTrabajo = diasTrabajo;
    }

    public Ano getAno() {
        if (ano == null){
            ano = new Ano();
        }
        return ano;
    }

    public void setAno(Ano ano) {
        this.ano = ano;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

//    public List<TipoCambioDetalle> getLstTcDetalle() {
//        return lstTcDetalle;
//    }
//
//    public void setLstTcDetalle(List<TipoCambioDetalle> lstTcDetalle) {
//        this.lstTcDetalle = lstTcDetalle;
//    }
//
//    public List<PorcentajeVentaDetalle> getLstPcVenta() {
//        return lstPcVenta;
//    }
//
//    public void setLstPcVenta(List<PorcentajeVentaDetalle> lstPcVenta) {
//        this.lstPcVenta = lstPcVenta;
//    }
//
    public List<ProductoModeloDetalle> getLstProductoModeloDetalle() {
        
       if (lstProductoModeloDetalle == null){
           lstProductoModeloDetalle = new ArrayList<ProductoModeloDetalle>();
       } 
        return lstProductoModeloDetalle;
    }

    public void setLstProductoModeloDetalle(List<ProductoModeloDetalle> lstProductoModeloDetalle) {
        this.lstProductoModeloDetalle = lstProductoModeloDetalle;
    }
    
    public List<InsumoModeloDetalle> getLstInsumoModeloDetalle() {
       if (lstInsumoModeloDetalle == null){
           lstInsumoModeloDetalle = new ArrayList<InsumoModeloDetalle>();
       } 
        
        return lstInsumoModeloDetalle;
    }
    
    public void setLstInsumoModeloDetalle(List<InsumoModeloDetalle> lstInsumoModeloDetalle) {
        this.lstInsumoModeloDetalle = lstInsumoModeloDetalle;
    }

    public void setLstActivoModeloDetalle(List<ActivoModeloDetalle> lstActivoModeloDetalle) {
        this.lstActivoModeloDetalle = lstActivoModeloDetalle;
    }
    
    
//
//    public List<ActivoModeloDetalle> getLstActivoModeloDetalle() {
//        return lstActivoModeloDetalle;
//    }
//
//    public List<InsumoModeloDetalle> getLstInsumoModeloDetalle() {
//        return lstInsumoModeloDetalle;
//    }
//
//    public void setLstActivoModeloDetalle(List<ActivoModeloDetalle> lstActivoModeloDetalle) {
//        this.lstActivoModeloDetalle = lstActivoModeloDetalle;
//    }
//
//    public void setLstInsumoModeloDetalle(List<InsumoModeloDetalle> lstInsumoModeloDetalle) {
//        this.lstInsumoModeloDetalle = lstInsumoModeloDetalle;
//    }
//
//    public List<CargoModeloDetalle> getLstCargoModeloDetalle() {
//        return lstCargoModeloDetalle;
//    }
//
//    public void setLstCargoModeloDetalle(List<CargoModeloDetalle> lstCargoModeloDetalle) {
//        this.lstCargoModeloDetalle = lstCargoModeloDetalle;
//    }
//    
//    

    public List<ActivoModeloDetalle> getLstActivoModeloDetalle() {
        if (lstActivoModeloDetalle == null){
            lstActivoModeloDetalle = new ArrayList<ActivoModeloDetalle>();
        }
        return lstActivoModeloDetalle;
    }

    public List<CargoModeloDetalle> getLstCargoModeloDetalle() {
        if (lstCargoModeloDetalle == null){
            lstCargoModeloDetalle = new ArrayList<CargoModeloDetalle>();
        }
        return lstCargoModeloDetalle;
    }

    public void setLstCargoModeloDetalle(List<CargoModeloDetalle> lstCargoModeloDetalle) {
        this.lstCargoModeloDetalle = lstCargoModeloDetalle;
    }

    public List<ServicioModeloDetalle> getLstServicioModeloDetalle() {
        if (lstServicioModeloDetalle == null){
            lstServicioModeloDetalle = new ArrayList<ServicioModeloDetalle>();
        }
        return lstServicioModeloDetalle;
    }

    public void setLstServicioModeloDetalle(List<ServicioModeloDetalle> lstServicioModeloDetalle) {
        this.lstServicioModeloDetalle = lstServicioModeloDetalle;
    }

    public List<PrestamoModeloDetalle> getLstPrestamoModeloDetalle() {
        if (lstPrestamoModeloDetalle == null){
            lstPrestamoModeloDetalle = new ArrayList<PrestamoModeloDetalle>();
        }
        return lstPrestamoModeloDetalle;
    }

    public void setLstPrestamoModeloDetalle(List<PrestamoModeloDetalle> lstPrestamoModeloDetalle) {
        this.lstPrestamoModeloDetalle = lstPrestamoModeloDetalle;
    }

    public Long getPorcCompraPagadaPeriodo() {
        return porcCompraPagadaPeriodo;
    }

    public Long getPorcCompraPagadaSgtePeriodo() {
        return porcCompraPagadaSgtePeriodo;
    }

    public Long getPorcComprasContado() {
        return porcComprasContado;
    }

    public Long getPorcComprasCredito() {
        return porcComprasCredito;
    }

    public Long getPorcDeudaCobradaPeriodo() {
        return porcDeudaCobradaPeriodo;
    }

    public Long getPorcDeudaCobradaSgtePeriodo() {
        return porcDeudaCobradaSgtePeriodo;
    }

    public Long getPorcVentasContado() {
        return porcVentasContado;
    }

    public Long getPorcVentasCredito() {
        return porcVentasCredito;
    }

    public Long getPorcVentasIncobrables() {
        return porcVentasIncobrables;
    }

    public void setPorcCompraPagadaPeriodo(Long porcCompraPagadaPeriodo) {
        this.porcCompraPagadaPeriodo = porcCompraPagadaPeriodo;
    }

    public void setPorcCompraPagadaSgtePeriodo(Long porcCompraPagadaSgtePeriodo) {
        this.porcCompraPagadaSgtePeriodo = porcCompraPagadaSgtePeriodo;
    }

    public void setPorcComprasContado(Long porcComprasContado) {
        this.porcComprasContado = porcComprasContado;
    }

    public void setPorcComprasCredito(Long porcComprasCredito) {
        this.porcComprasCredito = porcComprasCredito;
    }

    public void setPorcDeudaCobradaPeriodo(Long porcDeudaCobradaPeriodo) {
        this.porcDeudaCobradaPeriodo = porcDeudaCobradaPeriodo;
    }

    public void setPorcDeudaCobradaSgtePeriodo(Long porcDeudaCobradaSgtePeriodo) {
        this.porcDeudaCobradaSgtePeriodo = porcDeudaCobradaSgtePeriodo;
    }

    public void setPorcVentasContado(Long porcVentasContado) {
        this.porcVentasContado = porcVentasContado;
    }

    public void setPorcVentasCredito(Long porcVentasCredito) {
        this.porcVentasCredito = porcVentasCredito;
    }

    public void setPorcVentasIncobrables(Long porcVentasIncobrables) {
        this.porcVentasIncobrables = porcVentasIncobrables;
    }
    
}
