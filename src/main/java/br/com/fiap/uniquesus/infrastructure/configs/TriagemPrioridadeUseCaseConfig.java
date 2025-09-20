package br.com.fiap.uniquesus.infrastructure.configs;

import br.com.fiap.uniquesus.application.usecases.triagemPrioridade.*;
import br.com.fiap.uniquesus.domain.gateways.TriagemPrioridadeGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TriagemPrioridadeUseCaseConfig
{
    @Bean
    public AtualizarTriagemPrioridadeUseCase atualizarTriagemPrioridadeUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        return new AtualizarTriagemPrioridadeUseCase(triagemPrioridadeGateway);
    }
    
    @Bean
    public BuscarTriagemPrioridadePeloIdUseCase buscarTriagemPrioridadePeloIdUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        return new BuscarTriagemPrioridadePeloIdUseCase( triagemPrioridadeGateway);
    }
    
    @Bean
    public BuscarTriagemPrioridadesUseCase buscarTriagemPrioridadesUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        return new BuscarTriagemPrioridadesUseCase( triagemPrioridadeGateway);
    }
    
    @Bean
    public RemoverTriagemPrioridadeUseCase removerTriagemPrioridadeUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        return new RemoverTriagemPrioridadeUseCase( triagemPrioridadeGateway);
    }
    
    @Bean
    public CriarTriagemPrioridadeUseCase criarTriagemPrioridadeUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        return new CriarTriagemPrioridadeUseCase( triagemPrioridadeGateway);
    }
    
}
