package br.com.fiap.uniquesus.application.usecases.medico;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.exceptions.medico.MedicoNaoEncontradoPeloCRMException;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;

public class BuscarMedicoPeloCRMUseCase
{
    private final MedicoGateway medicoGateway;
    
    public BuscarMedicoPeloCRMUseCase ( MedicoGateway medicoGateway )
    {
        this.medicoGateway = medicoGateway;
    }
    
    public Medico executar ( String crm )
    {
        return this.medicoGateway.buscarMedicoPeloCRM( crm )
                .orElseThrow( () -> new MedicoNaoEncontradoPeloCRMException( crm ) );
    }
}
