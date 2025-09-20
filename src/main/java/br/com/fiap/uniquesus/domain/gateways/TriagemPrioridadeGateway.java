package br.com.fiap.uniquesus.domain.gateways;

import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TriagemPrioridadeGateway
{
    Optional<TriagemPrioridade> buscarTriagemPrioridadePeloId ( Long triagemPrioridadeId );
    TriagemPrioridade gravarTriagemPrioridade ( TriagemPrioridade triagemPrioridade );
    void removerTriagemPrioridade ( Long triagemPrioridadeId );
    Page<TriagemPrioridade> buscarTriagemPrioridades ( Pageable pageable );
}
