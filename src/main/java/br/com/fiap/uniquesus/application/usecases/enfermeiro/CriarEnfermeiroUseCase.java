package br.com.fiap.uniquesus.application.usecases.enfermeiro;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;

public class CriarEnfermeiroUseCase
{
    private final EnfermeiroGateway enfermeiroGateway;
    
    public CriarEnfermeiroUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        this.enfermeiroGateway = enfermeiroGateway;
    }
    
    public Enfermeiro executar ( Enfermeiro enfermeiro )
    {
        return this.enfermeiroGateway.gravarEnfermeiro( enfermeiro );
    }
}
