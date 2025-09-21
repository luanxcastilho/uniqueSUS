package br.com.fiap.uniquesus.adapter.presenters;

import br.com.fiap.uniquesus.domain.entities.Enfermeiro;
import br.com.fiap.uniquesus.infrastructure.dtos.enfermeiro.EnfermeiroRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.enfermeiro.EnfermeiroResponseDTO;
import org.springframework.data.domain.Page;

public class EnfermeiroPresenter
{
    public static EnfermeiroResponseDTO toDTO ( Enfermeiro enfermeiro )
    {
        EnfermeiroResponseDTO enfermeiroResponseDTO = new EnfermeiroResponseDTO();
        
        enfermeiroResponseDTO.setEnfermeiroId( enfermeiro.getEnfermeiroId() );
        enfermeiroResponseDTO.setNome( enfermeiro.getNome() );
        enfermeiroResponseDTO.setCoren( enfermeiro.getCoren() );
        
        return enfermeiroResponseDTO;
    }
    
    public static Page<EnfermeiroResponseDTO> toDTO ( Page<Enfermeiro> enfermeiros )
    {
        return enfermeiros.map( EnfermeiroPresenter::toDTO );
    }
    
    public static Enfermeiro toDomain ( Long enfermeiroId , EnfermeiroRequestDTO enfermeiroRequestDTO )
    {
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setEnfermeiroId( enfermeiroId );
        enfermeiro.setNome( enfermeiroRequestDTO.getNome() );
        enfermeiro.setCoren( enfermeiroRequestDTO.getCoren() );
        
        return enfermeiro;
    }
    
    public static Enfermeiro toDomain ( EnfermeiroRequestDTO enfermeiroRequestDTO )
    {
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome( enfermeiroRequestDTO.getNome() );
        enfermeiro.setCoren( enfermeiroRequestDTO.getCoren() );
        
        return enfermeiro;
    }
    
    
}
