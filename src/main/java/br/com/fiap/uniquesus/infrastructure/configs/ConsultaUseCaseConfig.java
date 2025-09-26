package br.com.fiap.uniquesus.infrastructure.configs;

import br.com.fiap.uniquesus.application.usecases.consulta.*;
import br.com.fiap.uniquesus.domain.gateways.AtendimentoGateway;
import br.com.fiap.uniquesus.domain.gateways.ConsultaGateway;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultaUseCaseConfig
{
    @Bean
    public BuscarConsultaPeloIdUseCase buscarConsultaPeloIdUseCase ( ConsultaGateway consultaGateway , AtendimentoGateway atendimentoGateway , MedicoGateway medicoGateway , PacienteGateway pacienteGateway )
    {
        return new BuscarConsultaPeloIdUseCase( consultaGateway , atendimentoGateway , medicoGateway , pacienteGateway );
    }
    
    @Bean
    public BuscarConsultasUseCase buscarConsultasUseCase ( ConsultaGateway consultaGateway , AtendimentoGateway atendimentoGateway , MedicoGateway medicoGateway , PacienteGateway pacienteGateway )
    {
        return new BuscarConsultasUseCase( consultaGateway , atendimentoGateway , medicoGateway , pacienteGateway );
    }
    
    @Bean
    public IniciarConsultaUseCase iniciarConsultaUseCase ( ConsultaGateway consultaGateway , AtendimentoGateway atendimentoGateway , MedicoGateway medicoGateway , PacienteGateway pacienteGateway )
    {
        return new IniciarConsultaUseCase( consultaGateway , atendimentoGateway , medicoGateway , pacienteGateway );
    }
    
    @Bean
    public FinalizarConsultaUseCase finalizarConsultaUseCase ( ConsultaGateway consultaGateway , AtendimentoGateway atendimentoGateway , MedicoGateway medicoGateway , PacienteGateway pacienteGateway )
    {
        return new FinalizarConsultaUseCase( consultaGateway , atendimentoGateway , medicoGateway , pacienteGateway );
    }
    
    @Bean
    public BuscarPosicaoNaFilaDeConsultaUseCase buscarPosicaoNaFilaDeConsultaUseCase ( ConsultaGateway consultaGateway , PacienteGateway pacienteGateway )
    {
        return new BuscarPosicaoNaFilaDeConsultaUseCase( consultaGateway , pacienteGateway );
    }
}
