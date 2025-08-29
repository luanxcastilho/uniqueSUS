package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.CpfJaRegistradoException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloId;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class AtualizarPacienteUseCase
{
    private final PacienteGateway pacienteGateway;
    
    public AtualizarPacienteUseCase ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public Paciente executar ( Paciente paciente )
    {
        Paciente pacienteExistente = this.pacienteGateway.buscarPacientePorId( paciente.getPacienteId() )
                .orElseThrow( () -> new PacienteNaoEncontradoPeloId( paciente.getPacienteId() ) );
        
        if (paciente.getCpf() != null && !pacienteExistente.getCpf().equals( paciente.getCpf() ))
        {
            if (this.pacienteGateway.buscarPacientePorCPF( paciente.getCpf() ).isPresent())
            {
                throw new CpfJaRegistradoException( paciente.getCpf() );
            }
            pacienteExistente.setCpf( paciente.getCpf() );
        }
        
        if (paciente.getNome() != null && !pacienteExistente.getNome().equals( paciente.getNome() ))
        {
            pacienteExistente.setNome( paciente.getNome() );
        }
        
        if (paciente.getEmail() != null && !pacienteExistente.getEmail().equals( paciente.getEmail() ))
        {
            pacienteExistente.setEmail( paciente.getEmail() );
        }
        
        if (paciente.getTelefone() != null && !pacienteExistente.getTelefone().equals( paciente.getTelefone() ))
        {
            pacienteExistente.setTelefone( paciente.getTelefone() );
        }
        
        return this.pacienteGateway.gravarPaciente( pacienteExistente );
    }
}
