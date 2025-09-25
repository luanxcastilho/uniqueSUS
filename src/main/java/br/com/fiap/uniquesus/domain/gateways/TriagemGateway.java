package br.com.fiap.uniquesus.domain.gateways;

import br.com.fiap.uniquesus.application.outputs.PosicaoNaFilaDeTriagemOutput;
import br.com.fiap.uniquesus.domain.entities.Triagem;
import br.com.fiap.uniquesus.infrastructure.projections.PosicaoNaFilaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TriagemGateway
{
    Optional<Triagem> buscarTriagemPeloId ( Long triagemId );
    
    Triagem gravarTriagem ( Triagem triagem );
    
    void removerTriagem ( Long triagemId );
    
    Page<Triagem> buscarTriagens ( Pageable pageable );
    
    PosicaoNaFilaProjection buscarPosicaoNaFilaDeTriagem ( Long pacienteId );
}
