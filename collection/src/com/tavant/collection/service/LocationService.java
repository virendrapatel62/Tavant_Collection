package com.tavant.collection.service;

import java.util.List;
import java.util.Optional;

import com.tavant.collection.models.Location;

public interface LocationService {
	public Boolean addLocation(Location location);
	public Optional<Location> updateLocation(String locationId , Location location);
	public Optional<List<Location>> getLocations();
	public Boolean deleteLocation(String locationId);
	public Optional<Location> getLocationById(String locationId);
	public Boolean isExists(String locationId);
}
