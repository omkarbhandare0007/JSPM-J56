package com.example;

import com.example.dao.StudentDAO;
import com.example.dao.StudentDAOImpl;
import com.example.model.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Get Student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    String grade = scanner.next();
                    Student newStudent = new Student(0, name, age, grade);
                    try {
                        studentDAO.createStudent(newStudent);
                        System.out.println("Student added successfully.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    try {
                        studentDAO.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    try {
                        Student studentToUpdate = studentDAO.getStudent(updateId);
                        if (studentToUpdate != null) {
                            System.out.print("Enter new name: ");
                            studentToUpdate.setName(scanner.next());
                            System.out.print("Enter new age: ");
                            studentToUpdate.setAge(scanner.nextInt());
                            System.out.print("Enter new grade: ");
                            studentToUpdate.setGrade(scanner.next());
                            studentDAO.updateStudent(studentToUpdate);
                            System.out.println("Student updated successfully.");
                        } else {
                            System.out.println("Student with ID " + updateId + " not found.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        List<Student> students = studentDAO.getAllStudents();
                        for (Student s : students) {
                            System.out.println(s.getId() + " - " + s.getName() + " - " + s.getAge() + " - " + s.getGrade());
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.print("Enter student ID to get: ");
                    int getId = scanner.nextInt();
                    try {
                        Student student = studentDAO.getStudent(getId);
                        if (student != null) {
                            System.out.println(student.getId() + " - " + student.getName() + " - " + student.getAge() + " - " + student.getGrade());
                        } else {
                            System.out.println("Student with ID " + getId + " not found.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
