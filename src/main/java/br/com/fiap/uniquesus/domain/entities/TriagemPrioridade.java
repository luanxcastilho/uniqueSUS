package br.com.fiap.uniquesus.domain.entities;

import lombok.Data;

@Data
public class TriagemPrioridade
{
    private Long triagemPrioridadeId;
    private String descricao;
    private Integer tempoParaAtendimento;
    
}
