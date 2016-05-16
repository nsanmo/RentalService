package persistence.dto;

import java.time.LocalDateTime;

public class ReservationDTO {
	private int id;
	private LocalDateTime pickupDate;
	private LocalDateTime returnDate;
	private String rentalModality;
	private String customerDni;
	private String categoryName;
	private int idPickupBranchOffice;
	private int idReturnBranchOffice;
	
	public ReservationDTO(int id, LocalDateTime pickupDate,
			LocalDateTime returnDate, String rentalModality,
			String categoryName, String customerDni, int idPickupBranchOffice,
			int idReturnBranchOffice) {
		super();
		this.id = id;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.rentalModality = rentalModality;
		this.customerDni = customerDni;
		this.categoryName = categoryName;
		this.idPickupBranchOffice = idPickupBranchOffice;
		this.idReturnBranchOffice = idReturnBranchOffice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDateTime pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public String getRentalModality() {
		return rentalModality;
	}

	public void setRentalModality(String rentalModality) {
		this.rentalModality = rentalModality;
	}

	public String getCustomerDni() {
		return customerDni;
	}

	public void setCustomerDni(String customerDni) {
		this.customerDni = customerDni;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getIdPickupBranchOffice() {
		return idPickupBranchOffice;
	}

	public void setIdPickupBranchOffice(int idPickupBranchOffice) {
		this.idPickupBranchOffice = idPickupBranchOffice;
	}

	public int getIdReturnBranchOffice() {
		return idReturnBranchOffice;
	}

	public void setIdReturnBranchOffice(int idReturnBranchOffice) {
		this.idReturnBranchOffice = idReturnBranchOffice;
	}
		
	
}
