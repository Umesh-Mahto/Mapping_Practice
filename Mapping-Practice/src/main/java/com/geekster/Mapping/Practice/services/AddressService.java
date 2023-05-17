package com.geekster.Mapping.Practice.services;

import com.geekster.Mapping.Practice.models.Address;
import com.geekster.Mapping.Practice.repository.IAddressRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    IAddressRepo iAddressRepo;

    public String addressDetails(Address address) {
       iAddressRepo.save(address);
       return "address added successfully";
    }


    public List<Address> getAllAddress() {
        return iAddressRepo.findAll();
    }

    @Transactional
    public String updateAddress(Address address) {
        iAddressRepo.updateAddress(address.getLandmark(),address.getDistrict(),
                address.getId(),address.getCountry(),address.getZipcode(),address.getState());
        return "address updated....!!";
    }

    public String deleteAddress(Integer id) {
        iAddressRepo.deleteById(id);
        return "id deleted";
    }
}
