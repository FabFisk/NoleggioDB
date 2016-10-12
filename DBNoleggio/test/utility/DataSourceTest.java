package utility;

import static org.junit.Assert.*;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DataSourceTest {

	@Test
	public void testConnessione() {
		Connection con = null;
		try {
			con = DataSource.getInstance().getConnection();
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(con);
	}
}
