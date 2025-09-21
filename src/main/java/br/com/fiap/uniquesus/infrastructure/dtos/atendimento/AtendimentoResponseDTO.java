package br.com.fiap.uniquesus.infrastructure.dtos.atendimento;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AtendimentoResponseDTO
{
    private Long          atendimentoId;
    private Paciente      paciente;
    private LocalDateTime dataHoraInicial;
    private LocalDateTime dataHoraFinal;
}
