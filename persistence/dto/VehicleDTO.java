package persistence.dto;

public class VehicleDTO {
	
		private String plate_number;
		private double kms;
		private int bo;
		private String cat;
		private String name;

		public VehicleDTO(String plate_number, double kms, int bo, String cat, String name) {
			this.plate_number = plate_number;
			this.kms = kms;
			this.bo=bo;
			this.cat=cat;
			this.name=name;
		}

		public int getBo() {
			return bo;
		}

		public void setBo(int bo) {
			this.bo = bo;
		}

		public String getCat() {
			return cat;
		}

		public void setCat(String cat) {
			this.cat = cat;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPlate_number() {
			return plate_number;
		}
		public void setPlate_number(String plate_number) {
			this.plate_number = plate_number;
		}
		public double getKms() {
			return kms;
		}
		public void setKms(double kms) {
			this.kms = kms;
		}

}
