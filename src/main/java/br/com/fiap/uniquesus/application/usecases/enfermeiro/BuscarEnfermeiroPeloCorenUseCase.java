package br.com.fiap.uniquesus.application.usecases.enfermeiro;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloCorenException;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;

import java.util.Optional;

public class BuscarEnfermeiroPeloCorenUseCase
{
    private final EnfermeiroGateway enfermeiroGateway;
    
    public BuscarEnfermeiroPeloCorenUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        this.enfermeiroGateway = enfermeiroGateway;
    }
    
    public Optional<Enfermeiro> executar ( String coren )
    {
        return Optional.of( this.enfermeiroGateway.buscarEnfermeiroPeloCoren( coren )
                                    .orElseThrow( () -> new EnfermeiroNaoEncontradoPeloCorenException( coren ) ) );
    }
}
