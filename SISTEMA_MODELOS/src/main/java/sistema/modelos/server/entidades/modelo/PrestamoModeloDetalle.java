/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author YURI
 */
@Entity
@Table(name = "MODELO_PRESTAMO")
public class PrestamoModeloDetalle implements Serializable{
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODELO_PRESTAMO_SEQ")
    @SequenceGenerator(name = "MODELO_PRESTAMO_SEQ", sequenceName = "MODELO_PRESTAMO_SEQ",allocationSize = 1)
    @Column(name="ID_MODELO_PRESTAMO")
    private Long idModeloPrestamo;
    
    @Column(name="MONTO")
    private Long monto;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="INTERES")
    private Long interes;
    
    @Column(name="CANTIDAD_PERIODOS")
    private Long cantPeriodos;
    
    @Column(name="SALDO_DEUDOR")
    private Long saldoDeudor;
        
    @ManyToOne
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO")
    private Modelo modelo;
    
    @ManyToOne
    @JoinColumn(name="ID_TIPO_PRESTAMO")
    private TipoPrestamo tipoPrestamo;

    public void setTipoPrestamo(TipoPrestamo tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public TipoPrestamo getTipoPrestamo() {
        if (tipoPrestamo == null){
            tipoPrestamo = new TipoPrestamo();
        }
        
        return tipoPrestamo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Long getMonto() {
        return monto;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setInteres(Long interes) {
        this.interes = interes;
    }

    public Long getInteres() {
        return interes;
    }

    public void setIdModeloPrestamo(Long idModeloPrestamo) {
        this.idModeloPrestamo = idModeloPrestamo;
    }

    public Long getIdModeloPrestamo() {
        return idModeloPrestamo;
    }

    public void setCantPeriodos(Long cantPeriodos) {
        this.cantPeriodos = cantPeriodos;
    }

    public Long getCantPeriodos() {
        return cantPeriodos;
    }

    public Long getSaldoDeudor() {
        return saldoDeudor;
    }

    public void setSaldoDeudor(Long saldoDeudor) {
        this.saldoDeudor = saldoDeudor;
    }

    

    
}


