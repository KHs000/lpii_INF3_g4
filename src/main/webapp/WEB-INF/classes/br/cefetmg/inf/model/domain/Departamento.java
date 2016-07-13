
package br.cefetmg.inf.model.domain;

/**
 *
 * @author Felipe Rabelo
 */
public class Departamento {
    private Long id;
    private String nome;
    private UnidadeDeEnsino unidadeDeEnsino;

    public Departamento() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UnidadeDeEnsino getUnidadeDeEnsino() {
        return unidadeDeEnsino;
    }

    public void setUnidadeDeEnsino(UnidadeDeEnsino unidadeDeEnsino) {
        this.unidadeDeEnsino = unidadeDeEnsino;
    }
}
