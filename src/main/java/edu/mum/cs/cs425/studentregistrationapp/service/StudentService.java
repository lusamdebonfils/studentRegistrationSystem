package edu.mum.cs.cs425.studentregistrationapp.service;

import edu.mum.cs.cs425.studentregistrationapp.model.Classroom;
import edu.mum.cs.cs425.studentregistrationapp.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student save(Student s);

    List<Student> getPassingStudentsOnly();

    List<Student> getLatestStudents();

    Student getStudentById(long id);

    void updateStudent(Classroom classroom, long studentId);
}
