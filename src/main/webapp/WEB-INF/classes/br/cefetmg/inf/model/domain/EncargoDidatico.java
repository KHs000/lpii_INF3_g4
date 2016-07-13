/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.domain;

import br.cefetmg.inf.model.domain.Disciplina;
import java.sql.Time;
import modelo.domain.Professor;

/**
 *
 * @author DASJ
 */
public class EncargoDidatico {
    
    private Long id;
    private Time horInicio;
    private Time horFim;
    private int diaSemana;
    
    private Professor professor;
    private AmbienteDeEnsino ambiente;
    private Modulo modulo;

    public Long getId() {
        return id;
    }

    public void setId(Long ID) {
        this.id = ID;
    }

    public Time getHorInicio() {
        return horInicio;
    }

    public void setHorInicio(Time horInicio) {
        this.horInicio = horInicio;
    }

    public Time getHorFim() {
        return horFim;
    }

    public void setHorFim(Time horFim) {
        this.horFim = horFim;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public AmbienteDeEnsino getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(AmbienteDeEnsino ambiente) {
        this.ambiente = ambiente;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    
    
    
}
