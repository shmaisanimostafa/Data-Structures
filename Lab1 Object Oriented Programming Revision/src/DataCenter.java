/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author user
 */
public class DataCenter {

	private String name;
	
	private  Device [] Devices;

	
	public DataCenter(String name) {
		this.name = name;
                Devices = new Device[10];
	}



	
	public void addDevice(Device d) {
		if (Devices[0] == null) {
			Devices[0] = d;
			return;
		}
		
		int i;
                
               
		for (i = 0; i < Devices.length; i++) {
			if (Devices[i] != null && Devices[i] instanceof NetworkDevice)
				break;
			if (Devices[i] == null)
				break;
		}
		// shift elements
		for (int j = Devices.length - 1; j >= i; j--) {
			if(Devices[j] != null) {
				Devices[j+1] = Devices[j];
			}
		}
		//insert element at index i
		Devices[i] = d;
	}
	
        public void getserversWithOS(String op){
            
        for (Device d : Devices) {
            Server s;
            
            if (d instanceof Server) {
            s = (Server) d;
                if (s.getOperatingSystemType().equals(op))
			System.out.println(s);
			}
        }
        }
        
        public void getEthernetNetworks(){
           for (Device d : Devices) {
            NetworkDevice n;
            if (d instanceof NetworkDevice) {
            n = (NetworkDevice) d;
                if (n.isPowerOverEthernet())
			System.out.println(n);
			}
        } 
        }
	
	public String toString() {
		String s = "";
		for (Device d : Devices)
			if (d instanceof Device) 
				s=s+d+"\n";
	
                return s;
              }
  


}