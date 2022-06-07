package springmvc.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import springmvc.model.Group;
import springmvc.model.Student;
import springmvc.repositories.StudentRepositories;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepositories studentRepositories;

    public StudentService(StudentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;
    }
//
//    public void save(Student student) {
//        studentRepositories.saveStudent(student);
//    }
//
//    public Optional<Student> findStudentById(UUID id) throws NotFoundException {
//        return Optional.ofNullable(findStudentById(id)).orElseThrow(() -> new NotFoundException("Student is id %s not found"));
//    }
//
//    public void deleteStudentByID(UUID id) throws NotFoundException {
//        Student student = findStudentById(id).orElseThrow(() -> new NotFoundException("not found"));
//        System.out.println(student);
//        studentRepositories.removeStudentById(id);
//    }
//
//    public List<Student> students() {
//        return studentRepositories.getAllStudent();
//    }
//
//    public void updateStudentById(UUID id, Student newStudent) throws NotFoundException {
//        Student student = findStudentById(id).orElseThrow(() -> new NotFoundException("not found"));
//        String studentName = student.getFirstName();
//        String newStudentName = newStudent.getFirstName();
//
//        if (!Objects.equals(studentName, newStudentName)) {
//            student.setFirstName(newStudentName);
//        }
//        String studentLastName = student.getLastname();
//        String newStudentLastName = newStudent.getLastname();
//        if (!Objects.equals(studentLastName, newStudentLastName)) {
//            student.setLastname(newStudentLastName);
//        }
//    }
//}

    public void saveStudent(Student student) {
        studentRepositories.saveStudent(student);
    }


    public List<Student> getStudents(UUID id) {
        return studentRepositories.getStudents(id);
    }


    public Student getStudentById(UUID id) {
        return studentRepositories.getStudentById(id);
    }


    public void deleteStudent(UUID id) {
        studentRepositories.deleteStudent(id);
    }


    public void updateStudent(UUID id, Student updatedStudent) {
        studentRepositories.updateStudent(id, updatedStudent);
    }
}
