package br.com.fiap.uniquesus.infrastructure.dtos.paciente;

import lombok.Data;

@Data
public class PacienteRequestDTO
{
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}
