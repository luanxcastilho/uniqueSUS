package br.com.fiap.uniquesus.infrastructure.mappers;

import br.com.fiap.uniquesus.domain.entities.TriagemPrioridade;
import br.com.fiap.uniquesus.infrastructure.entities.TriagemPrioridadeEntity;

public class TriagemPrioridadeMapper
{
    public static TriagemPrioridadeEntity toEntity ( TriagemPrioridade triagemPrioridade )
    {
        TriagemPrioridadeEntity triagemPrioridadeEntity = new TriagemPrioridadeEntity();
        
        triagemPrioridadeEntity.setTriagemPrioridadeId( triagemPrioridade.getTriagemPrioridadeId() );
        triagemPrioridadeEntity.setDescricao( triagemPrioridade.getDescricao() );
        triagemPrioridadeEntity.setTempoParaAtendimento( triagemPrioridade.getTempoParaAtendimento() );
        
        return triagemPrioridadeEntity;
    }
    
    public static TriagemPrioridade toDomain ( TriagemPrioridadeEntity triagemPrioridadeEntity )
    {
        TriagemPrioridade triagemPrioridade = new TriagemPrioridade();
        
        triagemPrioridade.setTriagemPrioridadeId( triagemPrioridadeEntity.getTriagemPrioridadeId() );
        triagemPrioridade.setDescricao( triagemPrioridadeEntity.getDescricao() );
        triagemPrioridade.setTempoParaAtendimento( triagemPrioridadeEntity.getTempoParaAtendimento() );
        
        return triagemPrioridade;
    }
}
