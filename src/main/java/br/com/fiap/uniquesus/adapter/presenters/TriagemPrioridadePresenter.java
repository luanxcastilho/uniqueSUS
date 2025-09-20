package br.com.fiap.uniquesus.adapter.presenters;

import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.infrastructure.dtos.TriagemPrioridadeResponseDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.TriagemPrioridadeRequestDTO;
import org.springframework.data.domain.Page;

public class TriagemPrioridadePresenter
{
    public static TriagemPrioridadeResponseDTO toDTO ( TriagemPrioridade triagemPrioridade )
    {
        TriagemPrioridadeResponseDTO triagemPrioridadeResponseDTO = new TriagemPrioridadeResponseDTO();
        
        triagemPrioridadeResponseDTO.setTriagemPrioridadeId( triagemPrioridade.getTriagemPrioridadeId() );
        triagemPrioridadeResponseDTO.setDescricao( triagemPrioridade.getDescricao() );
        triagemPrioridadeResponseDTO.setTempoParaAtendimento( triagemPrioridade.getTempoParaAtendimento() );
        
        return triagemPrioridadeResponseDTO;
    }
    
    public static Page<TriagemPrioridadeResponseDTO> toDTO ( Page<TriagemPrioridade> triagemPrioridades )
    {
        return triagemPrioridades.map( TriagemPrioridadePresenter::toDTO );
    }
    
    public static TriagemPrioridade toDomain ( TriagemPrioridadeRequestDTO triagemPrioridadeRequestDTO )
    {
        TriagemPrioridade triagemPrioridade = new TriagemPrioridade();
        
        triagemPrioridade.setDescricao( triagemPrioridadeRequestDTO.getDescricao() );
        triagemPrioridade.setTempoParaAtendimento( triagemPrioridadeRequestDTO.getTempoParaAtendimento() );
        
        return triagemPrioridade;
    }
    
    public static TriagemPrioridade toDomain ( Long triagemPrioridadeId , TriagemPrioridadeRequestDTO triagemPrioridadeRequestDTO )
    {
        TriagemPrioridade triagemPrioridade = new TriagemPrioridade();
        
        triagemPrioridade.setTriagemPrioridadeId( triagemPrioridadeId );
        triagemPrioridade.setDescricao( triagemPrioridadeRequestDTO.getDescricao() );
        triagemPrioridade.setTempoParaAtendimento( triagemPrioridadeRequestDTO.getTempoParaAtendimento() );
        
        return triagemPrioridade;
    }
    
}
