package br.com.fiap.uniquesus.infrastructure.repositories;

import br.com.fiap.uniquesus.infrastructure.entities.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long>
{
    Optional<MedicoEntity> getMedicoByCrm ( String crm );
}
