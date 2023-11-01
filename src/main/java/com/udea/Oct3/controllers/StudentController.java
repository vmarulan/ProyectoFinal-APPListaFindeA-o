package com.udea.Oct3.controllers;

import com.udea.Oct3.entity.Student;
import com.udea.Oct3.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServices studentService;

    @PostMapping("/addStudent")
    public RedirectView saveStudent(@ModelAttribute Student student,Model model){
        model.addAttribute(student);
        studentService.saveStudent(student);
        return new RedirectView("/students");
    }

    //Redirect View

    @PostMapping("/addStudents")
    public List<Student> saveStudents(@RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }

    /*@GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentService.getStudents();
    }*/

    @GetMapping("/student/{id}")
    public Student findById (@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    /*@PutMapping("/updateStudent")
    public Student updateStudent (@RequestBody Student student){
        return studentService.updateStudent(student);
    }*/

    @DeleteMapping("/student/{id}")
    public RedirectView deleteStudent (@PathVariable Integer id){
        studentService.deleteStudent(id);
        return new RedirectView("/students");
    }

    @PatchMapping("/student/{id}")
    public RedirectView updateStudent(@PathVariable ("id")Integer id){
        studentService.toogleAvailable(id);
        return  new RedirectView("/students");
    }

    @PostMapping("/student/update")
    public RedirectView updateStudent(@ModelAttribute Student student){
        studentService.updateStudent(student);
        return new RedirectView("/students");
    }

}
