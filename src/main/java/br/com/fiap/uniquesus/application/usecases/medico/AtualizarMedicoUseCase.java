package br.com.fiap.uniquesus.application.usecases.medico;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.exceptions.medico.CRMJaRegistradoException;
import br.com.fiap.uniquesus.domain.exceptions.medico.MedicoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;

public class AtualizarMedicoUseCase
{
    private final MedicoGateway medicoGateway;
    
    public AtualizarMedicoUseCase ( MedicoGateway medicoGateway )
    {
        this.medicoGateway = medicoGateway;
    }
    
    public Medico executar ( Medico medico )
    {
        Medico medicoEncontrado = this.medicoGateway.buscarMedicoPeloId( medico.getMedicoId() )
                .orElseThrow( () -> new MedicoNaoEncontradoPeloIdException( medico.getMedicoId() ) );
        
        if (medico.getCrm() != null && !medicoEncontrado.getCrm().equals( medico.getCrm() ))
        {
            if (this.medicoGateway.buscarMedicoPeloCRM( medico.getCrm() ).isPresent())
            {
                throw new CRMJaRegistradoException( medico.getCrm() );
            }
            medicoEncontrado.setCrm( medico.getCrm() );
        }
        
        if (medico.getNome() != null && !medicoEncontrado.getNome().equals( medico.getNome() ))
        {
            medicoEncontrado.setNome( medico.getNome() );
        }
        
        return this.medicoGateway.gravarMedico( medicoEncontrado );
    }
}
