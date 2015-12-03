package com.rms.mre;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class RALDAOTest {

	@Test
	public void testgetRiskItemsFilteredByCountry() throws SQLException {
		RALDAO dao = new RALDAO("jdbc:ral://localhost:2181");
		int columns = dao.getRiskItemsFilteredByCountry("GB");
		assertTrue("3 columns should be returned, instead there are %d", columns == 3);
	}

}
