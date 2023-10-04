package org.fin.practice.repository;

import org.fin.practice.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    //List<Student> getStudentsByStandard(String standardName);

    List<Student> findByStandard(String standardName);
    List<Student> findByState(String stateName);
}
