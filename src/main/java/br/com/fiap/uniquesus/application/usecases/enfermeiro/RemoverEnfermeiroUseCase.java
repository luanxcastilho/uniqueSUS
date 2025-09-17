package br.com.fiap.uniquesus.application.usecases.enfermeiro;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;

public class RemoverEnfermeiroUseCase
{
    private final EnfermeiroGateway enfermeiroGateway;
    
    public RemoverEnfermeiroUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        this.enfermeiroGateway = enfermeiroGateway;
    }
    
    public void executar ( Long enfermeiroId )
    {
        Enfermeiro enfermeiro = this.enfermeiroGateway.buscarEnfermeiroPeloId( enfermeiroId )
                .orElseThrow( () -> new EnfermeiroNaoEncontradoPeloIdException( enfermeiroId ) );
        
        this.enfermeiroGateway.removerEnfermeiro( enfermeiroId );
    }
}
