package dao;

import static org.junit.Assert.*;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import model.Macchina;
import model.Persona;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import utility.DataSource;

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
	public void updateTest() {
		int id = mDAO.createMacchina("500", "AAA");
		boolean token = mDAO.updateMacchina(id, "500", "BBB");
		mDAO.deleteMacchina(id);
		assertTrue(token);		
	}
}
