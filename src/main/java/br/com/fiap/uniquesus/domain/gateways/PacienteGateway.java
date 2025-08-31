package br.com.fiap.uniquesus.domain.gateways;

import br.com.fiap.uniquesus.domain.entities.Paciente;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface PacienteGateway
{
    Optional<Paciente> buscarPacientePorCPF ( String cpf );
    
    Optional<Paciente> buscarPacientePeloId ( Long pacienteId );
    
    Paciente gravarPaciente ( Paciente paciente );
    
    void removerPaciente ( Long pacienteId );
    
    List<Paciente> listarPacientes ( Pageable pageable );
}
