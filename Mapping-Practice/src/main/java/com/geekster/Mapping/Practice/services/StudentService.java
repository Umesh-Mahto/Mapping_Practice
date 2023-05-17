package com.geekster.Mapping.Practice.services;

import com.geekster.Mapping.Practice.models.Address;
import com.geekster.Mapping.Practice.models.Student;
import com.geekster.Mapping.Practice.repository.IAddressRepo;
import com.geekster.Mapping.Practice.repository.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepo iStudentRepo;
    @Autowired
    IAddressRepo iAddressRepo;
    public String addStudent(Student student) {
        Integer id=student.getAddress().getId();
        Address addressObj=iAddressRepo.findById(id).get();
            student.setAddress(addressObj);
        iStudentRepo.save(student);
        return "Student saved";
    }

    public List<Student> getAllStudent() {
        return iStudentRepo.findAll();
    }
@Transactional
    public String updateStudent(Student student) {
        iStudentRepo.updateStudent(student.getId(),student.getAge(),
                student.getDepartment(),student.getPhoneNumber(),student.getName(),student.getBranch());
    return "updated student";
    }

    public String deleteStudent(Integer id) {
        iStudentRepo.deleteById(id);
        return "student deleted";
    }
}
