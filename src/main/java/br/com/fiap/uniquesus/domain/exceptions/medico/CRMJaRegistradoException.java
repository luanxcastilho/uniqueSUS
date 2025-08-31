package br.com.fiap.uniquesus.domain.exceptions.medico;

public class CRMJaRegistradoException extends RuntimeException
{
    public CRMJaRegistradoException ( String crm )
    {
        super( "O CRM " + crm + " já esta sendo utilizado." );
    }
}
