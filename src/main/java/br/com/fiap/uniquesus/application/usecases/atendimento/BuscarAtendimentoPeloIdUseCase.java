package br.com.fiap.uniquesus.application.usecases.atendimento;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloId;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;

import java.util.Optional;

public class BuscarAtendimentoPeloIdUseCase
{
    private final AtendimentoGateway atendimentoGateway;
    
    public BuscarAtendimentoPeloIdUseCase ( AtendimentoGateway atendimentoGateway )
    {
        this.atendimentoGateway = atendimentoGateway;
    }
    
    public Optional<Atendimento> executar ( Long atendimentoId )
    {
        return Optional.of( this.atendimentoGateway.buscarAtendimentoPeloId( atendimentoId )
                                    .orElseThrow( () -> new AtendimentoNaoEncontradoPeloId( atendimentoId ) ) );
    }
}
