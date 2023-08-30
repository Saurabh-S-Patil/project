package com.sunbeaminfo.service;

import java.util.Set;

import com.sunbeaminfo.entities.Address;

public interface AddressService {
Address createAddress(Address address,Long id);
Set<Address> getAllAddressByUserId(Long id);
String deleteAddress(Long address,Long id);
}