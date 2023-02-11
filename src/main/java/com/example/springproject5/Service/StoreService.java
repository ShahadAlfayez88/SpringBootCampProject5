package com.example.springproject5.Service;

import com.example.springproject5.Exception.ApiException;
import com.example.springproject5.Model.Store;
import com.example.springproject5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StoreService {
     final private StoreRepository storeRepository;

    //Add
    public void addStore(Store store) {
        storeRepository.save(store);
    }

   //Display
    public List<Store> getStore() {
        return storeRepository.findAll();
    }

    //Update

    public void updateStore(Integer id, Store store) {
        Store newStore = storeRepository.findStoreById(id);
        if (newStore == null) {
            throw new ApiException("Store not found!!");
        }
        storeRepository.save(newStore);
    }

    // Delete
    public void deleteStore(Integer id) {
        Store store = storeRepository.findStoreById(id);
        if (!storeRepository.existsById(id)) {
            throw new ApiException("Id is not found");
        }
        storeRepository.delete(store);
    }

    // get Store
    public Store getStoreInfo(Integer id) {
        Store store = storeRepository.findStoreById(id);
        if (!storeRepository.existsById(id)) {
            throw new ApiException("Id is not found");
        }
        return store;
    }


}
