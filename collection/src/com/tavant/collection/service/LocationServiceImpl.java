package com.tavant.collection.service;

import java.util.List;
import java.util.Optional;

import com.tavant.collection.dao.*;
import com.tavant.collection.models.*;

public class LocationServiceImpl implements LocationService {

	private LocationDao locationDao = LocationDaoImpl.getInstance();

	private static LocationService locationService;

	public static LocationService getInstance() {
		if (locationService == null) {
			synchronized (LocationServiceImpl.class) {
				if (locationService == null) {
					locationService = new LocationServiceImpl();
				}
			}
		}
		return locationService;
	}

	private LocationServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Boolean addLocation(Location location) {
		return this.locationDao.addLocation(location);
	}

	@Override
	public Optional<Location> updateLocation(String locationId, Location location) {
		return this.locationDao.updateLocation(locationId, location);
	}

	@Override
	public Optional<List<Location>> getLocations() {
		return this.locationDao.getLocations();
	}

	@Override
	public Boolean deleteLocation(String locationId) {
		return this.locationDao.deleteLocation(locationId);
	}

	@Override
	public Optional<Location> getLocationById(String locationId) {
		return this.locationDao.getLocationById(locationId);
	}

	@Override
	public Boolean isExists(String locationId) {
		return this.locationDao.isExists(locationId);
	}

}
