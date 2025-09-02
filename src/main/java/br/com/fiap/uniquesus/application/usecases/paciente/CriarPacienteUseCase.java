package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.CPFJaRegistradoException;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class CriarPacienteUseCase
{
    private final PacienteGateway pacienteGateway;
    
    public CriarPacienteUseCase ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public Paciente executar ( Paciente paciente )
    {
        if (this.pacienteGateway.buscarPacientePeloCPF( paciente.getCpf() ).isPresent())
        {
            throw new CPFJaRegistradoException( paciente.getCpf() );
        }
        return this.pacienteGateway.gravarPaciente( paciente );
    }
}
