package com.udea.Oct3.services;

import com.udea.Oct3.entity.Student;
import com.udea.Oct3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository ;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent (Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveStudents (List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student updateStudent (Student student){
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setAvailable(student.isAvailable());
        return studentRepository.save(existingStudent);
    }

    public String deleteStudent(Integer id){
        studentRepository.deleteById(id);
        return "Has Eliminado al estudiante con el ID " + id;
    }

    public boolean toogleAvailable(Integer id){
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setAvailable(true);
            studentRepository.save(student);
            return  true;
        } else {
            return false;
        }
    }
    //CRUD: Ver Estudiante, Añadir,Nodificar, eliminar
}
