package br.com.fiap.uniquesus.domain.exceptions.triagem;

public class TriagemNaoEncontradaPeloIdException extends RuntimeException
{
    public TriagemNaoEncontradaPeloIdException ( Long triagemId )
    {
        super( "Triagem com ID [" + triagemId + "] não encontrado." );
    }
}
