import java.util.Date;
import java.util.Objects;

/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */
public class Student {
    private String firstname;
    private String lastname;
    private long studentId;
    private double weight;
    private Date birthday;

    public Student(String firstname, String lastname, long studentId, double weight, Date birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentId = studentId;
        this.weight = weight;
        this.birthday = birthday;
    }


    public Student() {
        new Student(null, null, 0, 0, new Date(0));
    }

    public enum SortKey {FIRSTNAME, LASTNAME, STUDENT_ID, WEIGHT, BIRTHDAY}

    /*
        Getters and Setters for all fields except setting studentID
     */
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public double getWeight() {
        return weight;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getStudentId() {
        return studentId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return this.firstname + " " + this.lastname;
    }

    @Override
    public boolean equals(Object other) {
        // If the object is compared with itself then return true
        if (other == this) {
            return true;
        }

        if(!(other instanceof Student o)) {
            return false;
        }
        // typecasting after ensuring it is a Student instance
        // Only the studentId sets two students apart, any other field could be duplicate for two very similar persons
        return this.studentId == o.getStudentId();
    }

    @Override
    public String toString() {
        return this.firstname + ' ' + this.lastname + ' ' + this.studentId + ' ' + this.birthday + ' ' + this.weight;
    }

}
