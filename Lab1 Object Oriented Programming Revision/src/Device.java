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
public abstract class Device {
	
	
	protected int id;
	protected String brand;	
	

	public Device (int id , String brand) {
		this.id=id;
		this.brand= brand;
	}
	
	public String toString() { 	
		return "Id: " + id + ", Brand: " + brand;
	}	
	
	
	
}