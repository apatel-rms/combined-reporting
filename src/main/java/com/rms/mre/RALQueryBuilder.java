package com.rms.mre;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

public class RALQueryBuilder {
	
	public String getRiskItem(String riskItemId){
		return String.format("SELECT riskItem from vRiskItem WHERE id = %s", riskItemId);
	}
	
	public String getRiskItemFromExternalId(String externalRiskItemId){
		return String.format("SELECT riskItem FROM vRiskItem WHERE riskItem.externalID = '%s'", externalRiskItemId);
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
