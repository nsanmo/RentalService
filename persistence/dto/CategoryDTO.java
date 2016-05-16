package persistence.dto;

public class CategoryDTO {
	private String name;
	private double priceUnlimitedMileage;
	private double priceFixedMileage;
	private double priceAdditionalKm;
	private double priceFullInsurance;
	private double pricePartialInsurance;
	private String upperCategoryName;
	
	public CategoryDTO(String name, double priceUnlimitedMileage,
			double priceFixedMileage, double priceAdditionalKm,
			double priceFullInsurance, double pricePartialInsurance,
			String upperCategoryName) {
		super();
		this.name = name;
		this.priceUnlimitedMileage = priceUnlimitedMileage;
		this.priceFixedMileage = priceFixedMileage;
		this.priceAdditionalKm = priceAdditionalKm;
		this.priceFullInsurance = priceFullInsurance;
		this.pricePartialInsurance = pricePartialInsurance;
		this.upperCategoryName = upperCategoryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceUnlimitedMileage() {
		return priceUnlimitedMileage;
	}

	public void setPriceUnlimitedMileage(double priceUnlimitedMileage) {
		this.priceUnlimitedMileage = priceUnlimitedMileage;
	}

	public double getPriceFixedMileage() {
		return priceFixedMileage;
	}

	public void setPriceFixedMileage(double priceFixedMileage) {
		this.priceFixedMileage = priceFixedMileage;
	}

	public double getPriceAdditionalKm() {
		return priceAdditionalKm;
	}

	public void setPriceAdditionalKm(double priceAdditionalKm) {
		this.priceAdditionalKm = priceAdditionalKm;
	}

	public double getPriceFullInsurance() {
		return priceFullInsurance;
	}

	public void setPriceFullInsurance(double priceFullInsurance) {
		this.priceFullInsurance = priceFullInsurance;
	}

	public double getPricePartialInsurance() {
		return pricePartialInsurance;
	}

	public void setPricePartialInsurance(double pricePartialInsurance) {
		this.pricePartialInsurance = pricePartialInsurance;
	}

	public String getUpperCategoryName() {
		return upperCategoryName;
	}

	public void setUpperCategoryName(String upperCategoryName) {
		this.upperCategoryName = upperCategoryName;
	}
		
		
}
