package br.com.fiap.uniquesus.adapter.presenters;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.entities.Triagem;
import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.infrastructure.dtos.triagem.FinalizarTriagemRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.triagem.TriagemResponseDTO;
import org.springframework.data.domain.Page;

public class TriagemPresenter
{
    public static TriagemResponseDTO toDTO ( Triagem triagem )
    {
        TriagemResponseDTO triagemResponseDTO = new TriagemResponseDTO();
        
        triagemResponseDTO.setTriagemId( triagem.getTriagemId() );
        triagemResponseDTO.setAtendimento( triagem.getAtendimento() );
        triagemResponseDTO.setEnfermeiro( triagem.getEnfermeiro() );
        triagemResponseDTO.setTriagemPrioridade( triagem.getTriagemPrioridade() );
        triagemResponseDTO.setSintomas( triagem.getSintomas() );
        triagemResponseDTO.setDataHoraInicial( triagem.getDataHoraInicial() );
        triagemResponseDTO.setDataHoraFinal( triagem.getDataHoraFinal() );
        
        return triagemResponseDTO;
    }
    
    public static Page<TriagemResponseDTO> toDTO ( Page<Triagem> triagens )
    {
        return triagens.map( TriagemPresenter::toDTO );
    }
    
    public static Triagem toDomain ( FinalizarTriagemRequestDTO finalizarTriagemRequestDTO )
    {
        Triagem triagem = new Triagem();
        
        TriagemPrioridade  triagemPrioridade = new TriagemPrioridade();
        triagemPrioridade.setTriagemPrioridadeId( finalizarTriagemRequestDTO.getTriagemPrioridadeId() );
        
        triagem.setTriagemPrioridade( triagemPrioridade );
        triagem.setSintomas( finalizarTriagemRequestDTO.getSintomas() );
        
        return triagem;
    }
    
    public static Triagem toDomain ( Long triagemId, FinalizarTriagemRequestDTO finalizarTriagemRequestDTO )
    {
        Triagem triagem = toDomain( finalizarTriagemRequestDTO );
        triagem.setTriagemId( triagemId );
        return triagem;
    }
}
