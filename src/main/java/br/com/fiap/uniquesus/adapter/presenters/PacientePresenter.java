package br.com.fiap.uniquesus.adapter.presenters;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.infrastructure.dtos.PacienteRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.PacienteResponseDTO;
import org.springframework.data.domain.Page;

public class PacientePresenter
{
    public static PacienteResponseDTO toDTO ( Paciente paciente )
    {
        PacienteResponseDTO pacienteResponseDTO = new PacienteResponseDTO();
        
        pacienteResponseDTO.setPacienteId( paciente.getPacienteId() );
        pacienteResponseDTO.setNome( paciente.getNome() );
        pacienteResponseDTO.setCpf( paciente.getCpf() );
        pacienteResponseDTO.setEmail( paciente.getEmail() );
        pacienteResponseDTO.setTelefone( paciente.getTelefone() );
        
        return pacienteResponseDTO;
    }
    
    public static Page<PacienteResponseDTO> toDTO ( Page<Paciente> pacientes )
    {
        return pacientes.map( PacientePresenter::toDTO );
    }
    
    public static Paciente toDomain ( PacienteRequestDTO pacienteRequestDTO )
    {
        Paciente paciente = new Paciente();
        
        paciente.setNome( pacienteRequestDTO.getNome() );
        paciente.setCpf( pacienteRequestDTO.getCpf() );
        paciente.setEmail( pacienteRequestDTO.getEmail() );
        paciente.setTelefone( pacienteRequestDTO.getTelefone() );
        
        return paciente;
    }
    
    public static Paciente toDomain ( Long pacienteId , PacienteRequestDTO pacienteRequestDTO )
    {
        Paciente paciente = new Paciente();
        
        paciente.setPacienteId( pacienteId );
        paciente.setNome( pacienteRequestDTO.getNome() );
        paciente.setCpf( pacienteRequestDTO.getCpf() );
        paciente.setEmail( pacienteRequestDTO.getEmail() );
        paciente.setTelefone( pacienteRequestDTO.getTelefone() );
        
        return paciente;
    }
}
