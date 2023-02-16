package mx.edu.itspa.esgi.scse.model;

/*
 * Clase elaborada para enviar mensajes de respuesta en los métodos de subir archivos
 * */

public class Response {
	private String message;

	public String getMessage() {
		return message;
	}

	public Response(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
