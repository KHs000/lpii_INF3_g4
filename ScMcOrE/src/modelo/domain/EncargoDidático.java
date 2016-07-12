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
import javax.persistence.JoinColumns;
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
@Table(name = "Encargo Did\u00e1tico")
@NamedQueries({
    @NamedQuery(name = "EncargoDid\u00e1tico.findAll", query = "SELECT e FROM EncargoDid\u00e1tico e")})
public class EncargoDidático implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Encargo")
    private Integer idEncargo;
    @Basic(optional = false)
    @Column(name = "hor_Inicio")
    @Temporal(TemporalType.TIME)
    private Date horInicio;
    @Basic(optional = false)
    @Column(name = "hor_Fim")
    @Temporal(TemporalType.TIME)
    private Date horFim;
    @Basic(optional = false)
    @Column(name = "dia_Semana")
    private short diaSemana;
    @JoinColumns({
        @JoinColumn(name = "id_Curso", referencedColumnName = "id_Curso"),
        @JoinColumn(name = "id_Disciplina", referencedColumnName = "id_Disciplina"),
        @JoinColumn(name = "idt_Relacao", referencedColumnName = "idt_Relacao")})
    @ManyToOne(optional = false)
    private RelaçãoCursoDisciplina relaçãoCursoDisciplina;
    @JoinColumn(name = "cpf_Professor", referencedColumnName = "cpf_Professor")
    @ManyToOne(optional = false)
    private Professor cpfProfessor;
    @JoinColumn(name = "id_Ambiente", referencedColumnName = "id_Ambiente")
    @ManyToOne(optional = false)
    private AmbientesdeEnsino idAmbiente;

    public EncargoDidático() {
    }

    public EncargoDidático(Integer idEncargo) {
        this.idEncargo = idEncargo;
    }

    public EncargoDidático(Integer idEncargo, Date horInicio, Date horFim, short diaSemana) {
        this.idEncargo = idEncargo;
        this.horInicio = horInicio;
        this.horFim = horFim;
        this.diaSemana = diaSemana;
    }

    public Integer getIdEncargo() {
        return idEncargo;
    }

    public void setIdEncargo(Integer idEncargo) {
        this.idEncargo = idEncargo;
    }

    public Date getHorInicio() {
        return horInicio;
    }

    public void setHorInicio(Date horInicio) {
        this.horInicio = horInicio;
    }

    public Date getHorFim() {
        return horFim;
    }

    public void setHorFim(Date horFim) {
        this.horFim = horFim;
    }

    public short getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(short diaSemana) {
        this.diaSemana = diaSemana;
    }

    public RelaçãoCursoDisciplina getRelaçãoCursoDisciplina() {
        return relaçãoCursoDisciplina;
    }

    public void setRelaçãoCursoDisciplina(RelaçãoCursoDisciplina relaçãoCursoDisciplina) {
        this.relaçãoCursoDisciplina = relaçãoCursoDisciplina;
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
        hash += (idEncargo != null ? idEncargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncargoDidático)) {
            return false;
        }
        EncargoDidático other = (EncargoDidático) object;
        if ((this.idEncargo == null && other.idEncargo != null) || (this.idEncargo != null && !this.idEncargo.equals(other.idEncargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.EncargoDid\u00e1tico[ idEncargo=" + idEncargo + " ]";
    }
    
}
