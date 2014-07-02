package org.namiya.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {

	private String streeingWheel;

	public String getStreeingWheel() {
		return streeingWheel;
	}

	public void setStreeingWheel(String streeingWheel) {
		this.streeingWheel = streeingWheel;
	}
	
}
