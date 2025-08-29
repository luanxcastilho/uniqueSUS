package br.com.fiap.uniquesus.domain.entities;

import lombok.Data;

@Data
public class Medico
{
    private Long medicoId;
    private String nome;
    private String crm;
}
