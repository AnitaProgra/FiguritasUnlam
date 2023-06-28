package srcFiguritas;

import java.util.Objects;

public abstract class Usuario {

	protected String nombre; 
	protected Integer userId;
	
	
	public Usuario(String nombre, Integer userId) {
		this.nombre = nombre;
		this.userId = userId;
	} 

	public abstract String getNombre();
	public abstract Integer getId();

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(userId, other.userId);
	} 
	
	
	
}


