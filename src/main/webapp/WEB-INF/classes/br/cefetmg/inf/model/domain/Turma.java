
package br.cefetmg.inf.model.domain;

import java.sql.Date;

/**
 *
 * @author carbo
 */
public class Turma {
    
    private Long id;
    private Integer vagasLimite;
    private Date inicio;
    private Date termino;
    
    public Turma () {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVagasLimite() {
        return vagasLimite;
    }

    public void setVagasLimite(Integer vagasLimite) {
        this.vagasLimite = vagasLimite;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
