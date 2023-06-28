package srcFiguritas;

import java.util.HashSet;

public class Administrador extends Usuario implements AccionesUsuarios{

	protected HashSet<Figurita> baseDeDatos; 
	
	
	public Administrador(String nombre, Integer userId) {
		super(nombre, userId);
		this.baseDeDatos= new HashSet<>(); 
	}



	public boolean agregarFigurita(Figurita figurita) throws CodigoExistenteException {
	    for (Figurita f : baseDeDatos) {
	        if (f.getIdentificador().equals(figurita.getIdentificador())) {
	            throw new CodigoExistenteException("Esta figurita ya está en la base de datos");

	        }
	  
	    }

	    baseDeDatos.add(figurita);
	    return true;
	}

	
	@Override
	public String getNombre() {
		return nombre;
	}


	@Override
	public Integer getId() {
		return userId;
	}


	public HashSet<Figurita> getBaseDeDatos() {
		return baseDeDatos;
	}


	public void setBaseDeDatos(HashSet<Figurita> baseDeDatos) {
		this.baseDeDatos = baseDeDatos;
	}
	
	
}
