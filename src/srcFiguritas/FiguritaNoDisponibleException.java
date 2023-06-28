package srcFiguritas;

public class FiguritaNoDisponibleException extends Exception {

	protected String mensaje;

	public FiguritaNoDisponibleException(String mensaje) {
		super(mensaje);
	}
	
	
}
