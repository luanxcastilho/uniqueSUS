package br.com.fiap.uniquesus.application.usecases.paciente;

import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.domain.gateways.PacienteGateway;

import java.awt.print.Pageable;
import java.util.List;

public class BuscarPacientes
{
    private final PacienteGateway pacienteGateway;
    
    public BuscarPacientes ( PacienteGateway pacienteGateway )
    {
        this.pacienteGateway = pacienteGateway;
    }
    
    public List<Paciente> executar ( Pageable pageable )
    {
        return this.pacienteGateway.listarPacientes( pageable );
    }
}
