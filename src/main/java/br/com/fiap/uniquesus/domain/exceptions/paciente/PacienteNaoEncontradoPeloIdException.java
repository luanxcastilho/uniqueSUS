package br.com.fiap.uniquesus.domain.exceptions.paciente;

public class PacienteNaoEncontradoPeloIdException extends RuntimeException
{
    public PacienteNaoEncontradoPeloIdException ( Long pacienteId )
    {
        super( "Paciente com ID [" + pacienteId + "] não encontrado." );
    }
}
