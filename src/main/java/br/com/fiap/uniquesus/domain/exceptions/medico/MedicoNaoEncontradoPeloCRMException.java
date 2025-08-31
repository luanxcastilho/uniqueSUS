package br.com.fiap.uniquesus.domain.exceptions.medico;

public class MedicoNaoEncontradoPeloCRMException extends RuntimeException
{
    public MedicoNaoEncontradoPeloCRMException ( String crm )
    {
        super( "Medico com CRM " + crm + " não encontrado." );
    }
}
