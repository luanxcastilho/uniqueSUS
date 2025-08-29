package br.com.fiap.uniquesus.domain.exceptions.paciente;

public class PacienteNaoEncontradoPeloCpf extends RuntimeException
{
    public PacienteNaoEncontradoPeloCpf ( String cpf )
    {
        super( "Paciente com CPF " + cpf + " não encontrado" );
    }
}
