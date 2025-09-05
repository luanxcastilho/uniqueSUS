package br.com.fiap.uniquesus.domain.gateways;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EnfermeiroGateway
{
    Optional<Enfermeiro> buscarEnfermeiroPeloCoren ( String coren );
    
    Optional<Enfermeiro> buscarEnfermeiroPeloId ( Long enfermeiroId );
    
    Enfermeiro gravarEnfermeiro ( Enfermeiro enfermeiro );
    
    void removerEnfermeiro ( Long enfermeiroId );
    
    Page<Enfermeiro> listarEnfermeiros ( Pageable pageable );
}
