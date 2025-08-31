package br.com.fiap.uniquesus.application.usecases.medico;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.exceptions.medico.MedicoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;

import java.util.Optional;

public class BuscarMedicoPeloIdUseCase
{
    private final MedicoGateway medicoGateway;
    
    public BuscarMedicoPeloIdUseCase ( MedicoGateway medicoGateway )
    {
        this.medicoGateway = medicoGateway;
    }
    
    public Optional<Medico> executar ( Long medicoId )
    {
        return Optional.of( this.medicoGateway.buscarMedicoPeloId( medicoId )
                                    .orElseThrow( () -> new MedicoNaoEncontradoPeloIdException( medicoId ) ) );
    }
}
