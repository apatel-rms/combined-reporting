package com.rms.mre;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RALQueryBuilderTest {

	private RALQueryBuilder builder;
	
	@Before
	public void setup(){
		this.builder = new RALQueryBuilder();
	}
	
	@Test
	public void testGetRiskItem() {
		String expectedQuery = "SELECT riskItem FROM vRiskItem WHERE id = 10000012154";
		String query = this.builder.getRiskItem("10000012154");
		assertTrue(query.equalsIgnoreCase(expectedQuery));
	}

	@Test
	public void testGetRiskItemFromExternalId() {
		String expectedQuery = "SELECT riskItem FROM vRiskItem WHERE riskItem.externalId = '48102300'";
		String query = this.builder.getRiskItemFromExternalId("48102300");
		assertTrue(query.equalsIgnoreCase(expectedQuery));
	}

	@Test
	public void testGetSubPortfolioOfExposures() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExposureFromContract() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetModelledLossesForContract() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPortfoliosContainingOilPlatform() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContractsContaininingExposure() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContractsContainingExposures() {
		fail("Not yet implemented");
	}

}
