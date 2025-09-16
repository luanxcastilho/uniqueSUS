package br.com.fiap.uniquesus.domain.exceptions.paciente;

public class CPFJaRegistradoException extends RuntimeException
{
    public CPFJaRegistradoException ( String cpf )
    {
        super( "O CPF [" + cpf + "] já esta sendo utilizado." );
    }
}
