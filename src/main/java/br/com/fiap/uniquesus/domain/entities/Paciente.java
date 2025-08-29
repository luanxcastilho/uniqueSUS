package br.com.fiap.uniquesus.domain.entities;

import lombok.Data;

@Data
public class Paciente
{
    private Long pacienteId;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    
}
