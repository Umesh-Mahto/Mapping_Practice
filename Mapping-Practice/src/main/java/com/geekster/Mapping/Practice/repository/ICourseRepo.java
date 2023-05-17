package com.geekster.Mapping.Practice.repository;

import com.geekster.Mapping.Practice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course,Integer> {

    @Modifying
    @Query(value = "update Course set description=:description,duration=:duration,title=:title where id=:id",nativeQuery = true)
    void updateCourse(Integer id, String description, String duration, String title);
}
