package persistence.dto;

import java.time.LocalDateTime;

public class CustomerDTO {
	private String dni;
	private String nameAndSurname;
	private String address;
	private String postalCode;
        private String city;
	private LocalDateTime dateDriverLicense;
	private String digitsCC;
	private int monthCC;
	private int yearCC;
	private int cvcCC;
	private String typeCC;
	
	public CustomerDTO(String dni, String nameAndSurname,
			String address, String city, String postalCode,  
			LocalDateTime dateDriverLicense, String digitsCC, int monthCC,
			int yearCC, int cvcCC, String typeCC) {
		super();
		this.dni = dni;
		this.nameAndSurname = nameAndSurname;
		this.address = address;
		this.postalCode = postalCode;
                this.city = city;
		this.dateDriverLicense = dateDriverLicense;
		this.digitsCC = digitsCC;
		this.monthCC = monthCC;
		this.yearCC = yearCC;
		this.cvcCC = cvcCC;
		this.typeCC = typeCC;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNameAndSurname() {
		return nameAndSurname;
	}
	public void setNameAndSurname(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
        public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDateTime getDateDriverLicense() {
		return dateDriverLicense;
	}
	public void setDateDriverLicense(LocalDateTime dateDriverLicense) {
		this.dateDriverLicense = dateDriverLicense;
	}
	public String getDigitsCC() {
		return digitsCC;
	}
	public void setDigitsCC(String digitsCC) {
		this.digitsCC = digitsCC;
	}
	public int getMonthCC() {
		return monthCC;
	}
	public void setMonthCC(int monthCC) {
		this.monthCC = monthCC;
	}
	public int getYearCC() {
		return yearCC;
	}
	public void setYearCC(int yearCC) {
		this.yearCC = yearCC;
	}
	public int getCvcCC() {
		return cvcCC;
	}
	public void setCvcCC(int cvcCC) {
		this.cvcCC = cvcCC;
	}
	public String getTypeCC() {
		return typeCC;
	}
	public void setTypeCC(String typeCC) {
		this.typeCC = typeCC;
	}
	
}
