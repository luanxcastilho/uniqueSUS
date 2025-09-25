package br.com.fiap.uniquesus.infrastructure.gateways;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloPacienteIdException;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.infrastructure.entities.AtendimentoEntity;
import br.com.fiap.uniquesus.infrastructure.mappers.AtendimentoMapper;
import br.com.fiap.uniquesus.infrastructure.repositories.AtendimentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AtendimentoGatewayImpl implements AtendimentoGateway
{
    private final AtendimentoRepository atendimentoRepository;
    
    public AtendimentoGatewayImpl ( AtendimentoRepository atendimentoRepository )
    {
        this.atendimentoRepository = atendimentoRepository;
    }
    
    @Override
    public Optional<Atendimento> buscarAtendimentoPeloId ( Long atendimentoId )
    {
        return this.atendimentoRepository.findById( atendimentoId ).map( AtendimentoMapper::toDomain );
    }
    
    @Override
    public Atendimento gravarAtendimento ( Atendimento atendimento )
    {
        return AtendimentoMapper.toDomain( this.atendimentoRepository.save( AtendimentoMapper.toEntity( atendimento ) ) );
    }
    
    @Override
    public void removerAtendimento ( Long atendimentoId )
    {
        this.atendimentoRepository.deleteById( atendimentoId );
    }
    
    @Override
    public Page<Atendimento> buscarAtendimentos ( Pageable pageable )
    {
        return this.atendimentoRepository.findAll( pageable ).map( AtendimentoMapper::toDomain );
    }
    
    @Override
    public Optional<Atendimento> buscarAtendimentoPeloPacienteId ( Long pacienteId )
    {
        AtendimentoEntity atendimentoEntity = this.atendimentoRepository.findAtendimentoEntityByPacienteId( pacienteId );
        
        if (atendimentoEntity == null)
        {
            throw new AtendimentoNaoEncontradoPeloPacienteIdException( pacienteId );
        }
        
        return Optional.of( AtendimentoMapper.toDomain( atendimentoEntity ) );
    }
    
}
