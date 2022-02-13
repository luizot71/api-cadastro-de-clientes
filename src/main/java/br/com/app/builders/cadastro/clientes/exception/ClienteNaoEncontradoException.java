package br.com.app.builders.cadastro.clientes.exception;

public class ClienteNaoEncontradoException extends RuntimeException implements NaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ClienteNaoEncontradoException(Integer id) {
		this.message = String.format("Cliente id %d não encontrado." , id);
	}

	public String getMessage() {
		return message;
	}

}
