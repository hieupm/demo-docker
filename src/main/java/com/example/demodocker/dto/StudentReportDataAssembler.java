package com.example.demodocker.dto;

import com.example.demodocker.entities.Course;
import com.example.demodocker.entities.Student;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.List;

public class StudentReportDataAssembler {
    public static StudentReportInput assemble() {
        StudentReportInput studentReportInput = new StudentReportInput();
        studentReportInput.setReportTitle("Student Report");
        studentReportInput.setInstituteName("Hieu's Institute");

        List<Student> students = new ArrayList<>();
        //Add Student1
        Student student1 = new Student();
        student1.setName("Mark");
        student1.setEmail("mark1234@gmail.com");
        List<Course> student1Courses = new ArrayList<>();

        Course course1Student1 = new Course();
        course1Student1.setName("History");
        course1Student1.setLocation("L1");
        student1Courses.add(course1Student1);
        student1.setCourseList(student1Courses);
        students.add(student1);

        //Add Student2
        Student student2 = new Student();
        student2.setName("Twain");
        student2.setEmail("twain234@gmail.com");
        List<Course> student2Courses = new ArrayList<>();

        Course course2Student1 = new Course();
        course2Student1.setName("Physics");
        course2Student1.setLocation("L2");
        student2Courses.add(course2Student1);
        student2.setCourseList(student2Courses);
        students.add(student2);

        JRBeanCollectionDataSource studentDataSource = new JRBeanCollectionDataSource(students, false);
        studentReportInput.setStudentDataSource(studentDataSource);

        return studentReportInput;
    }
}
