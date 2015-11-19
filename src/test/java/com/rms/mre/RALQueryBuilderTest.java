package com.rms.mre;

import static org.junit.Assert.*;
import org.junit.Test;

public class RALQueryBuilderTest {

	@Test
	public void testGetRiskItem() {
		String expectedQuery = "SELECT riskItem FROM vRiskItem WHERE id = 10000012154";
		String query = RALQueryBuilder.getRiskItem("10000012154");
		assertTrue(query.equalsIgnoreCase(expectedQuery));
	}

	@Test
	public void testGetRiskItemFromExternalId() {
		String expectedQuery = "SELECT riskItem FROM vRiskItem WHERE riskItem.externalId = '48102300'";
		String query = RALQueryBuilder.getRiskItemFromExternalId("48102300");
		assertTrue(query.equalsIgnoreCase(expectedQuery));
	}
	
	@Test
	public void testGetRiskItemsFromCountry(){
		String expectedQuery = "SELECT vportfoliocontractexposureindex.riskpositionid as RiskID, vportfoliocontractexposureindex.riskitemid as RiskItemID, vaddress.address.countrycode FROM vportfoliocontractexposureindex INNER JOIN vriskitem on vportfoliocontractexposureindex.riskitemid = vriskitem.id INNER JOIN vaddress on vportfoliocontractexposureindex.addressid = vaddress.id WHERE vaddress.address.countrycode = 'GB'";
		String query = RALQueryBuilder.getRiskItemsFromCountry("GB");
		assertTrue(String.format("Expected:%s\nActual:%s", expectedQuery, query), query.equalsIgnoreCase(expectedQuery));
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
