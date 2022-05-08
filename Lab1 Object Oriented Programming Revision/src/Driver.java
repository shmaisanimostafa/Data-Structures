 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Driver {
   public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		
		DataCenter dc = new DataCenter("DataCenter");

	
                NetworkDevice n1 =new NetworkDevice(4,"tplink",4,true);
                NetworkDevice n2 =new NetworkDevice(5,"tt",4,false);
                NetworkDevice n3 =new NetworkDevice(6,"tll",5,true);
		Server s1 = new Server(1, "IBM", "Linux", "DHCP:DNS");
		Server s2 = new Server(2, "Lenovo", "Windows", "Mail");
		Server s3 = new Server(3, "Dell", "Windows", "Web:DNS");
               
		dc.addDevice(n1);
                dc.addDevice(n2);
		dc.addDevice(s1);
                dc.addDevice(n3);
		dc.addDevice(s2);
		dc.addDevice(s3);
                
		System.out.println("All Devices: ");
		System.out.println(dc);

		String os;
                System.out.println("Enter an operating system");
                os=in.next();
		in.close();
                dc.getserversWithOS(os);
		
		

		System.out.println("The Network devices with power over ethernet are \n");
		dc.getEthernetNetworks();
		
		
	}
}