package br.com.fiap.uniquesus.application.usecases.triagem;

import br.com.fiap.uniquesus.application.outputs.PosicaoNaFilaDeTriagemOutput;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;
import br.com.fiap.uniquesus.domain.gateways.TriagemGateway;
import br.com.fiap.uniquesus.infrastructure.projections.PosicaoNaFilaProjection;


public class BuscarPosicaoNaFilaDeTriagemUseCase
{
    private final TriagemGateway  triagemGateway;
    private final PacienteGateway pacienteGateway;
    
    public BuscarPosicaoNaFilaDeTriagemUseCase ( TriagemGateway triagemGateway , PacienteGateway pacienteGateway )
    {
        this.triagemGateway  = triagemGateway;
        this.pacienteGateway = pacienteGateway;
    }
    
    public PosicaoNaFilaDeTriagemOutput executar ( Long pacienteId )
    {
        Paciente pacienteEncontrado = this.pacienteGateway.buscarPacientePeloId( pacienteId )
                .orElseThrow( () -> new PacienteNaoEncontradoPeloIdException( pacienteId ) );
        
        
        PosicaoNaFilaProjection posicaoNaFilaProjection = this.triagemGateway.buscarPosicaoNaFilaDeTriagem( pacienteId );
        
        int posicaoAtual = posicaoNaFilaProjection.getPosicaoNaFila();
        int totalFila    = posicaoNaFilaProjection.getTotalNaFila();
        
        return new PosicaoNaFilaDeTriagemOutput( pacienteId , posicaoAtual , totalFila );
    }
}
