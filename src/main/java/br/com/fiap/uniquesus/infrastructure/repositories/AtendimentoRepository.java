package br.com.fiap.uniquesus.infrastructure.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import br.com.fiap.uniquesus.infrastructure.entities.AtendimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Long>
{
    
    AtendimentoEntity findAtendimentoEntityByPacienteId ( Long pacienteId );
}
