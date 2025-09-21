package br.com.fiap.uniquesus.infrastructure.dtos.triagemPrioridade;

import lombok.Data;

@Data
public class TriagemPrioridadeRequestDTO
{
    private String descricao;
    private Integer tempoParaAtendimento;
}
