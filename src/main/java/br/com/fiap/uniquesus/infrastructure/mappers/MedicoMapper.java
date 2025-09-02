package br.com.fiap.uniquesus.infrastructure.mappers;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.infrastructure.entities.MedicoEntity;

public class MedicoMapper
{
    public static Medico toDomain ( MedicoEntity medicoEntity )
    {
        Medico medico = new Medico();
        
        medico.setMedicoId( medicoEntity.getMedicoId() );
        medico.setNome( medicoEntity.getNome() );
        medico.setCrm( medicoEntity.getCrm() );
        
        return medico;
    }
    
    public static MedicoEntity toEntity ( Medico medico )
    {
        MedicoEntity medicoEntity = new MedicoEntity();
        
        medicoEntity.setMedicoId( medico.getMedicoId() );
        medicoEntity.setNome( medico.getNome() );
        medicoEntity.setCrm( medico.getCrm() );
        
        return medicoEntity;
    }
}
