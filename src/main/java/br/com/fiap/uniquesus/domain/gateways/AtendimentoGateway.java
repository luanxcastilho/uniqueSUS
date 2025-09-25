package br.com.fiap.uniquesus.domain.gateways;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AtendimentoGateway
{
    Optional<Atendimento> buscarAtendimentoPeloId ( Long atendimentoId );
    
    Atendimento gravarAtendimento ( Atendimento atendimento );
    
    void removerAtendimento ( Long atendimentoId );
    
    Page<Atendimento> buscarAtendimentos ( Pageable pageable );
    
    Optional<Atendimento> buscarAtendimentoPeloPacienteId ( Long pacienteId );
}
