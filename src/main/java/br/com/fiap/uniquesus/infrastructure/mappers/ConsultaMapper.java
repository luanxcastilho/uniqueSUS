package br.com.fiap.uniquesus.infrastructure.mappers;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Consulta;
import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.infrastructure.entities.ConsultaEntity;

public class ConsultaMapper
{
    public static Consulta toDomain ( ConsultaEntity consultaEntity )
    {
        Consulta consulta = new Consulta();
        
        consulta.setConsultaId( consultaEntity.getConsultaId() );
        
        if (consultaEntity.getAtendimentoId() != null)
        {
            Atendimento atendimento = new Atendimento();
            atendimento.setAtendimentoId( consultaEntity.getAtendimentoId() );
            consulta.setAtendimento( atendimento );
        }
        
        if (consultaEntity.getMedicoId() != null)
        {
            Medico medico = new Medico();
            medico.setMedicoId( consultaEntity.getMedicoId() );
            consulta.setMedico( medico );
        }
        
        consulta.setDiagnostico( consultaEntity.getDiagnostico() );
        consulta.setDataHoraInicial( consultaEntity.getDataHoraInicial() );
        consulta.setDataHoraFinal( consultaEntity.getDataHoraFinal() );
        
        return consulta;
    }
    
    public static ConsultaEntity toEntity ( Consulta consulta )
    {
        ConsultaEntity consultaEntity = new ConsultaEntity();
        
        consultaEntity.setConsultaId( consulta.getConsultaId() );
        
        if (consulta.getAtendimento() != null && consulta.getAtendimento().getAtendimentoId() != null)
        {
            consultaEntity.setAtendimentoId( consulta.getAtendimento().getAtendimentoId() );
        }
        
        if (consulta.getMedico() != null && consulta.getMedico().getMedicoId() != null)
        {
            consultaEntity.setMedicoId( consulta.getMedico().getMedicoId() );
        }
        
        consultaEntity.setDiagnostico( consulta.getDiagnostico() );
        consultaEntity.setDataHoraInicial( consulta.getDataHoraInicial() );
        consultaEntity.setDataHoraFinal( consulta.getDataHoraFinal() );
        
        return consultaEntity;
    }
}
