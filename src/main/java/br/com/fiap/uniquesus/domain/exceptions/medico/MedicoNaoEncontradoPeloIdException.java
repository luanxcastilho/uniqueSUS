package br.com.fiap.uniquesus.domain.exceptions.medico;

public class MedicoNaoEncontradoPeloIdException extends RuntimeException
{
    public MedicoNaoEncontradoPeloIdException ( Long medicoId )
    {
        super( "Médico com ID [" + medicoId + "] não encontrado." );
    }
}
