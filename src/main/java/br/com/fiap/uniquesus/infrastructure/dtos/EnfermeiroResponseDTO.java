package br.com.fiap.uniquesus.infrastructure.dtos;

import lombok.Data;

@Data
public class EnfermeiroResponseDTO
{
    private Long enfermeiroId;
    private String nome;
    private String coren;
}
