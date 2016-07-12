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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alunoccc
 */
@Entity
@Table(name = "Unidade de Ensino")
@NamedQueries({
    @NamedQuery(name = "UnidadedeEnsino.findAll", query = "SELECT u FROM UnidadedeEnsino u")})
public class UnidadedeEnsino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Unidade")
    private Integer idUnidade;
    @Basic(optional = false)
    @Column(name = "nom_Unidade_Ensino")
    private String nomUnidadeEnsino;

    public UnidadedeEnsino() {
    }

    public UnidadedeEnsino(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public UnidadedeEnsino(Integer idUnidade, String nomUnidadeEnsino) {
        this.idUnidade = idUnidade;
        this.nomUnidadeEnsino = nomUnidadeEnsino;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getNomUnidadeEnsino() {
        return nomUnidadeEnsino;
    }

    public void setNomUnidadeEnsino(String nomUnidadeEnsino) {
        this.nomUnidadeEnsino = nomUnidadeEnsino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidade != null ? idUnidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadedeEnsino)) {
            return false;
        }
        UnidadedeEnsino other = (UnidadedeEnsino) object;
        if ((this.idUnidade == null && other.idUnidade != null) || (this.idUnidade != null && !this.idUnidade.equals(other.idUnidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.UnidadedeEnsino[ idUnidade=" + idUnidade + " ]";
    }
    
}
