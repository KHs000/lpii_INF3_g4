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
@Table(name = "Curso")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Curso")
    private Integer idCurso;
    @Basic(optional = false)
    @Column(name = "nom_Curso")
    private String nomCurso;
    @Basic(optional = false)
    @Column(name = "idt_Regime")
    private Character idtRegime;
    @Basic(optional = false)
    @Column(name = "nvl_Ensino")
    private Character nvlEnsino;
    @Basic(optional = false)
    @Column(name = "idt_Turno")
    private Character idtTurno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<RelaçãoCursoDisciplina> relaçãoCursoDisciplinaList;
    @JoinColumn(name = "cpf_Coordenador", referencedColumnName = "cpf_Professor")
    @ManyToOne(optional = false)
    private Professor cpfCoordenador;
    @JoinColumn(name = "id_Departamento", referencedColumnName = "id_Departamento")
    @ManyToOne(optional = false)
    private Departamento idDepartamento;

    public Curso() {
    }

    public Curso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(Integer idCurso, String nomCurso, Character idtRegime, Character nvlEnsino, Character idtTurno) {
        this.idCurso = idCurso;
        this.nomCurso = nomCurso;
        this.idtRegime = idtRegime;
        this.nvlEnsino = nvlEnsino;
        this.idtTurno = idtTurno;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public Character getIdtRegime() {
        return idtRegime;
    }

    public void setIdtRegime(Character idtRegime) {
        this.idtRegime = idtRegime;
    }

    public Character getNvlEnsino() {
        return nvlEnsino;
    }

    public void setNvlEnsino(Character nvlEnsino) {
        this.nvlEnsino = nvlEnsino;
    }

    public Character getIdtTurno() {
        return idtTurno;
    }

    public void setIdtTurno(Character idtTurno) {
        this.idtTurno = idtTurno;
    }

    public List<RelaçãoCursoDisciplina> getRelaçãoCursoDisciplinaList() {
        return relaçãoCursoDisciplinaList;
    }

    public void setRelaçãoCursoDisciplinaList(List<RelaçãoCursoDisciplina> relaçãoCursoDisciplinaList) {
        this.relaçãoCursoDisciplinaList = relaçãoCursoDisciplinaList;
    }

    public Professor getCpfCoordenador() {
        return cpfCoordenador;
    }

    public void setCpfCoordenador(Professor cpfCoordenador) {
        this.cpfCoordenador = cpfCoordenador;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Curso[ idCurso=" + idCurso + " ]";
    }
    
}
