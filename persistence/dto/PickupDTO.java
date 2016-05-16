package persistence.dto;

import java.time.LocalDateTime;

public class PickupDTO {
	private int id;
	private LocalDateTime date;
	private String insuranceModality;
	private double kms;
	private double gas_Level;
	
	public PickupDTO(int id, LocalDateTime date, String insuranceModality, double kms, double gas_Level) {
		this.id = id;
		this.date = date;
		this.insuranceModality = insuranceModality;
		this.kms = kms;
		this.gas_Level = gas_Level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getInsuranceModality() {
		return insuranceModality;
	}

	public void setInsuranceModality(String insuranceModality) {
		this.insuranceModality = insuranceModality;
	}

	public double getKms() {
		return kms;
	}

	public void setKms(double kms) {
		this.kms = kms;
	}

	public double getGas_Level() {
		return gas_Level;
	}

	public void setGas_Level(double gas_Level) {
		this.gas_Level = gas_Level;
	}

}
