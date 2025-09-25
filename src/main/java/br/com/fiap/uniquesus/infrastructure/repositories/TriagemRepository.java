package br.com.fiap.uniquesus.infrastructure.repositories;

import br.com.fiap.uniquesus.infrastructure.entities.TriagemEntity;
import br.com.fiap.uniquesus.infrastructure.projections.PosicaoNaFilaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TriagemRepository extends JpaRepository<TriagemEntity, Long>
{
    @Query(value = """
select ( select count(1)
         from atendimento xa
         where xa.id_atendimento < a.id_atendimento
           and not exists ( select 1
                            from triagem xb
                            where xa.id_atendimento = xb.id_atendimento )) +1 as posicaoNaFila,
       ( select count(1)
           from atendimento xa
          where xa.data_hora_final is null
            and not exists ( select 1
                               from triagem xb
                              where xa.id_atendimento = xb.id_atendimento ) )  as totalNaFila
from atendimento a
where 1=1
  and a.id_paciente = :pacienteId
  and not exists ( select 1
                   from triagem xa
                   where a.id_atendimento = xa.id_atendimento )""", nativeQuery = true)
    PosicaoNaFilaProjection getPosicaoNaFilaDeTriagem ( @Param("pacienteId") Long pacienteId );
}
