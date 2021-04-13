package entities07;

public abstract class Taxpayer {
	protected String name;
	protected Double annualIncome;
	
	public Taxpayer() {
	}
	public Taxpayer(String name, Double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	public abstract Double paidTax();
	
	public Double collectedTax() {
		return annualIncome - paidTax();
	}
	
	@Override
	public String toString() {
		return name 
				+ ": Tax $ " 
				+ String.format("%.2f", paidTax()) 
				+ ", Total $ "
				+ String.format("%.2f", collectedTax());
	}
}
