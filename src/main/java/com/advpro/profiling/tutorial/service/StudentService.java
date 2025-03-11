package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        List<StudentCourse> studentCourses = studentCourseRepository.findAll();
        Map<Long, Student> studentMap = new HashMap<>();
        List<Student> studRepo = studentRepository.findAll();

        for (Student student : studRepo) {
            studentMap.put(student.getId(), student);
        }

        List<StudentCourse> result = new ArrayList<>();
        for (StudentCourse studentCourse : studentCourses) {
            Student student = studentMap.get(studentCourse.getStudent().getId());
            StudentCourse newStudentCourse = new StudentCourse();
            newStudentCourse.setStudent(student);
            newStudentCourse.setCourse(studentCourse.getCourse());
            result.add(newStudentCourse);
        }
        return result;
    }

    public Optional<Student> findStudentWithHighestGpa() {
        List<Student> studRepo = studentRepository.findAll();
        Student highestGpaStudent = null;
        double highestGpa = 0.0;
        for (Student student : studRepo) {
            if (student.getGpa() > highestGpa) {
                highestGpa = student.getGpa();
                highestGpaStudent = student;
            }
        }
        return Optional.ofNullable(highestGpaStudent);
    }

    public String joinStudentNames() {
        List<Student> studRepo = studentRepository.findAll();
        StringBuilder sb = new StringBuilder();

        for (Student student : studRepo) {
            sb.append(student.getName()).append(", ");
        }

        if (!sb.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }
}

