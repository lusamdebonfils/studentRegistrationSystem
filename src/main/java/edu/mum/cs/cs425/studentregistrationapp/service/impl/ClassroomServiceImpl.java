package edu.mum.cs.cs425.studentregistrationapp.service.impl;

import edu.mum.cs.cs425.studentregistrationapp.model.Classroom;
import edu.mum.cs.cs425.studentregistrationapp.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentregistrationapp.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom save(Classroom cr) {
        return classroomRepository.save(cr);
    }

    @Override
    public Classroom getClassroomById(int id) {
        return classroomRepository.findById(id).orElse(null);
    }
}
