package com.tavant.collection.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tavant.collection.models.Location;

public class LocationDaoImpl implements LocationDao {
	private List<Location> locations = new ArrayList<Location>(20);

	@Override
	public Optional<Location> getLocationById(String locationId) {
		for (Location location : locations) {
			if (location.getLocationId().equals(locationId))
				return Optional.of(location);
		}
		return Optional.empty();
	}

	@Override
	public Boolean isExists(String locationId) {
		return (this.getLocationById(locationId) != null) ? true : false;
	}

	@Override
	public Boolean addLocation(Location location) {
		return this.locations.add(location);
	}

	@Override
	public Optional<Location> updateLocation(String locationId, Location location) {
		Location tempLocation = this.getLocationById(locationId).get();
		tempLocation.setLatitude(location.getLatitude());
		tempLocation.setLongitude(location.getLongitude());
		tempLocation.setName(location.getName());
		return Optional.of(tempLocation);
	}

	@Override
	public Optional<List<Location>> getLocations() {

		return this.locations.isEmpty() ? Optional.empty() : Optional.of(this.locations);
	}

	@Override
	public Boolean deleteLocation(String locationId) {
		return this.locations.remove(this.getLocationById(locationId).get());
	}

}
