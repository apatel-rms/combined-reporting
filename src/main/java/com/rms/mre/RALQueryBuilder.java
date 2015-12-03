package com.rms.mre;

import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class RALQueryBuilder {
	
	public static String getRiskItem(String riskItemId){
		return String.format("SELECT riskItem from vRiskItem WHERE id = %s", riskItemId);
	}
	
	public static String getRiskItemFromExternalId(String externalRiskItemId){
		return String.format("SELECT riskItem FROM vRiskItem WHERE riskItem.externalID = '%s'", externalRiskItemId);
	}
	
	public static String getRiskItemsFromCountry(String countryCode){
		return String.format("SELECT vportfoliocontractexposureindex.riskpositionid as RiskID, vportfoliocontractexposureindex.riskitemid as RiskItemID, vaddress.address.countrycode " +
				"FROM vportfoliocontractexposureindex " +
				"INNER JOIN vriskitem on vportfoliocontractexposureindex.riskitemid = vriskitem.id " +
				"INNER JOIN vaddress on vportfoliocontractexposureindex.addressid = vaddress.id " +
				"WHERE vaddress.address.countrycode = '%s'", countryCode);
	}
	
	public String getSubPortfolioOfExposures(){
		throw new NotImplementedException("Not implemented");
	}
	
	public String getExposureFromContract(String contractId){
		throw new NotImplementedException("Not implemented");
	}
	
	public String getModelledLossesForContract(String contractId){
		throw new NotImplementedException("Not implemented");
	}
	
	public String getPortfoliosContainingOilPlatform(){
		throw new NotImplementedException("Not implemented");
	}
	
	public String getContractsContaininingExposure(String riskItemId){
		throw new NotImplementedException("Not implemented");
	}
	
	public String getContractsContainingExposures(List<String> riskItemIds){
		throw new NotImplementedException("Not implemented");
	}
}
