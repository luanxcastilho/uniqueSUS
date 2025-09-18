package br.com.fiap.uniquesus.infrastructure.mappers;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.infrastructure.entities.AtendimentoEntity;

public class AtendimentoMapper
{
    public static Atendimento toDomain ( AtendimentoEntity atendimentoEntity )
    {
        Atendimento atendimento = new Atendimento();
        
        Paciente paciente = new Paciente();
        paciente.setPacienteId( atendimentoEntity.getPacienteId() );
        
        atendimento.setAtendimentoId( atendimentoEntity.getAtendimentoId() );
        atendimento.setPaciente( paciente );
        atendimento.setDataHoraInicial( atendimentoEntity.getDataHoraInicial() );
        atendimento.setDataHoraFinal( atendimentoEntity.getDataHoraFinal() );
        
        return atendimento;
    }
    
    public static AtendimentoEntity toEntity ( Atendimento atendimento )
    {
        AtendimentoEntity atendimentoEntity = new AtendimentoEntity();
        
        atendimentoEntity.setAtendimentoId( atendimento.getAtendimentoId() );
        atendimentoEntity.setPacienteId( atendimento.getPaciente().getPacienteId() );
        atendimentoEntity.setDataHoraInicial( atendimento.getDataHoraInicial() );
        atendimentoEntity.setDataHoraFinal( atendimento.getDataHoraFinal() );
        
        return atendimentoEntity;
    }
}
