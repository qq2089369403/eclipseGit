package json;

public class Address {
	private String schoolAddress;
	private String homeddress;
	
	public Address() {
	}
	
	public Address(String schoolAddress, String homeddress) {
		this.schoolAddress = schoolAddress;
		this.homeddress = homeddress;
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public String getHomeddress() {
		return homeddress;
	}
	public void setHomeddress(String homeddress) {
		this.homeddress = homeddress;
	}
	
}
