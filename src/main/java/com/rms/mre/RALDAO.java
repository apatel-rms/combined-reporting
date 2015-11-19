package com.rms.mre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RALDAO {
	
	private String URL;

	public RALDAO(String URL){
		this.URL = URL;
	}
	
	public int getRiskItemsFilteredByCountry(String countryCode) throws SQLException{
		try {
			RALClient client = new RALClient(this.URL);
			ResultSet rs = client.executeQuery(RALQueryBuilder.getRiskItemsFromCountry(countryCode));
			return rs.getMetaData().getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(String.format("Unable to getRiskItemsFilteredByCountry with countryCode %s", countryCode), e);
		}
	}
}
