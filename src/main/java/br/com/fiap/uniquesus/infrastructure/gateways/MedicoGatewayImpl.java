package br.com.fiap.uniquesus.infrastructure.gateways;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;
import br.com.fiap.uniquesus.infrastructure.mappers.MedicoMapper;
import br.com.fiap.uniquesus.infrastructure.repositories.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MedicoGatewayImpl implements MedicoGateway
{
    private final MedicoRepository medicoRepository;
    
    public MedicoGatewayImpl ( MedicoRepository medicoRepository )
    {
        this.medicoRepository = medicoRepository;
    }
    
    @Override
    public Optional<Medico> buscarMedicoPeloCRM ( String crm )
    {
        return this.medicoRepository.getMedicoByCrm( crm ).map( MedicoMapper::toDomain );
    }
    
    @Override
    public Optional<Medico> buscarMedicoPeloId ( Long medicoId )
    {
        return this.medicoRepository.getMedicoByMedicoId( medicoId ).map( MedicoMapper::toDomain );
    }
    
    @Override
    public Medico gravarMedico ( Medico medico )
    {
        return MedicoMapper.toDomain( this.medicoRepository.save( MedicoMapper.toEntity( medico ) ) );
    }
    
    @Override
    public void removerMedico ( Long medicoId )
    {
        this.medicoRepository.deleteById( medicoId );
    }
    
    @Override
    public Page<Medico> listarMedicos ( Pageable pageable )
    {
        return this.medicoRepository.findAll( pageable ).map( MedicoMapper::toDomain );
    }
    
}
