package br.com.fiap.uniquesus.application.usecases.triagemPrioridade;

import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.domain.exceptions.triagemPrioridade.TriagemPrioridadeNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.TriagemPrioridadeGateway;

public class RemoverTriagemPrioridadeUseCase
{
    private final TriagemPrioridadeGateway triagemPrioridadeGateway;
    
    public RemoverTriagemPrioridadeUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        this.triagemPrioridadeGateway = triagemPrioridadeGateway;
    }
    
    public void executar ( Long triagemPrioridadeId )
    {
        TriagemPrioridade triagemPrioridade = this.triagemPrioridadeGateway.buscarTriagemPrioridadePeloId( triagemPrioridadeId )
                                                .orElseThrow( () -> new TriagemPrioridadeNaoEncontradaPeloIdException( triagemPrioridadeId ));
        
        this.triagemPrioridadeGateway.removerTriagemPrioridade( triagemPrioridadeId );
    }
}
