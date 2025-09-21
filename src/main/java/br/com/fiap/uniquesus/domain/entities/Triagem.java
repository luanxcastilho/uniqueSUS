package br.com.fiap.uniquesus.domain.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Triagem
{
    private Long              triagemId;
    private Atendimento       atendimento;
    private Enfermeiro        enfermeiro;
    private TriagemPrioridade triagemPrioridade;
    private String            sintomas;
    private LocalDateTime     dataHoraInicial;
    private LocalDateTime     dataHoraFinal;
    
    public void iniciarTriagem ( Atendimento atendimento , Enfermeiro enfermeiro )
    {
        this.atendimento     = atendimento;
        this.enfermeiro      = enfermeiro;
        this.dataHoraInicial = LocalDateTime.now();
    }
    
    public void finalizarTriagem ( TriagemPrioridade triagemPrioridade , String sintomas )
    {
        this.triagemPrioridade = triagemPrioridade;
        this.sintomas          = sintomas;
        this.dataHoraFinal     = LocalDateTime.now();
    }
}
