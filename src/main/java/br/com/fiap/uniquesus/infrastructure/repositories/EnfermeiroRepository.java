package br.com.fiap.uniquesus.infrastructure.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.infrastructure.entities.EnfermeiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnfermeiroRepository extends JpaRepository<EnfermeiroEntity, Long>
{
    Optional<EnfermeiroEntity> getEnfermeiroByCoren ( String coren );
    
    Optional<EnfermeiroEntity> getEnfermeiroByEnfermeiroId ( Long enfermeiroId );
}
