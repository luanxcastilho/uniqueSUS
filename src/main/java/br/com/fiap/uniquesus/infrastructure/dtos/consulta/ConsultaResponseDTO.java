package br.com.fiap.uniquesus.infrastructure.dtos.consulta;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Medico;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaResponseDTO
{
    private Long          consultaId;
    private Atendimento   atendimento;
    private Medico        medico;
    private String        diagnostico;
    private LocalDateTime dataHoraInicial;
    private LocalDateTime dataHoraFinal;
}
