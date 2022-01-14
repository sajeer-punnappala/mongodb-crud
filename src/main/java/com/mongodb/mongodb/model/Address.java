package com.mongodb.mongodb.model;

public class Address {
	private String addressLine1;
	
	private String addressLine2;
	
	private String state;
	
	private String city;
	
	private int pinCode;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [addressLine1=").append(addressLine1).append(", addressLine2=").append(addressLine2)
				.append(", state=").append(state).append(", city=").append(city).append(", pinCode=").append(pinCode)
				.append("]");
		return builder.toString();
	}
	
	
}
