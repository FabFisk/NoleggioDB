package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utility.DataSource;

public class Persona_MacchinaDAO {
	
	//CREATE
	public boolean createNoleggio(int id_persona, int id_macchina){
		boolean token = false;
		String sql = "INSERT INTO PERSONA_MACCHINA (ID_PERSONA, ID_MACCHINA) VALUES (?, ?)";
		Connection con;
		PreparedStatement st;
		try {
			con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id_persona);
			st.setInt(2, id_macchina);
			int res = st.executeUpdate();		
			if(res != 0){
				token = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}
	

}
