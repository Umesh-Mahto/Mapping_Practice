package com.geekster.Mapping.Practice.repository;

import com.geekster.Mapping.Practice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Integer> {
@Modifying
@Query(value = "update student set age=:age,department=:department,phone_Number=:phoneNumber,name=:name,branch=:branch where id=:id",nativeQuery = true)
    void updateStudent(Integer id, String age, String department, String phoneNumber, String name, String branch);
}
