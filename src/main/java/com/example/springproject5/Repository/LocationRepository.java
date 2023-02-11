package com.example.springproject5.Repository;

import com.example.springproject5.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
Location findLocationById(Integer id);
}
