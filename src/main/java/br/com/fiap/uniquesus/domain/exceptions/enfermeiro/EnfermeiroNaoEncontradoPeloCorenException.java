package br.com.fiap.uniquesus.domain.exceptions.enfermeiro;

public class EnfermeiroNaoEncontradoPeloCorenException extends RuntimeException
{
    public EnfermeiroNaoEncontradoPeloCorenException ( String coren )
    {
        super( "Enfermeiro com COREN [" + coren + "] não encontrado." );
    }
}
