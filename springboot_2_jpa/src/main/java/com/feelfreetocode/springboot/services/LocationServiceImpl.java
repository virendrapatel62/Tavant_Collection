package com.feelfreetocode.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelfreetocode.springboot.dao.LocationDao;
import com.feelfreetocode.springboot.models.Location;

@Service
public class LocationServiceImpl implements LocationService {

//	@Autowired
	private LocationDao locationDao ;

	@Override
	public Boolean addLocation(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Location> updateLocation(String locationId, Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Location>> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteLocation(String locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Location> getLocationById(String locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isExists(String locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
