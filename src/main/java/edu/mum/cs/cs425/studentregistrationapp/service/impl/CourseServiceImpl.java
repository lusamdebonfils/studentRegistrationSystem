package edu.mum.cs.cs425.studentregistrationapp.service.impl;

import edu.mum.cs.cs425.studentregistrationapp.model.Course;
import edu.mum.cs.cs425.studentregistrationapp.repository.CourseRepository;
import edu.mum.cs.cs425.studentregistrationapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
