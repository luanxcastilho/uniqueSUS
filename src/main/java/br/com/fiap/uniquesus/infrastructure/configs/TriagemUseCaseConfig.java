package br.com.fiap.uniquesus.infrastructure.configs;

import br.com.fiap.uniquesus.application.usecases.triagem.*;
import br.com.fiap.uniquesus.domain.gateways.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TriagemUseCaseConfig
{
    @Bean
    public IniciarTriagemUseCase iniciarTriagemUseCase ( TriagemGateway triagemGateway , AtendimentoGateway atendimentoGateway , EnfermeiroGateway enfermeiroGateway, PacienteGateway pacienteGateway )
    {
        return new IniciarTriagemUseCase( triagemGateway, atendimentoGateway, enfermeiroGateway, pacienteGateway );
    }
    
    @Bean
    public FinalizarTriagemUseCase finalizarTriagemUseCase ( TriagemGateway triagemGateway , AtendimentoGateway atendimentoGateway , EnfermeiroGateway enfermeiroGateway , TriagemPrioridadeGateway triagemPrioridadeGateway, PacienteGateway pacienteGateway )
    {
        return new FinalizarTriagemUseCase( triagemGateway, atendimentoGateway, enfermeiroGateway, triagemPrioridadeGateway, pacienteGateway );
    }
    
    @Bean
    public BuscarTriagensUseCase buscarTriagensUseCase ( TriagemGateway triagemGateway , AtendimentoGateway atendimentoGateway , EnfermeiroGateway enfermeiroGateway , TriagemPrioridadeGateway triagemPrioridadeGateway, PacienteGateway pacienteGateway )
    {
        return new BuscarTriagensUseCase( triagemGateway, atendimentoGateway, enfermeiroGateway, triagemPrioridadeGateway, pacienteGateway );
    }
    
    @Bean
    public BuscarTriagemPeloIdUseCase buscarTriagemPeloIdUseCase ( TriagemGateway triagemGateway , AtendimentoGateway atendimentoGateway , EnfermeiroGateway enfermeiroGateway , TriagemPrioridadeGateway triagemPrioridadeGateway , PacienteGateway pacienteGateway )
    {
        return new BuscarTriagemPeloIdUseCase( triagemGateway, atendimentoGateway, enfermeiroGateway, triagemPrioridadeGateway, pacienteGateway );
    }
    
    @Bean
    public BuscarPosicaoNaFilaDeTriagemUseCase buscarPosicaoNaFilaDeTriagemUseCase ( TriagemGateway triagemGateway , PacienteGateway pacienteGateway ){
        return new BuscarPosicaoNaFilaDeTriagemUseCase( triagemGateway, pacienteGateway );
    }
}
