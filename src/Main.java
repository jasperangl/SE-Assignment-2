/* HelloWorld.java
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */
public class Main
{
    // A test modification
    // Another change
    public static void main(String[] args) {
        // Here we will write all of our tests for now
        System.out.println("Hello World!");
        testRemoveByIndex();
    }

    public static void testRemoveByIndex() {
        Student jason = new Student("Jason", "Bourne", 1, 80.4, new Date(2000, 6, 20));
        Student jasonCopy = new Student("Jason", "Bourne", 1, 80.4, new Date(2000, 6, 20));
        Student anna = new Student("Anna", "Bourne", 2, 72, new Date(2000, 9, 20));
        Student peter = new Student("Peter", "Pahn", 3, 72.9, new Date(2000, 10, 20));
        Student nina = new Student("Nina", "Ball", 4, 80.4, new Date(2000, 6, 20));
        Student dieter = new Student("Dieter", "Bohlen", 5, 80.4, new Date(2000, 6, 20));
        Student tom = new Student("Tom", "Tewes", 6, 72, new Date(2000, 9, 20));
        Student mark = new Student("Mark", "Tewes", 7, 72.9, new Date(2000, 10, 20));
        Student philipp = new Student("Philipp", "Lehmann", 8, 75.9, new Date(1900, 10, 20));
        Student malte = new Student("Malte", "Jakschik", 9, 78.9, new Date(2005, 8, 20));

        StudentList studentList = new StudentList();
        boolean s1 = studentList.add(jason);
        boolean s2 = studentList.add(anna);
        boolean s3 = studentList.add(peter);
        boolean s1c = studentList.add(jasonCopy);
        boolean s4 = studentList.add(nina);
        boolean s5 = studentList.add(dieter);
        boolean s6 = studentList.add(tom);
        boolean s7 = studentList.add(mark);

        StudentList stdListCopy = new StudentList(studentList);

        System.out.println(studentList.equals(stdListCopy));
        System.out.println(studentList.get(5));
        System.out.println(stdListCopy.get(5));
        stdListCopy.remove(5);
        System.out.println(studentList.get(5));
        System.out.println(stdListCopy.get(5) + "\n");
        System.out.println(stdListCopy.toString());

    }
}
