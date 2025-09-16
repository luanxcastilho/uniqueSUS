package br.com.fiap.uniquesus.application.usecases.atendimento;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BuscarAtendimentosUseCase
{
    private final AtendimentoGateway atendimentoGateway;
    
    public BuscarAtendimentosUseCase ( AtendimentoGateway atendimentoGateway )
    {
        this.atendimentoGateway = atendimentoGateway;
    }
    
    public Page<Atendimento> executar ( Pageable pageable )
    {
        return this.atendimentoGateway.buscarAtendimentos( pageable );
    }
}
