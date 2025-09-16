package br.com.fiap.uniquesus.application.usecases.enfermeiro;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BuscarEnfermeirosUseCase
{
    private final EnfermeiroGateway enfermeiroGateway;
    
    public BuscarEnfermeirosUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        this.enfermeiroGateway = enfermeiroGateway;
    }
    
    public Page<Enfermeiro> executar ( Pageable pageable )
    {
        return this.enfermeiroGateway.buscarEnfermeiros( pageable );
    }
}
