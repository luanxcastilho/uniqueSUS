package br.com.fiap.uniquesus.infrastructure.mappers;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.infrastructure.entities.PacienteEntity;

public class PacienteMapper
{
    public static Paciente toDomain ( PacienteEntity pacienteEntity )
    {
        Paciente paciente = new Paciente();
        
        paciente.setPacienteId( pacienteEntity.getPacienteId() );
        paciente.setNome( pacienteEntity.getNome() );
        paciente.setCpf( pacienteEntity.getCpf() );
        paciente.setEmail( pacienteEntity.getEmail() );
        paciente.setTelefone( pacienteEntity.getTelefone() );
        
        return paciente;
    }
    
    public static PacienteEntity toEntity ( Paciente paciente )
    {
        PacienteEntity pacienteEntity = new PacienteEntity();
        
        pacienteEntity.setPacienteId( paciente.getPacienteId() );
        pacienteEntity.setNome( paciente.getNome() );
        pacienteEntity.setCpf( paciente.getCpf() );
        pacienteEntity.setEmail( paciente.getEmail() );
        pacienteEntity.setTelefone( paciente.getTelefone() );
        
        return pacienteEntity;
    }
}
