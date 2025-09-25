package br.com.fiap.uniquesus.infrastructure.gateways;

import br.com.fiap.uniquesus.domain.entities.Triagem;
import br.com.fiap.uniquesus.domain.exceptions.triagem.PacienteNaoEstaNaFilaDaTriagemException;
import br.com.fiap.uniquesus.domain.gateways.TriagemGateway;
import br.com.fiap.uniquesus.infrastructure.mappers.TriagemMapper;
import br.com.fiap.uniquesus.infrastructure.projections.PosicaoNaFilaProjection;
import br.com.fiap.uniquesus.infrastructure.repositories.TriagemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TriagemGatewayImpl implements TriagemGateway
{
    private final TriagemRepository triagemRepository;
    
    public TriagemGatewayImpl ( TriagemRepository triagemRepository )
    {
        this.triagemRepository = triagemRepository;
    }
    
    @Override
    public Optional<Triagem> buscarTriagemPeloId ( Long triagemId )
    {
        return this.triagemRepository.findById( triagemId ).map( TriagemMapper::toDomain);
    }
    
    @Override
    public Triagem gravarTriagem ( Triagem triagem )
    {
        return TriagemMapper.toDomain( this.triagemRepository.save( TriagemMapper.toEntity( triagem ) ) );
    }
    
    @Override
    public void removerTriagem ( Long triagemId )
    {
        this.triagemRepository.deleteById( triagemId );
    }
    
    @Override
    public Page<Triagem> buscarTriagens ( Pageable pageable )
    {
        return this.triagemRepository.findAll( pageable ).map( TriagemMapper::toDomain );
    }
    
    @Override
    public PosicaoNaFilaProjection buscarPosicaoNaFilaDeTriagem ( Long pacienteId )
    {
        PosicaoNaFilaProjection posicaoNaFilaProjectionEncontrada = this.triagemRepository.getPosicaoNaFilaDeTriagem( pacienteId );
        
        if (posicaoNaFilaProjectionEncontrada == null)
        {
            throw new PacienteNaoEstaNaFilaDaTriagemException( pacienteId );
        }
        return posicaoNaFilaProjectionEncontrada;
    }
    
    
}
