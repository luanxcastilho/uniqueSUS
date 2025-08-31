package br.com.fiap.uniquesus.application.usecases.medico;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.exceptions.medico.CRMJaRegistradoException;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;

public class CriarMedicoUseCase
{
    private final MedicoGateway medicoGateway;
    
    public CriarMedicoUseCase ( MedicoGateway medicoGateway )
    {
        this.medicoGateway = medicoGateway;
    }
    
    public Medico executar ( Medico medico )
    {
        if (this.medicoGateway.buscarMedicoPeloCRM( medico.getCrm() ).isPresent())
        {
            throw new CRMJaRegistradoException( medico.getCrm() );
        }
        return this.medicoGateway.gravarMedico( medico );
    }
}
