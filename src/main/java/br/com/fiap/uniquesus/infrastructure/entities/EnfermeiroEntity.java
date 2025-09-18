package br.com.fiap.uniquesus.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "enfermeiro")
public class EnfermeiroEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enfermeiro", nullable = false)
    private Long   enfermeiroId;
    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "coren", length = 20, nullable = false)
    private String coren;
    
    @CurrentTimestamp
    @Column(name = "data_inclusao", nullable = false)
    private LocalDateTime dataInclusao;
}
