package br.com.fiap.uniquesus.domain.gateways;

import br.com.fiap.uniquesus.domain.entities.Medico;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MedicoGateway
{
    Optional<Medico> buscarMedicoPeloCRM ( String crm );
    
    Optional<Medico> buscarMedicoPeloId ( Long medicoId );
    
    Medico gravarMedico ( Medico medico );
    
    void removerMedico ( Long medicoId );
    
    List<Medico> listarMedicos ( Pageable pageable );
}
