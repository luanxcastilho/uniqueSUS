package br.com.fiap.uniquesus.application.usecases.triagem;

import br.com.fiap.uniquesus.domain.entities.*;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.triagemPrioridade.TriagemPrioridadeNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BuscarTriagensUseCase
{
    private final TriagemGateway           triagemGateway;
    private final AtendimentoGateway       atendimentoGateway;
    private final EnfermeiroGateway        enfermeiroGateway;
    private final TriagemPrioridadeGateway triagemPrioridadeGateway;
    private final PacienteGateway          pacienteGateway;
    
    public BuscarTriagensUseCase ( TriagemGateway triagemGateway , AtendimentoGateway atendimentoGateway , EnfermeiroGateway enfermeiroGateway , TriagemPrioridadeGateway triagemPrioridadeGateway , PacienteGateway pacienteGateway )
    {
        this.triagemGateway           = triagemGateway;
        this.atendimentoGateway       = atendimentoGateway;
        this.enfermeiroGateway        = enfermeiroGateway;
        this.triagemPrioridadeGateway = triagemPrioridadeGateway;
        this.pacienteGateway          = pacienteGateway;
    }
    
    public Page<Triagem> executar ( Pageable pageable )
    {
        Page<Triagem> triagens = this.triagemGateway.buscarTriagens( pageable );
        
        for ( Triagem triagem : triagens )
        {
            if (triagem.getAtendimento() != null && triagem.getAtendimento().getAtendimentoId() != null)
            {
                Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloId( triagem.getAtendimento().getAtendimentoId() )
                        .orElseThrow( () -> new AtendimentoNaoEncontradoPeloIdException( triagem.getAtendimento().getAtendimentoId() ) );
                
                Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( atendimentoEncontrado.getPaciente().getPacienteId() )
                        .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( atendimentoEncontrado.getPaciente().getPacienteId() ) );
                
                atendimentoEncontrado.setPaciente( pacienteEncontrado );
                triagem.setAtendimento( atendimentoEncontrado );
            }
            
            if (triagem.getEnfermeiro() != null && triagem.getEnfermeiro().getEnfermeiroId() != null)
            {
                Enfermeiro enfermeiroEncontrado = this.enfermeiroGateway.buscarEnfermeiroPeloId( triagem.getEnfermeiro().getEnfermeiroId() )
                        .orElseThrow( () -> new EnfermeiroNaoEncontradoPeloIdException( triagem.getEnfermeiro().getEnfermeiroId() ) );
                
                triagem.setEnfermeiro( enfermeiroEncontrado );
            }
            
            if (triagem.getTriagemPrioridade() != null && triagem.getTriagemPrioridade().getTriagemPrioridadeId() != null)
            {
                TriagemPrioridade triagemPrioridadeEncontrada = this.triagemPrioridadeGateway.buscarTriagemPrioridadePeloId( triagem.getTriagemPrioridade().getTriagemPrioridadeId() )
                        .orElseThrow( () -> new TriagemPrioridadeNaoEncontradaPeloIdException( triagem.getTriagemPrioridade().getTriagemPrioridadeId() ) );
                
                triagem.setTriagemPrioridade( triagemPrioridadeEncontrada );
            }
        };
        
        return triagens;
    }
}
