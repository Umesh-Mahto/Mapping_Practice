package com.geekster.Mapping.Practice.services;

import com.geekster.Mapping.Practice.models.Address;
import com.geekster.Mapping.Practice.models.Course;
import com.geekster.Mapping.Practice.models.Student;
import com.geekster.Mapping.Practice.repository.ICourseRepo;
import com.geekster.Mapping.Practice.repository.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    ICourseRepo iCourseRepo;
    @Autowired
    IStudentRepo iStudentRepo;


    public String addCouse(Course course) {
      List<Student>studentList=course.getStudentList();
      ArrayList<Student> temp=new ArrayList<>();
      for(Student studentObj :studentList){
          Integer stId=studentObj.getId();

          Student studentObject=iStudentRepo.findById(stId).get();
          temp.add(studentObject);
      }
      course.setStudentList(temp);
        iCourseRepo.save(course);
        return "Course added successfully";
    }

    public List<Course> getAllCourse() {
        return iCourseRepo.findAll();
    }


    @Transactional
    public String updateCourse(Course course) {
        iCourseRepo.updateCourse(course.getId(),course.getDescription(),course.getDuration(),course.getTitle());
        return "Course updated Successfully";
    }

    public String deleteCourseById(Integer id) {
        iCourseRepo.deleteById(id);
      return "Course deleted Successfully";
    }
}
