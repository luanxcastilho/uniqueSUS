package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloId;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

import java.util.Optional;

public class BuscarPacientePorId
{
    private final PacienteGateway pacienteGateway;
    
    public BuscarPacientePorId ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public Optional<Paciente> executar ( Long pacienteId )
    {
        return Optional.of( this.pacienteGateway.buscarPacientePorId( pacienteId )
                                    .orElseThrow( () -> new PacienteNaoEncontradoPeloId( pacienteId ) ) );
    }
}
