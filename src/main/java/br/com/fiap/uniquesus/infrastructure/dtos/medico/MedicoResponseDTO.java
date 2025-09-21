package br.com.fiap.uniquesus.infrastructure.dtos.medico;

import lombok.Data;

@Data
public class MedicoResponseDTO
{
    private Long medicoId;
    private String nome;
    private String crm;
}
