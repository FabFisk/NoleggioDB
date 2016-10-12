package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Macchina;
import utility.DataSource;

public class MacchinaDAO {

	//CREATE
	public int createMacchina(String modello, String targa) {
		int primaryKey = 0;
		String sql = "INSERT INTO MACCHINA (MODELLO, TARGA) VALUES (?, ?)";
		Connection con;
		PreparedStatement st;
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql, new String[]{"ID_MACCHINA"});
			st.setString(1, modello);
			st.setString(2, targa);
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
	public Macchina readMacchina(int id) {
		Macchina m = null;
		String sql = "SELECT * FROM MACCHINA WHERE ID_MACCHINA = ?";
		Connection con;
		PreparedStatement st;
		
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				int iD = rs.getInt(1);
				String modello = rs.getString(2);
				String targa = rs.getString(3);
				m = new Macchina(iD, modello, targa);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	public Macchina readMacchina(String modello, String targa) {
		Macchina m = null;
		String sql = "SELECT * FROM MACCHINA WHERE MODELLO = ? AND TARGA = ?";
		Connection con;
		PreparedStatement st;
		
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, modello);
			st.setString(2, targa);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				int iD = rs.getInt(1);
				String model = rs.getString(2);
				String code = rs.getString(3);
				m = new Macchina(iD, model, code);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	
	//UPDATE	
	public boolean updateMacchina(int id, String modello, String targa) {
		boolean token = false;
		String sql = "UPDATE MACCHINA SET MODELLO=?, TARGA=? WHERE ID_MACCHINA=?";
		Connection con;
		PreparedStatement st;
		
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, modello);
			st.setString(2, targa);
			st.setInt(3, id);
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
	public boolean deleteMacchina(int id) {
		boolean token = false;
		String sql = "DELETE FROM MACCHINA WHERE ID_MACCHINA=?";
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
