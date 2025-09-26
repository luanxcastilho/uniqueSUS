package br.com.fiap.uniquesus.infrastructure.projections;

public interface PosicaoNaFilaDeConsultaProjection
{
    Long getPacienteId ();
    
    Integer getPosicaoNaFila ();
    
    Integer getTotalNaFila ();
}
