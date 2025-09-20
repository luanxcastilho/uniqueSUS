package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.CPFJaRegistradoException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class    AtualizarPacienteUseCase
{
    private final PacienteGateway pacienteGateway;
    
    public AtualizarPacienteUseCase ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public Paciente executar ( Paciente paciente )
    {
        Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( paciente.getPacienteId() )
                .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( paciente.getPacienteId() ) );
        
        if (paciente.getCpf() != null && !pacienteEncontrado.getCpf().equals( paciente.getCpf() ))
        {
            if (this.pacienteGateway.buscarPacientePeloCPF( paciente.getCpf() ).isPresent())
            {
                throw new CPFJaRegistradoException( paciente.getCpf() );
            }
            pacienteEncontrado.setCpf( paciente.getCpf() );
        }
        
        if (paciente.getNome() != null && !pacienteEncontrado.getNome().equals( paciente.getNome() ))
        {
            pacienteEncontrado.setNome( paciente.getNome() );
        }
        
        if (paciente.getEmail() != null && !pacienteEncontrado.getEmail().equals( paciente.getEmail() ))
        {
            pacienteEncontrado.setEmail( paciente.getEmail() );
        }
        
        if (paciente.getTelefone() != null && !pacienteEncontrado.getTelefone().equals( paciente.getTelefone() ))
        {
            pacienteEncontrado.setTelefone( paciente.getTelefone() );
        }
        
        return this.pacienteGateway.gravarPaciente( pacienteEncontrado );
    }
}
