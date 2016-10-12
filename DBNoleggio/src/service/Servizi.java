package service;

import dao.MacchinaDAO;
import dao.PersonaDAO;
import dao.Persona_MacchinaDAO;
import model.Macchina;
import model.Persona;

public class Servizi {
	
	private MacchinaDAO mDAO = new MacchinaDAO();
	private PersonaDAO pDAO = new PersonaDAO();
	private Persona_MacchinaDAO nDAO = new Persona_MacchinaDAO();
	
	public Macchina aggiungiMacchina(String modello, String targa){
		Macchina m = null;
		m = mDAO.readMacchina(modello, targa);
		if(m == null){
			m = mDAO.readMacchina(mDAO.createMacchina(modello, targa));
		}		
		return m;
	}
	
	public Persona aggiungiPersona(String nome, String cognome, String codFisc){
		Persona p = null;
		p = pDAO.readPersona(nome, cognome, codFisc);
		if(p==null){
			p = pDAO.readPersona(pDAO.createPersona(nome, cognome, codFisc));
		}		
		return p;
	}
	
	public boolean noleggia(Persona p, Macchina m){
		int id_persona = p.getId_persona();
		int id_macchina = m.getId_macchina();
		return nDAO.createNoleggio(id_persona, id_macchina);	
	}

}
