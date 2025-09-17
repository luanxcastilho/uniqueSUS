package br.com.fiap.uniquesus.application.usecases.enfermeiro;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;

public class BuscarEnfermeiroPeloIdUseCase
{
    private final EnfermeiroGateway enfermeiroGateway;
    
    public BuscarEnfermeiroPeloIdUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        this.enfermeiroGateway = enfermeiroGateway;
    }
    
    public Enfermeiro executar ( Long enfermeiroId )
    {
        return this.enfermeiroGateway.buscarEnfermeiroPeloId( enfermeiroId )
                .orElseThrow( () -> new EnfermeiroNaoEncontradoPeloIdException( enfermeiroId ) );
    }
}
