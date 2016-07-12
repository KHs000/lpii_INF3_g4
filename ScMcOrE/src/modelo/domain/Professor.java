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
import javax.persistence.Id;
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
@Table(name = "Professor")
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")})
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf_Professor")
    private String cpfProfessor;
    @Basic(optional = false)
    @Column(name = "nom_Professor")
    private long nomProfessor;
    @Basic(optional = false)
    @Column(name = "log_Professor")
    private String logProfessor;
    @Basic(optional = false)
    @Column(name = "pwd_Professor")
    private String pwdProfessor;
    @ManyToMany(mappedBy = "professorList")
    private List<Disciplina> disciplinaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpfProfessor")
    private List<Alocação> alocaçãoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpfProfessor")
    private List<EncargoDidático> encargoDidáticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpfCoordenador")
    private List<Curso> cursoList;

    public Professor() {
    }

    public Professor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public Professor(String cpfProfessor, long nomProfessor, String logProfessor, String pwdProfessor) {
        this.cpfProfessor = cpfProfessor;
        this.nomProfessor = nomProfessor;
        this.logProfessor = logProfessor;
        this.pwdProfessor = pwdProfessor;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public long getNomProfessor() {
        return nomProfessor;
    }

    public void setNomProfessor(long nomProfessor) {
        this.nomProfessor = nomProfessor;
    }

    public String getLogProfessor() {
        return logProfessor;
    }

    public void setLogProfessor(String logProfessor) {
        this.logProfessor = logProfessor;
    }

    public String getPwdProfessor() {
        return pwdProfessor;
    }

    public void setPwdProfessor(String pwdProfessor) {
        this.pwdProfessor = pwdProfessor;
    }

    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<Disciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
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

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfProfessor != null ? cpfProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.cpfProfessor == null && other.cpfProfessor != null) || (this.cpfProfessor != null && !this.cpfProfessor.equals(other.cpfProfessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Professor[ cpfProfessor=" + cpfProfessor + " ]";
    }
    
}
