package com.sunbeaminfo.controller;

import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeaminfo.dao.UserRepository;
import com.sunbeaminfo.entities.Address;
import com.sunbeaminfo.entities.User;
import com.sunbeaminfo.service.AddressService;
import com.sunbeaminfo.service.UserService;
@RestController
@RequestMapping("/address/")
public class AddressController {
   
@Autowired
private AddressService addressService;

public AddressController(AddressService addressService) {
this.addressService = addressService;

}

@PostMapping("add")
public Address addAddress(@RequestBody Address address , @RequestParam("uuid") Long userId) {
return addressService.createAddress(address,userId);
}
@GetMapping("get")
public Set<Address> getAddresses(@RequestParam("uuid") Long id){
  return addressService.getAllAddressByUserId(id);
}

@DeleteMapping("delete/{addressId}/{id}")
public String addAddress(@PathVariable Long addressId, @PathVariable Long id) {
return addressService.deleteAddress(addressId,id);
}

}
