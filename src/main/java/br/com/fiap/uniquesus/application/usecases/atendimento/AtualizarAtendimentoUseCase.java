package br.com.fiap.uniquesus.application.usecases.atendimento;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloId;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class AtualizarAtendimentoUseCase
{
    private final AtendimentoGateway atendimentoGateway;
    private final PacienteGateway    pacienteGateway;
    
    public AtualizarAtendimentoUseCase ( AtendimentoGateway atendimentoGateway , PacienteGateway pacienteGateway )
    {
        this.atendimentoGateway = atendimentoGateway;
        this.pacienteGateway    = pacienteGateway;
    }
    
    public Atendimento executar ( Atendimento atendimento )
    {
        Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloId( atendimento.getAtendimentoId() )
                .orElseThrow( () -> new AtendimentoNaoEncontradoPeloId( atendimento.getAtendimentoId() ) );
        
        if (atendimento.getPaciente() != null && !atendimentoEncontrado.getPaciente().equals( atendimento.getPaciente() ))
        {
            Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( atendimento.getPaciente().getPacienteId() )
                    .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( atendimento.getPaciente().getPacienteId() ) );
            
            atendimentoEncontrado.setPaciente( pacienteEncontrado );
        }
        
        if (atendimento.getDataHoraInicial() != null && !atendimentoEncontrado.getDataHoraInicial().equals( atendimento.getDataHoraInicial() ))
        {
            atendimentoEncontrado.setDataHoraInicial( atendimento.getDataHoraInicial() );
        }
        
        if (atendimento.getDataHoraFinal() != null && !atendimentoEncontrado.getDataHoraFinal().equals( atendimento.getDataHoraFinal() ))
        {
            atendimentoEncontrado.setDataHoraFinal( atendimento.getDataHoraFinal() );
        }
        
        return this.atendimentoGateway.atualizarAtendimento( atendimentoEncontrado );
    }
}
