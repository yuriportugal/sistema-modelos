/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.empresa;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable{
   
    @Id
    @Column(name="ID_EMPRESA")
    private Long idEmpresa;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "RUC")
    private String ruc;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;
    
    @Column(name = "TELEFONO")
    private String telefono;
    
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "PAGINA_WEB")
    private String paginaWeb;
    
    @ManyToOne
    @JoinColumn(name="ID_RUBRO")
    private Rubro rubro;

    @Column(name = "BI_AC_CAJA_BANCOS")
    private Long biCajaBancos;
    
    @Column(name = "BI_AC_CREDITO_FISCAL")
    private Long biCreditoFiscal;
    
    @Column(name = "BI_AC_CUENTAS_X_COBRAR")
    private Long biCuentasXCobrar;
    
    @Column(name = "BI_AC_EX_INSUMOS")
    private Long biExistInsumos;
    
    @Column(name = "BI_AC_EX_PROD_TERM")
    private Long biExistProdTerminados;
    
    @Column(name = "BI_ANC_ACTIVOS_FIJOS")
    private Long biActivosFijos;
    
    @Column(name = "BI_ANC_DEPREC_ACUM")
    private Long biDeprecAcumulada;
    
    @Column(name = "BI_ANC_INTANGIBLES")
    private Long biIntangibles;
    
    @Column(name = "BI_ANC_AMORT_ACUM")
    private Long biAmortAcumulada;
    
    @Column(name = "BI_ANC_VALOR_NEGOC")
    private Long biValoresNegociables;
    
    @Column(name = "BI_PC_CUENTAS_X_PAGAR_PROV")
    private Long biCuentasXPagarProv;
    
    @Column(name = "BI_PC_CUENTAS_X_PAGAR_SOB")
    private Long biCuentasxPagarSobregiro;
    
    @Column(name = "BI_PC_IGV")
    private Long biIGV;
    
    @Column(name = "BI_PC_PRESTAMOS_CORTO_PLAZO")
    private Long biPrestamosCortoPlazo;
    
    @Column(name = "BI_PC_PARTICIPACIONES")
    private Long biParticipaciones;
    
    @Column(name = "BI_PC_DIREC_BUENA_GESTION")
    private Long biDirecBuenaGestion;
    
    @Column(name = "BI_PC_IMPUESTO_RENTA")
    private Long biImpuestoRenta;
    
    @Column(name = "BI_PC_DIVIDENDOS")
    private Long biDividendos;
    
    @Column(name = "BI_PNC_DEUDAS_LARGO_PLAZO")
    private Long biDeudasLargoPlazo;
    
    @Column(name = "BI_PT_CAPITAL_SOCIAL")
    private Long biCapitalSocial;
    
    @Column(name = "BI_PT_RESERVA_LEGAL_ACUM")
    private Long biReservaLegalAcum;
    
    @Column(name = "BI_PT_RESULT_ACUM")
    private Long biResultAcumulados;
    
    
    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Long getBiCajaBancos() {
        return biCajaBancos;
    }

    public void setBiCajaBancos(Long biCajaBancos) {
        this.biCajaBancos = biCajaBancos;
    }

    public Long getBiCreditoFiscal() {
        return biCreditoFiscal;
    }

    public void setBiCreditoFiscal(Long biCreditoFiscal) {
        this.biCreditoFiscal = biCreditoFiscal;
    }

    public Long getBiCuentasXCobrar() {
        return biCuentasXCobrar;
    }

    public void setBiCuentasXCobrar(Long biCuentasXCobrar) {
        this.biCuentasXCobrar = biCuentasXCobrar;
    }

    public Long getBiExistInsumos() {
        return biExistInsumos;
    }

    public void setBiExistInsumos(Long biExistInsumos) {
        this.biExistInsumos = biExistInsumos;
    }

    public Long getBiExistProdTerminados() {
        return biExistProdTerminados;
    }

    public void setBiExistProdTerminados(Long biExistProdTerminados) {
        this.biExistProdTerminados = biExistProdTerminados;
    }

    public Long getBiActivosFijos() {
        return biActivosFijos;
    }

    public void setBiActivosFijos(Long biActivosFijos) {
        this.biActivosFijos = biActivosFijos;
    }

    public Long getBiDeprecAcumulada() {
        return biDeprecAcumulada;
    }

    public void setBiDeprecAcumulada(Long biDeprecAcumulada) {
        this.biDeprecAcumulada = biDeprecAcumulada;
    }

    public Long getBiIntangibles() {
        return biIntangibles;
    }

    public void setBiIntangibles(Long biIntangibles) {
        this.biIntangibles = biIntangibles;
    }

    public Long getBiAmortAcumulada() {
        return biAmortAcumulada;
    }

    public void setBiAmortAcumulada(Long biAmortAcumulada) {
        this.biAmortAcumulada = biAmortAcumulada;
    }

    public Long getBiValoresNegociables() {
        return biValoresNegociables;
    }

    public void setBiValoresNegociables(Long biValoresNegociables) {
        this.biValoresNegociables = biValoresNegociables;
    }

    public Long getBiCuentasXPagarProv() {
        return biCuentasXPagarProv;
    }

    public void setBiCuentasXPagarProv(Long biCuentasXPagarProv) {
        this.biCuentasXPagarProv = biCuentasXPagarProv;
    }

    public Long getBiCuentasxPagarSobregiro() {
        return biCuentasxPagarSobregiro;
    }

    public void setBiCuentasxPagarSobregiro(Long biCuentasxPagarSobregiro) {
        this.biCuentasxPagarSobregiro = biCuentasxPagarSobregiro;
    }

    public Long getBiIGV() {
        return biIGV;
    }

    public void setBiIGV(Long biIGV) {
        this.biIGV = biIGV;
    }

    public Long getBiPrestamosCortoPlazo() {
        return biPrestamosCortoPlazo;
    }

    public void setBiPrestamosCortoPlazo(Long biPrestamosCortoPlazo) {
        this.biPrestamosCortoPlazo = biPrestamosCortoPlazo;
    }

    public Long getBiParticipaciones() {
        return biParticipaciones;
    }

    public void setBiParticipaciones(Long biParticipaciones) {
        this.biParticipaciones = biParticipaciones;
    }

    public Long getBiDirecBuenaGestion() {
        return biDirecBuenaGestion;
    }

    public void setBiDirecBuenaGestion(Long biDirecBuenaGestion) {
        this.biDirecBuenaGestion = biDirecBuenaGestion;
    }

    public Long getBiImpuestoRenta() {
        return biImpuestoRenta;
    }

    public void setBiImpuestoRenta(Long biImpuestoRenta) {
        this.biImpuestoRenta = biImpuestoRenta;
    }

    public Long getBiDividendos() {
        return biDividendos;
    }

    public void setBiDividendos(Long biDividendos) {
        this.biDividendos = biDividendos;
    }

    public Long getBiDeudasLargoPlazo() {
        return biDeudasLargoPlazo;
    }

    public void setBiDeudasLargoPlazo(Long biDeudasLargoPlazo) {
        this.biDeudasLargoPlazo = biDeudasLargoPlazo;
    }

    public Long getBiCapitalSocial() {
        return biCapitalSocial;
    }

    public void setBiCapitalSocial(Long biCapitalSocial) {
        this.biCapitalSocial = biCapitalSocial;
    }

    public Long getBiReservaLegalAcum() {
        return biReservaLegalAcum;
    }

    public void setBiReservaLegalAcum(Long biReservaLegalAcum) {
        this.biReservaLegalAcum = biReservaLegalAcum;
    }

    public Long getBiResultAcumulados() {
        return biResultAcumulados;
    }

    public void setBiResultAcumulados(Long biResultAcumulados) {
        this.biResultAcumulados = biResultAcumulados;
    }
    
    
    
    
}
