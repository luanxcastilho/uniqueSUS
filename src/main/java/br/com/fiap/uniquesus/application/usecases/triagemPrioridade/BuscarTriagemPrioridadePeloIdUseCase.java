package br.com.fiap.uniquesus.application.usecases.triagemPrioridade;

import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.domain.exceptions.triagemPrioridade.TriagemPrioridadeNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.TriagemPrioridadeGateway;

public class BuscarTriagemPrioridadePeloIdUseCase
{
    private final TriagemPrioridadeGateway triagemPrioridadeGateway;

    public BuscarTriagemPrioridadePeloIdUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        this.triagemPrioridadeGateway = triagemPrioridadeGateway;
    }

    public TriagemPrioridade executar ( Long triagemPrioridadeId )
    {
        return this.triagemPrioridadeGateway.buscarTriagemPrioridadePeloId( triagemPrioridadeId )
                .orElseThrow( () -> new TriagemPrioridadeNaoEncontradaPeloIdException( triagemPrioridadeId ) );
    }
}
