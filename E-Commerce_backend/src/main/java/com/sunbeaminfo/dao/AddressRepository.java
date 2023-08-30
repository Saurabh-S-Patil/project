package com.sunbeaminfo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeaminfo.entities.Address;
import com.sunbeaminfo.entities.User;

public interface AddressRepository extends JpaRepository<Address, Long> {

    
}
