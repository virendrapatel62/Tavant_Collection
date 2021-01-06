package com.feelfreetocode.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelfreetocode.springboot.dao.LocationDao;
import com.feelfreetocode.springboot.models.Location;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao ;

	

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
