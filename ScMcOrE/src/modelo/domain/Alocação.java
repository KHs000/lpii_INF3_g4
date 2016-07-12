/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alunoccc
 */
@Entity
@Table(name = "Aloca\u00e7\u00e3o")
@NamedQueries({
    @NamedQuery(name = "Aloca\u00e7\u00e3o.findAll", query = "SELECT a FROM Aloca\u00e7\u00e3o a")})
public class Alocação implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Alocacao")
    private Integer idAlocacao;
    @Basic(optional = false)
    @Column(name = "dat_Alocacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datAlocacao;
    @JoinColumn(name = "cpf_Professor", referencedColumnName = "cpf_Professor")
    @ManyToOne(optional = false)
    private Professor cpfProfessor;
    @JoinColumn(name = "id_Ambiente", referencedColumnName = "id_Ambiente")
    @ManyToOne(optional = false)
    private AmbientesdeEnsino idAmbiente;

    public Alocação() {
    }

    public Alocação(Integer idAlocacao) {
        this.idAlocacao = idAlocacao;
    }

    public Alocação(Integer idAlocacao, Date datAlocacao) {
        this.idAlocacao = idAlocacao;
        this.datAlocacao = datAlocacao;
    }

    public Integer getIdAlocacao() {
        return idAlocacao;
    }

    public void setIdAlocacao(Integer idAlocacao) {
        this.idAlocacao = idAlocacao;
    }

    public Date getDatAlocacao() {
        return datAlocacao;
    }

    public void setDatAlocacao(Date datAlocacao) {
        this.datAlocacao = datAlocacao;
    }

    public Professor getCpfProfessor() {
        return cpfProfessor;
    }

    public void setCpfProfessor(Professor cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public AmbientesdeEnsino getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(AmbientesdeEnsino idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlocacao != null ? idAlocacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alocação)) {
            return false;
        }
        Alocação other = (Alocação) object;
        if ((this.idAlocacao == null && other.idAlocacao != null) || (this.idAlocacao != null && !this.idAlocacao.equals(other.idAlocacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Aloca\u00e7\u00e3o[ idAlocacao=" + idAlocacao + " ]";
    }
    
}
