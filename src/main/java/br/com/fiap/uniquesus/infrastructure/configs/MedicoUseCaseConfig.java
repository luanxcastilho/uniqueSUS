package br.com.fiap.uniquesus.infrastructure.configs;

import br.com.fiap.uniquesus.application.usecases.medico.*;
import br.com.fiap.uniquesus.domain.gateways.MedicoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicoUseCaseConfig
{
    @Bean
    public AtualizarMedicoUseCase atualizarMedicoUseCase ( MedicoGateway medicoGateway )
    {
        return new AtualizarMedicoUseCase( medicoGateway );
    }
    
    @Bean
    public BuscarMedicoPeloCRMUseCase buscarMedicoPeloCRMUseCase( MedicoGateway medicoGateway )
    {
        return new BuscarMedicoPeloCRMUseCase( medicoGateway );
    }
    
    @Bean
    public BuscarMedicoPeloIdUseCase buscarMedicoPeloIdUseCase ( MedicoGateway medicoGateway )
    {
        return new BuscarMedicoPeloIdUseCase( medicoGateway );
    }
    
    @Bean
    public BuscarMedicosUseCase buscarMedicosUseCase ( MedicoGateway medicoGateway )
    {
        return new BuscarMedicosUseCase( medicoGateway );
    }
    
    @Bean
    public CriarMedicoUseCase criarMedicoUseCase ( MedicoGateway medicoGateway )
    {
        return new CriarMedicoUseCase( medicoGateway );
    }
    
    @Bean
    public RemoverMedicoUseCase removerMedicoUseCase ( MedicoGateway medicoGateway )
    {
        return new RemoverMedicoUseCase( medicoGateway );
    }
}
