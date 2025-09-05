package br.com.fiap.uniquesus.infrastructure.gateways;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;
import br.com.fiap.uniquesus.infrastructure.mappers.EnfermeiroMapper;
import br.com.fiap.uniquesus.infrastructure.repositories.EnfermeiroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EnfermeiroGatewayImpl implements EnfermeiroGateway
{
    private final EnfermeiroRepository enfermeiroRepository;
    
    public EnfermeiroGatewayImpl ( EnfermeiroRepository enfermeiroRepository )
    {
        this.enfermeiroRepository = enfermeiroRepository;
    }
    
    @Override
    public Optional<Enfermeiro> buscarEnfermeiroPeloCoren ( String coren )
    {
        return this.enfermeiroRepository.getEnfermeiroByCoren( coren ).map( EnfermeiroMapper::toDomain );
    }
    
    @Override
    public Optional<Enfermeiro> buscarEnfermeiroPeloId ( Long enfermeiroId )
    {
        return this.enfermeiroRepository.getEnfermeiroByEnfermeiroId( enfermeiroId ).map( EnfermeiroMapper::toDomain );
    }
    
    @Override
    public Enfermeiro gravarEnfermeiro ( Enfermeiro enfermeiro )
    {
        return EnfermeiroMapper.toDomain( this.enfermeiroRepository.save( EnfermeiroMapper.toEntity( enfermeiro ) ) );
    }
    
    @Override
    public void removerEnfermeiro ( Long enfermeiroId )
    {
        this.enfermeiroRepository.deleteById( enfermeiroId );
    }
    
    @Override
    public Page<Enfermeiro> listarEnfermeiros ( Pageable pageable )
    {
        return this.enfermeiroRepository.findAll( pageable ).map( EnfermeiroMapper::toDomain );
    }
}
