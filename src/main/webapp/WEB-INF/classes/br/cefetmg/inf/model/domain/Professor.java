/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alunoccc
 */

public class Professor {
    
    private String cpfProfessor;
    private long nomProfessor;
    private String logProfessor;
    private String pwdProfessor;
    private List<Disciplina> disciplinaList;
    private List<Alocacao> alocacaoList;
    private List<EncargoDidatico> encargoDidaticoList;
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

    public List<Alocacao> getAlocacaoList() {
        return alocacaoList;
    }

    public void setAlocacaoList(List<Alocacao> alocacaoList) {
        this.alocacaoList = alocacaoList;
    }

    public List<EncargoDidatico> getEncargoDidaticoList() {
        return encargoDidaticoList;
    }

    public void setEncargoDidaticoList(List<EncargoDidatico> encargoDidaticoList) {
        this.encargoDidaticoList = encargoDidaticoList;
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
