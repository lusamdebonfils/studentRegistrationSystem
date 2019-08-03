package edu.mum.cs.cs425.studentregistrationapp.service;

import edu.mum.cs.cs425.studentregistrationapp.model.Classroom;

public interface ClassroomService {
    Classroom save(Classroom cr);

    Classroom getClassroomById(int id);
}
