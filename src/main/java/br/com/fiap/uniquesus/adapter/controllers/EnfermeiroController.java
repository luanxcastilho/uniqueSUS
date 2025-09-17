package br.com.fiap.uniquesus.adapter.controllers;

import br.com.fiap.uniquesus.adapter.presenters.EnfermeiroPresenter;
import br.com.fiap.uniquesus.application.usecases.enfermeiro.*;
import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.infrastructure.dtos.EnfermeiroRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.EnfermeiroResponseDTO;
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
@RequestMapping("/api/v1/enfermeiros")
@Tag(name = "Enfermeiros", description = "Gerenciamento de enfermeiros.")
public class EnfermeiroController
{
    private final Logger logger = LoggerFactory.getLogger( EnfermeiroController.class );
    
    private final CriarEnfermeiroUseCase           criarEnfermeiroUseCase;
    private final AtualizarEnfermeiroUseCase       atualizarEnfermeiroUseCase;
    private final RemoverEnfermeiroUseCase         removerEnfermeiroUseCase;
    private final BuscarEnfermeirosUseCase         buscarEnfermeirosUseCase;
    private final BuscarEnfermeiroPeloCorenUseCase buscarEnfermeiroPeloCorenUseCase;
    private final BuscarEnfermeiroPeloIdUseCase    buscarEnfermeiroPeloIdUseCase;
    
    public EnfermeiroController ( CriarEnfermeiroUseCase criarEnfermeiroUseCase , AtualizarEnfermeiroUseCase atualizarEnfermeiroUseCase , RemoverEnfermeiroUseCase removerEnfermeiroUseCase , BuscarEnfermeirosUseCase buscarEnfermeirosUseCase , BuscarEnfermeiroPeloCorenUseCase buscarEnfermeiroPeloCorenUseCase , BuscarEnfermeiroPeloIdUseCase buscarEnfermeiroPeloIdUseCase )
    {
        this.criarEnfermeiroUseCase           = criarEnfermeiroUseCase;
        this.atualizarEnfermeiroUseCase       = atualizarEnfermeiroUseCase;
        this.removerEnfermeiroUseCase         = removerEnfermeiroUseCase;
        this.buscarEnfermeirosUseCase         = buscarEnfermeirosUseCase;
        this.buscarEnfermeiroPeloCorenUseCase = buscarEnfermeiroPeloCorenUseCase;
        this.buscarEnfermeiroPeloIdUseCase    = buscarEnfermeiroPeloIdUseCase;
    }
    
    @PostMapping
    @Operation(summary = "Cadastra um enfermeiro.")
    public ResponseEntity<EnfermeiroResponseDTO> criarEnfermeiro (
            @RequestBody
            EnfermeiroRequestDTO enfermeiroRequestDTO )
    {
        Enfermeiro enfermeiro = EnfermeiroPresenter.toDomain( enfermeiroRequestDTO );
        Enfermeiro enfermeiroCriado = this.criarEnfermeiroUseCase.executar( enfermeiro );
        EnfermeiroResponseDTO enfermeiroResponseDTO = EnfermeiroPresenter.toDTO( enfermeiroCriado );
        
        return ResponseEntity.status( HttpStatus.CREATED ).body( enfermeiroResponseDTO );
    }
    
    @PutMapping("/{enfermeiroId}")
    @Operation(summary = "Atualiza um enfermeiro pelo ID.")
    public ResponseEntity<EnfermeiroResponseDTO> atualizarEnfermeiro (
            @PathVariable
            Long enfermeiroId ,
            @RequestBody
            EnfermeiroRequestDTO enfermeiroRequestDTO )
    {
        Enfermeiro enfermeiro = EnfermeiroPresenter.toDomain( enfermeiroId , enfermeiroRequestDTO );
        Enfermeiro enfermeiroAtualizado = this.atualizarEnfermeiroUseCase.executar( enfermeiro );
        EnfermeiroResponseDTO enfermeiroResponseDTO = EnfermeiroPresenter.toDTO( enfermeiroAtualizado );
        
        return ResponseEntity.status( HttpStatus.OK ).body( enfermeiroResponseDTO );
    }
    
    @DeleteMapping("/{enfermeiroId}")
    @Operation(summary = "Remove um enfermeiro pelo ID.")
    public ResponseEntity<Void> removerEnfermeiro (
            @PathVariable
            Long enfermeiroId )
    {
        this.removerEnfermeiroUseCase.executar( enfermeiroId );
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    @Operation(summary = "Busca todos os enfermeiros.")
    public ResponseEntity<PageResponse<EnfermeiroResponseDTO>> buscarEnfermeiros ( Pageable pageable )
    {
        Page<EnfermeiroResponseDTO> enfermeiroResponseDTOS = EnfermeiroPresenter.toDTO( this.buscarEnfermeirosUseCase.executar( pageable ) );
        return ResponseEntity.status( HttpStatus.OK ).body( PageResponse.from( enfermeiroResponseDTOS ) );
    }
    
    @GetMapping("/{enfermeiroId}")
    @Operation(summary = "Busca um enfermeiro pelo ID.")
    public ResponseEntity<EnfermeiroResponseDTO> buscarEnfermeiroPeloId (
            @PathVariable
            Long enfermeiroId )
    {
        Enfermeiro enfermeiroEncontrado = this.buscarEnfermeiroPeloIdUseCase.executar( enfermeiroId );
        EnfermeiroResponseDTO enfermeiroResponseDTO = EnfermeiroPresenter.toDTO( enfermeiroEncontrado );
        return ResponseEntity.status( HttpStatus.OK ).body( enfermeiroResponseDTO );
    }
    
    @GetMapping("/coren/{coren}")
    @Operation(summary = "Busca um enfermeiro pelo COREN.")
    public ResponseEntity<EnfermeiroResponseDTO> buscarEnfermeiroPeloCoren (
            @PathVariable
            String coren )
    {
        Enfermeiro enfermeiroEncontrado = this.buscarEnfermeiroPeloCorenUseCase.executar( coren );
        EnfermeiroResponseDTO enfermeiroResponseDTO = EnfermeiroPresenter.toDTO( enfermeiroEncontrado );
        return ResponseEntity.status( HttpStatus.OK ).body( enfermeiroResponseDTO );
    }
}
