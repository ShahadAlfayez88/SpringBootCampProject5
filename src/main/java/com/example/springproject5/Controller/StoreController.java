package com.example.springproject5.Controller;

import com.example.springproject5.DTO.LocationDTO;
import com.example.springproject5.Model.Store;
import com.example.springproject5.Service.LocationService;
import com.example.springproject5.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {

    final private StoreService storeService;

    final private LocationService locationService;

    //display
    @GetMapping("/display")
    public ResponseEntity getAllStores(){
        List<Store> stores = storeService.getStore();
        return ResponseEntity.status(200).body(stores);
    }

    // get Store info

    @GetMapping("/getInfo/{id}")
    public ResponseEntity getStoreInfo(@PathVariable Integer id){
        Store store = storeService.getStoreInfo(id);
        return ResponseEntity.status(200).body(store);
    }


    //Add
    @PostMapping("/add")
    public ResponseEntity addStore(@Valid @RequestBody Store store){
        storeService.addStore(store);
        return ResponseEntity.status(200).body("Store Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateStore(@Valid @RequestBody Store store, @PathVariable Integer id) {

        storeService.updateStore(id, store);
        return ResponseEntity.status(200).body("Store is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id){
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body("Store is deleted ");
    }

    // Location CRUD - Add, Delete, Update

    @PostMapping("/location/add")
    public ResponseEntity addStoreAddress(@Valid @RequestBody LocationDTO locationDTO){
        locationService.addStoreLocation(locationDTO);
        return ResponseEntity.status(200).body("Store Address Added");
    }

    @PutMapping("/location/update")
    public ResponseEntity updateStoreAddress(@Valid @RequestBody LocationDTO locationDTO){
        locationService.updateStoreLocation(locationDTO);
        return ResponseEntity.status(200).body("Store Address updated");

    }

    @DeleteMapping("/location/delete/{id}")
    public ResponseEntity deleteStoreAddress(@PathVariable Integer id){
        locationService.deleteStoreLocation(id);
        return ResponseEntity.status(200).body("Store Address deleted");

    }

}
