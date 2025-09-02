package br.com.fiap.uniquesus.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "paciente")
public class PacienteEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente", nullable = false)
    private Long pacienteId;
    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "cpf", length = 20, nullable = false)
    private String cpf;
    
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    
    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;
    
    @Column(name = "data_inclusao", nullable = false)
    private LocalDateTime dataInclusao;
    
    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime dataAlteracao;
}
