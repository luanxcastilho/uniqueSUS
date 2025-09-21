package br.com.fiap.uniquesus.infrastructure.mappers;

import br.com.fiap.uniquesus.domain.entities.Atendimento;
import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.domain.entities.Triagem;
import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.infrastructure.entities.TriagemEntity;

public class TriagemMapper
{
    public static Triagem toDomain ( TriagemEntity triagemEntity )
    {
        Triagem triagem = new Triagem();
        
        Atendimento atendimento = new Atendimento();
        atendimento.setAtendimentoId( triagemEntity.getAtendimentoId() );
        
        Enfermeiro enfermeiro = new Enfermeiro();
        enfermeiro.setEnfermeiroId( triagemEntity.getEnfermeiroId() );
        
        TriagemPrioridade triagemPrioridade = new TriagemPrioridade();
        triagemPrioridade.setTriagemPrioridadeId( triagemEntity.getTriagemPrioridadeId() );
        
        triagem.setTriagemId( triagemEntity.getTriagemId() );
        triagem.setAtendimento( atendimento );
        triagem.setEnfermeiro( enfermeiro );
        triagem.setTriagemPrioridade( triagemPrioridade );
        triagem.setSintomas( triagemEntity.getSintomas() );
        triagem.setDataHoraInicial( triagemEntity.getDataHoraInicial() );
        triagem.setDataHoraFinal( triagemEntity.getDataHoraFinal() );
        
        return triagem;
    }
    
    public static TriagemEntity toEntity ( Triagem triagem )
    {
        TriagemEntity triagemEntity = new TriagemEntity();
        
        triagemEntity.setTriagemId( triagem.getTriagemId() );
        triagemEntity.setAtendimentoId( triagem.getAtendimento().getAtendimentoId() );
        triagemEntity.setEnfermeiroId( triagem.getEnfermeiro().getEnfermeiroId() );
        
        if (triagem.getTriagemPrioridade() != null && triagem.getTriagemPrioridade().getTriagemPrioridadeId() != null)
        {
            triagemEntity.setTriagemPrioridadeId( triagem.getTriagemPrioridade().getTriagemPrioridadeId() );
        }
        
        triagemEntity.setSintomas( triagem.getSintomas() );
        triagemEntity.setDataHoraInicial( triagem.getDataHoraInicial() );
        triagemEntity.setDataHoraFinal( triagem.getDataHoraFinal() );
        
        return triagemEntity;
    }
}
