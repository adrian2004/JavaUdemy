package entities07;

public class PhysicalPerson extends Taxpayer{
	private Double healtSpending;
	
	public PhysicalPerson() {
		super();
	}
	public PhysicalPerson(String name, Double annualIncome, Double healtSpending) {
		super(name, annualIncome);
		this.healtSpending = healtSpending;
	}
	
	public Double getHealtSpending() {
		return healtSpending;
	}
	public void setHealtSpending(Double healtSpending) {
		this.healtSpending = healtSpending;
	}
	
	@Override
	public Double paidTax() {
		Double tax = 0.0;
		if(annualIncome < 2000) {
			tax = annualIncome * 0.15;
		} else {
			tax = annualIncome * 0.25;
		}
		
		if(healtSpending > 0) {
			return tax;
		} else {
			return tax - (healtSpending / 2);
		}
	}
}