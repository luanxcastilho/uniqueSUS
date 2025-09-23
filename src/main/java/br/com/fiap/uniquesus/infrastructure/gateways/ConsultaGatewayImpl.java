package br.com.fiap.uniquesus.infrastructure.gateways;

import br.com.fiap.uniquesus.domain.entities.Consulta;
import br.com.fiap.uniquesus.domain.gateways.ConsultaGateway;
import br.com.fiap.uniquesus.infrastructure.mappers.ConsultaMapper;
import br.com.fiap.uniquesus.infrastructure.repositories.ConsultaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ConsultaGatewayImpl implements ConsultaGateway
{
    private final ConsultaRepository consultaRepository;
    
    public ConsultaGatewayImpl ( ConsultaRepository consultaRepository )
    {
        this.consultaRepository = consultaRepository;
    }
    
    @Override
    public Optional<Consulta> buscarConsultaPeloId ( Long consultaId )
    {
        return this.consultaRepository.findById( consultaId ).map( ConsultaMapper::toDomain );
    }
    
    @Override
    public Consulta gravarConsulta ( Consulta consulta )
    {
        return ConsultaMapper.toDomain( this.consultaRepository.save( ConsultaMapper.toEntity( consulta ) ) );
    }
    
    @Override
    public void removerConsulta ( Long consultaId )
    {
        this.consultaRepository.deleteById( consultaId );
    }
    
    @Override
    public Page<Consulta> buscarConsultas ( Pageable pageable )
    {
        return this.consultaRepository.findAll( pageable ).map( ConsultaMapper::toDomain );
    }
}
