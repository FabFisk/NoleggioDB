package dao;

import static org.junit.Assert.*;

import java.util.Map;

import model.Macchina;
import dao.PersonaDAO;

import org.junit.Test;

public class MacchinaDAOTest {
	
	static MacchinaDAO mDAO = new MacchinaDAO();
		
	@Test
	public void createDeleteTest() {
		int id = mDAO.createMacchina("500", "AAA");
		assertNotEquals(0, id);
		boolean token = mDAO.deleteMacchina(id);
		assertTrue(token);
	}
	
	@Test
	public void readTest1() {
		int id = mDAO.createMacchina("Croma", "BBB");
		Macchina m = mDAO.readMacchina(id);
		boolean token = mDAO.deleteMacchina(id);
		assertTrue(token);
		assertNotNull(m);
	}
	
	@Test
	public void readTest2() {
		int id1 = mDAO.createMacchina("AAA", "AAA01");
		Macchina m = mDAO.readMacchina("AAA", "AAA01");
		int id2 = m.getId_macchina();
		boolean token = mDAO.deleteMacchina(id2);
		assertTrue(token);
		assertNotNull(m);
		assertEquals(id1, id2);
	}
	
	@Test
	public void readTest3() {
		int id1 = mDAO.createMacchina("AAA", "AAA01");
		int id2 = mDAO.createMacchina("AAA", "AAA01");
		int id3 = mDAO.createMacchina("AAA", "AAA01");
		Map<Integer, Macchina> c = mDAO.readAll();
		mDAO.deleteMacchina(id1);
		mDAO.deleteMacchina(id2);
		mDAO.deleteMacchina(id3);		
		assertNotNull(c);
	}
	
	@Test
	public void readTest4() {
		PersonaDAO pDAO = new PersonaDAO();
		Persona_MacchinaDAO nDAO = new Persona_MacchinaDAO();
		int id1 = mDAO.createMacchina("AAA", "AAA01");
		int id2 = mDAO.createMacchina("AAA", "AAA01");
		int id4 = pDAO.createPersona("AAA", "AAA", "AAA01");
		nDAO.createNoleggio(id4, id1);
		nDAO.createNoleggio(id4, id2);
		Map<Integer, Macchina> m = mDAO.readAllMacchine(id4);
		
		mDAO.deleteMacchina(id1);
		mDAO.deleteMacchina(id2);
		pDAO.deletePersona(id4);
		
		assertNotNull(m);
	}
	
	@Test
	public void updateTest() {
		int id = mDAO.createMacchina("500", "AAA");
		boolean token = mDAO.updateMacchina(id, "500", "BBB");
		mDAO.deleteMacchina(id);
		assertTrue(token);		
	}
}
