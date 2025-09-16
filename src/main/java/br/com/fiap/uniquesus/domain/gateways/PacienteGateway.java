package br.com.fiap.uniquesus.domain.gateways;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PacienteGateway
{
    Optional<Paciente> buscarPacientePeloCPF ( String cpf );
    
    Optional<Paciente> buscarPacientePeloId ( Long pacienteId );
    
    Paciente gravarPaciente ( Paciente paciente );
    
    void removerPaciente ( Long pacienteId );
    
    Page<Paciente> buscarPacientes ( Pageable pageable );
}
