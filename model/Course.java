package java_assessment.model;

public class Course {

    // attributes for the Course
    String name;    // name
    String id;      // id
    int credit;     // credits

    public Course(String name, String id, int credit) {
        this.name = name;
        this.id = id;
        this.credit = credit;
    }

    public Course() {
        name = "";
        id = "";
        credit = 0;
    }

    public int getCredit() {
        return credit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override // OVERRIDE the default toString() method
    public String toString() { // for a Java class
        return "Course{'" +
                "name':'" +
                name + "'," +
                "'id':'" +
                id + "'," +
                "'credits':" +
                credit + "}";

    }
}