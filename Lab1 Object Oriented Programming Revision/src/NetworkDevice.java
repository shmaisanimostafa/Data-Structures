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
public class NetworkDevice extends Device {// class header: 4 points

	// two data fields
	private int nbOfports;
	private boolean powerOverEthernet;
	
	
	public NetworkDevice(int id, String brand, int nbOfports, boolean powerOverEthernet) {
		super(id, brand);
		this.nbOfports = nbOfports;
		this.powerOverEthernet = powerOverEthernet;
	}

    public int getNbOfports() {
        return nbOfports;
    }

    public boolean isPowerOverEthernet() {
        return powerOverEthernet;
    }
	
	public String toString() {
		return "Network Device: " + super.toString() + ", NumberOfPorts: " + nbOfports + ", PowerOverEthernet "
				+ powerOverEthernet;
	}

    

}