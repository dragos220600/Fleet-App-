package com.fleetapp.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fleetapp.fleetapp.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
