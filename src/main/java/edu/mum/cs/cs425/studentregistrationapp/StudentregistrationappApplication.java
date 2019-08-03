package edu.mum.cs.cs425.studentregistrationapp;

import edu.mum.cs.cs425.studentregistrationapp.model.Classroom;
import edu.mum.cs.cs425.studentregistrationapp.model.Course;
import edu.mum.cs.cs425.studentregistrationapp.model.Student;
import edu.mum.cs.cs425.studentregistrationapp.model.Transcript;
import edu.mum.cs.cs425.studentregistrationapp.service.ClassroomService;
import edu.mum.cs.cs425.studentregistrationapp.service.CourseService;
import edu.mum.cs.cs425.studentregistrationapp.service.StudentService;
import edu.mum.cs.cs425.studentregistrationapp.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class StudentregistrationappApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TranscriptService transcriptService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private CourseService courseService;

    public static void main(String[] args) {
        SpringApplication.run(StudentregistrationappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello StudentRegistrationApp!!!");
        // Create 3 new classrooms
        Classroom cr1 = new Classroom("McLaughlin building", "M105");
        Classroom cr2 = new Classroom("Verrill Hall", "V29");
        Classroom cr3 = new Classroom("Dreier Building", "#3");
        // Create 3 new courses
        Course c1 = new Course("FPP", "CS390", 4.0f);
        Course c2 = new Course("MPP", "CS401", 4.0f);
        Course c3 = new Course("SWE", "CS425", 4.0f);
        Course[] courses = {c1, c2, c3};

        // Create 5 new Transcripts
        Transcript tr1 = new Transcript("BS Computer Science");
        Transcript tr2 = new Transcript("MS Computer Science");
        Transcript tr3 = new Transcript("BS Mathematics");
        Transcript tr4 = new Transcript("PhD Vedic Science");
        Transcript tr5 = new Transcript("MA Film Production");

        // Create 5 new students
        Student s1 = new Student(980001L, "John A. Smith", 3.94f, LocalDate.of(2018, 10, 24), tr1);
        Student s2 = new Student(980002L, "Anna-Marie Jones", 3.05f, LocalDate.of(2019, 3, 15), tr2);
        Student s3 = new Student(980003L, "Peter Harrington", 2.90f, LocalDate.of(2018, 10, 24), tr3);
        Student s4 = new Student(980004L, "Ducarmel R. Saint-Jean", 3.77f, LocalDate.of(2018, 10, 24), tr4);
        Student s5 = new Student(980005L, "Mary W. Washington", 3.26f, LocalDate.of(2019, 3, 13), tr5);

        tr1.setStudent(s1);
        tr2.setStudent(s2);
        tr3.setStudent(s3);
        tr4.setStudent(s4);
        tr5.setStudent(s5);

        Classroom[] classrooms = {cr1, cr2, cr3};

        // Add/Register 5 New Students
        Student[] students = {s1, s2, s3, s4, s5};
        for (Student s : students) {
            Student newStudent = addNewStudent(s);
//            System.out.printf("New Student added: %s\n", newStudent);
        }

        createClassrooms(classrooms);
        createCourses(courses);

        assignStudentsToClassrooms();

        studentService.getAllStudents().forEach(System.out::println);

        printListOfHonorRollStudents();
    }

    /**
     * Adds/registers a new student into the system
     *
     * @param s the new student data object
     * @return the newly added/registered student
     */
    private Student addNewStudent(Student s) {
        //Student newStudent = studentService.save(s);
        Transcript newTranscript = transcriptService.save(s.getTranscript());
        //return newStudent;
        return newTranscript.getStudent();
    }

    /**
     * Prints list of all honor-roll students (i.e. those with cgpa > 3.0),
     * sorted by name in ascending order
     */
    private void printListOfHonorRollStudents() {
        System.out.println("List of Honor-roll students with a CGPA of 3.0+");
        System.out.println("=============================================");
        studentService.getPassingStudentsOnly()
                .stream()
                .map(s -> s.getName() + ", " + s.getCgpa())
                .forEach(System.out::println);
    }

    private void createClassrooms(Classroom[] classrooms) {
        for (Classroom cr : classrooms) {
            classroomService.save(cr);
        }
    }

    private void createCourses(Course[] courses) {
        for (Course c : courses) {
            courseService.save(c);
        }
    }

    private void assignStudentsToClassrooms() {
        Classroom cr1 = classroomService.getClassroomById(1);
        Student s1 = studentService.getStudentById(1L);
        Student s2 = studentService.getStudentById(2L);
        Student s3 = studentService.getStudentById(3L);
        s1.setClassroom(cr1);
        s2.setClassroom(cr1);
        s3.setClassroom(cr1);
        studentService.updateStudent(cr1, s1.getStudentId());
        studentService.updateStudent(cr1, s2.getStudentId());
        studentService.updateStudent(cr1, s3.getStudentId());
        Classroom cr3 = classroomService.getClassroomById(3);
        Student s4 = studentService.getStudentById(4L);
        s4.setClassroom(cr3);
        studentService.updateStudent(cr3, s4.getStudentId());
    }
}
