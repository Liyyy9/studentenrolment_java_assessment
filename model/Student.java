package java_assessment.model;

import java.util.*;

public class Student implements Evaluation{

    // attributes for the student
    String firstName;                   // first name
    String lastName;                    // last name
    String email;                       // email
    Date birthdate;                      // birthday
    int grade;                          // grade
    String id;                          // id

    // student's enrolled courses
    ArrayList<Course> enrolledCourses = new ArrayList<>();

    Map<String, Course> approvedCourses = new HashMap<>();

    Map<String, Integer> courseGrades = new HashMap<>();

    public Student(String firstName, String lastName, String email, Date birthdate, String id) {           // default constructor to create an of a student
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
        this.grade = 0;
        this.id = id;
    }

    public Integer getCourseGrades(String courseId) {
        return courseGrades.get(courseId);
    }

    public void setCourseGrades(String courseId, int grades) {
        if(approvedCourses.containsKey(courseId)){
            courseGrades.put(courseId, grades);
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getGrade(String courseId) {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean enrollToCourse(Course course){
        // TODO 1. if the course is not found in approvedCourses,
        // TODO 2. add it to the student's approvedCourses
        if (!approvedCourses.containsKey(course.getId())) {              // Hashmap is a key, value pair
            approvedCourses.put(course.getId(), course);
        }
        return enrolledCourses.add(course);
    }

    public int totalEnrolledCourses(){
        return enrolledCourses.size();
    }

    public boolean unEnrollCourse(Course course){
        return enrolledCourses.remove(course);
    }

    public void printFullName(){
        System.out.println(this.firstName + " " + this.lastName);
    }

    public ArrayList<Course> getEnrolledCourses(){
        return enrolledCourses;
    }

    public boolean isApproved(String courseId){
        return approvedCourses.containsKey(courseId);
    }

    public boolean isAttendingCourse(String courseId){              // check if the student is enrolled to a course
        // TODO return true if the student is attending the course by courseId
        // TODO use enrolledCourses to determine if the student is attending
        for (Course course : enrolledCourses){
            if (course.getId().equals(courseId)){
                return true;
            }
        }
        return false;
    }

    public List<Course> findPassedCourses(Course course) {
        List<Course> passedCourses = new ArrayList<>();
        if(courseGrades.get(course.getId())>= 75) {
            passedCourses.add(course);
            return passedCourses;
        }
        return null;
    }



    @Override                                                                                                           // Overriding the default toString() method of a java class
    public String toString(){
        return "Student{'" + "firstName': '" +
                firstName + "', '" + "lastName': '" +
                lastName + "', '" +
                "grade': " + grade + ", '" +
                "email': " + email + ", '" +
                 "birth date': " + birthdate + ", '" +
                "id': '" + id + "'}";
    }

    @Override
    public double getAverage() {
        double totalScore = 0;
        int count = 0;

        for (String key : courseGrades.keySet()){
            totalScore += courseGrades.get(key);
            count++;
        }
        return totalScore/count;
    }

    @Override
    public List<Course> getApprovedCourses() {
        // TODO implement this method
        // TODO 1. return the list of courses that are found in approved courses
        ArrayList<Course> approvedCourses = new ArrayList<>();
        boolean status = approvedCourses.addAll(this.approvedCourses.values());
        if(status == false){
            return null;
        }
        return approvedCourses;
    }

}
