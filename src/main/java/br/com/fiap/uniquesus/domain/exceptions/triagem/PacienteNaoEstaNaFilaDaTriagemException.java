package br.com.fiap.uniquesus.domain.exceptions.triagem;

public class PacienteNaoEstaNaFilaDaTriagemException extends RuntimeException
{
    public PacienteNaoEstaNaFilaDaTriagemException ( Long pacienteId )
    {
        super( "O paciente com ID ["+pacienteId+"] não está na fila da triagem." );
    }
}
