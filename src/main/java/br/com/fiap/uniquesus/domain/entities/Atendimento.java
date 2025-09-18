package br.com.fiap.uniquesus.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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
    
    public void iniciarAtendimento ( Paciente paciente )
    {
        this.paciente = paciente;
        this.dataHoraInicial = LocalDateTime.now();
    }
}
