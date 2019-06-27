package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

public interface IStuService {
    List<Student> queryAll();
    int insertStudent(Student student);

    int deleteStudent(Integer sid);

    Student queryById(Integer sid);

    int updateStudent(Student student);
}
