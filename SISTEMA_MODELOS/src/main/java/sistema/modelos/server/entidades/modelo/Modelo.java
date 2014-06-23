/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;

import sistema.modelos.server.entidades.empresa.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    @JoinColumn(name="ID_INDUCTOR")
    private Inductor inductor;
    
    @ManyToOne 
    @JoinColumn(name="PARENT_ID_MODELO")
    private Modelo parentModelo;
    
    
    
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
     private BigDecimal porcVentasContado;
     @Column(name="PORC_VENTAS_CREDITO")
     private BigDecimal porcVentasCredito;
     @Column(name="PORC_VENTAS_INCOBRABLES")        
     private BigDecimal porcVentasIncobrables;
    @Column(name="NUM_DIAS_COBRANZA")        
     private Long numDiasCobranza;

     //pagos
     @Column(name="PORC_COMPRAS_CONTADO")
     private BigDecimal porcComprasContado;
     @Column(name="PORC_COMPRAS_CRED")        
     private BigDecimal porcComprasCredito;
     @Column(name="NUM_DIAS_PAGO")        
     private Long numDiasPago;
      
     //Balance Inicial  
    
     //ACTIVO CORRIENTE
     
     @Column(name="AC_CAJA_BANCO")
     private BigDecimal ACCajaBanco;
     @Column(name="AC_CRED_FISCAL")
     private BigDecimal ACCredFiscal;
     @Column(name="AC_CTA_COBRAR")
     private BigDecimal ACCuentaxCobrar;
     @Column(name="AC_INSUMOS")
     private BigDecimal ACInsumos;
     @Column(name="AC_PRODUCTO_TERMINADO")
     private BigDecimal ACProductosTerminados;
     @Column(name="ANC_ACTIVO_FIJO")
     private BigDecimal ANCActivoFijo;
     @Column(name="ANC_DEPRE_ACUMU")
     private BigDecimal ANCDepreciacionAcum;
     @Column(name="ANC_INTANGIBLE")
     private BigDecimal ANCIntangible;
     @Column(name="ANC_AMORT_ACUMU")
     private BigDecimal ANCAmortAcumulada;
     @Column(name="ANC_VAL_NEGOCIABLE")
     private BigDecimal ANCValNegociable;
     @Column(name="PC_CCXPP_PROV")
     private BigDecimal PCCuentaxCobrarProveedores;
     @Column(name="PC_CCXPP_SOBREGIRO")
     private BigDecimal PCCuentaxCobrarSobregiro;
     @Column(name="PC_IGV_X_PAG")
     private BigDecimal PCIGVxPagar;
     @Column(name="PC_PREST_X_PAG_CORTO")
     private BigDecimal PCPrestxPagarCortoPlazo;
     @Column(name="PC_PART_X_PAGAR")
     private BigDecimal PCPartixPagar;
     @Column(name="PC_DIR_BUEN_GEST_X_PAG")
     private BigDecimal PCDirBuenaGest;
     @Column(name="PC_IMP_RENT_X_PAG")
     private BigDecimal PCImpuestoRenta;
     @Column(name="PC_DIV_X_PAGAR")
     private BigDecimal PCDividendoxPag;
     @Column(name="PNC_DEUD_LARG_PLAZO")
     private BigDecimal PNCDeudaLargoPlazo;
     @Column(name="PAT_CAP_SOCIAL")
     private BigDecimal PATCapitalSocial;
     @Column(name="PAT_RESER_LEGAL_ACUM")
     private BigDecimal PATReservaLegal;
     @Column(name="PT_RESUL_ACUM")
     private BigDecimal PATResultadoAcumulado;
     
     
     //PARAMETROS DE TIEMPO
     @Column(name="PTM_HORAS_JORNADA")
     private BigDecimal PTHorasJornada;
     @Column(name="PTM_NUMERO_TURNOS")
     private BigDecimal PTNumeroTurnos;
     @Column(name="PTM_COMISIONES_VENDEDOR")
     private BigDecimal PTComisionesVend;
     @Column(name="PTM_PORC_ACTIVOS_NO_REL_PROD")
     private BigDecimal PTPorcActivosNoRelProd;
     //TODO INDUCTOR    
     @Column(name="PTM_IND_VAR_TC")
     private BigDecimal PTIndVarTipoCambio;
     @Column(name="PTM_TC_INICIAL")
     private BigDecimal PTTipoCambioIni;

     //Parametros estados financieros
     @Column(name="PF_PORC_RESERV_LEGAL_CAP")
     private BigDecimal PFPorcReservaLegalCapital;
    @Column(name="PF_PORC_RESERV_LEGAL")
       private BigDecimal PFPorcReservaLegal;
    @Column(name="PF_PORC_REP_DIVID")
         private BigDecimal PFPorcRepDividendos;
    @Column(name="PF_PART_TRABAJADOR")
         private BigDecimal PFPartTrabajadores;
    @Column(name="PF_DIREC_BUENA_GEST")
         private BigDecimal PFDirBuenaGest;
    @Column(name="PF_UTILIDAD_CAP")
     private BigDecimal PFUtiCapitalizar;
    //Decisiones financieras
    @Column(name="DF_CAJA_MINIMA")
     private BigDecimal DFCajaMinima;
    @Column(name="DF_CAJA_MAXIMA")
     private BigDecimal DFCajaMaxima;
    @Column(name="DF_SOBREGIRO_MAXIMO")
     private BigDecimal DFSobreGiroMax;
    @Column(name="DF_INTERES_ANU_SOBRE")
     private BigDecimal DFInteresAnualSobregiro;
    @Column(name="DF_PREST_CORTO")
     private BigDecimal DFPrestamoCortoPlazoMax;
    @Column(name="DF_INTERES_PREST_CORTO")
     private BigDecimal DFInteresAnualPrestamo;
    //Variaciones
    @Column(name="VAR_IND_PRECIO_VENTA")
     private BigDecimal VARIndPrecioVenta;
    @Column(name="VAR_PORC_INI_PRE_VENT")
     private BigDecimal VARPorcInicialPrecioVenta;
    @Column(name="VAR_IND_PRECIO_COMPRA")
     private BigDecimal VARIndPrecioCompra;
    @Column(name="VAR_PORC_INI_PRE_COMP")
     private BigDecimal VARPorcInicialPrecioCompra;
    @Column(name="VAR_IND_VENTA")
     private BigDecimal VARIndVenta;
    @Column(name="VAR_PORC_INI_VENTA")
     private BigDecimal VARPorcInicialVenta;
    @Column(name="VAR_IND_MANTENIMIENTO")
     private BigDecimal VARIndMantenimiento;
    @Column(name="VAR_PORC_INI_MANTENIMIENTO")
     private BigDecimal VARPorcInicialMantenimiento;
    @Column(name="VAR_IND_SALARIAL")
     private BigDecimal VARIndSalarial;
    @Column(name="VAR_PORC_INI_SALARIAL")
     private BigDecimal VARPorcInicialSalarial;
    @Column(name="VAR_IND_GASTOS")
     private BigDecimal VARIndGastos;
    @Column(name="VAR_PORC_INI_GASTOS")
     private BigDecimal VARPorcInicialGastos;
    
    @Column(name="VAR_PORC_INI_PERSONAL")
     private BigDecimal VARPorcInicialPersonal;
    @Column(name="VAR_IND_PERSONAL")
     private BigDecimal VARIndPersonal;

    public BigDecimal getVARIndPersonal() {
        return VARIndPersonal;
    }

    public void setVARIndPersonal(BigDecimal VARIndPersonal) {
        this.VARIndPersonal = VARIndPersonal;
    }

    public BigDecimal getVARPorcInicialPersonal() {
        return VARPorcInicialPersonal;
    }

    public void setVARPorcInicialPersonal(BigDecimal VARPorcInicialPersonal) {
        this.VARPorcInicialPersonal = VARPorcInicialPersonal;
    }
    
    
    
    public BigDecimal getVARIndGastos() {
        return VARIndGastos;
    }

    public void setVARIndGastos(BigDecimal VARIndGastos) {
        this.VARIndGastos = VARIndGastos;
    }

    public BigDecimal getVARIndMantenimiento() {
        return VARIndMantenimiento;
    }

    public BigDecimal getVARIndPrecioCompra() {
        return VARIndPrecioCompra;
    }

    public BigDecimal getVARIndPrecioVenta() {
        return VARIndPrecioVenta;
    }

    public BigDecimal getVARIndSalarial() {
        return VARIndSalarial;
    }

    public BigDecimal getVARIndVenta() {
        return VARIndVenta;
    }

    public BigDecimal getVARPorcInicialGastos() {
        return VARPorcInicialGastos;
    }

    public BigDecimal getVARPorcInicialMantenimiento() {
        return VARPorcInicialMantenimiento;
    }

    public BigDecimal getVARPorcInicialPrecioCompra() {
        return VARPorcInicialPrecioCompra;
    }

    public BigDecimal getVARPorcInicialPrecioVenta() {
        return VARPorcInicialPrecioVenta;
    }

    public BigDecimal getVARPorcInicialSalarial() {
        return VARPorcInicialSalarial;
    }

    public BigDecimal getVARPorcInicialVenta() {
        return VARPorcInicialVenta;
    }

    public void setVARIndMantenimiento(BigDecimal VARIndMantenimiento) {
        this.VARIndMantenimiento = VARIndMantenimiento;
    }

    public void setVARIndPrecioCompra(BigDecimal VARIndPrecioCompra) {
        this.VARIndPrecioCompra = VARIndPrecioCompra;
    }

    public void setVARIndPrecioVenta(BigDecimal VARIndPrecioVenta) {
        this.VARIndPrecioVenta = VARIndPrecioVenta;
    }

    public void setVARIndSalarial(BigDecimal VARIndSalarial) {
        this.VARIndSalarial = VARIndSalarial;
    }

    public void setVARIndVenta(BigDecimal VARIndVenta) {
        this.VARIndVenta = VARIndVenta;
    }

    public void setVARPorcInicialGastos(BigDecimal VARPorcInicialGastos) {
        this.VARPorcInicialGastos = VARPorcInicialGastos;
    }

    public void setVARPorcInicialMantenimiento(BigDecimal VARPorcInicialMantenimiento) {
        this.VARPorcInicialMantenimiento = VARPorcInicialMantenimiento;
    }

    public void setVARPorcInicialPrecioCompra(BigDecimal VARPorcInicialPrecioCompra) {
        this.VARPorcInicialPrecioCompra = VARPorcInicialPrecioCompra;
    }

    public void setVARPorcInicialPrecioVenta(BigDecimal VARPorcInicialPrecioVenta) {
        this.VARPorcInicialPrecioVenta = VARPorcInicialPrecioVenta;
    }

    public void setVARPorcInicialSalarial(BigDecimal VARPorcInicialSalarial) {
        this.VARPorcInicialSalarial = VARPorcInicialSalarial;
    }

    public void setVARPorcInicialVenta(BigDecimal VARPorcInicialVenta) {
        this.VARPorcInicialVenta = VARPorcInicialVenta;
    }
    
    
    
    
    
    
    public BigDecimal getDFCajaMaxima() {
        return DFCajaMaxima;
    }

    public void setDFCajaMaxima(BigDecimal DFCajaMaxima) {
        this.DFCajaMaxima = DFCajaMaxima;
    }

    public BigDecimal getDFCajaMinima() {
        return DFCajaMinima;
    }

    public void setDFCajaMinima(BigDecimal DFCajaMinima) {
        this.DFCajaMinima = DFCajaMinima;
    }

    public BigDecimal getDFInteresAnualPrestamo() {
        return DFInteresAnualPrestamo;
    }

    public void setDFInteresAnualPrestamo(BigDecimal DFInteresAnualPrestamo) {
        this.DFInteresAnualPrestamo = DFInteresAnualPrestamo;
    }

    public BigDecimal getDFInteresAnualSobregiro() {
        return DFInteresAnualSobregiro;
    }

    public void setDFInteresAnualSobregiro(BigDecimal DFInteresAnualSobregiro) {
        this.DFInteresAnualSobregiro = DFInteresAnualSobregiro;
    }

    public BigDecimal getDFPrestamoCortoPlazoMax() {
        return DFPrestamoCortoPlazoMax;
    }

    public void setDFPrestamoCortoPlazoMax(BigDecimal DFPrestamoCortoPlazoMax) {
        this.DFPrestamoCortoPlazoMax = DFPrestamoCortoPlazoMax;
    }

    public BigDecimal getDFSobreGiroMax() {
        return DFSobreGiroMax;
    }

    public void setDFSobreGiroMax(BigDecimal DFSobreGiroMax) {
        this.DFSobreGiroMax = DFSobreGiroMax;
    }
    
    
    
    
    
    
    public BigDecimal getPFDirBuenaGest() {
        return PFDirBuenaGest;
    }

    public void setPFDirBuenaGest(BigDecimal PFDirBuenaGest) {
        this.PFDirBuenaGest = PFDirBuenaGest;
    }

    public BigDecimal getPFPartTrabajadores() {
        return PFPartTrabajadores;
    }

    public void setPFPartTrabajadores(BigDecimal PFPartTrabajadores) {
        this.PFPartTrabajadores = PFPartTrabajadores;
    }

    public BigDecimal getPFPorcRepDividendos() {
        return PFPorcRepDividendos;
    }

    public void setPFPorcRepDividendos(BigDecimal PFPorcRepDividendos) {
        this.PFPorcRepDividendos = PFPorcRepDividendos;
    }

    public BigDecimal getPFPorcReservaLegal() {
        return PFPorcReservaLegal;
    }

    public void setPFPorcReservaLegal(BigDecimal PFPorcReservaLegal) {
        this.PFPorcReservaLegal = PFPorcReservaLegal;
    }

    public BigDecimal getPFPorcReservaLegalCapital() {
        return PFPorcReservaLegalCapital;
    }

    public void setPFPorcReservaLegalCapital(BigDecimal PFPorcReservaLegalCapital) {
        this.PFPorcReservaLegalCapital = PFPorcReservaLegalCapital;
    }

    public BigDecimal getPFUtiCapitalizar() {
        return PFUtiCapitalizar;
    }

    public void setPFUtiCapitalizar(BigDecimal PFUtiCapitalizar) {
        this.PFUtiCapitalizar = PFUtiCapitalizar;
    }
 
    public BigDecimal getPTHorasJornada() {
        return PTHorasJornada;
    }

    public void setPTHorasJornada(BigDecimal PTHorasJornada) {
        this.PTHorasJornada = PTHorasJornada;
    }

    public BigDecimal getPTNumeroTurnos() {
        return PTNumeroTurnos;
    }

    public void setPTNumeroTurnos(BigDecimal PTNumeroTurnos) {
        this.PTNumeroTurnos = PTNumeroTurnos;
    }

    public BigDecimal getPTComisionesVend() {
        return PTComisionesVend;
    }

    public void setPTComisionesVend(BigDecimal PTComisionesVend) {
        this.PTComisionesVend = PTComisionesVend;
    }

    public BigDecimal getPTPorcActivosNoRelProd() {
        return PTPorcActivosNoRelProd;
    }

    public void setPTPorcActivosNoRelProd(BigDecimal PTPorcActivosNoRelProd) {
        this.PTPorcActivosNoRelProd = PTPorcActivosNoRelProd;
    }

    public BigDecimal getPTIndVarTipoCambio() {
        return PTIndVarTipoCambio;
    }

    public void setPTIndVarTipoCambio(BigDecimal PTIndVarTipoCambio) {
        this.PTIndVarTipoCambio = PTIndVarTipoCambio;
    }

    public BigDecimal getPTTipoCambioIni() {
        return PTTipoCambioIni;
    }

    public void setPTTipoCambioIni(BigDecimal PTTipoCambioIni) {
        this.PTTipoCambioIni = PTTipoCambioIni;
    }
     
     
     
    public BigDecimal getACCajaBanco() {
        return ACCajaBanco;
    }

    public BigDecimal getACCredFiscal() {
        return ACCredFiscal;
    }

    public BigDecimal getACCuentaxCobrar() {
        return ACCuentaxCobrar;
    }

    public BigDecimal getACInsumos() {
        return ACInsumos;
    }

    public BigDecimal getACProductosTerminados() {
        return ACProductosTerminados;
    }

    public BigDecimal getANCActivoFijo() {
        return ANCActivoFijo;
    }

    public BigDecimal getANCAmortAcumulada() {
        return ANCAmortAcumulada;
    }

    public BigDecimal getANCDepreciacionAcum() {
        return ANCDepreciacionAcum;
    }

    public BigDecimal getANCIntangible() {
        return ANCIntangible;
    }

    public BigDecimal getANCValNegociable() {
        return ANCValNegociable;
    }

    public BigDecimal getPATCapitalSocial() {
        return PATCapitalSocial;
    }

    public BigDecimal getPATReservaLegal() {
        return PATReservaLegal;
    }

    public BigDecimal getPATResultadoAcumulado() {
        return PATResultadoAcumulado;
    }

    public BigDecimal getPCCuentaxCobrarProveedores() {
        return PCCuentaxCobrarProveedores;
    }

    public BigDecimal getPCCuentaxCobrarSobregiro() {
        return PCCuentaxCobrarSobregiro;
    }

    public BigDecimal getPCDirBuenaGest() {
        return PCDirBuenaGest;
    }

    public BigDecimal getPCDividendoxPag() {
        return PCDividendoxPag;
    }

    public BigDecimal getPCIGVxPagar() {
        return PCIGVxPagar;
    }

    public BigDecimal getPCImpuestoRenta() {
        return PCImpuestoRenta;
    }

    public BigDecimal getPCPartixPagar() {
        return PCPartixPagar;
    }

    public BigDecimal getPCPrestxPagarCortoPlazo() {
        return PCPrestxPagarCortoPlazo;
    }

    public BigDecimal getPNCDeudaLargoPlazo() {
        return PNCDeudaLargoPlazo;
    }

    public void setACCajaBanco(BigDecimal ACCajaBanco) {
        this.ACCajaBanco = ACCajaBanco;
    }

    public void setACCredFiscal(BigDecimal ACCredFiscal) {
        this.ACCredFiscal = ACCredFiscal;
    }

    public void setACCuentaxCobrar(BigDecimal ACCuentaxCobrar) {
        this.ACCuentaxCobrar = ACCuentaxCobrar;
    }

    public void setACInsumos(BigDecimal ACInsumos) {
        this.ACInsumos = ACInsumos;
    }

    public void setACProductosTerminados(BigDecimal ACProductosTerminados) {
        this.ACProductosTerminados = ACProductosTerminados;
    }

    public void setANCActivoFijo(BigDecimal ANCActivoFijo) {
        this.ANCActivoFijo = ANCActivoFijo;
    }

    public void setANCAmortAcumulada(BigDecimal ANCAmortAcumulada) {
        this.ANCAmortAcumulada = ANCAmortAcumulada;
    }

    public void setANCDepreciacionAcum(BigDecimal ANCDepreciacionAcum) {
        this.ANCDepreciacionAcum = ANCDepreciacionAcum;
    }

    public void setANCIntangible(BigDecimal ANCIntangible) {
        this.ANCIntangible = ANCIntangible;
    }

    public void setANCValNegociable(BigDecimal ANCValNegociable) {
        this.ANCValNegociable = ANCValNegociable;
    }

    public void setPATCapitalSocial(BigDecimal PATCapitalSocial) {
        this.PATCapitalSocial = PATCapitalSocial;
    }

    public void setPATReservaLegal(BigDecimal PATReservaLegal) {
        this.PATReservaLegal = PATReservaLegal;
    }

    public void setPATResultadoAcumulado(BigDecimal PATResultadoAcumulado) {
        this.PATResultadoAcumulado = PATResultadoAcumulado;
    }

    public void setPCCuentaxCobrarProveedores(BigDecimal PCCuentaxCobrarProveedores) {
        this.PCCuentaxCobrarProveedores = PCCuentaxCobrarProveedores;
    }

    public void setPCCuentaxCobrarSobregiro(BigDecimal PCCuentaxCobrarSobregiro) {
        this.PCCuentaxCobrarSobregiro = PCCuentaxCobrarSobregiro;
    }

    public void setPCDirBuenaGest(BigDecimal PCDirBuenaGest) {
        this.PCDirBuenaGest = PCDirBuenaGest;
    }

    public void setPCDividendoxPag(BigDecimal PCDividendoxPag) {
        this.PCDividendoxPag = PCDividendoxPag;
    }

    public void setPCIGVxPagar(BigDecimal PCIGVxPagar) {
        this.PCIGVxPagar = PCIGVxPagar;
    }

    public void setPCImpuestoRenta(BigDecimal PCImpuestoRenta) {
        this.PCImpuestoRenta = PCImpuestoRenta;
    }

    public void setPCPartixPagar(BigDecimal PCPartixPagar) {
        this.PCPartixPagar = PCPartixPagar;
    }

    public void setPCPrestxPagarCortoPlazo(BigDecimal PCPrestxPagarCortoPlazo) {
        this.PCPrestxPagarCortoPlazo = PCPrestxPagarCortoPlazo;
    }

    public void setPNCDeudaLargoPlazo(BigDecimal PNCDeudaLargoPlazo) {
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



    public BigDecimal getPorcComprasContado() {
        return porcComprasContado;
    }

    public BigDecimal getPorcComprasCredito() {
        return porcComprasCredito;
    }


    public BigDecimal getPorcVentasContado() {
        return porcVentasContado;
    }

    public BigDecimal getPorcVentasCredito() {
        return porcVentasCredito;
    }

    public BigDecimal getPorcVentasIncobrables() {
        return porcVentasIncobrables;
    }

    public Long getNumDiasPago() {
        return numDiasPago;
    }

    public void setNumDiasPago(Long numDiasPago) {
        this.numDiasPago = numDiasPago;
    }

    
    
    public void setPorcComprasContado(BigDecimal porcComprasContado) {
        this.porcComprasContado = porcComprasContado;
    }

    public void setPorcComprasCredito(BigDecimal porcComprasCredito) {
        this.porcComprasCredito = porcComprasCredito;
    }

    public Long getNumDiasCobranza() {
        return numDiasCobranza;
    }

    public void setNumDiasCobranza(Long numDiasCobranza) {
        this.numDiasCobranza = numDiasCobranza;
    }

    
    
    public void setPorcVentasContado(BigDecimal porcVentasContado) {
        this.porcVentasContado = porcVentasContado;
    }

    public void setPorcVentasCredito(BigDecimal porcVentasCredito) {
        this.porcVentasCredito = porcVentasCredito;
    }

    public void setPorcVentasIncobrables(BigDecimal porcVentasIncobrables) {
        this.porcVentasIncobrables = porcVentasIncobrables;
    }

    public Modelo getParentModelo() {
        if (parentModelo == null){
            parentModelo = null;
        }
        return parentModelo;
    }

    public void setParentModelo(Modelo parentModelo) {
        this.parentModelo = parentModelo;
    }

    public Inductor getInductor() {
        if (inductor == null){
            inductor = new Inductor();
        }
        return inductor;
    }

    public void setInductor(Inductor inductor) {
        this.inductor = inductor;
    }
    
    
    
    
    
}
