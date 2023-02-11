package com.example.springproject5.Service;

import com.example.springproject5.DTO.LocationDTO;
import com.example.springproject5.Exception.ApiException;
import com.example.springproject5.Model.Location;
import com.example.springproject5.Model.Store;
import com.example.springproject5.Repository.LocationRepository;
import com.example.springproject5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    final private StoreRepository storeRepository;

    final private LocationRepository locationRepository;
    public void addStoreLocation(LocationDTO dto){
        // find customer by id ;
        Store store = storeRepository.findStoreById(dto.getStore_id());
        if (store ==null){
            throw new ApiException("Store not found");
        }
        Location location = new Location(null,dto.getStreet(), dto.getArea(), store);
        locationRepository.save(location);
    }

    public void updateStoreLocation(LocationDTO dto){
        // find customer by id ;
        Location location = locationRepository.findLocationById(dto.getStore_id());
        if (location ==null){
            throw new ApiException("Store not found");
        }
        Store store = storeRepository.findStoreById(dto.getStore_id());
        if (store ==null){
            throw new ApiException("Store not found");
        }
        location.setArea(dto.getArea());
        location.setStreet(dto.getStreet());
        locationRepository.save(location);
    }

    public void deleteStoreLocation(Integer id){
        Location location = locationRepository.findLocationById(id);
        if (location ==null){
            throw new ApiException("Location not found");
        }
        locationRepository.delete(location);
    }
}
