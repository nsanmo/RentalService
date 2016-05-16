package persistence.dto;

public class EmployeeDTO {
	String name;
	boolean administrator;
	String dni;
	int bo;
	
	
	public EmployeeDTO(String dni, String name, boolean administrator, int bo) {
		super();
		this.dni=dni;
		this.bo=bo;
		this.name = name;
		this.administrator = administrator;
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getBo() {
		return bo;
	}

	public void setBo(int bo) {
		this.bo = bo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}
	
	
	

}
