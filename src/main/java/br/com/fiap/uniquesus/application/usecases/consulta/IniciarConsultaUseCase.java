package br.com.fiap.uniquesus.application.usecases.consulta;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Consulta;
import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.medico.MedicoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.domain.gateways.ConsultaGateway;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

public class IniciarConsultaUseCase
{
    private final ConsultaGateway    consultaGateway;
    private final AtendimentoGateway atendimentoGateway;
    private final MedicoGateway      medicoGateway;
    private final PacienteGateway    pacienteGateway;
    
    public IniciarConsultaUseCase ( ConsultaGateway consultaGateway , AtendimentoGateway atendimentoGateway , MedicoGateway medicoGateway , PacienteGateway pacienteGateway )
    {
        this.consultaGateway    = consultaGateway;
        this.atendimentoGateway = atendimentoGateway;
        this.medicoGateway      = medicoGateway;
        this.pacienteGateway    = pacienteGateway;
    }
    
    public Consulta executar ( Long atendimentoId , Long medicoId )
    {
        Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloId( atendimentoId )
                .orElseThrow( () -> new AtendimentoNaoEncontradoPeloIdException( atendimentoId ));
        
        Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( atendimentoEncontrado.getPaciente().getPacienteId() )
                .orElseThrow(() -> new PacienteNaoEncontradoPeloIdException( atendimentoEncontrado.getPaciente().getPacienteId() ) );
        
        atendimentoEncontrado.setPaciente( pacienteEncontrado );
        
        Medico medicoEncontrado = this.medicoGateway.buscarMedicoPeloId( medicoId )
                .orElseThrow( () -> new MedicoNaoEncontradoPeloIdException( medicoId ));
                
        Consulta consulta = new Consulta().iniciarConsulta( atendimentoEncontrado , medicoEncontrado );
        
        Consulta consultaCriada = this.consultaGateway.gravarConsulta( consulta );
        
        consultaCriada.setAtendimento( atendimentoEncontrado );
        consultaCriada.setMedico( medicoEncontrado );
        
        return consultaCriada;
    }
}
