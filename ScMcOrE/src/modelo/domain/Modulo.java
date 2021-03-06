/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alunoccc
 */
@Entity
@Table(name = "Rela\u00e7\u00e3o CursoDisciplina")
@NamedQueries({
    @NamedQuery(name = "Rela\u00e7\u00e3oCursoDisciplina.findAll", query = "SELECT r FROM Rela\u00e7\u00e3oCursoDisciplina r")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModuloPK relaçãoCursoDisciplinaPK;
    @Basic(optional = false)
    @Column(name = "idt_Serie")
    private Short idtSerie;
    @Basic(optional = false)
    @Column(name = "idt_Modulo")
    private Short idtModulo;
    @JoinColumn(name = "id_Disciplina", referencedColumnName = "id_Disciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @JoinColumn(name = "id_Curso", referencedColumnName = "id_Curso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rela\u00e7\u00e3oCursoDisciplina")
    private List<EncargoDidático> encargoDidáticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rela\u00e7\u00e3oCursoDisciplina")
    private List<CurrículoemOferta> currículoemOfertaList;

    public Modulo() {
    }

    public Modulo(ModuloPK relaçãoCursoDisciplinaPK) {
        this.relaçãoCursoDisciplinaPK = relaçãoCursoDisciplinaPK;
    }

    public Modulo(ModuloPK relaçãoCursoDisciplinaPK, short idtSerie, short idtModulo) {
        this.relaçãoCursoDisciplinaPK = relaçãoCursoDisciplinaPK;
        this.idtSerie = idtSerie;
        this.idtModulo = idtModulo;
    }

    public Modulo(int idtRelacao, int idCurso, int idDisciplina) {
        this.relaçãoCursoDisciplinaPK = new ModuloPK(idtRelacao, idCurso, idDisciplina);
    }

    public ModuloPK getRelaçãoCursoDisciplinaPK() {
        return relaçãoCursoDisciplinaPK;
    }

    public void setRelaçãoCursoDisciplinaPK(ModuloPK relaçãoCursoDisciplinaPK) {
        this.relaçãoCursoDisciplinaPK = relaçãoCursoDisciplinaPK;
    }

    public Short getIdtSerie() {
        return idtSerie;
    }

    public void setIdtSerie(Short idtSerie) {
        this.idtSerie = idtSerie;
    }

    

    public Short getIdtModulo() {
        return idtModulo;
    }

    public void setIdtModulo(Short idtModulo) {
        this.idtModulo = idtModulo;
    }

   

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<EncargoDidático> getEncargoDidáticoList() {
        return encargoDidáticoList;
    }

    public void setEncargoDidáticoList(List<EncargoDidático> encargoDidáticoList) {
        this.encargoDidáticoList = encargoDidáticoList;
    }

    public List<CurrículoemOferta> getCurrículoemOfertaList() {
        return currículoemOfertaList;
    }

    public void setCurrículoemOfertaList(List<CurrículoemOferta> currículoemOfertaList) {
        this.currículoemOfertaList = currículoemOfertaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relaçãoCursoDisciplinaPK != null ? relaçãoCursoDisciplinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.relaçãoCursoDisciplinaPK == null && other.relaçãoCursoDisciplinaPK != null) || (this.relaçãoCursoDisciplinaPK != null && !this.relaçãoCursoDisciplinaPK.equals(other.relaçãoCursoDisciplinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Rela\u00e7\u00e3oCursoDisciplina[ rela\u00e7\u00e3oCursoDisciplinaPK=" + relaçãoCursoDisciplinaPK + " ]";
    }
    
}
