package br.com.fiap.uniquesus.domain.exceptions.atendimento;

public class AtendimentoNaoEncontradoPeloPacienteIdException extends RuntimeException
{
    public AtendimentoNaoEncontradoPeloPacienteIdException ( Long pacienteId )
    {
        super( "Atendimento com ID do paciente [" + pacienteId + "] não encontrado." );
    }
}
