package com.rms.mre;

import com.rms.ral.jdbc.RALDriver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class RALClient {
	
	public static final String DOMAIN = "RMS";
	public static final String SCHEMA = "TEST";
	
	private Connection connection;
	
	public RALClient(String URL) throws SQLException{
		Connection connection = connect(URL, new Properties());
		setup(connection);
	}
	
	public RALClient(Connection connection) throws SQLException{
		setup(connection);
	}
	
	private void setup(Connection connection) throws SQLException{
		setupQueryEnvironment(connection);
		this.connection = connection;
	}
	
	public Connection connect(String url, Properties properties) throws SQLException{
		RALDriver driver = new RALDriver();
		Connection connection = driver.connect(url, properties);
		
		return connection;
	}
	
	private void setupQueryEnvironment(Connection connection) throws SQLException{
		Statement statement = connection.createStatement();
		statement.execute(String.format("USE DOMAIN %s", DOMAIN));
		statement.execute(String.format("USE SCHEMA %s", SCHEMA));
	}
	
	public ResultSet executeQuery(String query) throws SQLException{
		try {
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			throw new SQLException(String.format("ERROR: Unable to execute query: %s", query), e);
		}
	}
}
