package raisetech.student.management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.student.management.data.Students;
import raisetech.student.management.data.StudentsCourses;


@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Students> search();

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCourses();

  @Insert("INSERT INTO students (name, kana_name, nickname, email, area, age, sex) VALUES (#{name},#{kanaName},#{nickname},#{email},#{area},#{age},#{sex})")
  void registerStudent(Students students);

  @Insert("INSERT INTO students_courses (course_name) VALUES (#{course_name})")
  void registerStudentCourses(StudentsCourses studentsCourses);



}
