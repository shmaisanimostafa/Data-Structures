
package javaapplication7;


public class Server extends Device {

	
	private String operatingSystemType;
	private String availableServices;
	
	
	public Server(int id, String brand, String operatingSystemType, String availableServices) {
		super(id, brand);
		this.operatingSystemType = operatingSystemType;
		this.availableServices = availableServices;
	}
	
	public String getOperatingSystemType() {
		return operatingSystemType;
	}

	public String getAvailableServices() {
		return availableServices;
	}	

	
	public String toString() {
		return "Server: " + super.toString() + ", OperatingSystem: " + operatingSystemType + ", Services: "
				+ availableServices;
	}

}