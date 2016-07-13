/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service.impl;

import db.exception.NegocioException;
import db.exception.PersistenciaException;
import java.util.List;
import modelo.dao.impl.EncargoDidaticoDAO;
import modelo.domain.EncargoDidático;
import modelo.service.IManterEncargoDidatico;

/**
 *
 * @author helde
 */
public class ManterEncargoDidatico implements IManterEncargoDidatico {

    @Override
    public Integer cadastrar(EncargoDidático encargo) throws PersistenciaException, NegocioException {
        if (encargo.getDiaSemana()==7) {
            throw new NegocioException("As unidades não têm aulas aos domingos.");
        } 
        if (encargo.getHorFim().before(encargo.getHorInicio())) {
            throw new NegocioException("O encargo não pode terminar antes de começar.");
        }
        if(encargo.getHorInicio() == null)
            throw new NegocioException("A hora de início precisa ser informada");
        if(encargo.getHorFim() == null)
            throw new NegocioException("A hora de término precisa ser informada");
        if(encargo.getCpfProfessor() == null)
            throw new NegocioException("Precisa haver um professor para o encargo");
        if(encargo.getIdAmbiente() == null)
            throw new NegocioException("Precisa haver um ambiente para o encargo");
        if(encargo.getRelaçãoCursoDisciplina() == null)
            throw new NegocioException("É necessário um módulo para o encargo.");
        
        Integer resultado = new EncargoDidaticoDAO().inserir(encargo);
        encargo.setIdEncargo(resultado);
        return resultado;
        

    }

    @Override
    public List<EncargoDidático> listarTodos() throws PersistenciaException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(EncargoDidático encargo) throws PersistenciaException, NegocioException {
        if (encargo.getDiaSemana()==7) {
            throw new NegocioException("As unidades não têm aulas aos domingos.");
        } 
        if (encargo.getHorFim().before(encargo.getHorInicio())) {
            throw new NegocioException("O encargo não pode terminar antes de começar.");
        }
        if(encargo.getHorInicio() == null)
            throw new NegocioException("A hora de início precisa ser informada");
        if(encargo.getHorFim() == null)
            throw new NegocioException("A hora de término precisa ser informada");
        if(encargo.getCpfProfessor() == null)
            throw new NegocioException("Precisa haver um professor para o encargo");
        if(encargo.getIdAmbiente() == null)
            throw new NegocioException("Precisa haver um ambiente para o encargo");
        if(encargo.getRelaçãoCursoDisciplina() == null)
            throw new NegocioException("É necessário um módulo para o encargo.");
        if (encargo.getIdEncargo() == null) 
            throw new NegocioException("É preciso que exista o encargo.");
        new EncargoDidaticoDAO().atualizar(encargo);
        
    }

    @Override
    public void excluir(EncargoDidático encargo) throws PersistenciaException, NegocioException {
        
        if (encargo.getIdEncargo() == null) 
            throw new NegocioException("É preciso que exista o encargo.");
        new EncargoDidaticoDAO().excluir(encargo.getIdEncargo());
        
    }
    
}
