package com.feelfreetocode.springboot.services;

import java.util.List;
import java.util.Optional;

import com.feelfreetocode.springboot.models.Location;

public interface LocationService {
	public Boolean addLocation(Location location);
	public Optional<Location> updateLocation(String locationId , Location location);
	public Optional<List<Location>> getLocations();
	public Boolean deleteLocation(String locationId);
	public Optional<Location> getLocationById(String locationId);
	public Boolean isExists(String locationId);
}
