package java_assessment.utils;

import java_assessment.model.Student;
import java_assessment.service.StudentService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PrinterHelper
{

    public static void showMainMenu(){
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Welcome to StudentGen         |" );
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Select 1 option:              |" );
        System.out.println( "| . 1 Register Student          |" );
        System.out.println( "| . 2 Find Student              |" );
        System.out.println( "| . 3 Grade Student             |" );
        System.out.println( "| . 4 Enroll Student to Course  |" );
        System.out.println( "| . 5 Show Students Summary     |" );
        System.out.println( "| . 6 Show Courses Summary      |" );
        System.out.println( "| . 7 Get Course Average        |" );
        System.out.println( "| . 8 Exit                      |" );
        System.out.println( "|-------------------------------|" );
    }

    public static Student createStudentMenu( Scanner scanner )
        throws ParseException
    {
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 1 Register Student                |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter student's first name:         |" );
        String firstName = scanner.next();
        System.out.println( "| Enter student's last name:         |" );
        String lastName = scanner.next();
        System.out.println( "| Enter student ID:                   |" );
        String id = scanner.next();
        System.out.println( "| Enter student email:                |" );
        String email = scanner.next();
        System.out.println( "| Enter student birth date(mm/dd/yyyy)|" );
        DateFormat formatter = new SimpleDateFormat( "mm/dd/yyyy");
        //TODO validate date format and catch exception to avoid crash
        Date birthDate = formatter.parse( scanner.next());
        System.out.println( "|-------------------------------------|" );
        Student student = new Student( firstName, lastName, email, birthDate, id );
        System.out.println( "Student Successfully Registered! " );
        System.out.println(student);
        return student;
    }

    public static void updateStudentGradeMenu(StudentService studentService, Scanner scanner) {
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 3 Grade Student                   |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter course ID:                    |" );
        String courseId = scanner.next();
        System.out.println( "| Enter student's ID:                 |" );
        String studentId = scanner.next();
        System.out.println( "| Enter student's grades:               |" );
        int grades = scanner.nextInt();
        studentService.setStudentScore(studentId, courseId, grades);
    }

    public static void displayAverageMenu(StudentService studentService, Scanner scanner){
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 7 Get Course Average              |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter course ID:                    |" );
        String courseId = scanner.next();
        double average = studentService.getAverage(courseId);
        System.out.println("The average grade for course " + courseId + ": " + average);
    }
}