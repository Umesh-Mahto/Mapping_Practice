package com.geekster.Mapping.Practice.repository;

import com.geekster.Mapping.Practice.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IAddressRepo extends JpaRepository<Address,Integer> {
    @Modifying
    @Query(value = "update address set landmark=:landmark,district=:district,country=:country,zipcode=:zipcode,state=:state where id =:id",nativeQuery = true)
    void updateAddress(String landmark, String district, Integer id, String country,
                       String zipcode, String state);
}
