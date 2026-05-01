package raisetech.student.management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;


@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students WHERE age BETWEEN #{min} and #{max}")
  List<Student> search(int min, int max);

  @Select("SELECT * FROM students_courses WHERE course_name LIKE CONCAT ('%', #{courseName}, '%')")
  List<StudentsCourses> searchStudentsCourses(String courseName);
}
