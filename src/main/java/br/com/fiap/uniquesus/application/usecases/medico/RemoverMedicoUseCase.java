package br.com.fiap.uniquesus.application.usecases.medico;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.exceptions.medico.MedicoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;

public class RemoverMedicoUseCase
{
    private final MedicoGateway medicoGateway;
    
    public RemoverMedicoUseCase ( MedicoGateway medicoGateway )
    {
        this.medicoGateway = medicoGateway;
    }
    
    public void executar ( Long medicoId )
    {
        Medico medico = this.medicoGateway.buscarMedicoPeloId( medicoId )
                .orElseThrow( () -> new MedicoNaoEncontradoPeloIdException( medicoId ) );
        
        this.medicoGateway.removerMedico( medicoId );
    }
}
