package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloCpfException;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

import java.util.Optional;

public class BuscarPacientePeloCPFUseCase
{
    private final PacienteGateway pacienteGateway;
    
    public BuscarPacientePeloCPFUseCase ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public Optional<Paciente> executar ( String cpf )
    {
        return Optional.of( this.pacienteGateway.buscarPacientePorCPF( cpf )
                                    .orElseThrow( () -> new PacienteNaoEncontradoPeloCpfException( cpf ) ) );
    }
}
