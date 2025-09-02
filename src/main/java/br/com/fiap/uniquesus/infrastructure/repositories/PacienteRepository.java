package br.com.fiap.uniquesus.infrastructure.repositories;

import br.com.fiap.uniquesus.infrastructure.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long>
{
    Optional<PacienteEntity> getPacienteByPacienteId ( Long pacienteId );
    
    Optional<PacienteEntity> getPacienteByCpf ( String cpf );
}
