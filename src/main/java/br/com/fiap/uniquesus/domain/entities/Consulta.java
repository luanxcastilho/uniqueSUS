package br.com.fiap.uniquesus.domain.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Consulta
{
    private Long          consultaId;
    private Atendimento   atendimento;
    private Medico        medico;
    private String        diagnostico;
    private LocalDateTime dataHoraInicial;
    private LocalDateTime dataHoraFinal;
    
    public Consulta iniciarConsulta ( Atendimento atendimento , Medico medico )
    {
        this.atendimento      = atendimento;
        this.medico           = medico;
        this.dataHoraInicial  = LocalDateTime.now();
        return this;
    }
    
    public Consulta finalizarConsulta ( String diagnostico )
    {
        this.diagnostico     = diagnostico;
        this.dataHoraFinal   = LocalDateTime.now();
        return this;
    }
}
