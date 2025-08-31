package br.com.fiap.uniquesus.application.usecases.medico;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.exceptions.medico.MedicoNaoEncontradoPeloCRMException;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;

import java.util.Optional;

public class BuscarMedicoPeloCRMUseCase
{
    private final MedicoGateway medicoGateway;
    
    public BuscarMedicoPeloCRMUseCase ( MedicoGateway medicoGateway )
    {
        this.medicoGateway = medicoGateway;
    }
    
    public Optional<Medico> executar ( String crm )
    {
        return Optional.of( this.medicoGateway.buscarMedicoPeloCRM( crm )
                                    .orElseThrow( () -> new MedicoNaoEncontradoPeloCRMException( crm ) ) );
    }
}
