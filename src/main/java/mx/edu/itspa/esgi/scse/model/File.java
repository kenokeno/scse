package mx.edu.itspa.esgi.scse.model;

/*
 * Clase creada para el manejo de archivos en los métodos 
 * de subir archivos en la API de la aplicación (getAllFiles)
 * */
public class File {
	private String name;
	private String url;
	
	public File(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
