package br.com.fiap.uniquesus.infrastructure.repositories;

import br.com.fiap.uniquesus.infrastructure.entities.ConsultaEntity;
import br.com.fiap.uniquesus.infrastructure.projections.PosicaoNaFilaDeConsultaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long>
{
    @Query(value = """
select (
            select count(1)
              from atendimento xa
             inner join triagem xb
                on xb.id_atendimento = xa.id_atendimento
             where 1=1
               and xa.data_hora_final is null
               and xb.data_hora_final is not null
               and not exists ( select 1 from consulta xa
                                where xa.id_atendimento = a.id_atendimento
                                  and xa.data_hora_final is not null)
       ) totalNaFila,

       (
            select count(1)
              from atendimento xa
             inner join triagem xb
                on xb.id_atendimento = xa.id_atendimento
             inner join triagem_prioridade xc
                on xc.id_triagem_prioridade = xb.id_triagem_prioridade
             where 1=1
               and ( xc.tempo_atendimento < c.tempo_atendimento or ( xc.tempo_atendimento = c.tempo_atendimento and xa.id_atendimento < a.id_atendimento) )
               and xa.data_hora_final is null
               and xb.data_hora_final is not null
               and not exists ( select 1 from consulta xa
                                where xa.id_atendimento = a.id_atendimento
                                  and xa.data_hora_final is not null)
       )+1
       posicaoNaFila,

       a.*,
       c.*

  from atendimento a

 inner join triagem b
    on b.id_atendimento = a.id_atendimento

 inner join triagem_prioridade c
    on c.id_triagem_prioridade = b.id_triagem_prioridade

 where 1=1
   and a.id_paciente = :pacienteId
   and a.data_hora_final is null
   and b.data_hora_final is not null
   and not exists ( select 1 from consulta xa
                     where xa.id_atendimento = a.id_atendimento
                       and xa.data_hora_final is not null)""", nativeQuery = true)
    PosicaoNaFilaDeConsultaProjection getPosicaoNaFilaDeConsulta ( @Param( "pacienteId" ) Long pacienteId );
}
