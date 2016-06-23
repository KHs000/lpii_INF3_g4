
package br.cefetmg.inf.model.domain;

/**
 *
 * @author Felipe Rabelo
 */
public class Departamento {
    private Long id;
    private String sigla;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String url;
    private UnidadeDeEnsino unidadeDeEnsino;

    public Departamento() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UnidadeDeEnsino getUnidadeDeEnsino() {
        return unidadeDeEnsino;
    }

    public void setUnidadeDeEnsino(UnidadeDeEnsino unidadeDeEnsino) {
        this.unidadeDeEnsino = unidadeDeEnsino;
    }
}
