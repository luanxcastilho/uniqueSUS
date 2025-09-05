package br.com.fiap.uniquesus.application.usecases.enfermeiro;

import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;

public class RemoverEnfermeiroUseCase
{
    private final EnfermeiroGateway enfermeiroGateway;
    
    public RemoverEnfermeiroUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        this.enfermeiroGateway = enfermeiroGateway;
    }
    
    public void executar ( Long enfermeiroId )
    {
        this.enfermeiroGateway.removerEnfermeiro( enfermeiroId );
    }
}
