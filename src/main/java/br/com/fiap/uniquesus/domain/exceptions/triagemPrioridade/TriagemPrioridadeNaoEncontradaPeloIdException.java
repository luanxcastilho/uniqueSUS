package br.com.fiap.uniquesus.domain.exceptions.triagemPrioridade;

public class TriagemPrioridadeNaoEncontradaPeloIdException extends RuntimeException
{
    public TriagemPrioridadeNaoEncontradaPeloIdException ( Long triagemPrioridadeId )
    {
        super( "Prioridade de triagem com ID [" + triagemPrioridadeId + "] não encontrado." );
    }
}
