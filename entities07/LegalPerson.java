package entities07;

public class LegalPerson extends Taxpayer{
	private Integer employeeQuantity;
	
	public LegalPerson() {
		super();
	}
	public LegalPerson(String name, Double annualIncome, Integer employeeQuantity) {
		super(name, annualIncome);
		this.employeeQuantity = employeeQuantity;
	}
	
	public Integer getEmployeeQuantity() {
		return employeeQuantity;
	}
	public void setEmployeeQuantity(Integer employeeQuantity) {
		this.employeeQuantity = employeeQuantity;
	}
	
	@Override
	public Double paidTax() {
		if(employeeQuantity <= 10) {
			return annualIncome * 0.16;
		} else {
			return annualIncome * 0.14;
		}
	}
}