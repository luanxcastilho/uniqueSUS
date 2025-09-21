package br.com.fiap.uniquesus.adapter.controllers;

import br.com.fiap.uniquesus.adapter.presenters.PacientePresenter;
import br.com.fiap.uniquesus.application.usecases.paciente.*;
import br.com.fiap.uniquesus.domain.entities.Paciente;
import br.com.fiap.uniquesus.infrastructure.dtos.paciente.PacienteRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.paciente.PacienteResponseDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.PageResponse;
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
@RequestMapping("/api/v1/pacientes")
@Tag( name = "Pacientes" , description = "Gerenciamento de pacientes." )
public class PacienteController
{
    private final Logger logger = LoggerFactory.getLogger( PacienteController.class );
    
    private final CriarPacienteUseCase         criarPacienteUseCase;
    private final AtualizarPacienteUseCase     atualizarPacienteUseCase;
    private final RemoverPacienteUseCase       removerPacienteUseCase;
    private final BuscarPacientesUseCase       buscarPacientesUseCase;
    private final BuscarPacientePeloCPFUseCase buscarPacientePeloCPFUseCase;
    private final BuscarPacientePeloIdUseCase  buscarPacientePeloIdUseCase;
    
    public PacienteController ( CriarPacienteUseCase criarPacienteUseCase , AtualizarPacienteUseCase atualizarPacienteUseCase , RemoverPacienteUseCase removerPacienteUseCase , BuscarPacientesUseCase buscarPacientesUseCase , BuscarPacientePeloCPFUseCase buscarPacientePeloCPFUseCase , BuscarPacientePeloIdUseCase buscarPacientePeloIdUseCase )
    {
        this.criarPacienteUseCase         = criarPacienteUseCase;
        this.atualizarPacienteUseCase     = atualizarPacienteUseCase;
        this.removerPacienteUseCase       = removerPacienteUseCase;
        this.buscarPacientesUseCase       = buscarPacientesUseCase;
        this.buscarPacientePeloCPFUseCase = buscarPacientePeloCPFUseCase;
        this.buscarPacientePeloIdUseCase  = buscarPacientePeloIdUseCase;
    }
    
    @PostMapping
    @Operation(summary = "Cadastra um paciente.")
    public ResponseEntity<PacienteResponseDTO> criarPaciente (
            @RequestBody
            PacienteRequestDTO pacienteRequestDTO )
    {
        Paciente paciente = PacientePresenter.toDomain( pacienteRequestDTO );
        Paciente pacienteCriado = this.criarPacienteUseCase.executar( paciente );
        PacienteResponseDTO pacienteResponseDTO = PacientePresenter.toDTO( pacienteCriado );
        
        return ResponseEntity.status( HttpStatus.CREATED ).body( pacienteResponseDTO );
    }
    
    @PutMapping("/{pacienteId}")
    @Operation(summary = "Atualiza um paciente pelo ID.")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente (
            @PathVariable
            Long pacienteId ,
            @RequestBody
            PacienteRequestDTO pacienteRequestDTO )
    {
        Paciente paciente = PacientePresenter.toDomain( pacienteId , pacienteRequestDTO );
        Paciente pacienteAtualizado = this.atualizarPacienteUseCase.executar( paciente );
        PacienteResponseDTO pacienteResponseDTO = PacientePresenter.toDTO( pacienteAtualizado );
        
        return ResponseEntity.status( HttpStatus.OK ).body( pacienteResponseDTO );
    }
    
    @DeleteMapping("/{pacienteId}")
    @Operation(summary = "Remove um paciente pelo ID.")
    public ResponseEntity<Void> removerPaciente (
            @PathVariable
            Long pacienteId )
    {
        this.removerPacienteUseCase.executar( pacienteId );
        return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
    }
    
    @GetMapping
    @Operation(summary = "Busca todos os pacientes.")
    public ResponseEntity<PageResponse<PacienteResponseDTO>> buscarPacientes ( Pageable pageable )
    {
        Page<PacienteResponseDTO> pacienteResponseDTOS = PacientePresenter.toDTO( this.buscarPacientesUseCase.executar( pageable ) );
        return ResponseEntity.status( HttpStatus.OK ).body( PageResponse.from( pacienteResponseDTOS ));
    }
    
    @GetMapping("/{pacienteId}")
    @Operation(summary = "Busca um paciente pelo ID.")
    public ResponseEntity<PacienteResponseDTO> buscarPacientePeloId (
            @PathVariable
            Long pacienteId )
    {
        Paciente pacienteEncontrado = this.buscarPacientePeloIdUseCase.executar( pacienteId ) ;
        PacienteResponseDTO pacienteResponseDTO = PacientePresenter.toDTO( pacienteEncontrado );
        return ResponseEntity.status( HttpStatus.OK ).body( pacienteResponseDTO );
    }
    
    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Busca um paciente pelo CPF.")
    public ResponseEntity<PacienteResponseDTO> buscarPacientePeloCpf (
            @PathVariable
            String cpf )
    {
        Paciente pacienteEncontrado = this.buscarPacientePeloCPFUseCase.executar( cpf );
        PacienteResponseDTO pacienteResponseDTO = PacientePresenter.toDTO( pacienteEncontrado );
        return ResponseEntity.status( HttpStatus.OK ).body( pacienteResponseDTO );
    }
}
