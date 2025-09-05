package br.com.fiap.uniquesus.application.usecases.enfermeiro;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;

import java.util.Optional;

public class BuscarEnfermeiroPeloIdUseCase
{
    private final EnfermeiroGateway enfermeiroGateway;
    
    public BuscarEnfermeiroPeloIdUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        this.enfermeiroGateway = enfermeiroGateway;
    }
    
    public Optional<Enfermeiro> executar ( Long enfermeiroId )
    {
        return Optional.of( this.enfermeiroGateway.buscarEnfermeiroPeloId( enfermeiroId )
                                    .orElseThrow( () -> new EnfermeiroNaoEncontradoPeloIdException( enfermeiroId ) ) );
    }
}
