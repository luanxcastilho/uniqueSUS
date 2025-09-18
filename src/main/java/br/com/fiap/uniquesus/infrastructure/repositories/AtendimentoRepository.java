package br.com.fiap.uniquesus.infrastructure.repositories;

import br.com.fiap.uniquesus.infrastructure.entities.AtendimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Long>
{
    
}
