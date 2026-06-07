package raisetech.student.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.management.data.Students;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Students> searchStudentList(){
    return repository.search();
  }

  public List<StudentsCourses> searchStudentsCourseList(){
    return repository.searchStudentsCourses();
  }

  public void registerStudent(Students students){
    repository.registerStudent(students);
  }

  public void registerStudentCourses(StudentsCourses studentsCourses){
    repository.registerStudentCourses(studentsCourses);
  }


}
