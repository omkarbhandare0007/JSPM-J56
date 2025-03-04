package com.example.dao;

import com.example.model.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    void createStudent(Student student) throws SQLException;
    Student getStudent(int id) throws SQLException;
    List<Student> getAllStudents() throws SQLException;
    void updateStudent(Student student) throws SQLException;
    void deleteStudent(int id) throws SQLException;
}
