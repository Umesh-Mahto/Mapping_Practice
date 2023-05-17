package com.geekster.Mapping.Practice.controllers;

import com.geekster.Mapping.Practice.models.Address;
import com.geekster.Mapping.Practice.models.Course;
import com.geekster.Mapping.Practice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @PostMapping("/addCourse")
    public String addCourse(@RequestBody Course course){
        return courseService.addCouse(course);
    }
    @GetMapping("/getAllCourse")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }
    @PutMapping("/updateCouse")
    public String updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Integer id){
        return courseService.deleteCourseById(id);
    }
}
