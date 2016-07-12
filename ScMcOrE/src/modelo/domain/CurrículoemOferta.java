/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alunoccc
 */
@Entity
@Table(name = "Curr\u00edculo em Oferta")
@NamedQueries({
    @NamedQuery(name = "Curr\u00edculoemOferta.findAll", query = "SELECT c FROM Curr\u00edculoemOferta c")})
public class CurrículoemOferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Curriculo_Oferta")
    private Integer idCurriculoOferta;
    @JoinColumns({
        @JoinColumn(name = "id_Curso", referencedColumnName = "id_Curso"),
        @JoinColumn(name = "id_Disciplina", referencedColumnName = "id_Disciplina"),
        @JoinColumn(name = "idt_Relacao", referencedColumnName = "idt_Relacao")})
    @ManyToOne(optional = false)
    private RelaçãoCursoDisciplina relaçãoCursoDisciplina;
    @JoinColumn(name = "idt_Periodo", referencedColumnName = "idt_Periodo")
    @ManyToOne(optional = false)
    private PeríodoLetivo idtPeriodo;

    public CurrículoemOferta() {
    }

    public CurrículoemOferta(Integer idCurriculoOferta) {
        this.idCurriculoOferta = idCurriculoOferta;
    }

    public Integer getIdCurriculoOferta() {
        return idCurriculoOferta;
    }

    public void setIdCurriculoOferta(Integer idCurriculoOferta) {
        this.idCurriculoOferta = idCurriculoOferta;
    }

    public RelaçãoCursoDisciplina getRelaçãoCursoDisciplina() {
        return relaçãoCursoDisciplina;
    }

    public void setRelaçãoCursoDisciplina(RelaçãoCursoDisciplina relaçãoCursoDisciplina) {
        this.relaçãoCursoDisciplina = relaçãoCursoDisciplina;
    }

    public PeríodoLetivo getIdtPeriodo() {
        return idtPeriodo;
    }

    public void setIdtPeriodo(PeríodoLetivo idtPeriodo) {
        this.idtPeriodo = idtPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurriculoOferta != null ? idCurriculoOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrículoemOferta)) {
            return false;
        }
        CurrículoemOferta other = (CurrículoemOferta) object;
        if ((this.idCurriculoOferta == null && other.idCurriculoOferta != null) || (this.idCurriculoOferta != null && !this.idCurriculoOferta.equals(other.idCurriculoOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Curr\u00edculoemOferta[ idCurriculoOferta=" + idCurriculoOferta + " ]";
    }
    
}
