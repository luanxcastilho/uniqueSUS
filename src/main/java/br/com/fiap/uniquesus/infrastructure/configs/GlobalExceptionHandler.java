package br.com.fiap.uniquesus.infrastructure.configs;

import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.atendimento.AtendimentoNaoEncontradoPeloPacienteIdException;
import br.com.fiap.uniquesus.domain.exceptions.consulta.ConsultaNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.CorenJaRegistradoException;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloCorenException;
import br.com.fiap.uniquesus.domain.exceptions.enfermeiro.EnfermeiroNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.medico.CRMJaRegistradoException;
import br.com.fiap.uniquesus.domain.exceptions.medico.MedicoNaoEncontradoPeloCRMException;
import br.com.fiap.uniquesus.domain.exceptions.medico.MedicoNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.CPFJaRegistradoException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloCpfException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.triagem.PacienteNaoEstaNaFilaDaTriagemException;
import br.com.fiap.uniquesus.domain.exceptions.triagem.TriagemNaoEncontradaPeloIdException;
import br.com.fiap.uniquesus.domain.exceptions.triagemPrioridade.TriagemPrioridadeNaoEncontradaPeloIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    // Tratamento para Paciente
    @ExceptionHandler(PacienteNaoEncontradoPeloIdException.class)
    public ResponseEntity<Map<String, Object>> pacienteNaoEncontradoPeloIdExceptionHandler ( PacienteNaoEncontradoPeloIdException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    @ExceptionHandler(PacienteNaoEncontradoPeloCpfException.class)
    public ResponseEntity<Map<String, Object>> pacienteNaoEncontradoPeloCpfExceptionHandler ( PacienteNaoEncontradoPeloCpfException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    @ExceptionHandler(CPFJaRegistradoException.class)
    public ResponseEntity<Map<String, Object>> cpfJaRegistradoExceptionHandler ( CPFJaRegistradoException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.CONFLICT ).body( body );
    }
    
    // Tratamento para Medico
    @ExceptionHandler(MedicoNaoEncontradoPeloIdException.class)
    public ResponseEntity<Map<String, Object>> medicoNaoEncontradoPeloIdExceptionHandler ( MedicoNaoEncontradoPeloIdException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    @ExceptionHandler(MedicoNaoEncontradoPeloCRMException.class)
    public ResponseEntity<Map<String, Object>> medicoNaoEncontradoPeloCRMExceptionHandler ( MedicoNaoEncontradoPeloCRMException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    @ExceptionHandler(CRMJaRegistradoException.class)
    public ResponseEntity<Map<String, Object>> crmJaRegistradoExceptionHandler ( CRMJaRegistradoException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.CONFLICT ).body( body );
    }
    
    // Tratamento para Enfermeiro
    @ExceptionHandler(EnfermeiroNaoEncontradoPeloIdException.class)
    public ResponseEntity<Map<String, Object>> enfermeiroNaoEncontradoPeloIdExceptionHandler ( EnfermeiroNaoEncontradoPeloIdException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    @ExceptionHandler(EnfermeiroNaoEncontradoPeloCorenException.class)
    public ResponseEntity<Map<String, Object>> enfermeiroNaoEncontradoPeloCorenExceptionHandler ( EnfermeiroNaoEncontradoPeloCorenException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    @ExceptionHandler(CorenJaRegistradoException.class)
    public ResponseEntity<Map<String, Object>> corenJaRegistradoExceptionHandler ( CorenJaRegistradoException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.CONFLICT ).body( body );
    }
    
    // Tratamento para atendimento
    @ExceptionHandler(AtendimentoNaoEncontradoPeloIdException.class)
    public ResponseEntity<Map<String, Object>> atendimentoNaoEncontradoPeloIdExceptionHandler ( AtendimentoNaoEncontradoPeloIdException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    @ExceptionHandler(AtendimentoNaoEncontradoPeloPacienteIdException.class)
    public ResponseEntity<Map<String, Object>> atendimentoNaoEncontradoPeloPacienteIdExceptionHandler ( AtendimentoNaoEncontradoPeloPacienteIdException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    // Tratamento para Prioridades de triagem
    @ExceptionHandler(TriagemPrioridadeNaoEncontradaPeloIdException.class)
    public ResponseEntity<Map<String, Object>> triagemPrioridadeNaoEncontradaPeloIdExceptionHandler ( TriagemPrioridadeNaoEncontradaPeloIdException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    // Tratamento para triagem
    @ExceptionHandler(TriagemNaoEncontradaPeloIdException.class)
    public ResponseEntity<Map<String, Object>> triagemNaoEncontradaPeloIdExceptionHandler ( TriagemNaoEncontradaPeloIdException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    @ExceptionHandler(PacienteNaoEstaNaFilaDaTriagemException.class)
    public ResponseEntity<Map<String, Object>> pacienteNaoEstaNaFilaDaTriagemExceptionHandler ( PacienteNaoEstaNaFilaDaTriagemException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    // Tratamento para consulta
    @ExceptionHandler(ConsultaNaoEncontradaPeloIdException.class)
    public ResponseEntity<Map<String, Object>> consultaNaoEncontradaPeloIdExceptionHandler ( ConsultaNaoEncontradaPeloIdException ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( body );
    }
    
    // Tratamento genérico para outras exceções
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> erroGenericoHandler ( Exception ex )
    {
        Map<String, Object> body = new HashMap<>();
        body.put( "message" , ex.getMessage() );
        return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( body );
    }
}
