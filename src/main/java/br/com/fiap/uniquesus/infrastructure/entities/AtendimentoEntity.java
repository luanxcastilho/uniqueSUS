package br.com.fiap.uniquesus.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "atendimento")
public class AtendimentoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento", nullable = false)
    private Long atendimentoId;
    
    @Column(name = "id_paciente", nullable = false)
    private Long pacienteId;
    
    @Column(name = "data_hora_inicial", nullable = false)
    private LocalDateTime dataHoraInicial;
    
    @Column(name = "data_hora_final")
    private LocalDateTime dataHoraFinal;
    
    @CurrentTimestamp
    @Column(name = "data_inclusao", nullable = false)
    private LocalDateTime dataInclusao;
}
