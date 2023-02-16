package mx.edu.itspa.esgi.scse.model;

public abstract class FormatStudent<T, U> implements Document{
	public abstract T getSender();
	public abstract U getAddressee();
}
