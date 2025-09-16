package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloCpfException;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class BuscarPacientePeloCPFUseCase
{
    private final PacienteGateway pacienteGateway;
    
    public BuscarPacientePeloCPFUseCase ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public Paciente executar ( String cpf )
    {
        return this.pacienteGateway.buscarPacientePeloCPF( cpf )
                .orElseThrow( () -> new PacienteNaoEncontradoPeloCpfException( cpf ) );
    }
}
