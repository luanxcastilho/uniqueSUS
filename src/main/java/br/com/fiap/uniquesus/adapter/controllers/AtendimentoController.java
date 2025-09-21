package br.com.fiap.uniquesus.adapter.controllers;

import br.com.fiap.uniquesus.adapter.presenters.AtendimentoPresenter;
import br.com.fiap.uniquesus.application.usecases.atendimento.BuscarAtendimentoPeloIdUseCase;
import br.com.fiap.uniquesus.application.usecases.atendimento.BuscarAtendimentosUseCase;
import br.com.fiap.uniquesus.application.usecases.atendimento.FinalizarAtendimentoUseCase;
import br.com.fiap.uniquesus.application.usecases.atendimento.IniciarAtendimentoUseCase;
import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.infrastructure.dtos.atendimento.AtendimentoResponseDTO;
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
@RequestMapping("/api/v1/atendimentos")
@Tag(name = "Atendimentos", description = "Gerenciamento de atendimentos.")
public class AtendimentoController
{
    private final Logger logger = LoggerFactory.getLogger( AtendimentoController.class );
    
    private final IniciarAtendimentoUseCase      iniciarAtendimentoUseCase;
    private final FinalizarAtendimentoUseCase    finalizarAtendimentoUseCase;
    private final BuscarAtendimentosUseCase      buscarAtendimentosUseCase;
    private final BuscarAtendimentoPeloIdUseCase buscarAtendimentoPeloIdUseCase;
    
    public AtendimentoController ( IniciarAtendimentoUseCase iniciarAtendimentoUseCase , FinalizarAtendimentoUseCase finalizarAtendimentoUseCase , BuscarAtendimentosUseCase buscarAtendimentosUseCase , BuscarAtendimentoPeloIdUseCase buscarAtendimentoPeloIdUseCase )
    {
        this.iniciarAtendimentoUseCase      = iniciarAtendimentoUseCase;
        this.finalizarAtendimentoUseCase    = finalizarAtendimentoUseCase;
        this.buscarAtendimentosUseCase      = buscarAtendimentosUseCase;
        this.buscarAtendimentoPeloIdUseCase = buscarAtendimentoPeloIdUseCase;
    }
    
    @PostMapping("/iniciar/{pacienteId}")
    @Operation(summary = "Inicia um atendimento para um paciente.")
    public ResponseEntity<AtendimentoResponseDTO> iniciarAtendimento (
            @PathVariable
            Long pacienteId )
    {
        Atendimento atendimento = this.iniciarAtendimentoUseCase.executar( pacienteId );
        AtendimentoResponseDTO atendimentoResponseDTO = AtendimentoPresenter.toDTO( atendimento );
        
        return ResponseEntity.status( HttpStatus.OK ).body( atendimentoResponseDTO );
    }
    
    @PutMapping("/finalizar/{atendimentoId}")
    @Operation(summary = "Finaliza um atendimento pelo ID.")
    public ResponseEntity<AtendimentoResponseDTO> finalizarAtendimento (
            @PathVariable
            Long atendimentoId )
    {
        Atendimento atendimento = this.finalizarAtendimentoUseCase.executar( atendimentoId );
        AtendimentoResponseDTO atendimentoResponseDTO = AtendimentoPresenter.toDTO( atendimento );
        
        return ResponseEntity.status( HttpStatus.OK ).body( atendimentoResponseDTO );
    }
    
    @GetMapping
    @Operation(summary = "Busca todos os atendimentos.")
    public ResponseEntity<PageResponse<AtendimentoResponseDTO>> buscarAtendimentos ( Pageable pageable )
    {
        Page<AtendimentoResponseDTO> atendimentos = this.buscarAtendimentosUseCase.executar( pageable ).map( AtendimentoPresenter::toDTO );
        return ResponseEntity.status( HttpStatus.OK ).body( PageResponse.from( atendimentos ) );
    }
    
    @GetMapping("/{atendimentoId}")
    @Operation(summary = "Busca um atendimento pelo ID.")
    public ResponseEntity<AtendimentoResponseDTO> buscarAtendimentoPeloId (
            @PathVariable
            Long atendimentoId )
    {
        Atendimento atendimento = this.buscarAtendimentoPeloIdUseCase.executar( atendimentoId );
        AtendimentoResponseDTO atendimentoResponseDTO = AtendimentoPresenter.toDTO( atendimento );
        return ResponseEntity.status( HttpStatus.OK ).body( atendimentoResponseDTO );
    }
}
