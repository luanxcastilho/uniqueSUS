package br.com.fiap.uniquesus.application.usecases.atendimento;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;

public class CriarAtendimentoUseCase
{
    private final AtendimentoGateway atendimentoGateway;
    
    public CriarAtendimentoUseCase ( AtendimentoGateway atendimentoGateway )
    {
        this.atendimentoGateway = atendimentoGateway;
    }
    
    public Atendimento executar ( Atendimento atendimento )
    {
        return this.atendimentoGateway.criarAtendimento( atendimento );
    }
}
