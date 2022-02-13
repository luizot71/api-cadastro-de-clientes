package br.com.app.builders.cadastro.clientes.exception;

public class RecursoNaoEncontradoException extends RuntimeException implements NaoEncontradoException {

	private static final long serialVersionUID = 1L;

	private String message;

	public RecursoNaoEncontradoException() {
		this.message = "Recurso não encontrado!.";
	}

	public String getMessage() {
		return message;
	}

}
