package br.com.fiap.uniquesus.application.usecases.triagem;

import br.com.fiap.uniquesus.domain.entities.*;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.triagem.TriagemNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.triagemPrioridade.TriagemPrioridadeNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.*;

public class BuscarTriagemPeloIdUseCase
{
    private final TriagemGateway           triagemGateway;
    private final AtendimentoGateway       atendimentoGateway;
    private final EnfermeiroGateway        enfermeiroGateway;
    private final TriagemPrioridadeGateway triagemPrioridadeGateway;
    private final PacienteGateway          pacienteGateway;
    
    public BuscarTriagemPeloIdUseCase ( TriagemGateway triagemGateway , AtendimentoGateway atendimentoGateway , EnfermeiroGateway enfermeiroGateway , TriagemPrioridadeGateway triagemPrioridadeGateway , PacienteGateway pacienteGateway )
    {
        this.triagemGateway           = triagemGateway;
        this.atendimentoGateway       = atendimentoGateway;
        this.enfermeiroGateway        = enfermeiroGateway;
        this.triagemPrioridadeGateway = triagemPrioridadeGateway;
        this.pacienteGateway          = pacienteGateway;
    }
    
    public Triagem executar ( Long triagemId )
    {
        Triagem triagemEncontrada = this.triagemGateway.buscarTriagemPeloId( triagemId )
                .orElseThrow( () -> new TriagemNaoEncontradaPeloIdException( triagemId ) );
        
        if (triagemEncontrada.getAtendimento() != null && triagemEncontrada.getAtendimento().getAtendimentoId() != null)
        {
            Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloId( triagemEncontrada.getAtendimento().getAtendimentoId() )
                    .orElseThrow( () -> new AtendimentoNaoEncontradoPeloIdException( triagemEncontrada.getAtendimento().getAtendimentoId() ) );
            
            Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( atendimentoEncontrado.getPaciente().getPacienteId() )
                    .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( atendimentoEncontrado.getPaciente().getPacienteId() ) );
            
            atendimentoEncontrado.setPaciente( pacienteEncontrado );
            triagemEncontrada.setAtendimento( atendimentoEncontrado );
        }
        
        if (triagemEncontrada.getEnfermeiro() != null && triagemEncontrada.getEnfermeiro().getEnfermeiroId() != null)
        {
            Enfermeiro enfermeiroEncontrado = this.enfermeiroGateway.buscarEnfermeiroPeloId( triagemEncontrada.getEnfermeiro().getEnfermeiroId() )
                    .orElseThrow( () -> new EnfermeiroNaoEncontradoPeloIdException( triagemEncontrada.getEnfermeiro().getEnfermeiroId() ) );
            
            triagemEncontrada.setEnfermeiro( enfermeiroEncontrado );
        }
        
        if (triagemEncontrada.getTriagemPrioridade() != null && triagemEncontrada.getTriagemPrioridade().getTriagemPrioridadeId() != null)
        {
            TriagemPrioridade triagemPrioridadeEncontrada = this.triagemPrioridadeGateway.buscarTriagemPrioridadePeloId( triagemEncontrada.getTriagemPrioridade().getTriagemPrioridadeId() )
                    .orElseThrow( () -> new TriagemPrioridadeNaoEncontradaPeloIdException( triagemEncontrada.getTriagemPrioridade().getTriagemPrioridadeId() ) );
            
            triagemEncontrada.setTriagemPrioridade( triagemPrioridadeEncontrada );
        }
        
        return triagemEncontrada;
    }
}
