package br.com.fiap.uniquesus.application.usecases.triagem;

import br.com.fiap.uniquesus.domain.entities.*;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.triagem.TriagemNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.triagemPrioridade.TriagemPrioridadeNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.*;
import br.com.fiap.uniquesus.infrastructure.dtos.triagem.FinalizarTriagemRequestDTO;

public class FinalizarTriagemUseCase
{
    private final TriagemGateway           triagemGateway;
    private final AtendimentoGateway       atendimentoGateway;
    private final EnfermeiroGateway        enfermeiroGateway;
    private final TriagemPrioridadeGateway triagemPrioridadeGateway;
    private final PacienteGateway          pacienteGateway;
    
    public FinalizarTriagemUseCase ( TriagemGateway triagemGateway , AtendimentoGateway atendimentoGateway , EnfermeiroGateway enfermeiroGateway , TriagemPrioridadeGateway triagemPrioridadeGateway , PacienteGateway pacienteGateway )
    {
        this.triagemGateway           = triagemGateway;
        this.atendimentoGateway       = atendimentoGateway;
        this.enfermeiroGateway        = enfermeiroGateway;
        this.triagemPrioridadeGateway = triagemPrioridadeGateway;
        this.pacienteGateway          = pacienteGateway;
    }
    
    public Triagem executar ( Long triagemId, FinalizarTriagemRequestDTO finalizarTriagemRequestDTO )
    {
        Triagem triagemEncontrada = this.triagemGateway.buscarTriagemPeloId( triagemId )
                .orElseThrow( () -> new TriagemNaoEncontradaPeloIdException( triagemId ) );
        
        
        TriagemPrioridade triagemPrioridadeEncontrada = this.triagemPrioridadeGateway.buscarTriagemPrioridadePeloId( finalizarTriagemRequestDTO.getTriagemPrioridadeId() )
                .orElseThrow( () -> new TriagemPrioridadeNaoEncontradaPeloIdException( finalizarTriagemRequestDTO.getTriagemPrioridadeId() ) );
        
        triagemEncontrada.finalizarTriagem(triagemPrioridadeEncontrada, finalizarTriagemRequestDTO.getSintomas());
        
        Triagem triagemCriada = this.triagemGateway.gravarTriagem( triagemEncontrada );
        
        // Recarregar as entidades relacionadas
        if (triagemCriada.getAtendimento() != null && triagemCriada.getAtendimento().getAtendimentoId() != null)
        {
            Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloId( triagemCriada.getAtendimento().getAtendimentoId() )
                    .orElseThrow( () -> new AtendimentoNaoEncontradoPeloIdException( triagemCriada.getAtendimento().getAtendimentoId() ) );
            
            Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( atendimentoEncontrado.getPaciente().getPacienteId() )
                    .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( atendimentoEncontrado.getPaciente().getPacienteId() ) );
            atendimentoEncontrado.setPaciente( pacienteEncontrado );
            
            triagemCriada.setAtendimento( atendimentoEncontrado );
        }
        
        if (triagemCriada.getEnfermeiro() != null && triagemCriada.getEnfermeiro().getEnfermeiroId() != null)
        {
            Enfermeiro enfermeiroEncontrado = this.enfermeiroGateway.buscarEnfermeiroPeloId( triagemCriada.getEnfermeiro().getEnfermeiroId() )
                    .orElseThrow( () -> new EnfermeiroNaoEncontradoPeloIdException( triagemCriada.getEnfermeiro().getEnfermeiroId() ) );
            
            triagemCriada.setEnfermeiro( enfermeiroEncontrado );
        }
        
        if (triagemCriada.getTriagemPrioridade() != null && triagemCriada.getTriagemPrioridade().getTriagemPrioridadeId() != null)
        {
            triagemCriada.setTriagemPrioridade( triagemPrioridadeEncontrada );
        }
        
        return triagemCriada;
    }
}
