package br.com.fiap.uniquesus.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "triagem")
public class TriagemEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_triagem", nullable = false)
    private Long triagemId;
    
    @Column(name = "id_atendimento", nullable = false)
    private Long atendimentoId;
    
    @Column(name = "id_enfermeiro", nullable = false)
    private Long enfermeiroId;
    
    @Column(name = "id_triagem_prioridade")
    private Long triagemPrioridadeId;
    
    @Column(name = "sintomas", length = 500)
    private String sintomas;
    
    @Column(name = "data_hora_inicial", nullable = false)
    private LocalDateTime dataHoraInicial;
    
    @Column(name = "data_hora_final")
    private LocalDateTime dataHoraFinal;
}
