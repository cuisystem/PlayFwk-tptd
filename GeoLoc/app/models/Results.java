package models;

import java.util.Arrays;

public class Results {
	@Override
	public String toString() {
		return "Results [address_components="
				+ Arrays.toString(address_components) + "]";
	}

	public adress_component[] getAddress_components() {
		return address_components;
	}

	public void setAddress_components(adress_component[] address_components) {
		this.address_components = address_components;
	}

	private adress_component address_components[];
}
