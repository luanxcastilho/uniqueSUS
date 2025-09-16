package br.com.fiap.uniquesus.application.usecases.medico;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BuscarMedicosUseCase
{
    private final MedicoGateway medicoGateway;
    
    public BuscarMedicosUseCase ( MedicoGateway medicoGateway )
    {
        this.medicoGateway = medicoGateway;
    }
    
    public Page<Medico> executar ( Pageable pageable )
    {
        return this.medicoGateway.buscarMedicos( pageable );
    }
}
