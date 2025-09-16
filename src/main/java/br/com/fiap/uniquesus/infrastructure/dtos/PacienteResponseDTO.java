package br.com.fiap.uniquesus.infrastructure.dtos;

import lombok.Data;


@Data
public class PacienteResponseDTO
{
    private Long   pacienteId;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}
