package com.java.server.server.Student;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/student")
public class studentController {
    private final studentService studentService;

    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/name")
    public List<student> name() {
        return studentService.getstudent();
    }
    @PostMapping("/create")
    public void register(@RequestBody student student){
        studentService.addStudent(student);
    }

    @PutMapping("/update/{studentid}")
    public void update(@PathVariable Long studentid ,@RequestParam(required = false) String name, String email ){
        studentService.updateStudent(studentid, name , email);
    }

    @DeleteMapping("/delete/{studentID}")
    public void delete(@PathVariable Long studentID){
        studentService.deletestudent(studentID);
    }
}
