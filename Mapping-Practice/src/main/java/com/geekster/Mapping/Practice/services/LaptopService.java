package com.geekster.Mapping.Practice.services;

import com.geekster.Mapping.Practice.models.Laptop;
import com.geekster.Mapping.Practice.models.Student;
import com.geekster.Mapping.Practice.repository.ILaptopRepo;
import com.geekster.Mapping.Practice.repository.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    ILaptopRepo iLaptopRepo;
    @Autowired
    IStudentRepo iStudentRepo;

    public String addLaptop(Laptop laptop) {
        Integer id = laptop.getStudent().getId();
        Student studentObject = iStudentRepo.findById(id).get();
        laptop.setStudent(studentObject);
        iLaptopRepo.save(laptop);
     return "laptop added successfully";
    }

    public List<Laptop> getAllLaptop() {
       return iLaptopRepo.findAll();
    }


@Transactional
    public String updateLaptop(Laptop laptop) {
        iLaptopRepo.updateLaptop(laptop.getId(),laptop.getName(),laptop.getBrand(),laptop.getPrice());
        return " laptop updated successfully";
    }

    public String deleteLaptop(Integer id) {
        iLaptopRepo.deleteById(id);
        return "deleted successfully";
    }
}
