package com.udea.Oct3.repository;

import com.udea.Oct3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Integer>{

}
