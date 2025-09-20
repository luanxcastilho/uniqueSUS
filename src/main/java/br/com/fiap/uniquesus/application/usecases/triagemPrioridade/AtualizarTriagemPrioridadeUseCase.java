package br.com.fiap.uniquesus.application.usecases.triagemPrioridade;

import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.domain.exceptions.triagemPrioridade.TriagemPrioridadeNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.TriagemPrioridadeGateway;

public class AtualizarTriagemPrioridadeUseCase
{
    private final TriagemPrioridadeGateway triagemPrioridadeGateway;
    
    public AtualizarTriagemPrioridadeUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        this.triagemPrioridadeGateway = triagemPrioridadeGateway;
    }
    
    public TriagemPrioridade executar ( TriagemPrioridade triagemPrioridade )
    {
        TriagemPrioridade triagemPrioridadeEncontrada = this.triagemPrioridadeGateway.buscarTriagemPrioridadePeloId( triagemPrioridade.getTriagemPrioridadeId() ).
                orElseThrow( () -> new TriagemPrioridadeNaoEncontradaPeloIdException( triagemPrioridade.getTriagemPrioridadeId() ) );
        
        if( triagemPrioridade.getDescricao() != null && !triagemPrioridadeEncontrada.getDescricao().equals( triagemPrioridade.getDescricao() ) )
        {
            triagemPrioridadeEncontrada.setDescricao( triagemPrioridade.getDescricao() );
        }
        if( triagemPrioridade.getTempoParaAtendimento() != null && !triagemPrioridadeEncontrada.getTempoParaAtendimento().equals( triagemPrioridade.getTempoParaAtendimento() ) )
        {
            triagemPrioridadeEncontrada.setTempoParaAtendimento( triagemPrioridade.getTempoParaAtendimento() );
        }
        
        return this.triagemPrioridadeGateway.gravarTriagemPrioridade( triagemPrioridadeEncontrada );
    }
}
