package com.geekster.Mapping.Practice.repository;

import com.geekster.Mapping.Practice.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaptopRepo extends JpaRepository<Laptop,Integer> {

    @Modifying
    @Query(value = "update laptop set name=:name,brand=:brand,price=:price where id=:id",nativeQuery = true)
    void updateLaptop(Integer id,String name,String brand,Integer price);
}



