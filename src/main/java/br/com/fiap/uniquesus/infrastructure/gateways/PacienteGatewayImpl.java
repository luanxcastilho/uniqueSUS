package br.com.fiap.uniquesus.infrastructure.gateways;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;
import br.com.fiap.uniquesus.infrastructure.mappers.PacienteMapper;
import br.com.fiap.uniquesus.infrastructure.repositories.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PacienteGatewayImpl implements PacienteGateway
{
    private final PacienteRepository pacienteRepository;
    
    public PacienteGatewayImpl ( PacienteRepository pacienteRepository )
    {
        this.pacienteRepository = pacienteRepository;
    }
    
    @Override
    public Optional<Paciente> buscarPacientePeloCPF ( String cpf )
    {
        return this.pacienteRepository.getPacienteByCpf( cpf ).map( PacienteMapper::toDomain );
    }
    
    @Override
    public Optional<Paciente> buscarPacientePeloId ( Long pacienteId )
    {
        return this.pacienteRepository.getPacienteByPacienteId( pacienteId ).map( PacienteMapper::toDomain );
    }
    
    @Override
    public Paciente gravarPaciente ( Paciente paciente )
    {
        return PacienteMapper.toDomain( this.pacienteRepository.save( PacienteMapper.toEntity( paciente ) ) );
    }
    
    @Override
    public void removerPaciente ( Long pacienteId )
    {
        this.pacienteRepository.deleteById( pacienteId );
    }
    
    @Override
    public Page<Paciente> buscarPacientes ( Pageable pageable )
    {
        return this.pacienteRepository.findAll( pageable ).map( PacienteMapper::toDomain );
    }
}
