package br.com.fiap.uniquesus.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "medico")
public class MedicoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico", nullable = false)
    private Long medicoId;
    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "crm", length = 20, nullable = false)
    private String crm;
    
    @CreatedDate
    @Column(name = "data_inclusao", nullable = false)
    private LocalDateTime dataInclusao;
}
