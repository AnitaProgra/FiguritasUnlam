package srcFiguritas;

import java.util.Objects;

public class Figurita {

	protected Integer nroFigurita; 
	protected Seleccion seleccion;
	protected String jugador; 
	protected Double valorJugador;
	
	
	public Figurita(Integer nroFigurita, Seleccion seleccion, String jugador, Double valorJugador) {
		this.nroFigurita= nroFigurita; 
		this.seleccion = seleccion;
		this.jugador = jugador;
		this.valorJugador = valorJugador;
	}


    public Integer getNroFigurita() {
		return nroFigurita;
	}


	public void setNroFigurita(Integer nroFigurita) {
		this.nroFigurita = nroFigurita;
	}


	public String getIdentificador() {
    	return seleccion.toString() + " " +nroFigurita.toString(); 
    }


	public Seleccion getSeleccion() {
		return seleccion;
	}


	public void setSeleccion(Seleccion seleccion) {
		this.seleccion = seleccion;
	}


	@Override
	public int hashCode() {
		return Objects.hash(nroFigurita, seleccion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		return Objects.equals(nroFigurita, other.nroFigurita) && seleccion == other.seleccion;
	}


	public String getJugador() {
		return jugador;
	}


	public void setJugador(String jugador) {
		this.jugador = jugador;
	}


	public Double getValorJugador() {
		return valorJugador;
	}


	public void setValorJugador(Double valorJugador) {
		this.valorJugador = valorJugador;
	}
	


}
