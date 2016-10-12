package service;

import static org.junit.Assert.*;
import model.Macchina;
import model.Persona;

import org.junit.Test;

public class ServiziTest {
	static Macchina m = null;
	static Persona p = null;
	static Servizi s = new Servizi();

	@Test
	public void aggiungiMacchina() {
		m = s.aggiungiMacchina("Croma", "AAA001");
		
		assertNotNull(m);
	}
	
	@Test
	public void aggiungiPersona() {
		p = s.aggiungiPersona("Fabrizio", "Fischetto", "FSCFRZ");
		
		assertNotNull(p);
	}
	
	@Test
	public void noleggia() {
		boolean token = s.noleggia(p, m);
		assertTrue(token);
	}

}
