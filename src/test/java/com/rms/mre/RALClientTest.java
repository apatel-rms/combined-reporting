package com.rms.mre;

import org.junit.Test;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class RALClientTest {

	@Mock
	private Connection connection;
	
	// Must have RMS(one) running with test data in the tables in order for it to run successfully
	@Test
	public void integrationTest() throws SQLException {
		RALClient  client = new RALClient("jdbc:ral://localhost:2181");
		ResultSet rs = client.executeQuery("SELECT * FROM vRiskItem");
		assertTrue(rs.next());
	}
}
