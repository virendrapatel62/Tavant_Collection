package com.tavant.collection.dao;

import java.util.List;
import java.util.Optional;

import com.tavant.collection.models.Location;

public interface LocationDao {
	public Boolean addLocation(Location location);
	public Optional<Location> updateLocation(String locationId , Location location);
	public Optional<List<Location>> getLocations();
	public Boolean deleteLocation(String empid);
	public Optional<Location> getLocationById(String empid);
	public Boolean isExists(String empId);
}
