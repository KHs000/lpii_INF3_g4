/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author alunoccc
 */
@Embeddable
public class ModuloPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idt_Relacao")
    private Integer idtRelacao;
    @Basic(optional = false)
    @Column(name = "id_Curso")
    private int idCurso;
    @Basic(optional = false)
    @Column(name = "id_Disciplina")
    private int idDisciplina;

    public ModuloPK() {
    }

    public ModuloPK(int idtRelacao, int idCurso, int idDisciplina) {
        this.idtRelacao = idtRelacao;
        this.idCurso = idCurso;
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdtRelacao() {
        return idtRelacao;
    }

    public void setIdtRelacao(Integer idtRelacao) {
        this.idtRelacao = idtRelacao;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtRelacao;
        hash += (int) idCurso;
        hash += (int) idDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuloPK)) {
            return false;
        }
        ModuloPK other = (ModuloPK) object;
        if (this.idtRelacao != other.idtRelacao) {
            return false;
        }
        if (this.idCurso != other.idCurso) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Rela\u00e7\u00e3oCursoDisciplinaPK[ idtRelacao=" + idtRelacao + ", idCurso=" + idCurso + ", idDisciplina=" + idDisciplina + " ]";
    }
    
}
