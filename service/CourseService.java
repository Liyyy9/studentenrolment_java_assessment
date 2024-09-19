package java_assessment.service;

import java_assessment.model.Course;
import java_assessment.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseService {

    // attribute students as a Hashmap of students <id, Student>
    HashMap<String, List<Student>> enrolledStudents = new HashMap<>();                 // enrolled students

    // attribute courses as a Hashmap of courses
    HashMap<String, Course> courses = new HashMap<>();                                 // courses

    // constructor to initialise our values for students and courses
    public CourseService() {
        courses.put("INTRO-CS-1", new Course("Introduction to Computer Science", "INTRO-CS-1", 9));
        courses.put("INTRO-CS-2", new Course("Introduction to Algorithms", "INTRO-CS-2", 9));
        courses.put("INTRO-CS-3", new Course("Algorithm Design and Problem Solving - Introduction ", "INTRO-CS-3", 9));
        courses.put("INTRO-CS-4", new Course("Algorithm Design and Problem Solving - Advanced", "INTRO-CS-4", 9));
        courses.put("INTRO-CS-5", new Course("Terminal Fundamentals", "INTRO-CS-5", 9));
        courses.put("INTRO-CS-6", new Course("Source Control Using Git and Github", "INTRO-CS-6", 9));
        courses.put("INTRO-CS-7", new Course("Agile Software Development with SCRUM", "INTRO-CS-7", 9));
    }

    public void enrollStudent(String courseId, Student student){
        // TODO enrol a student to a course
        // TODO 1. check if student is enrolled to a course
        // TODO 2. if not, create a new course with an empty arrayList
        // TODO 3. enrol the student to the course by ID
        if ( !enrolledStudents.containsKey( courseId ) )
        {
            enrolledStudents.put( courseId, new ArrayList<>() );
        }
        enrolledStudents.get( courseId ).add( student );
    }

    public Course getCourse(String courseId) {
        return courses.get(courseId);
    }

    public void showSummary()
    {
        System.out.println( "Available Courses:" );
        for ( String key : courses.keySet() )
        {
            Course course = courses.get( key );
            System.out.println( course );
        }
        System.out.println( "Enrolled Students" );
        for ( String key : enrolledStudents.keySet() )
        {
            List<Student> students = enrolledStudents.get( key );
            System.out.println( "Students in Course " + key + ": " );
            for ( Student student : students )
            {
                System.out.println( student );
            }
        }
    }

}
