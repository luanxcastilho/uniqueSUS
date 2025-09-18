package br.com.fiap.uniquesus.application.usecases.atendimento;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class FinalizarAtendimentoUseCase
{
    private final AtendimentoGateway atendimentoGateway;
    private final PacienteGateway pacienteGateway;
    
    public FinalizarAtendimentoUseCase ( AtendimentoGateway atendimentoGateway , PacienteGateway pacienteGateway )
    {
        this.atendimentoGateway = atendimentoGateway;
        this.pacienteGateway    = pacienteGateway;
    }
    
    public Atendimento executar ( Long atendimentoId )
    {
        Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloId( atendimentoId )
                .orElseThrow( () -> new AtendimentoNaoEncontradoPeloIdException( atendimentoId ) );
        
        Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( atendimentoEncontrado.getPaciente().getPacienteId() )
                .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( atendimentoEncontrado.getPaciente().getPacienteId() ) );
        
        atendimentoEncontrado.finalizarAtendimento();
        
        Atendimento atendimentoFinalizado = this.atendimentoGateway.gravarAtendimento( atendimentoEncontrado );
        atendimentoFinalizado.setPaciente( pacienteEncontrado );
        
        return atendimentoFinalizado;
    }
}
