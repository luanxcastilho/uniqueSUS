package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class BuscarPacientesUseCase
{
    private final PacienteGateway pacienteGateway;
    
    public BuscarPacientesUseCase ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public Page<Paciente> executar ( Pageable pageable )
    {
        return this.pacienteGateway.buscarPacientes( pageable );
    }
}
