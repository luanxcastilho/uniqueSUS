package br.com.fiap.uniquesus.domain.exceptions.consulta;

public class ConsultaNaoEncontradaPeloIdException extends RuntimeException
{
    public ConsultaNaoEncontradaPeloIdException ( Long consultaId )
    {
        super( "Consulta com ID [" + consultaId + "] não encontrada." );
    }
}
