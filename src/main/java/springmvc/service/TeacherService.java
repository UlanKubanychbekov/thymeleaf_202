package springmvc.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import springmvc.model.Teacher;
import springmvc.repositories.TeacherRepositories;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherService {

    private final TeacherRepositories teacherRepositories;

    public TeacherService(TeacherRepositories teacherRepositories) {
        this.teacherRepositories = teacherRepositories;


    }
//    public void saveTeachers(Teacher teacher){
//        teacherRepositories.saveTeacher(teacher);
//    }
//    public Optional<Teacher> findTeacherNyID(UUID id) throws NotFoundException {
//        return Optional.ofNullable(findTeacherNyID(id)).orElseThrow(()->new NotFoundException(String.format("not found",Teacher.class)));
//    }
//    public void deleteTeacherById(UUID id) throws NotFoundException {
//       Teacher teacher = findTeacherNyID(id).orElseThrow(()->new NotFoundException("Teacher is id %S not found"));
//        System.out.println(teacher);
//        teacherRepositories.removeTeacherById(id);
//    }
//    public List<Teacher> getAllTeachers(){
//        return teacherRepositories.getAllTeacher();
//    }
//    public void updateTeachersById(Teacher newTeacher, UUID id) throws NotFoundException {
//        Teacher teacher = findTeacherNyID(id).orElseThrow(()->new NotFoundException("not found"));
//        String teacherName = teacher.getFirstName();
//        String newTeacherName = newTeacher.getFirstName();
//
//        if(!Objects.equals(teacherName,newTeacherName)) {
//        teacher.setFirstName(newTeacherName);
//        }
//        String teacherNameLast = teacher.getLastName();
//        String newTeacherLastName = newTeacher.getLastName();
//        if(!Objects.equals(newTeacherLastName, teacherNameLast)){
//            teacher.setLastName(newTeacherLastName);
//        }
//
//    }
//}

    public void saveTeacher(Teacher teacher) {
        teacherRepositories.saveTeacher(teacher);
    }


    public List<Teacher> getTeachers(UUID id) {
        return teacherRepositories.getTeachers(id);
    }


    public Teacher getTeacherById(UUID id) {
        return teacherRepositories.getTeacherById(id);
    }


    public void deleteTeacher(UUID id) {
        teacherRepositories.deleteTeacher(id);
    }


    public void updateTeacher(UUID id, Teacher updatedTeacher) {
        teacherRepositories.updateTeacher(id, updatedTeacher);
    }

}
