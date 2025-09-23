package br.com.fiap.uniquesus.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "consulta")
public class ConsultaEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta", nullable = false)
    private Long consultaId;
    
    @Column(name = "id_atendimento", nullable = false)
    private Long atendimentoId;
    
    @Column(name = "id_medico", nullable = false)
    private Long medicoId;
    
    @Column(name = "diagnostico", length = 1000)
    private String diagnostico;
    
    @Column(name = "data_hora_inicial", nullable = false)
    private LocalDateTime dataHoraInicial;
    
    @Column(name = "data_hora_final")
    private LocalDateTime dataHoraFinal;
}
