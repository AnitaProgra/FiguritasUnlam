package srcFiguritas;

import java.util.ArrayList;
import java.util.HashSet;


public class UsuarioFinal extends Usuario implements AccionesUsuarios{

	protected ArrayList<Figurita> misFiguritas; 
	protected HashSet<Figurita> figuritasPegadas; 
	
	public UsuarioFinal(String nombre, Integer userId) {
		super(nombre, userId);
		this.misFiguritas= new ArrayList<>(); 
		this.figuritasPegadas= new HashSet<>();
	}

	@Override
	public boolean agregarFigurita(Figurita figurita) {
		return this.misFiguritas.add(figurita); 
		
	}
	
	
	public Integer cantidadDeFiguritas() {
		return misFiguritas.size(); 
		
	}

	public Integer cantidadDeFiguritasPegadas() {
		return figuritasPegadas.size(); 
		
	}

	
	
	
		public boolean pegarFiguritaAlAlbum(Figurita figurita) throws FiguritaRepetidaException {
		    if (figuritasPegadas.contains(figurita)) {
		        throw new FiguritaRepetidaException("La figurita que intenta pegar ya está pegada");
		    }

		    figuritasPegadas.add(figurita);
		    return true;
		}
		

	
	
	
	
	public boolean intercambiarFigurita(Figurita figurita) throws FiguritaNoDisponibleException {
		try {
			for(Figurita f: figuritasPegadas)
			for(Figurita fi : misFiguritas){
				if( misFiguritas.contains(figurita) && !figuritasPegadas.contains(figurita) ) {
					return true;
	}
			}
			throw new FiguritaNoDisponibleException("La figurita que intenta intercambiar ya esta pegada o no la tiene");

		
		}
		catch(FiguritaNoDisponibleException e) {
			System.out.println(e.getMessage());
			return false; 
		}

	}
	
	
	public boolean pegarUnaFiguritaSoloSiLaTengoEnMiColeccion(Figurita figurita) throws FiguritaNoDisponibleException {
		try {
			for(Figurita fi : misFiguritas){
				if( misFiguritas.contains(figurita) ) {
					figuritasPegadas.add(figurita);
					return true;
	}
			}
			throw new FiguritaNoDisponibleException("La figurita que intenta pegar no esta en su coleccion");

		
		}
		catch(FiguritaNoDisponibleException e) {
			System.out.println(e.getMessage());
			return false; 
		}

	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public Integer getId() {
		return userId;
	}

	public ArrayList<Figurita> getMisFiguritas() {
		return misFiguritas;
	}

	public void setMisFiguritas(ArrayList<Figurita> misFiguritas) {
		this.misFiguritas = misFiguritas;
	}
	
	

	
}
