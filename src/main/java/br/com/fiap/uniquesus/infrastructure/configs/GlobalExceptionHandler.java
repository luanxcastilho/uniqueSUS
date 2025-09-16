package br.com.fiap.uniquesus.infrastructure.configs;

import br.com.fiap.uniquesus.domain.exceptions.paciente.CPFJaRegistradoException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloCpfException;
import br.com.fiap.uniquesus.domain.exceptions.paciente.PacienteNaoEncontradoPeloIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    // Tratamento para Paciente
    @ExceptionHandler(PacienteNaoEncontradoPeloIdException.class)
    public ResponseEntity<Map<String, Object>> pacienteNaoEncontradoPeloIdExceptionHandler(PacienteNaoEncontradoPeloIdException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    
    @ExceptionHandler(PacienteNaoEncontradoPeloCpfException.class)
    public ResponseEntity<Map<String, Object>> pacienteNaoEncontradoPeloCpfExceptionHandler(PacienteNaoEncontradoPeloCpfException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    
    @ExceptionHandler(CPFJaRegistradoException.class)
    public ResponseEntity<Map<String, Object>> cpfJaRegistradoExceptionHandler(CPFJaRegistradoException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }
    
    // Tratamento para Medico
    
    
    // Tratamento genérico para outras exceções
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> erroGenericoHandler(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( body );
    }
}
