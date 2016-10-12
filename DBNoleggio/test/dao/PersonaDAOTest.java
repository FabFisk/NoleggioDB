package dao;

import static org.junit.Assert.*;

import java.util.Map;

import model.Persona;

import org.junit.Test;

public class PersonaDAOTest {

	static PersonaDAO pDAO = new PersonaDAO();
	
	@Test
	public void createDeleteTest() {
		int id = pDAO.createPersona("AAA", "AAA", "AAA01");
		assertNotEquals(0, id);
		boolean token = pDAO.deletePersona(id);
		assertTrue(token);
	}
	
	@Test
	public void readTest1() {
		int id = pDAO.createPersona("AAA", "AAA", "AAA01");
		Persona m = pDAO.readPersona(id);
		boolean token = pDAO.deletePersona(id);
		assertTrue(token);
		assertNotNull(m);
	}
	
	@Test
	public void readTest2() {
		int id1 = pDAO.createPersona("AAA", "AAA", "AAA01");
		Persona m = pDAO.readPersona("AAA", "AAA", "AAA01");
		int id2 = m.getId_persona();
		boolean token = pDAO.deletePersona(id2);
		assertTrue(token);
		assertNotNull(m);
		assertEquals(id1, id2);
	}
	
	@Test
	public void readTest3() {
		int id1 = pDAO.createPersona("AAA", "AAA", "AAA01");
		int id2 = pDAO.createPersona("AAA", "AAA", "AAA01");
		int id3 = pDAO.createPersona("AAA", "AAA", "AAA01");
		Map<Integer, Persona> c = pDAO.readAll();
		pDAO.deletePersona(id1);
		pDAO.deletePersona(id2);
		pDAO.deletePersona(id3);		
		assertNotNull(c);
	}
		
	@Test
	public void updateTest() {
		int id = pDAO.createPersona("AAA", "AAA", "AAA01");
		boolean token = pDAO.updatePersona(id, "BBB", "BBB", "BBB02");
		pDAO.deletePersona(id);
		assertTrue(token);		
	}
}
