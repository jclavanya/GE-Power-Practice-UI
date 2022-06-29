package com.restapi.postgresql.controller;
import com.restapi.postgresql.entity.StudentEntity;
import com.restapi.postgresql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class StudentController {
    @Autowired
StudentRepository studentRepository;

    @GetMapping("/getallstudent")
    public List<StudentEntity> getAllStudent()
    {
        List<StudentEntity> allstudentlist = studentRepository.findAll();
        return allstudentlist;

    }

    @GetMapping("/getstudent/{id}")
    public StudentEntity getstudentbyId(@PathVariable(value = "id") Integer studentId)

    {
        StudentEntity studentEntity = studentRepository.findById(studentId).get();

        return studentEntity;

    }

    @PostMapping("/createstudent")
    public StudentEntity create(@RequestBody StudentEntity student) {

        StudentEntity savedStudent = studentRepository.save(student);

        return savedStudent;
    }
    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable(value = "id") Integer studentId,
                                                        @RequestBody StudentEntity studentDetails)
    {
        StudentEntity student = studentRepository.findById(studentId).get();

        student.setSubjects(studentDetails.getSubjects());
        student.setName(studentDetails.getName());
        final StudentEntity updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/deletestudent/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Integer studentId)
    {
        StudentEntity student = studentRepository.findById(studentId).get();

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
