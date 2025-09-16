package br.com.fiap.uniquesus.domain.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Atendimento
{
    private Long          atendimentoId;
    private Paciente      paciente;
    private LocalDateTime dataHoraInicial;
    private LocalDateTime dataHoraFinal;
    
    public void finalizarAtendimento ()
    {
        this.dataHoraFinal = LocalDateTime.now();
    }
    
    public Atendimento ( Paciente paciente )
    {
        this.paciente = paciente;
        this.dataHoraInicial = LocalDateTime.now();
    }
}
