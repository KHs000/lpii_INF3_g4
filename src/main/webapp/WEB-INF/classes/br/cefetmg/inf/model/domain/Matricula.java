
package br.cefetmg.inf.model.domain;

import java.sql.Date;

/**
 *
 * @author Felipe Rabelo
 */
public class Matricula {
    
    private Long id;
    private Date dataInscricao;
    private Integer situacao;
    private Integer notaFinal;

    public Matricula() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public Integer getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Integer notaFinal) {
        this.notaFinal = notaFinal;
    }
    
}

