/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alunoccc
 */
@Entity
@Table(name = "Per\u00edodo Letivo")
@NamedQueries({
    @NamedQuery(name = "Per\u00edodoLetivo.findAll", query = "SELECT p FROM Per\u00edodoLetivo p")})
public class PeríodoLetivo implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtPeriodo")
    private List<CurrículoemOferta> currículoemOfertaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_Periodo")
    private Integer idtPeriodo;
    @Basic(optional = false)
    @Column(name = "idt_Regime")
    private Character idtRegime;
    @Basic(optional = false)
    @Column(name = "dat_Inicio")
    @Temporal(TemporalType.DATE)
    private Date datInicio;
    @Basic(optional = false)
    @Column(name = "dat_Fim")
    @Temporal(TemporalType.DATE)
    private Date datFim;

    public PeríodoLetivo() {
    }

    public PeríodoLetivo(Integer idtPeriodo) {
        this.idtPeriodo = idtPeriodo;
    }

    public PeríodoLetivo(Integer idtPeriodo, Character idtRegime, Date datInicio, Date datFim) {
        this.idtPeriodo = idtPeriodo;
        this.idtRegime = idtRegime;
        this.datInicio = datInicio;
        this.datFim = datFim;
    }

    public Integer getIdtPeriodo() {
        return idtPeriodo;
    }

    public void setIdtPeriodo(Integer idtPeriodo) {
        this.idtPeriodo = idtPeriodo;
    }

    public Character getIdtRegime() {
        return idtRegime;
    }

    public void setIdtRegime(Character idtRegime) {
        this.idtRegime = idtRegime;
    }

    public Date getDatInicio() {
        return datInicio;
    }

    public void setDatInicio(Date datInicio) {
        this.datInicio = datInicio;
    }

    public Date getDatFim() {
        return datFim;
    }

    public void setDatFim(Date datFim) {
        this.datFim = datFim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtPeriodo != null ? idtPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeríodoLetivo)) {
            return false;
        }
        PeríodoLetivo other = (PeríodoLetivo) object;
        if ((this.idtPeriodo == null && other.idtPeriodo != null) || (this.idtPeriodo != null && !this.idtPeriodo.equals(other.idtPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Per\u00edodoLetivo[ idtPeriodo=" + idtPeriodo + " ]";
    }

    public List<CurrículoemOferta> getCurrículoemOfertaList() {
        return currículoemOfertaList;
    }

    public void setCurrículoemOfertaList(List<CurrículoemOferta> currículoemOfertaList) {
        this.currículoemOfertaList = currículoemOfertaList;
    }
    
}
