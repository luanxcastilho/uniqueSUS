package br.com.fiap.uniquesus.infrastructure.gateways;

import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.domain.gateways.TriagemPrioridadeGateway;
import br.com.fiap.uniquesus.infrastructure.mappers.TriagemPrioridadeMapper;
import br.com.fiap.uniquesus.infrastructure.repositories.TriagemPrioridadeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TriagemPrioridadeGatewayImpl implements TriagemPrioridadeGateway
{
    private final TriagemPrioridadeRepository triagemPrioridadeRepository;
    
    public TriagemPrioridadeGatewayImpl ( TriagemPrioridadeRepository triagemPrioridadeRepository )
    {
        this.triagemPrioridadeRepository = triagemPrioridadeRepository;
    }
    
    @Override
    public Optional<TriagemPrioridade> buscarTriagemPrioridadePeloId ( Long triagemPrioridadeId )
    {
        return this.triagemPrioridadeRepository.findById( triagemPrioridadeId ).map( TriagemPrioridadeMapper::toDomain );
    }
    
    @Override
    public TriagemPrioridade gravarTriagemPrioridade ( TriagemPrioridade triagemPrioridade )
    {
        return TriagemPrioridadeMapper.toDomain( this.triagemPrioridadeRepository.save( TriagemPrioridadeMapper.toEntity( triagemPrioridade ) ) );
    }
    
    @Override
    public void removerTriagemPrioridade ( Long triagemPrioridadeId )
    {
        this.triagemPrioridadeRepository.deleteById( triagemPrioridadeId );
    }
    
    @Override
    public Page<TriagemPrioridade> buscarTriagemPrioridades ( Pageable pageable )
    {
        return this.triagemPrioridadeRepository.findAll( pageable ).map( TriagemPrioridadeMapper::toDomain );
    }
}
