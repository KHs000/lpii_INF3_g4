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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alunoccc
 */
@Entity
@Table(name = "Usu\u00e1rio")
@NamedQueries({
    @NamedQuery(name = "Usu\u00e1rio.findAll", query = "SELECT u FROM Usu\u00e1rio u")})
public class Usuário implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf_Usuario")
    private String cpfUsuario;
    @Basic(optional = false)
    @Column(name = "log_Usuario")
    private String logUsuario;
    @Basic(optional = false)
    @Column(name = "pwd_Usuario")
    private String pwdUsuario;

    public Usuário() {
    }

    public Usuário(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public Usuário(String cpfUsuario, String logUsuario, String pwdUsuario) {
        this.cpfUsuario = cpfUsuario;
        this.logUsuario = logUsuario;
        this.pwdUsuario = pwdUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getLogUsuario() {
        return logUsuario;
    }

    public void setLogUsuario(String logUsuario) {
        this.logUsuario = logUsuario;
    }

    public String getPwdUsuario() {
        return pwdUsuario;
    }

    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfUsuario != null ? cpfUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuário)) {
            return false;
        }
        Usuário other = (Usuário) object;
        if ((this.cpfUsuario == null && other.cpfUsuario != null) || (this.cpfUsuario != null && !this.cpfUsuario.equals(other.cpfUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Usu\u00e1rio[ cpfUsuario=" + cpfUsuario + " ]";
    }
    
}
