package br.com.fiap.uniquesus.application.usecases.triagem;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.entities.Triagem;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;
import br.com.fiap.uniquesus.domain.gateways.TriagemGateway;

public class IniciarTriagemUseCase
{
    private final TriagemGateway     triagemGateway;
    private final AtendimentoGateway atendimentoGateway;
    private final EnfermeiroGateway enfermeiroGateway;
    private final PacienteGateway   pacienteGateway;
    
    public IniciarTriagemUseCase ( TriagemGateway triagemGateway , AtendimentoGateway atendimentoGateway , EnfermeiroGateway enfermeiroGateway , PacienteGateway pacienteGateway )
    {
        this.triagemGateway     = triagemGateway;
        this.atendimentoGateway = atendimentoGateway;
        this.enfermeiroGateway  = enfermeiroGateway;
        this.pacienteGateway    = pacienteGateway;
    }
    
    public Triagem executar ( Long atendimentoId , Long enfermeiroId )
    {
        Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloId( atendimentoId )
                .orElseThrow( () -> new AtendimentoNaoEncontradoPeloIdException( atendimentoId ) );
        
        Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( atendimentoEncontrado.getPaciente().getPacienteId() )
                .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( atendimentoEncontrado.getPaciente().getPacienteId() ) );
        atendimentoEncontrado.setPaciente( pacienteEncontrado );
        
        Enfermeiro enfermeiroEncontrado = this.enfermeiroGateway.buscarEnfermeiroPeloId( enfermeiroId )
                .orElseThrow( () -> new EnfermeiroNaoEncontradoPeloIdException( enfermeiroId ) );
        
        Triagem triagem = new Triagem();
        triagem.iniciarTriagem( atendimentoEncontrado , enfermeiroEncontrado );
        
        Triagem triagemCriada = this.triagemGateway.gravarTriagem( triagem );
        triagemCriada.setAtendimento( atendimentoEncontrado );
        triagemCriada.setEnfermeiro( enfermeiroEncontrado );
        
        return triagemCriada;
    }
}
