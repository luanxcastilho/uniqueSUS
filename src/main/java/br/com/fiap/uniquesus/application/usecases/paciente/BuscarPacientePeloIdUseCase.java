package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

import java.util.Optional;

public class BuscarPacientePeloIdUseCase
{
    private final PacienteGateway pacienteGateway;
    
    public BuscarPacientePeloIdUseCase ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public Optional<Paciente> executar ( Long pacienteId )
    {
        return Optional.of( this.pacienteGateway.buscarPacientePeloId( pacienteId )
                                    .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( pacienteId ) ) );
    }
}
