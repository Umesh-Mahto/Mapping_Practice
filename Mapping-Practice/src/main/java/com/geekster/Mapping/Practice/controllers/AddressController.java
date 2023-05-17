package com.geekster.Mapping.Practice.controllers;

import com.geekster.Mapping.Practice.models.Address;
import com.geekster.Mapping.Practice.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("/addAddress")
    public String AddAddress(@RequestBody Address address){
        return addressService.addressDetails(address);
    }
    @GetMapping("/getAddress")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
    @PutMapping("/updateAddress")
    public String updateAddress(@RequestBody Address address){
        return addressService.updateAddress(address);
    }
    @DeleteMapping("deleteAddress/{id}")
    public String deleteAddress(@PathVariable Integer id){
        return addressService.deleteAddress(id);
    }
}
