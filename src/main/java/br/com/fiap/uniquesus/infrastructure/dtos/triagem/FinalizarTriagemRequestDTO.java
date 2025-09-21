package br.com.fiap.uniquesus.infrastructure.dtos.triagem;

import lombok.Data;

@Data
public class FinalizarTriagemRequestDTO
{
    private Long          triagemPrioridadeId;
    private String        sintomas;
}
