package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import model.Persona;
import utility.DataSource;

public class PersonaDAO {

	//CREATE
	public int createPersona(String nome, String cognome, String codFisc) {
		int primaryKey = 0;
		String sql = "INSERT INTO PERSONA (NOME, COGNOME, CODICE_FISCALE) VALUES (?, ?, ?)";
		Connection con;
		PreparedStatement st;
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql, new String[]{"ID_PERSONA"});
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3, codFisc);
			st.executeUpdate();
			
			ResultSet rs = st.getGeneratedKeys();
			if(rs!=null && rs.next()){
				primaryKey = rs.getInt(1);
			}			
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return primaryKey;
	}
	
	//READ
	public Map<Integer, Persona> readAll(){
		Persona p = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Map<Integer, Persona> lista = new TreeMap<Integer, Persona>();
		try {
			String sql = "SELECT * FROM PERSONA";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
					int id_p = rs.getInt(1);
					String nome = rs.getString(2);
					String cognome = rs.getString(3);
					String codFisc = rs.getString(4);
					p = new Persona(id_p, nome, cognome, codFisc);
					lista.put(p.getId_persona(), p);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}		
		return lista;
	}
	
	public Persona readPersona(int id) {
		Persona p = null;
		String sql = "SELECT * FROM PERSONA WHERE ID_PERSONA = ?";
		Connection con;
		PreparedStatement st;
		
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				int iD = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				String codFisc = rs.getString(3);
				p = new Persona(iD, nome, cognome, codFisc);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public Persona readPersona(String nome, String cognome, String codFisc) {
		Persona p = null;
		String sql = "SELECT * FROM PERSONA WHERE NOME = ? AND COGNOME=? AND CODICE_FISCALE=?";
		Connection con;
		PreparedStatement st;
		
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3, codFisc);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				int iD = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				String code = rs.getString(3);
				p = new Persona(iD, name, surname, code);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	//UPDATE	
	public boolean updatePersona(int id, String nome, String cognome, String codFisc) {
		boolean token = false;
		String sql = "UPDATE PERSONA SET NOME=?, COGNOME=?, CODICE_FISCALE=? WHERE ID_PERSONA=?";
		Connection con;
		PreparedStatement st;
		
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3, codFisc);
			st.setInt(4, id);
			int res = st.executeUpdate();
			if(res!=0){
				token = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}
	
	//DELETE
	public boolean deletePersona(int id) {
		boolean token = false;
		String sql = "DELETE FROM PERSONA WHERE ID_PERSONA=?";
		Connection con;
		PreparedStatement st;
		
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			int res = st.executeUpdate();
			if(res!=0){
				token = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}



}
