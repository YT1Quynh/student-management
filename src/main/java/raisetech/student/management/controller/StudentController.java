package raisetech.student.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/studentsList/age")
  public List<Student> getStudentsList(@RequestParam int min, @RequestParam int max){
    return service.searchStudentList(min, max);

  }
  @GetMapping("/studentsCourseList/course")
  public List<StudentsCourses> getStudentsCourseList(@RequestParam String name){
    return service.searchStudentsCourseList(name);
  }
}
