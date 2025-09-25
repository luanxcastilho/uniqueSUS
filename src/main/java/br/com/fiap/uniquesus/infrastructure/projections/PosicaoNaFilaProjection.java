package br.com.fiap.uniquesus.infrastructure.projections;

public interface PosicaoNaFilaProjection
{
    Long getPacienteId ();
    
    Integer getPosicaoNaFila ();
    
    Integer getTotalNaFila ();
}
