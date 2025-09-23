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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BuscarConsultasUseCase
{
    private final ConsultaGateway    consultaGateway;
    private final AtendimentoGateway atendimentoGateway;
    private final MedicoGateway   medicoGateway;
    private final PacienteGateway pacienteGateway;
    
    public BuscarConsultasUseCase ( ConsultaGateway consultaGateway , AtendimentoGateway atendimentoGateway , MedicoGateway medicoGateway , PacienteGateway pacienteGateway )
    {
        this.consultaGateway    = consultaGateway;
        this.atendimentoGateway = atendimentoGateway;
        this.medicoGateway      = medicoGateway;
        this.pacienteGateway    = pacienteGateway;
    }
    
    public Page<Consulta> executar ( Pageable pageable )
    {
        Page<Consulta> consultas = this.consultaGateway.buscarConsultas( pageable );
        
        //Atendimento atendimentoEncontrado;
        //Paciente pacienteEncontrado;
        //Medico medicoEncontrado;
        
        
        for ( Consulta consulta : consultas )
        {
            Atendimento atendimentoEncontrado = this.atendimentoGateway.buscarAtendimentoPeloId( consulta.getAtendimento().getAtendimentoId() )
                    .orElseThrow( () -> new AtendimentoNaoEncontradoPeloIdException( consulta.getAtendimento().getAtendimentoId() ) );
            
            Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( atendimentoEncontrado.getPaciente().getPacienteId() )
                    .orElseThrow(() -> new PacienteNaoEncontradoPeloIdException( atendimentoEncontrado.getPaciente().getPacienteId() ) );
            
            atendimentoEncontrado.setPaciente( pacienteEncontrado );
            consulta.setAtendimento(  atendimentoEncontrado );
            
            Medico medicoEncontrado = this.medicoGateway.buscarMedicoPeloId( consulta.getMedico().getMedicoId() )
                    .orElseThrow( () -> new MedicoNaoEncontradoPeloIdException( consulta.getMedico().getMedicoId() ) );
            
            consulta.setMedico( medicoEncontrado );
        }
        
        return consultas;
    }
}
