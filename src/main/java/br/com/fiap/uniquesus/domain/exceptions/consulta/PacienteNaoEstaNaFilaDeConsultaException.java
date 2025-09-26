package br.com.fiap.uniquesus.domain.exceptions.consulta;

public class PacienteNaoEstaNaFilaDeConsultaException extends RuntimeException
{
    public PacienteNaoEstaNaFilaDeConsultaException ( Long pacienteId )
    {
        super( "O paciente com ID ["+pacienteId+"] não está na fila de consulta." );
    }
}
