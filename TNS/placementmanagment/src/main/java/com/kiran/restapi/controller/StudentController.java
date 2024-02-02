package com.kiran.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kiran.restapi.entity.Student;
import com.kiran.restapi.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Optional<Student> optionalStudent = repo.findById(id);
        return optionalStudent.map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        repo.save(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id) {
        Optional<Student> optionalStudent = repo.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName("kiran");
            student.setPercentage(86);
            repo.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<Void> removeStudent(@PathVariable int id) {
        Optional<Student> optionalStudent = repo.findById(id);
        if (optionalStudent.isPresent()) {
            repo.delete(optionalStudent.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/student/hallticket/{ticketNo}")
    public ResponseEntity<Object> getStudentByHallTicket(@PathVariable String ticketNo) {
        Optional<Student> optionalStudent = repo.findAll().stream()
                .filter(student -> ticketNo.equals(student.getHallticket()))
                .findFirst();

        return optionalStudent.map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND));
    }

    @PostMapping("/student/{id}/certificates/add")
    public ResponseEntity<Certificate> addCertificateForStudent(@PathVariable long id, @RequestBody Certificate certificate) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.getCertificates().add(certificate);
            studentRepository.save(student);
            return new ResponseEntity<>(certificate, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/student/{id}/certificates/update")
    public ResponseEntity<Certificate> updateCertificateForStudent(@PathVariable long id, @RequestBody Certificate updatedCertificate) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            // Find the certificate to update based on its ID
            Optional<Certificate> optionalCertificate = student.getCertificates().stream()
                    .filter(cert -> cert.getId() == updatedCertificate.getId())
                    .findFirst();

            if (optionalCertificate.isPresent()) {
                // Update the certificate fields
                Certificate existingCertificate = optionalCertificate.get();
                existingCertificate.setYear(updatedCertificate.getYear());
                existingCertificate.setCollege(updatedCertificate.getCollege());

                studentRepository.save(student);
                return new ResponseEntity<>(existingCertificate, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
