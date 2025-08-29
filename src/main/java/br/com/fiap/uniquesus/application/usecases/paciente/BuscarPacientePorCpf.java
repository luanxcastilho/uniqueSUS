package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloCpf;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

import java.util.Optional;

public class BuscarPacientePorCpf
{
    private final PacienteGateway pacienteGateway;
    
    public BuscarPacientePorCpf ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public Optional<Paciente> executar ( String cpf )
    {
        return Optional.of( this.pacienteGateway.buscarPacientePorCPF( cpf )
                                    .orElseThrow( () -> new PacienteNaoEncontradoPeloCpf( cpf ) ) );
    }
}
