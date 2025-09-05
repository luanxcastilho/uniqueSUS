package br.com.fiap.uniquesus.domain.exceptions.enfermeiro;

public class EnfermeiroNaoEncontradoPeloIdException extends RuntimeException
{
    public EnfermeiroNaoEncontradoPeloIdException ( Long enfermeiroId )
    {
        super( "Enfermeiro com ID " + enfermeiroId + " não encontrado." );
    }
}
