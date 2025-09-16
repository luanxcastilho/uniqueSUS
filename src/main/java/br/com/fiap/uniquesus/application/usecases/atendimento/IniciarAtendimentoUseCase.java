package br.com.fiap.uniquesus.application.usecases.atendimento;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class IniciarAtendimentoUseCase
{
    private final AtendimentoGateway atendimentoGateway;
    private final PacienteGateway    pacienteGateway;
    
    public IniciarAtendimentoUseCase ( AtendimentoGateway atendimentoGateway , PacienteGateway pacienteGateway )
    {
        this.atendimentoGateway = atendimentoGateway;
        this.pacienteGateway    = pacienteGateway;
    }
    
    public Atendimento executar ( Long pacienteId )
    {
        Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( pacienteId )
                .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( pacienteId ) );
        
        Atendimento atendimento = new Atendimento( pacienteEncontrado );
        
        return this.atendimentoGateway.criarAtendimento( atendimento );
    }
}
