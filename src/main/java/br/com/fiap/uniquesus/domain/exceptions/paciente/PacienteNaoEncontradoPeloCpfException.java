package br.com.fiap.uniquesus.domain.exceptions.paciente;

public class PacienteNaoEncontradoPeloCpfException extends RuntimeException
{
    public PacienteNaoEncontradoPeloCpfException ( String cpf )
    {
        super( "Paciente com CPF " + cpf + " não encontrado." );
    }
}
