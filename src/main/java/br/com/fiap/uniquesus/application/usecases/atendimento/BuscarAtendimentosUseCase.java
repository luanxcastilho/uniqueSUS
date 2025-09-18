package br.com.fiap.uniquesus.application.usecases.atendimento;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BuscarAtendimentosUseCase
{
    private final AtendimentoGateway atendimentoGateway;
    private final PacienteGateway    pacienteGateway;
    
    public BuscarAtendimentosUseCase ( AtendimentoGateway atendimentoGateway , PacienteGateway pacienteGateway )
    {
        this.atendimentoGateway = atendimentoGateway;
        this.pacienteGateway    = pacienteGateway;
    }
    
    public Page<Atendimento> executar ( Pageable pageable )
    {
        Page<Atendimento> atendimentos = this.atendimentoGateway.buscarAtendimentos( pageable );
        Paciente pacienteEncontrado;
        
        for ( Atendimento atendimento : atendimentos )
        {
            pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( atendimento.getPaciente().getPacienteId() )
                    .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( atendimento.getPaciente().getPacienteId() ) );
            
            atendimento.setPaciente( pacienteEncontrado );
        }
        
        return atendimentos;
    }
}
