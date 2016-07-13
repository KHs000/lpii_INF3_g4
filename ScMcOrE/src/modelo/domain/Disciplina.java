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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alunoccc
 */
@Entity
@Table(name = "Disciplina")
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Disciplina")
    private Integer idDisciplina;
    @Basic(optional = false)
    @Column(name = "nom_Disciplina")
    private String nomDisciplina;
    @Basic(optional = false)
    @Column(name = "qtd_Carga_Horaria")
    private short qtdCargaHoraria;
    @Column(name = "des_Ementa")
    private String desEmenta;
    @JoinTable(name = "Disciplinas Ministradas", joinColumns = {
        @JoinColumn(name = "id_Disciplina", referencedColumnName = "id_Disciplina")}, inverseJoinColumns = {
        @JoinColumn(name = "cpf_Professor", referencedColumnName = "cpf_Professor")})
    @ManyToMany
    private List<Professor> professorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Modulo> relaçãoCursoDisciplinaList;

    public Disciplina() {
    }

    public Disciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Disciplina(Integer idDisciplina, String nomDisciplina, short qtdCargaHoraria) {
        this.idDisciplina = idDisciplina;
        this.nomDisciplina = nomDisciplina;
        this.qtdCargaHoraria = qtdCargaHoraria;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomDisciplina() {
        return nomDisciplina;
    }

    public void setNomDisciplina(String nomDisciplina) {
        this.nomDisciplina = nomDisciplina;
    }

    public short getQtdCargaHoraria() {
        return qtdCargaHoraria;
    }

    public void setQtdCargaHoraria(short qtdCargaHoraria) {
        this.qtdCargaHoraria = qtdCargaHoraria;
    }

    public String getDesEmenta() {
        return desEmenta;
    }

    public void setDesEmenta(String desEmenta) {
        this.desEmenta = desEmenta;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public List<Modulo> getRelaçãoCursoDisciplinaList() {
        return relaçãoCursoDisciplinaList;
    }

    public void setRelaçãoCursoDisciplinaList(List<Modulo> relaçãoCursoDisciplinaList) {
        this.relaçãoCursoDisciplinaList = relaçãoCursoDisciplinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisciplina != null ? idDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.idDisciplina == null && other.idDisciplina != null) || (this.idDisciplina != null && !this.idDisciplina.equals(other.idDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Disciplina[ idDisciplina=" + idDisciplina + " ]";
    }
    
}
