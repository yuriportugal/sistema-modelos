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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo")
     private List<ProductoModeloDetalle> lstProductoModeloDetalle;
//    
//     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
//     private List <InsumoModeloDetalle> lstInsumoModeloDetalle;
//
//     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
//     private List<ActivoModeloDetalle> lstActivoModeloDetalle;
//
//     @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo",orphanRemoval=true)
//     private List<CargoModeloDetalle> lstCargoModeloDetalle;
// 
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
    
}
