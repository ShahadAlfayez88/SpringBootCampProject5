package com.example.springproject5.Repository;

import com.example.springproject5.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findStoreById(Integer id);
}
