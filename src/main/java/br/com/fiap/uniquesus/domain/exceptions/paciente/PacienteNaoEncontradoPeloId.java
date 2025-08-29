package br.com.fiap.uniquesus.domain.exceptions.paciente;

public class PacienteNaoEncontradoPeloId extends RuntimeException
{
    public PacienteNaoEncontradoPeloId ( Long pacienteId )
    {
        super( "Paciente com ID " + pacienteId + " não encontrado" );
    }
}
