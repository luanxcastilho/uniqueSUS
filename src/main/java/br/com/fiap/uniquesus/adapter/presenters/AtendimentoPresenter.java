package br.com.fiap.uniquesus.adapter.presenters;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.infrastructure.dtos.AtendimentoRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.AtendimentoResponseDTO;
import org.springframework.data.domain.Page;

public class AtendimentoPresenter
{
    public static AtendimentoResponseDTO toDTO ( Atendimento atendimento )
    {
        AtendimentoResponseDTO atendimentoResponseDTO = new AtendimentoResponseDTO();
        
        atendimentoResponseDTO.setAtendimentoId( atendimento.getAtendimentoId() );
        atendimentoResponseDTO.setPaciente( atendimento.getPaciente() );
        atendimentoResponseDTO.setDataHoraInicial( atendimento.getDataHoraInicial() );
        atendimentoResponseDTO.setDataHoraFinal( atendimento.getDataHoraFinal() );
        
        return atendimentoResponseDTO;
    }
    
    public static Page<AtendimentoResponseDTO> toDTO ( Page<Atendimento> atendimentos )
    {
        return atendimentos.map( AtendimentoPresenter::toDTO );
    }
    
    public static Atendimento toDomain ( Long atendimentoId, AtendimentoRequestDTO atendimentoRequestDTO )
    {
        Atendimento atendimento = new Atendimento();
        
        Paciente paciente = new Paciente();
        paciente.setPacienteId(  atendimentoRequestDTO.getPacienteId() );
        
        atendimento.setAtendimentoId( atendimentoId );
        atendimento.setPaciente( paciente );
        
        return atendimento;
    }
    
    public static Atendimento toDomain ( AtendimentoResponseDTO atendimentoResponseDTO )
    {
        Atendimento atendimento = new Atendimento();
        
        atendimento.setAtendimentoId( atendimentoResponseDTO.getAtendimentoId() );
        atendimento.setPaciente( atendimentoResponseDTO.getPaciente() );
        atendimento.setDataHoraInicial( atendimentoResponseDTO.getDataHoraInicial() );
        atendimento.setDataHoraFinal( atendimentoResponseDTO.getDataHoraFinal() );
        
        return atendimento;
    }
}
