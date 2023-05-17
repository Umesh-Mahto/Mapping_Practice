package com.geekster.Mapping.Practice.controllers;

import com.geekster.Mapping.Practice.models.Laptop;
import com.geekster.Mapping.Practice.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    @Autowired
    LaptopService laptopService;

    @PostMapping("/addLaptop")
    public String addLaptop(@RequestBody Laptop laptop){
        return laptopService.addLaptop(laptop);
    }
    @GetMapping("/getAllLaptop")
     public List<Laptop>getAllLaptop(){
        return laptopService.getAllLaptop();
    }
    @PutMapping("/updateLaptop")
    public String updateLaptop(@RequestBody Laptop laptop){
        return laptopService.updateLaptop(laptop);
    }
    @DeleteMapping("deleteLaptop/{id}")
    public String deleteLaptop(@PathVariable Integer id){
        return laptopService.deleteLaptop(id);
    }
}
