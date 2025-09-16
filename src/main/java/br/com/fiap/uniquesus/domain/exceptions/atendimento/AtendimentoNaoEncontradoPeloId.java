package br.com.fiap.uniquesus.domain.exceptions.atendimento;

public class AtendimentoNaoEncontradoPeloId extends RuntimeException {
  public AtendimentoNaoEncontradoPeloId(String message) {
    super(message);
  }
}
