package br.com.fiap.uniquesus.application.usecases.atendimento;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloId;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;

public class FinalizarAtendimentoUseCase
{
    private final AtendimentoGateway atendimentoGateway;
    
    public FinalizarAtendimentoUseCase ( AtendimentoGateway atendimentoGateway )
    {
        this.atendimentoGateway = atendimentoGateway;
    }
    
    public Atendimento executar ( Long atendimentoId )
    {
        Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloId( atendimentoId )
                .orElseThrow( () -> new AtendimentoNaoEncontradoPeloId( atendimentoId ) );
        
        atendimentoEncontrado.finalizarAtendimento();
        
        return this.atendimentoGateway.atualizarAtendimento( atendimentoEncontrado );
    }
}
