package br.com.fiap.uniquesus.adapter.controllers;

import br.com.fiap.uniquesus.adapter.presenters.MedicoPresenter;
import br.com.fiap.uniquesus.application.usecases.medico.*;
import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.infrastructure.dtos.medico.MedicoRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.medico.MedicoResponseDTO;
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
@RequestMapping("/api/v1/medicos")
@Tag(name = "Médicos", description = "Gerenciamento de médicos.")
public class MedicoController
{
    private final Logger logger = LoggerFactory.getLogger( MedicoController.class );
    
    private final CriarMedicoUseCase         criarMedicoUseCase;
    private final AtualizarMedicoUseCase     atualizarMedicoUseCase;
    private final RemoverMedicoUseCase       removerMedicoUseCase;
    private final BuscarMedicosUseCase       buscarMedicosUseCase;
    private final BuscarMedicoPeloIdUseCase  buscarMedicoPeloIdUseCase;
    private final BuscarMedicoPeloCRMUseCase buscarMedicoPeloCRMUseCase;
    
    public MedicoController ( CriarMedicoUseCase criarMedicoUseCase , AtualizarMedicoUseCase atualizarMedicoUseCase , RemoverMedicoUseCase removerMedicoUseCase , BuscarMedicosUseCase buscarMedicosUseCase , BuscarMedicoPeloIdUseCase buscarMedicoPeloIdUseCase , BuscarMedicoPeloCRMUseCase buscarMedicoPeloCRMUseCase )
    {
        this.criarMedicoUseCase         = criarMedicoUseCase;
        this.atualizarMedicoUseCase     = atualizarMedicoUseCase;
        this.removerMedicoUseCase       = removerMedicoUseCase;
        this.buscarMedicosUseCase       = buscarMedicosUseCase;
        this.buscarMedicoPeloIdUseCase  = buscarMedicoPeloIdUseCase;
        this.buscarMedicoPeloCRMUseCase = buscarMedicoPeloCRMUseCase;
    }
    
    @PostMapping
    @Operation(summary = "Cadastra um médico.")
    public ResponseEntity<MedicoResponseDTO> criarMedico (
            @RequestBody
            MedicoRequestDTO medicoRequestDTO )
    {
        Medico medico = MedicoPresenter.toDomain( medicoRequestDTO );
        Medico medicoCriado = this.criarMedicoUseCase.executar( medico );
        MedicoResponseDTO medicoResponseDTO = MedicoPresenter.toDTO( medicoCriado );
        
        return ResponseEntity.status( HttpStatus.CREATED ).body( medicoResponseDTO );
    }
    
    @PutMapping("/{medicoId}")
    @Operation(summary = "Atualiza um médico pelo ID.")
    public ResponseEntity<MedicoResponseDTO> atualizarMedico (
            @PathVariable
            Long medicoId ,
            
            @RequestBody
            MedicoRequestDTO medicoRequestDTO )
    {
        Medico medico = MedicoPresenter.toDomain( medicoId , medicoRequestDTO );
        Medico medicoAtualizado = this.atualizarMedicoUseCase.executar( medico );
        MedicoResponseDTO medicoResponseDTO = MedicoPresenter.toDTO( medicoAtualizado );
        
        return ResponseEntity.status( HttpStatus.OK ).body( medicoResponseDTO );
    }
    
    @DeleteMapping("/{medicoId}")
    @Operation(summary = "Remove um médico pelo ID.")
    public ResponseEntity<Void> removerMedico (
            @PathVariable
            Long medicoId )
    {
        this.removerMedicoUseCase.executar( medicoId );
        return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
    }
    
    @GetMapping
    @Operation(summary = "Busca todos os médicos.")
    public ResponseEntity<PageResponse<MedicoResponseDTO>> buscarMedicos ( Pageable pageable )
    {
        Page<MedicoResponseDTO> medicoResponseDTOS = MedicoPresenter.toDTO( this.buscarMedicosUseCase.executar( pageable ) );
        return ResponseEntity.status( HttpStatus.OK ).body( PageResponse.from( medicoResponseDTOS ) );
    }
    
    @GetMapping("/{medicoId}")
    @Operation(summary = "Busca um médico pelo ID.")
    public ResponseEntity<MedicoResponseDTO> buscarMedicoPeloId (
            @PathVariable
            Long medicoId )
    {
        Medico medicoEncontrado = this.buscarMedicoPeloIdUseCase.executar( medicoId );
        MedicoResponseDTO medicoResponseDTO = MedicoPresenter.toDTO( medicoEncontrado );
        return ResponseEntity.status( HttpStatus.OK ).body( medicoResponseDTO );
    }
    
    @GetMapping("/crm/{crm}")
    @Operation(summary = "Busca um médico pelo CRM.")
    public ResponseEntity<MedicoResponseDTO> buscarMedicoPeloCrm (
            @PathVariable
            String crm )
    {
        Medico medicoEncontrado = this.buscarMedicoPeloCRMUseCase.executar( crm );
        MedicoResponseDTO medicoResponseDTO = MedicoPresenter.toDTO( medicoEncontrado );
        return ResponseEntity.status( HttpStatus.OK ).body( medicoResponseDTO );
    }
    
}
