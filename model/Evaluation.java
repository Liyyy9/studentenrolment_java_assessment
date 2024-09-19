package java_assessment.model;

import java.util.List;

public interface Evaluation                             // business rules for any entities that require Evaluation methods
{
    double getAverage();                                // method signatures

    List<Course> getApprovedCourses();                  // method signatures

}