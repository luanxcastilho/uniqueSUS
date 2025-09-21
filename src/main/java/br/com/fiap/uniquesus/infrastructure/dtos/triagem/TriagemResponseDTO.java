package br.com.fiap.uniquesus.infrastructure.dtos.triagem;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TriagemResponseDTO
{
    private Long              triagemId;
    private Atendimento       atendimento;
    private Enfermeiro        enfermeiro;
    private TriagemPrioridade triagemPrioridade;
    private String            sintomas;
    private LocalDateTime     dataHoraInicial;
    private LocalDateTime     dataHoraFinal;
}
