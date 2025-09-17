package br.com.fiap.uniquesus.application.usecases.enfermeiro;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.CorenJaRegistradoException;
import br.com.fiap.uniquesus.domain.exceptions.medico.CRMJaRegistradoException;
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
        if (this.enfermeiroGateway.buscarEnfermeiroPeloCoren( enfermeiro.getCoren() ).isPresent())
        {
            throw new CorenJaRegistradoException( enfermeiro.getCoren() );
        }
        return this.enfermeiroGateway.gravarEnfermeiro( enfermeiro );
    }
}
