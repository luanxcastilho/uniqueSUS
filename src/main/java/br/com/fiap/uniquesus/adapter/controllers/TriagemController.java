package br.com.fiap.uniquesus.adapter.controllers;

import br.com.fiap.uniquesus.adapter.presenters.TriagemPresenter;
import br.com.fiap.uniquesus.application.usecases.triagem.*;
import br.com.fiap.uniquesus.domain.entities.Triagem;
import br.com.fiap.uniquesus.infrastructure.dtos.triagem.FinalizarTriagemRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.triagem.IniciarTriagemRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.triagem.PosicaoNaFilaDeTriagemResponseDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.triagem.TriagemResponseDTO;
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
@RequestMapping("/api/v1/triagens")
@Tag(name = "Triagens", description = "Gerenciamento de triagens.")
public class TriagemController
{
    private final Logger logger = LoggerFactory.getLogger( TriagemController.class );
    
    private final IniciarTriagemUseCase               iniciarTriagemUseCase;
    private final FinalizarTriagemUseCase             finalizarAtendimentoUseCase;
    private final BuscarTriagensUseCase               buscarTriagensUseCase;
    private final BuscarTriagemPeloIdUseCase          buscarTriagemPeloIdUseCase;
    private final BuscarPosicaoNaFilaDeTriagemUseCase buscarPosicaoNaFilaDeTriagemUseCase;
    
    public TriagemController ( IniciarTriagemUseCase iniciarTriagemUseCase , FinalizarTriagemUseCase finalizarAtendimentoUseCase , BuscarTriagensUseCase buscarTriagensUseCase , BuscarTriagemPeloIdUseCase buscarTriagemPeloIdUseCase , BuscarPosicaoNaFilaDeTriagemUseCase buscarPosicaoNaFilaDeTriagemUseCase )
    {
        this.iniciarTriagemUseCase               = iniciarTriagemUseCase;
        this.finalizarAtendimentoUseCase         = finalizarAtendimentoUseCase;
        this.buscarTriagensUseCase               = buscarTriagensUseCase;
        this.buscarTriagemPeloIdUseCase          = buscarTriagemPeloIdUseCase;
        this.buscarPosicaoNaFilaDeTriagemUseCase = buscarPosicaoNaFilaDeTriagemUseCase;
    }
    
    
    @PostMapping("/iniciar/{atendimentoId}")
    @Operation(summary = "Inicia uma triagem de um atendimento.")
    public ResponseEntity<TriagemResponseDTO> iniciarTriagem (
            @PathVariable
            Long atendimentoId ,
            
            @RequestBody
            IniciarTriagemRequestDTO iniciarTriagemRequestDTO )
    {
        Triagem triagem = this.iniciarTriagemUseCase.executar( atendimentoId , iniciarTriagemRequestDTO.getEnfermeiroId() );
        TriagemResponseDTO triagemResponseDTO = TriagemPresenter.toDTO( triagem );
        
        return ResponseEntity.status( HttpStatus.OK ).body( triagemResponseDTO );
    }
    
    @PostMapping("/finalizar/{triagemId}")
    @Operation(summary = "Finaliza uma triagem pelo ID.")
    public ResponseEntity<TriagemResponseDTO> finalizarTriagem (
            @PathVariable
            Long triagemId ,
            
            @RequestBody
            FinalizarTriagemRequestDTO finalizarTriagemRequestDTO )
    {
        Triagem triagem = this.finalizarAtendimentoUseCase.executar( triagemId , finalizarTriagemRequestDTO );
        TriagemResponseDTO triagemResponseDTO = TriagemPresenter.toDTO( triagem );
        
        return ResponseEntity.status( HttpStatus.OK ).body( triagemResponseDTO );
    }
    
    @GetMapping
    @Operation(summary = "Busca todas as triagens.")
    public ResponseEntity<Page<TriagemResponseDTO>> buscarTriagem ( Pageable pageable )
    {
        Page<TriagemResponseDTO> triagemResponseDTOS = this.buscarTriagensUseCase.executar( pageable )
                .map( TriagemPresenter::toDTO );
        return ResponseEntity.status( HttpStatus.OK ).body( triagemResponseDTOS );
    }
    
    @GetMapping("/{triagemId}")
    @Operation(summary = "Busca uma triagem pelo ID.")
    public ResponseEntity<TriagemResponseDTO> buscarTriagemPeloId (
            @PathVariable
            Long triagemId )
    {
        Triagem triagemEncontrada = this.buscarTriagemPeloIdUseCase.executar( triagemId );
        TriagemResponseDTO triagemResponseDTO = TriagemPresenter.toDTO( triagemEncontrada );
        return ResponseEntity.status( HttpStatus.OK ).body( triagemResponseDTO );
    }
    
    @GetMapping("/fila/{pacienteId}")
    public ResponseEntity<PosicaoNaFilaDeTriagemResponseDTO> buscarPosicaoNaFila (
            @PathVariable
            Long pacienteId )
    {
        var output = this.buscarPosicaoNaFilaDeTriagemUseCase.executar( pacienteId );
        
        PosicaoNaFilaDeTriagemResponseDTO posicaoNaFilaDeTriagemResponseDTO = new PosicaoNaFilaDeTriagemResponseDTO( output.pacienteId() , output.posicaoAtual() , output.totalFila() );
        
        return ResponseEntity.status( HttpStatus.OK ).body( posicaoNaFilaDeTriagemResponseDTO );
    }
}
