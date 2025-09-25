package br.com.fiap.uniquesus.application.usecases.atendimento;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloPacienteIdException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class BuscarAtendimentoPeloPacienteIdUseCase
{
    private final AtendimentoGateway atendimentoGateway;
    private final PacienteGateway    pacienteGateway;
    
    public BuscarAtendimentoPeloPacienteIdUseCase ( AtendimentoGateway atendimentoGateway , PacienteGateway pacienteGateway )
    {
        this.atendimentoGateway = atendimentoGateway;
        this.pacienteGateway    = pacienteGateway;
    }
    
    public Atendimento executar ( Long pacienteId )
    {
        Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloPacienteId( pacienteId )
                .orElseThrow( () -> new AtendimentoNaoEncontradoPeloPacienteIdException( pacienteId ) );
        
        Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( pacienteId )
                .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( pacienteId ) );
        
        atendimentoEncontrado.setPaciente( pacienteEncontrado );
        
        return atendimentoEncontrado;
    }
}
