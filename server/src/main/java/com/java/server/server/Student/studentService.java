package com.java.server.server.Student;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class studentService {

    private final studentRepository studentRepository;

    public studentService(com.java.server.server.Student.studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getstudent(){
        return studentRepository.findAll();

    }

    public void addStudent(student student) {
        Optional<student> studentemail = studentRepository.findemail(student.getEmail());

        if (studentemail.isPresent()){
            throw new IllegalStateException("Email already taken");
        }
        studentRepository.save(student);
    }



    public void deletestudent(Long studentID) {
        boolean exists = studentRepository.existsById(studentID);
        if (!exists){
            throw new IllegalStateException("does not exists");
        }
        studentRepository.deleteById(studentID);
    }
    @Transactional
    public void updateStudent(Long studentid, String name, String email) {
        student student = studentRepository.findById(studentid).orElseThrow(() -> new IllegalStateException("student does not exists"));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);

        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<student> optionemail = studentRepository.findemail(email);
            if (optionemail.isPresent()){
                throw  new IllegalStateException("email already taken");
            }
            student.setEmail(email);
        }


    }
}
