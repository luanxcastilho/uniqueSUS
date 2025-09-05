package br.com.fiap.uniquesus.infrastructure.mappers;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.infrastructure.entities.EnfermeiroEntity;

public class EnfermeiroMapper
{
    public static Enfermeiro toDomain ( EnfermeiroEntity enfermeiroEntity )
    {
        Enfermeiro enfermeiro = new Enfermeiro();
        enfermeiro.setEnfermeiroId( enfermeiroEntity.getEnfermeiroId() );
        enfermeiro.setNome( enfermeiroEntity.getNome() );
        enfermeiro.setCoren( enfermeiroEntity.getCoren() );
        return enfermeiro;
    }
    
    public static EnfermeiroEntity toEntity ( Enfermeiro enfermeiro )
    {
        EnfermeiroEntity enfermeiroEntity = new EnfermeiroEntity();
        enfermeiroEntity.setEnfermeiroId( enfermeiro.getEnfermeiroId() );
        enfermeiroEntity.setNome( enfermeiro.getNome() );
        enfermeiroEntity.setCoren( enfermeiro.getCoren() );
        return enfermeiroEntity;
    }
}
