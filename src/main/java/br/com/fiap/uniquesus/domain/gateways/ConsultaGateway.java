package br.com.fiap.uniquesus.domain.gateways;

import br.com.fiap.uniquesus.domain.entities.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ConsultaGateway
{
    Optional<Consulta> buscarConsultaPeloId ( Long consultaId );
    
    Consulta gravarConsulta ( Consulta consulta );
    
    void removerConsulta ( Long consultaId );
    
    Page<Consulta> buscarConsultas ( Pageable pageable );
}
