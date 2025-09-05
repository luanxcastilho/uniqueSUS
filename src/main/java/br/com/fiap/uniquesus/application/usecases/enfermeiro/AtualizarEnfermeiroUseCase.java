package br.com.fiap.uniquesus.application.usecases.enfermeiro;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.CorenJaRegistradoException;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.gateways.EnfermeiroGateway;

public class AtualizarEnfermeiroUseCase
{
    private final EnfermeiroGateway enfermeiroGateway;
    
    public AtualizarEnfermeiroUseCase ( EnfermeiroGateway enfermeiroGateway )
    {
        this.enfermeiroGateway = enfermeiroGateway;
    }
    
    public Enfermeiro executar ( Enfermeiro enfermeiro )
    {
        Enfermeiro enfermeiroEncontrado = this.enfermeiroGateway.buscarEnfermeiroPeloId( enfermeiro.getEnfermeiroId() )
                .orElseThrow( () -> new EnfermeiroNaoEncontradoPeloIdException( enfermeiro.getEnfermeiroId() ) );
        
        if (enfermeiro.getCoren() != null && !enfermeiroEncontrado.getCoren().equals( enfermeiro.getCoren() ))
        {
            if (this.enfermeiroGateway.buscarEnfermeiroPeloCoren( enfermeiro.getCoren() ).isPresent())
            {
                throw new CorenJaRegistradoException( enfermeiro.getCoren() );
            }
            enfermeiroEncontrado.setCoren( enfermeiro.getCoren() );
        }
        
        if (enfermeiro.getNome() != null && !enfermeiroEncontrado.getNome().equals( enfermeiro.getNome() ))
        {
            enfermeiroEncontrado.setNome( enfermeiro.getNome() );
        }
        
        return this.enfermeiroGateway.gravarEnfermeiro( enfermeiroEncontrado );
    }
}
