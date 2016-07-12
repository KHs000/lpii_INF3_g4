/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.domain;


/**
 *
 * @author alunoccc
 */

public class Usuario {
    
    private String cpfUsuario;
    private String logUsuario;
    private String pwdUsuario;

    public Usuario() {
    }

    public Usuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public Usuario(String cpfUsuario, String logUsuario, String pwdUsuario) {
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.cpfUsuario == null && other.cpfUsuario != null) || (this.cpfUsuario != null && !this.cpfUsuario.equals(other.cpfUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.domain.Usuario[ cpfUsuario=" + cpfUsuario + " ]";
    }
    
}
