package br.com.fiap.uniquesus.adapter.presenters;

import br.com.fiap.uniquesus.domain.entities.Medico;
import br.com.fiap.uniquesus.infrastructure.dtos.MedicoRequestDTO;
import br.com.fiap.uniquesus.infrastructure.dtos.MedicoResponseDTO;
import org.springframework.data.domain.Page;

public class MedicoPresenter
{
    public static MedicoResponseDTO toDTO ( Medico medico )
    {
        MedicoResponseDTO medicoResponseDTO = new MedicoResponseDTO();
        
        medicoResponseDTO.setMedicoId( medico.getMedicoId() );
        medicoResponseDTO.setNome( medico.getNome() );
        medicoResponseDTO.setCrm( medico.getCrm() );
        
        return medicoResponseDTO;
    }
    
    public static Page<MedicoResponseDTO> toDTO ( Page<Medico> medicos )
    {
        return medicos.map( MedicoPresenter::toDTO );
    }
    
    public static Medico toDomain ( Long medicoId , MedicoRequestDTO medicoRequestDTO )
    {
        Medico medico = new Medico();
        
        medico.setMedicoId( medicoId );
        medico.setNome( medicoRequestDTO.getNome() );
        medico.setCrm( medicoRequestDTO.getCrm() );
        
        return medico;
    }
    
    public static Medico toDomain ( MedicoRequestDTO medicoRequestDTO )
    {
        Medico medico = new Medico();
        
        medico.setNome( medicoRequestDTO.getNome() );
        medico.setCrm( medicoRequestDTO.getCrm() );
        
        return medico;
    }
}
