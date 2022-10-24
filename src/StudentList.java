import java.io.*;
import java.util.ArrayList;

/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */
public class StudentList {

    private ArrayList<Student> studentList;

    public StudentList() {
        this.studentList = new ArrayList<Student>();
    }

    public StudentList(StudentList that)  {
        /*
             TODO: Since strings are immutable in Java, we need to convert all elements of each Student
              to a String and parse it back to an object, only that way we avoid using libraries.
         */
        this.studentList = that.getStudentList();
    }


    /*
        2.8 All StudentList Methods
     */

    // Helper methods, determining whether a student is already part of the studentList
    public boolean containsStudent(Student student) {
        for (Student s: studentList) {
            if (s.equals(student)) {
                return true;
            }
        }
        return false;
    }

    /**
     *  Adds a student to the student list, if the student doesn't exist yet.
     * @param student A Student object
     * @return A boolean whether or not the student was added
     */
    public boolean add(Student student) {
        if (this.containsStudent(student)) {
            return false;
        } else {
            this.studentList.add(student);
            return true;
        }
    }

    /**
     *  Removes a given student from the Student List
     * @param student A student object
     * @return True if given Student was removed and false the Student was not
     *          in the list
     */
    public boolean remove(Student student) {
        for(int i = 0; i < this.studentList.size(); i++) {
            Student currStudent = this.studentList.get(i);
            if (currStudent.equals(student)) {
                this.studentList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student remove(int pos) {
        try {
            return this.studentList.remove(pos);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Student get(int pos) {
        try {
            return this.studentList.get(pos);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * Returns a list of positions of Students who's last name match the one from the input param.
     * @param lastname
     * @return a list of positions of Students who's last name match the one from the input param.
     */
    public ArrayList<Integer> findLastname(String lastname) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).getLastname() == lastname) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<Integer> findFirstname(String firstname) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).getFirstname() == firstname) {
                result.add(i);
            }
        }
        return result;
    }

    public int findStudentId(long studentId) {
        for (Student student : this.studentList) {
            if (student.getStudentId() == studentId) {
                return Long.valueOf(studentId).intValue();
            }
        }
        return -1;
    }

    public int size() {
        // You allowed this method ;)
        return this.studentList.size();
    }

    private boolean containsId(final long studentId) {
        for (Student student : this.studentList) {
            if (student.getStudentId() == studentId) {
                return true;
            }
        }
        return false;
    }

    /**
        Get and Set Student List
     */
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        String finalString = "";
        for (Student s : this.studentList) {
            finalString += s.toString() + "\n";
        }
        return finalString;
    }
}
