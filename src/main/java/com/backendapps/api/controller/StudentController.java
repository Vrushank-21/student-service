package com.backendapps.api.controller;

import com.backendapps.api.model.Student;
import com.backendapps.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping
    public List<Student> getStudents(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND, "resource not found"));
    }

    @PostMapping
    public Student createStudent(@RequestBody Student request){
        return repository.save(request);
    }

    @PutMapping("/{id}")
    public Optional<Student> updateStudent(@PathVariable Long id, @RequestBody Student request){
        return Optional.ofNullable(repository.findById(id).map(student->{
            student.setName(request.getName());
            student.setDegree(request.getDegree());
            return repository.save(student);
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found")));
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        repository.deleteById(id);
    }



}
