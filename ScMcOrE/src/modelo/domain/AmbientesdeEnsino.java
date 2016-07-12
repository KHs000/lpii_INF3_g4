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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Ambientes de Ensino")
@NamedQueries({
    @NamedQuery(name = "AmbientesdeEnsino.findAll", query = "SELECT a FROM AmbientesdeEnsino a")})
public class AmbientesdeEnsino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Ambiente")
    private Integer idAmbiente;
    @Basic(optional = false)
    @Column(name = "nom_Ambiente")
    private int nomAmbiente;
    @Column(name = "des_Ambiente")
    private String desAmbiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbiente")
    private List<Alocação> alocaçãoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbiente")
    private List<EncargoDidático> encargoDidáticoList;
    @JoinColumn(name = "id_Unidade", referencedColumnName = "id_Unidade")
    @ManyToOne(optional = false)
    private UnidadedeEnsino idUnidade;

    public AmbientesdeEnsino() {
    }

    public AmbientesdeEnsino(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public AmbientesdeEnsino(Integer idAmbiente, int nomAmbiente) {
        this.idAmbiente = idAmbiente;
        this.nomAmbiente = nomAmbiente;
    }

    public Integer getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public int getNomAmbiente() {
        return nomAmbiente;
    }

    public void setNomAmbiente(int nomAmbiente) {
        this.nomAmbiente = nomAmbiente;
    }

    public String getDesAmbiente() {
        return desAmbiente;
    }

    public void setDesAmbiente(String desAmbiente) {
        this.desAmbiente = desAmbiente;
    }

    public List<Alocação> getAlocaçãoList() {
        return alocaçãoList;
    }

    public void setAlocaçãoList(List<Alocação> alocaçãoList) {
        this.alocaçãoList = alocaçãoList;
    }

    public List<EncargoDidático> getEncargoDidáticoList() {
        return encargoDidáticoList;
    }

    public void setEncargoDidáticoList(List<EncargoDidático> encargoDidáticoList) {
        this.encargoDidáticoList = encargoDidáticoList;
    }

    public UnidadedeEnsino getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(UnidadedeEnsino idUnidade) {
        this.idUnidade = idUnidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmbiente != null ? idAmbiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbientesdeEnsino)) {
            return false;
        }
        AmbientesdeEnsino other = (AmbientesdeEnsino) object;
        if ((this.idAmbiente == null && other.idAmbiente != null) || (this.idAmbiente != null && !this.idAmbiente.equals(other.idAmbiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.AmbientesdeEnsino[ idAmbiente=" + idAmbiente + " ]";
    }
    
}
