package br.com.fiap.uniquesus.application.usecases.consulta;

import br.com.fiap.uniquesus.application.outputs.PosicaoNaFilaDeConsultaOutput;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.ConsultaGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;
import br.com.fiap.uniquesus.infrastructure.projections.PosicaoNaFilaDeConsultaProjection;

public class BuscarPosicaoNaFilaDeConsultaUseCase
{
    private final ConsultaGateway consultaGateway;
    private final PacienteGateway pacienteGateway;
    
    public BuscarPosicaoNaFilaDeConsultaUseCase ( ConsultaGateway consultaGateway , PacienteGateway pacienteGateway )
    {
        this.consultaGateway = consultaGateway;
        this.pacienteGateway = pacienteGateway;
    }
    
    public PosicaoNaFilaDeConsultaOutput executar ( Long pacienteId )
    {
        Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( pacienteId )
                .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( pacienteId ) );
        
        PosicaoNaFilaDeConsultaProjection posicaoNaFilaDeConsultaProjection = this.consultaGateway.buscarPosicaoNaFilaDeConsulta( pacienteId );
        
        int posicaoAtual = posicaoNaFilaDeConsultaProjection.getPosicaoNaFila();
        int totalFila = posicaoNaFilaDeConsultaProjection.getTotalNaFila();
        
        return new PosicaoNaFilaDeConsultaOutput( pacienteId , posicaoAtual , totalFila );
    }
}
