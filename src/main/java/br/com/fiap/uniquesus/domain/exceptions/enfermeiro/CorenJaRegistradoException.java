package br.com.fiap.uniquesus.domain.exceptions.enfermeiro;

public class CorenJaRegistradoException extends RuntimeException
{
    public CorenJaRegistradoException ( String coren )
    {
        super( "O COREN " + coren + " já esta sendo utilizado." );
    }
}
