package br.com.fiap.uniquesus.application.usecases.triagemPrioridade;

import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.domain.gateways.TriagemPrioridadeGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BuscarTriagemPrioridadesUseCase
{
    private final TriagemPrioridadeGateway triagemPrioridadeGateway;

    public BuscarTriagemPrioridadesUseCase ( TriagemPrioridadeGateway triagemPrioridadeGateway )
    {
        this.triagemPrioridadeGateway = triagemPrioridadeGateway;
    }

    public Page<TriagemPrioridade> executar ( Pageable pageable )
    {
        return this.triagemPrioridadeGateway.buscarTriagemPrioridades(pageable);
    }
}
