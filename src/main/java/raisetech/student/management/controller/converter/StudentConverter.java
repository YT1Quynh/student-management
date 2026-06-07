package raisetech.student.management.controller.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.student.management.data.Students;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.domain.StudentDetail;

@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Students> students,
      List<StudentsCourses> studentsCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();
    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudents(student);

      List<StudentsCourses> convertStudentCourses = new ArrayList<>();
      for (StudentsCourses studentCourse : studentsCourses) {
        if (Objects.equals(student.getId(), studentCourse.getStudentId())) {
          convertStudentCourses.add(studentCourse);
        }
      }

      studentDetail.setStudentsCourses((StudentsCourses) convertStudentCourses);
      studentDetails.add(studentDetail);
    });
    return studentDetails;
  }

}
