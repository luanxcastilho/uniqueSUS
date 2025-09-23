package br.com.fiap.uniquesus.adapter.presenters;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Consulta;
import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.infrastructure.dtos.consulta.ConsultaResponseDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.consulta.FinalizarConsultaRequestDTO;
import org.springframework.data.domain.Page;

public class ConsultaPresenter
{
    public static ConsultaResponseDTO toDTO ( Consulta consulta )
    {
        ConsultaResponseDTO consultaResponseDTO = new ConsultaResponseDTO();
        
        consultaResponseDTO.setConsultaId( consulta.getConsultaId() );
        consultaResponseDTO.setAtendimento( consulta.getAtendimento() );
        consultaResponseDTO.setMedico( consulta.getMedico() );
        consultaResponseDTO.setDiagnostico( consulta.getDiagnostico() );
        consultaResponseDTO.setDataHoraInicial( consulta.getDataHoraInicial() );
        consultaResponseDTO.setDataHoraFinal( consulta.getDataHoraFinal() );
        
        return consultaResponseDTO;
    }
    
    public static Page<ConsultaResponseDTO> toDTO ( Page<Consulta> consultas )
    {
        return consultas.map( ConsultaPresenter::toDTO );
    }
    
    public static Consulta toDomain ( FinalizarConsultaRequestDTO finalizarConsultaRequestDTO )
    {
        Consulta consulta = new Consulta();
        consulta.setDiagnostico( finalizarConsultaRequestDTO.getDiagnostico() );
        
        return consulta;
    }
    
    public static Consulta toDomain ( Long consultaId , FinalizarConsultaRequestDTO finalizarConsultaRequestDTO )
    {
        Consulta consulta = toDomain( finalizarConsultaRequestDTO );
        consulta.setConsultaId( consultaId );
        return consulta;
    }
}
