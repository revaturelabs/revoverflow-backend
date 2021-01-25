package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Location;
import com.revature.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository locationRepository;
	
	
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}
	
	@Transactional
	public Location addLocation(Location location) {
		return locationRepository.save(location);
	}

}
