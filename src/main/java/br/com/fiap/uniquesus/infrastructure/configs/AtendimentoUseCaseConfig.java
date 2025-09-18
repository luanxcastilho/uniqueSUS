package br.com.fiap.uniquesus.infrastructure.configs;

import br.com.fiap.uniquesus.application.usecases.atendimento.BuscarAtendimentoPeloIdUseCase;
import br.com.fiap.uniquesus.application.usecases.atendimento.BuscarAtendimentosUseCase;
import br.com.fiap.uniquesus.application.usecases.atendimento.FinalizarAtendimentoUseCase;
import br.com.fiap.uniquesus.application.usecases.atendimento.IniciarAtendimentoUseCase;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtendimentoUseCaseConfig
{
    @Bean
    public IniciarAtendimentoUseCase iniciarAtendimentoUseCase ( AtendimentoGateway atendimentoGateway, PacienteGateway pacienteGateway )
    {
        return new IniciarAtendimentoUseCase( atendimentoGateway, pacienteGateway );
    }
    
    @Bean
    public FinalizarAtendimentoUseCase finalizarAtendimentoUseCase ( AtendimentoGateway atendimentoGateway, PacienteGateway pacienteGateway )
    {
        return new FinalizarAtendimentoUseCase( atendimentoGateway, pacienteGateway );
    }
    
    @Bean
    public BuscarAtendimentosUseCase buscarAtendimentosUseCase ( AtendimentoGateway atendimentoGateway, PacienteGateway pacienteGateway )
    {
        return new BuscarAtendimentosUseCase( atendimentoGateway, pacienteGateway );
    }
    
    @Bean
    public BuscarAtendimentoPeloIdUseCase buscarAtendimentoPeloIdUseCase ( AtendimentoGateway atendimentoGateway, PacienteGateway pacienteGateway )
    {
        return new BuscarAtendimentoPeloIdUseCase( atendimentoGateway, pacienteGateway );
    }
}
