package br.com.fiap.uniquesus.application.usecases.triagemPrioridade;

import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.domain.gateways.TriagemPrioridadeGateway;

public class CriarTriagemPrioridadeUseCase
{
    private final TriagemPrioridadeGateway triagemPrioridadeGateway;
    
    public CriarTriagemPrioridadeUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        this.triagemPrioridadeGateway = triagemPrioridadeGateway;
    }
    
    public TriagemPrioridade executar ( TriagemPrioridade triagemPrioridade )
    {
        return triagemPrioridadeGateway.gravarTriagemPrioridade ( triagemPrioridade );
    }
}
