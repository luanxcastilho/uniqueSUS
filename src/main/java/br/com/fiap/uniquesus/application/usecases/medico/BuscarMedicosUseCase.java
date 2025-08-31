package br.com.fiap.uniquesus.application.usecases.medico;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BuscarMedicosUseCase
{
    private final MedicoGateway medicoGateway;
    
    public BuscarMedicosUseCase ( MedicoGateway medicoGateway )
    {
        this.medicoGateway = medicoGateway;
    }
    
    public List<Medico> executar ( Pageable pageable )
    {
        return this.medicoGateway.listarMedicos( pageable );
    }
}
