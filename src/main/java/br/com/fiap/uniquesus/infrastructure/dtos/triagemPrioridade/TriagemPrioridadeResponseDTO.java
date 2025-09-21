package br.com.fiap.uniquesus.infrastructure.dtos.triagemPrioridade;

import lombok.Data;

@Data
public class TriagemPrioridadeResponseDTO
{
    private Long triagemPrioridadeId;
    private String descricao;
    private Integer tempoParaAtendimento;
}
