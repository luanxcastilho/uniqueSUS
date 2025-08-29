package br.com.fiap.uniquesus.domain.exceptions.paciente;

public class CpfJaRegistradoException extends RuntimeException
{
    public CpfJaRegistradoException ( String cpf )
    {
        super( "O CPF " + cpf + " já esta sendo utilizado." );
    }
}
