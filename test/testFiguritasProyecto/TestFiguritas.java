package testFiguritasProyecto;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

import srcFiguritas.Administrador;
import srcFiguritas.CodigoExistenteException;
import srcFiguritas.Figurita;
import srcFiguritas.FiguritaNoDisponibleException;
import srcFiguritas.FiguritaRepetidaException;
import srcFiguritas.Seleccion;
import srcFiguritas.Usuario;
import srcFiguritas.UsuarioFinal;

public class TestFiguritas {

	@Test
	public void testQueSePuedaCrearUnaFigurita() {
		
		Figurita figurita1 = new Figurita(1, Seleccion.ARGENTINA, "lionel messi", 300.000); 
		
		String esperado= "ARGENTINA 1"; 
		
		assertEquals(esperado, figurita1.getIdentificador()); 
	}

	@Test
	public void testQueSePuedaCrearUnAdministrador() {
		
		Usuario admin1 = new Administrador("juan diaz", 1000); 
		
		Integer esperado= 1000; 
		
		assertEquals(esperado, admin1.getId()); 
	}
	
	@Test
	public void testQueSePuedaCrearUnUsuarioFinal() {
		
		Usuario user1 = new UsuarioFinal("sergio garcia", 0001); 
		
		Integer esperado= 0001; 
		
		assertEquals(esperado, user1.getId()); 
	}
	
	
	@Test
	public void testQueUnUsuarioFinalPuedaAgregarUnaFigurita () {
		
		Usuario user1 = new UsuarioFinal("sergio garcia", 0001); 
		
		Figurita figurita1 = new Figurita(1, Seleccion.ARGENTINA, "lionel messi", 300.000); 
		
		((UsuarioFinal)user1).agregarFigurita(figurita1);
		
		assertEquals((Integer)1, ((UsuarioFinal)user1).cantidadDeFiguritas()); 
	}
	

	@Test
	public void testQueUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws CodigoExistenteException {
		
		Usuario admin1 = new Administrador("juan diaz", 1000); 
		
		Figurita figurita1 = new Figurita(1, Seleccion.ARGENTINA, "lionel messi", 300.000); 
		Figurita figurita2 = new Figurita(2, Seleccion.BRASIL, "mario salas", 200.000); 
		Figurita figurita3 = new Figurita(3, Seleccion.CHINA, "xiaho cho", 150.000); 
		Figurita figurita4 = new Figurita(3, Seleccion.GUATEMALA, "xiaho cho", 150.000); 
		
		((Administrador)admin1).agregarFigurita(figurita1);
		((Administrador)admin1).agregarFigurita(figurita2);
		((Administrador)admin1).agregarFigurita(figurita3);
		
		assertTrue(((Administrador)admin1).agregarFigurita(figurita3));  
		
	}
	
	
	@Test
	public void testQueUnUsuarioSiPuedaAgregarUnaFiguritaExistente(){
		
		Usuario user1 = new UsuarioFinal("sergio garcia", 0001); 
		
		Figurita figurita1 = new Figurita(1, Seleccion.ARGENTINA, "lionel messi", 300.000); 
		Figurita figurita2 = new Figurita(2, Seleccion.BRASIL, "mario salas", 200.000); 
		Figurita figurita3 = new Figurita(3, Seleccion.CHINA, "xiaho cho", 150.000); 
		Figurita figurita4 = new Figurita(3, Seleccion.CHINA, "xiaho cho", 150.000); 
		
		((UsuarioFinal)user1).agregarFigurita(figurita1);
		((UsuarioFinal)user1).agregarFigurita(figurita2);
		((UsuarioFinal)user1).agregarFigurita(figurita3);
		((UsuarioFinal)user1).agregarFigurita(figurita4);
			
		assertEquals((Integer)4, ((UsuarioFinal)user1).cantidadDeFiguritas());  
		
	}
	
	
	@Test
	public void testQueUnUsuarioFinalPuedaPegarUnaFigurita() throws FiguritaRepetidaException{
		
		Usuario user1 = new UsuarioFinal("sergio garcia", 0001); 
		
		Figurita figurita1 = new Figurita(1, Seleccion.ARGENTINA, "lionel messi", 300.000); 
		Figurita figurita2 = new Figurita(2, Seleccion.BRASIL, "mario salas", 200.000); 
		Figurita figurita3 = new Figurita(3, Seleccion.CHINA, "xiaho cho", 150.000); 
		Figurita figurita4 = new Figurita(4, Seleccion.CHINA, "xiaho man", 150.000); 
		
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita1);
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita2);
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita3);
		
		
		assertTrue(((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita4));  
		
	}
	
	@Test
	public void testQueUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetidaException{
		
		Usuario user1 = new UsuarioFinal("sergio garcia", 0001); 
		
		Figurita figurita1 = new Figurita(1, Seleccion.ARGENTINA, "lionel messi", 300.000); 
		Figurita figurita2 = new Figurita(2, Seleccion.BRASIL, "mario salas", 200.000); 
		Figurita figurita3 = new Figurita(3, Seleccion.CHINA, "xiaho cho", 150.000); 
		Figurita figurita4 = new Figurita(4, Seleccion.CHINA, "xiaho man", 150.000); 
		
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita1);
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita2);
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita3);
		
		
		assertTrue(((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita3));  
		
	}
	
	@Test
	public void testQueSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws FiguritaNoDisponibleException, FiguritaRepetidaException{
		
		Usuario user1 = new UsuarioFinal("sergio garcia", 0001); 
		
		Figurita figurita1 = new Figurita(1, Seleccion.ARGENTINA, "lionel messi", 300.000); 
		Figurita figurita2 = new Figurita(2, Seleccion.BRASIL, "mario salas", 200.000); 
		Figurita figurita3 = new Figurita(3, Seleccion.CHINA, "xiaho cho", 150.000); 
		Figurita figurita4 = new Figurita(4, Seleccion.CHINA, "xiaho man", 150.000); 
		Figurita figurita5 = new Figurita(5, Seleccion.ARGENTINA, "lionel mi", 300.000); 
		Figurita figurita6 = new Figurita(6, Seleccion.ALEMANIA, "mario gomez", 200.000); 
		Figurita figurita7 = new Figurita(7, Seleccion.JAPON, "pedro perez", 150.000); 
		Figurita figurita8 = new Figurita(8, Seleccion.ITALIA, "enzo salas", 150.000); 
		
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita1);
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita2);
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita3);
		((UsuarioFinal)user1).agregarFigurita(figurita1);
		((UsuarioFinal)user1).agregarFigurita(figurita5);
		((UsuarioFinal)user1).agregarFigurita(figurita5);
		((UsuarioFinal)user1).agregarFigurita(figurita7);
		
		assertFalse(((UsuarioFinal)user1).intercambiarFigurita(figurita8));  
		
	}
	
	@Test
	public void testQueNoPuedaPegarUnaFiguritaSiNoLaTengoEnMisFiguritas() throws FiguritaNoDisponibleException, FiguritaRepetidaException{
		
		Usuario user1 = new UsuarioFinal("sergio garcia", 0001); 
		
		Figurita figurita1 = new Figurita(1, Seleccion.ARGENTINA, "lionel messi", 300.000); 
		Figurita figurita2 = new Figurita(2, Seleccion.BRASIL, "mario salas", 200.000); 
		Figurita figurita3 = new Figurita(3, Seleccion.CHINA, "xiaho cho", 150.000); 
		Figurita figurita4 = new Figurita(4, Seleccion.CHINA, "xiaho man", 150.000); 
		Figurita figurita5 = new Figurita(5, Seleccion.ARGENTINA, "lionel mi", 300.000); 
		Figurita figurita6 = new Figurita(6, Seleccion.ALEMANIA, "mario gomez", 200.000); 
		Figurita figurita7 = new Figurita(7, Seleccion.JAPON, "pedro perez", 150.000); 
		Figurita figurita8 = new Figurita(8, Seleccion.ITALIA, "enzo salas", 150.000); 
		
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita1);
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita2);
		((UsuarioFinal)user1).pegarFiguritaAlAlbum(figurita3);
		((UsuarioFinal)user1).agregarFigurita(figurita1);
		((UsuarioFinal)user1).agregarFigurita(figurita5);
		((UsuarioFinal)user1).agregarFigurita(figurita5);
		((UsuarioFinal)user1).agregarFigurita(figurita7);
		
		assertFalse(((UsuarioFinal)user1).pegarUnaFiguritaSoloSiLaTengoEnMiColeccion(figurita8));  
		
	}
	
}
