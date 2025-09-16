package br.com.fiap.uniquesus.domain.exceptions.atendimento;

public class AtendimentoNaoEncontradoPeloId extends RuntimeException
{
    public AtendimentoNaoEncontradoPeloId ( Long atendimentoId )
    {
        super( "Atendimento com ID " + atendimentoId + " não encontrado." );
    }
}
