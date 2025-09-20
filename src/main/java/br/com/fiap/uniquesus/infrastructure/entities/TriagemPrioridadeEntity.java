package br.com.fiap.uniquesus.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "triagem_prioridade")
public class TriagemPrioridadeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_triagem_prioridade", nullable = false)
    private Long triagemPrioridadeId;
    
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    @Column(name = "tempo_atendimento", nullable = false)
    private Integer tempoParaAtendimento;
    
    @CreationTimestamp
    @Column(name = "data_inclusao", updatable = false, nullable = false)
    private LocalDateTime dataInclusao;
}
