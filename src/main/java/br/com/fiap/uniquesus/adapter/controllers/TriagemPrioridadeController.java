package br.com.fiap.uniquesus.adapter.controllers;

import br.com.fiap.uniquesus.adapter.presenters.TriagemPrioridadePresenter;
import br.com.fiap.uniquesus.application.usecases.triagemPrioridade.*;
import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.infrastructure.dtos.PageResponse;
import br.com.fiap.uniquesus.infrastructure.dtos.TriagemPrioridadeRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.TriagemPrioridadeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/triagem-prioridades")
@Tag(name = "Prioridades de triagem", description = "Gerenciamento de prioridades de triagem.")
public class TriagemPrioridadeController
{
    private final Logger logger = LoggerFactory.getLogger( TriagemPrioridadeController.class );
    
    private final CriarTriagemPrioridadeUseCase        criarTriagemPrioridade;
    private final AtualizarTriagemPrioridadeUseCase    atualizarTriagemPrioridade;
    private final RemoverTriagemPrioridadeUseCase      removerTriagemPrioridade;
    private final BuscarTriagemPrioridadesUseCase      buscarTriagemPrioridades;
    private final BuscarTriagemPrioridadePeloIdUseCase buscarTriagemPrioridadePeloId;
    
    public TriagemPrioridadeController ( CriarTriagemPrioridadeUseCase criarTriagemPrioridade , AtualizarTriagemPrioridadeUseCase atualizarTriagemPrioridade , RemoverTriagemPrioridadeUseCase removerTriagemPrioridade , BuscarTriagemPrioridadesUseCase buscarTriagemPrioridades , BuscarTriagemPrioridadePeloIdUseCase buscarTriagemPrioridadePeloId )
    {
        this.criarTriagemPrioridade        = criarTriagemPrioridade;
        this.atualizarTriagemPrioridade    = atualizarTriagemPrioridade;
        this.removerTriagemPrioridade      = removerTriagemPrioridade;
        this.buscarTriagemPrioridades      = buscarTriagemPrioridades;
        this.buscarTriagemPrioridadePeloId = buscarTriagemPrioridadePeloId;
    }
    
    @PostMapping
    @Operation(summary = "Cadastra uma prioridade de triagem.")
    public ResponseEntity<TriagemPrioridadeResponseDTO> criarTriagemPrioridade (
            @RequestBody
            TriagemPrioridadeRequestDTO triagemPrioridadeRequestDTO )
    {
        TriagemPrioridade triagemPrioridade = TriagemPrioridadePresenter.toDomain( triagemPrioridadeRequestDTO );
        TriagemPrioridade triagemPrioridadeCriada = this.criarTriagemPrioridade.executar( triagemPrioridade );
        TriagemPrioridadeResponseDTO triagemPrioridadeResponseDTO = TriagemPrioridadePresenter.toDTO( triagemPrioridadeCriada );
        
        return ResponseEntity.status( HttpStatus.CREATED ).body( triagemPrioridadeResponseDTO );
    }
    
    @PutMapping("/{triagemPrioridadeId}")
    @Operation(summary = "Atualiza uma prioridade de triagem pelo ID.")
    public ResponseEntity<TriagemPrioridadeResponseDTO> atualizarTriagemPrioridade (
            @PathVariable
            Long triagemPrioridadeId ,
            @RequestBody
            TriagemPrioridadeRequestDTO triagemPrioridadeRequestDTO )
    {
        TriagemPrioridade triagemPrioridade = TriagemPrioridadePresenter.toDomain( triagemPrioridadeId , triagemPrioridadeRequestDTO );
        TriagemPrioridade triagemPrioridadeAtualizada = this.atualizarTriagemPrioridade.executar( triagemPrioridade );
        TriagemPrioridadeResponseDTO triagemPrioridadeResponseDTO = TriagemPrioridadePresenter.toDTO( triagemPrioridadeAtualizada );
        
        return ResponseEntity.status( HttpStatus.OK ).body( triagemPrioridadeResponseDTO );
    }
    
    @DeleteMapping("/{triagemPrioridadeId}")
    @Operation(summary = "Remove uma prioridade de triagem pelo ID.")
    public ResponseEntity<Void> removerTriagemPrioridade (
            @PathVariable
            Long triagemPrioridadeId )
    {
        this.removerTriagemPrioridade.executar( triagemPrioridadeId );
        return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
    }
    
    @GetMapping("/{triagemPrioridadeId}")
    @Operation(summary = "Busca uma prioridade de triagem pelo ID.")
    public ResponseEntity<TriagemPrioridadeResponseDTO> buscarTriagemPrioridadePeloId (
            @PathVariable
            Long triagemPrioridadeId )
    {
        TriagemPrioridade triagemPrioridade = this.buscarTriagemPrioridadePeloId.executar( triagemPrioridadeId );
        TriagemPrioridadeResponseDTO triagemPrioridadeResponseDTO = TriagemPrioridadePresenter.toDTO( triagemPrioridade );
        return ResponseEntity.status( HttpStatus.OK ).body( triagemPrioridadeResponseDTO );
    }
    
    @GetMapping
    @Operation(summary = "Busca todas as prioridades de triagem.")
    public ResponseEntity<PageResponse<TriagemPrioridadeResponseDTO>> buscarTriagemPrioridades ( Pageable pageable )
    {
        org.springframework.data.domain.Page<TriagemPrioridadeResponseDTO> triagemPrioridadeResponseDTOS = TriagemPrioridadePresenter.toDTO( this.buscarTriagemPrioridades.executar( pageable ) );
        return ResponseEntity.status( HttpStatus.OK ).body( PageResponse.from( triagemPrioridadeResponseDTOS ) );
    }
}
