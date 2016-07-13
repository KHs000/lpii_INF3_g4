
package br.cefetmg.inf.model.domain;

/**
 *
 * @author Felipe Rabelo
 */
public class Curso {
    
    private Long id;
    private String Nome;
    private String regime;
    private String ensino;
    private String turno;
    private String cpf_coord;
    
    public Curso () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getEnsino() {
        return ensino;
    }

    public void setEnsino(String ensino) {
        this.ensino = ensino;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCpf_coord() {
        return cpf_coord;
    }

    public void setCpf_coord(String cpf_coord) {
        this.cpf_coord = cpf_coord;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
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
