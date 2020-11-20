package entities;

public class PhysicalPerson extends TaxPayer {
	
	private Double healthSpending;
	

	public PhysicalPerson(String name, Double anualIncome, Double healthSpending) {
		super(name, anualIncome);
		this.healthSpending = healthSpending;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	@Override
	public Double tax() {
		if (getAnualIncome() < 20000.0) {
			return getAnualIncome() * 0.15 - healthSpending * 0.5;
		}
		else {
			return getAnualIncome() * 0.25 - healthSpending * 0.5;
		} 
	}

}
