package raisetech.student.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private String name;
	private String age;
	private Map<String , String> studentMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/studentInfo")
	public List<String> getAllStudents(){
		return studentMap.entrySet().stream().map(e->e.getKey() + " " + e.getValue() + "歳").toList();
	}

	@PostMapping("/studentInfo")
	public void setStudentInfo(@RequestParam String name,@RequestParam String age){
		this.name=name;
		this.age=age;
		studentMap.put(name,age);

	}
	@PostMapping("/studentName")
	public void updateStudentName(@RequestParam String name){
		this.name=name;
		studentMap.put(name,age);
	}

}
