package org.fin.practice.serviceimplementions;

import org.fin.practice.modal.Student;
import org.fin.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class service {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentsByStandard(String standardName) {
        return studentRepository.findByStandard(standardName);
    }

    public List<Student> getStudentsByState(String stateName){
        return studentRepository.findByState(stateName);
    }
}
