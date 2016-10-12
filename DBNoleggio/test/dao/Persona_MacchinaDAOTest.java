package dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class Persona_MacchinaDAOTest {

	static Persona_MacchinaDAO nDAO = new Persona_MacchinaDAO();
	
	@Test
	public void createTest() {
		int id_persona = 1;
		int id_macchina = 1;
		boolean token = nDAO.createNoleggio(id_persona, id_macchina);
		assertTrue(token);
	}

}
