package org.fin.practice.controller;

import org.fin.practice.exception.ResourceNotFoundException;
import org.fin.practice.modal.Student;
import org.fin.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    //get all students details
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Student> getStudentsById(@PathVariable long id){
        return studentRepository.findById(id);
    }

    //get students by standard/class
    @GetMapping("/standard/{standardName}")
    public List<Student> getStudentsByStandard(@PathVariable String standardName){
        return studentRepository.findByStandard(standardName);
    }

    // get students details by state
    @GetMapping("/state/{stateName}")
    public List<Student> getStudentsByState(@PathVariable String stateName){
        return studentRepository.findByState(stateName);
    }

    // insert the new values in list format

//    @PostMapping("/add")
//    public Student addStudents(@RequestBody Student student){
//        return studentRepository.save(student);
//    }

    @PostMapping("/add")
    public ResponseEntity<String> addStudents(@RequestBody List<Student> student){
        for (Student value : student) {
            studentRepository.save(value);
        }
        return ResponseEntity.ok("Students are added successfully");
    }


    // update the value by id
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudentDetails(@PathVariable long id, @RequestBody Student studentUpdateValue){
        Student studentToUpdated=studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student doesn't exist with "+id));

        studentToUpdated.setName(studentUpdateValue.getName());
        studentToUpdated.setRoll(studentUpdateValue.getRoll());
        studentToUpdated.setStandard(studentUpdateValue.getStandard());
        studentToUpdated.setContactNumber(studentUpdateValue.getContactNumber());
        studentToUpdated.setEmail(studentUpdateValue.getEmail());
        studentToUpdated.setState(studentUpdateValue.getState());

        studentRepository.save(studentToUpdated);
        System.out.println("Student details has been updated of id: "+id);
        return ResponseEntity.ok(studentToUpdated);
    }


//// Want to update the details in list
//    @PutMapping("/updateList/{id}")
//    public ResponseEntity<Student> updateStudentDetailsList(@PathVariable long id, @RequestBody List<Student> studentUpdateValues){
//        List<Student> studentToUpdated= (List<Student>) studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student doesn't exist with "+id));
//for(int i=0;i<studentUpdateValues.size();i++) {
//    studentToUpdated.set(i).setName(studentUpdateValues.get(i).getName());
//    studentToUpdated.set(i).setRoll(studentUpdateValues.get(i).getRoll());
//    studentToUpdated.setStandard(studentUpdateValues.getStandard());
//    studentToUpdated.setContactNumber(studentUpdateValues.getContactNumber());
//    studentToUpdated.setEmail(studentUpdateValues.getEmail());
//    studentToUpdated.setState(studentUpdateValues.getState());
//
//    studentRepository.save(studentToUpdated);
//}
//        System.out.println("Student details has been updated of id: "+id);
//        return ResponseEntity.ok(studentToUpdated);
//    }


    // deleting the details by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDetailsById(@PathVariable long id){
        Student student=studentRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Student id not found of id:-"+id));
        studentRepository.delete(student);
        //return new ResponseEntity <> (HttpStatus.NO_CONTENT);
        return ResponseEntity.ok("Student details has been deleted of id:- "+id);
    }


    // thymeleaf testing
    @GetMapping ("/home")
    public String thymeleafTesting(Model model){
        model.addAttribute("message","Thymeleaf");
        return "home";
    }
}
