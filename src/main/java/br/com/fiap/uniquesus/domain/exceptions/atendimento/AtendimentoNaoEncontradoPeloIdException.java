package br.com.fiap.uniquesus.domain.exceptions.atendimento;

public class AtendimentoNaoEncontradoPeloIdException extends RuntimeException
{
    public AtendimentoNaoEncontradoPeloIdException ( Long atendimentoId )
    {
        super( "Atendimento com ID [" + atendimentoId + "] não encontrado." );
    }
}
