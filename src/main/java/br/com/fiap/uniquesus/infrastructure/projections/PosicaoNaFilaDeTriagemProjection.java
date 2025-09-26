package br.com.fiap.uniquesus.infrastructure.projections;

public interface PosicaoNaFilaDeTriagemProjection
{
    Long getPacienteId ();
    
    Integer getPosicaoNaFila ();
    
    Integer getTotalNaFila ();
}
