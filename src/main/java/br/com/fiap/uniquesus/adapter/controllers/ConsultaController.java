package br.com.fiap.uniquesus.adapter.controllers;

import br.com.fiap.uniquesus.adapter.presenters.ConsultaPresenter;
import br.com.fiap.uniquesus.application.usecases.consulta.BuscarConsultaPeloIdUseCase;
import br.com.fiap.uniquesus.application.usecases.consulta.BuscarConsultasUseCase;
import br.com.fiap.uniquesus.application.usecases.consulta.FinalizarConsultaUseCase;
import br.com.fiap.uniquesus.application.usecases.consulta.IniciarConsultaUseCase;
import br.com.fiap.uniquesus.domain.entities.Consulta;
import br.com.fiap.uniquesus.infrastructure.dtos.PageResponse;
import br.com.fiap.uniquesus.infrastructure.dtos.consulta.ConsultaResponseDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.consulta.FinalizarConsultaRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.consulta.IniciarConsultaRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consultas")
@Tag( name = "Consultas" , description = "Gerenciamento de consultas." )
public class ConsultaController
{
    private final Logger logger = LoggerFactory.getLogger( ConsultaController.class );
    
    private final IniciarConsultaUseCase   iniciarConsultaUseCase;
    private final FinalizarConsultaUseCase finalizarConsultaUseCase;
    private final BuscarConsultasUseCase   buscarConsultasUseCase;
    private final BuscarConsultaPeloIdUseCase buscarConsultaPeloIdUseCase;
    
    public ConsultaController ( IniciarConsultaUseCase iniciarConsultaUseCase , FinalizarConsultaUseCase finalizarConsultaUseCase , BuscarConsultasUseCase buscarConsultasUseCase , BuscarConsultaPeloIdUseCase buscarConsultaPeloIdUseCase )
    {
        this.iniciarConsultaUseCase      = iniciarConsultaUseCase;
        this.finalizarConsultaUseCase    = finalizarConsultaUseCase;
        this.buscarConsultasUseCase      = buscarConsultasUseCase;
        this.buscarConsultaPeloIdUseCase = buscarConsultaPeloIdUseCase;
    }
    
    @PostMapping("/iniciar/{atendimentoId}")
    @Operation(summary = "Inicia uma consulta de um atendimento.")
    public ResponseEntity<ConsultaResponseDTO> iniciarConsulta
            (
            @RequestBody
            IniciarConsultaRequestDTO iniciarConsultaRequestDTO ,
            
            @PathVariable
            Long atendimentoId )
    {
        Consulta consulta = this.iniciarConsultaUseCase.executar( atendimentoId, iniciarConsultaRequestDTO.getMedicoId() );
        ConsultaResponseDTO consultaResponseDTO = ConsultaPresenter.toDTO( consulta );
        
        return ResponseEntity.status( HttpStatus.OK ).body( consultaResponseDTO );
    }
    
    @PostMapping("/finalizar/{consultaId}")
    @Operation(summary = "Finaliza uma consulta pelo ID.")
    public ResponseEntity<ConsultaResponseDTO> finalizarConsulta (
            @PathVariable
            Long consultaId,
            @RequestBody FinalizarConsultaRequestDTO finalizarConsultaRequestDTO )
    {
        Consulta consulta = this.finalizarConsultaUseCase.executar( consultaId, finalizarConsultaRequestDTO.getDiagnostico() );
        ConsultaResponseDTO consultaResponseDTO = ConsultaPresenter.toDTO( consulta );
        
        return ResponseEntity.status( HttpStatus.OK ).body( consultaResponseDTO );
    }
    
    @GetMapping
    @Operation(summary = "Busca todas as consultas.")
    public ResponseEntity<PageResponse<ConsultaResponseDTO>> buscarConsultas ( Pageable pageable )
    {
        Page<ConsultaResponseDTO> consultas = this.buscarConsultasUseCase.executar( pageable ).map( ConsultaPresenter::toDTO );
        return ResponseEntity.status( HttpStatus.OK ).body( PageResponse.from( consultas ) );
    }
    
    @GetMapping("/{consultaId}")
    @Operation(summary = "Busca uma consulta pelo ID.")
    public ResponseEntity<ConsultaResponseDTO> buscarConsultaPeloId (
            @PathVariable
            Long consultaId )
    {
        Consulta consulta = this.buscarConsultaPeloIdUseCase.executar( consultaId );
        ConsultaResponseDTO consultaResponseDTO = ConsultaPresenter.toDTO( consulta );
        return ResponseEntity.status( HttpStatus.OK ).body( consultaResponseDTO );
    }
}
