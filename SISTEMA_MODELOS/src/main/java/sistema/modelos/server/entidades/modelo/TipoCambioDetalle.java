/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelos.server.entidades.modelo;


import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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
@Table(name = "DETALLE_TC")
public class TipoCambioDetalle implements Serializable{
   
    @EmbeddedId
    private DetailTCPK detailTCPK;
    
    @Column(name = "VALOR_TC")
    private Long valorTC;

    @ManyToOne
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO", insertable = false, updatable = false)
    private Modelo modelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_MES", referencedColumnName = "ID_MES", insertable = false, updatable = false)
    private Mes mes;
    
    @ManyToOne
    @JoinColumn(name = "ID_ANO", referencedColumnName = "ID_ANO", insertable = false, updatable = false)
    private Ano ano;

    
    
    public DetailTCPK getDetailTCPK() {
        return detailTCPK;
    }

    public void setDetailTCPK(DetailTCPK detailTCPK) {
        this.detailTCPK = detailTCPK;
    }

    public Long getValorTC() {
        return valorTC;
    }

    public void setValorTC(Long valorTC) {
        this.valorTC = valorTC;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Ano getAno() {
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

    
}


