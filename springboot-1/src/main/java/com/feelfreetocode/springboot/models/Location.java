package com.feelfreetocode.springboot.models;

import com.feelfreetocode.springboot.exceptions.InvalidLocationNameException;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Location {
	@Getter
	private String locationId;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private Double longitude;
	
	@Getter @Setter
	private Double latitude;

	public void setLocationId(String locationId) throws InvalidLocationNameException{
		if(locationId==null || locationId.trim().isEmpty())
			throw new InvalidLocationNameException("Location Id Must have altest One Character");
		this.locationId = locationId;
	}
	
	
}
