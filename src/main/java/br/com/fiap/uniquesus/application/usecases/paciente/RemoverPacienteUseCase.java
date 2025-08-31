package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class RemoverPacienteUseCase
{
    private final PacienteGateway pacienteGateway;
    
    public RemoverPacienteUseCase ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public void executar ( Long pacienteId )
    {
        Paciente paciente = this.pacienteGateway.buscarPacientePeloId( pacienteId )
                                    .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( pacienteId ) );
        
        this.pacienteGateway.removerPaciente( pacienteId );
    }
}
