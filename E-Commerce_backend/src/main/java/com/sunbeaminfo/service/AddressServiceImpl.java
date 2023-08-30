package com.sunbeaminfo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeaminfo.dao.AddressRepository;
import com.sunbeaminfo.dao.UserRepository;
import com.sunbeaminfo.entities.Address;
import com.sunbeaminfo.entities.User;
@Service
@Transactional
public class AddressServiceImpl implements AddressService{

@Autowired
private AddressRepository addressRepository;
@Autowired
private UserRepository userRepository;

@Override

public Address createAddress(Address address , Long userId) {
   User user = userRepository.findById(userId).get();
       Set<Address> addresses = user.getAddresses();
       Address updatedAddress = addressRepository.save(address);
       addresses.add(address);
userRepository.save(user);
return updatedAddress;
}
 

//Showing LazyIntialize Error
@Override
public Set<Address> getAllAddressByUserId(Long id) {
User user = userRepository.findById(id).get();
Set<Address> set = user.getAddresses();
return set;
}

@Override
public String deleteAddress(Long addressId, Long id) {
User user = userRepository.findById(id).get();
        Set<Address> addresses = user.getAddresses();
        Address address = addressRepository.getById(addressId);
        addressRepository.deleteById(addressId);;
        addresses.remove(address);
userRepository.save(user);
return "success";
}

}