package br.com.fiap.uniquesus.infrastructure.configs;

import br.com.fiap.uniquesus.application.usecases.enfermeiro.*;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnfermeiroUseCaseConfig
{
    @Bean
    public AtualizarEnfermeiroUseCase atualizarEnfermeiroUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        return new AtualizarEnfermeiroUseCase( enfermeiroGateway );
    }
    
    @Bean
    public BuscarEnfermeiroPeloCorenUseCase buscarEnfermeiroPeloCorenUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        return new BuscarEnfermeiroPeloCorenUseCase( enfermeiroGateway );
    }
    
    @Bean
    public BuscarEnfermeiroPeloIdUseCase buscarEnfermeiroPeloIdUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        return new BuscarEnfermeiroPeloIdUseCase( enfermeiroGateway );
    }
    
    @Bean
    public BuscarEnfermeirosUseCase buscarEnfermeirosUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        return new BuscarEnfermeirosUseCase( enfermeiroGateway );
    }
    
    @Bean
    public CriarEnfermeiroUseCase criarEnfermeiroUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        return new CriarEnfermeiroUseCase( enfermeiroGateway );
    }
    
    @Bean
    public RemoverEnfermeiroUseCase removerEnfermeiroUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        return new RemoverEnfermeiroUseCase( enfermeiroGateway );
    }
}
