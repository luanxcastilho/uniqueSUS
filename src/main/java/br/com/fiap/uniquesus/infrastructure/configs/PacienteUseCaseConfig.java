package br.com.fiap.uniquesus.infrastructure.configs;

import br.com.fiap.uniquesus.application.usecases.paciente.*;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PacienteUseCaseConfig
{
    @Bean
    public AtualizarPacienteUseCase atualizarPacienteUseCase ( PacienteGateway pacienteGateway )
    {
        return new AtualizarPacienteUseCase( pacienteGateway );
    }
    @Bean
    public BuscarPacientePeloCPFUseCase buscarPacientePeloCPFUseCase ( PacienteGateway pacienteGateway )
    {
        return new BuscarPacientePeloCPFUseCase( pacienteGateway );
    }
    @Bean
    public BuscarPacientePeloIdUseCase buscarPacientePeloIdUseCase ( PacienteGateway pacienteGateway )
    {
        return new BuscarPacientePeloIdUseCase( pacienteGateway );
    }
    @Bean
    public BuscarPacientesUseCase buscarPacientesUseCase ( PacienteGateway pacienteGateway )
    {
        return new BuscarPacientesUseCase( pacienteGateway );
    }
    @Bean
    public CriarPacienteUseCase criarPacienteUseCase ( PacienteGateway pacienteGateway )
    {
        return new CriarPacienteUseCase( pacienteGateway );
    }
    @Bean
    public RemoverPacienteUseCase removerPacienteUseCase ( PacienteGateway pacienteGateway )
    {
        return new RemoverPacienteUseCase( pacienteGateway );
    }
}
