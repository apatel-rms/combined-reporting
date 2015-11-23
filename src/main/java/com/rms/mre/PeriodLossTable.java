package com.rms.mre;

import java.util.List;

public class PeriodLossTable {
	
	private final List<PeriodRow> plt;
	
	public PeriodLossTable(List<PeriodRow> plt){
		this.plt = plt;
	}

	public List<PeriodRow> getPlt() {
		return this.plt;
	}
	
	public double getPortfolioAAL(){
		return 0.0;
	}
	
	public List<Integer> getContractIds(){
		
		return null;
	}
	
	public double getContractAAL(){
		return 0.0;
	}
	
	public double getPortfolioOEP(){
		return 0.0;
	}
	
	public double getPortfolioAEP(){
		return 0.0;
	}
	
	public double getContractAEP(){
		return 0.0;
	}
	
	public double getContractOEP(){
		return 0.0;
	}
}
