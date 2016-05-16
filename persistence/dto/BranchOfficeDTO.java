package persistence.dto;

public class BranchOfficeDTO {
	private int id;
	private String address;
	
	public BranchOfficeDTO(int id, String address) {
		super();
		this.id = id;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
