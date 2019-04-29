package sdp;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(processGrades(scanner));
  }

  private static String processGrades(Scanner scanner) {
    double sum = 0;
    int courses = 0;
    String checkval;
    while(scanner.hasNextLine()){
      scanner.next();
      scanner.next();
      checkval = scanner.next();
      System.out.println(checkval);
      if (checkval.equals("A")) {
        sum = sum + 4;
        courses = courses + 1;
      }
      if (checkval.equals("A-")) {
        sum = sum + 3.67;
        courses = courses + 1;
      }
      if (checkval.equals("B+")) {
        sum = sum + 3.33;
        courses = courses + 1;
      }
      if (checkval.equals("B")) {
        sum = sum + 3;
        courses = courses + 1;
      }
      if (checkval.equals("B-")) {
        sum = sum + 2.67;
        courses = courses + 1;
      }
      if (checkval.equals("C+")) {
        sum = sum + 2.33;
        courses = courses + 1;
      }
      if (checkval.equals("C")) {
        sum = sum + 2;
        courses = courses + 1;
      }
      if (checkval.equals("C-")) {
        sum = sum + 1.67;
        courses = courses + 1;
      }
      if (checkval.equals("D+")) {
        sum = sum + 1.33;
        courses = courses + 1;
      }
      if (checkval.equals("D")) {
        sum = sum + 1;
        courses = courses + 1;
      }
      if (checkval.equals("F")) {
        courses = courses + 1;
      }
    }
    System.out.println("Courses: \" + courses + \"\\nGPA: \" + sum/courses +\"\\n");
    return "Courses: " + courses + "\nGPA: " + sum/courses +"\n";
  }

  @Test
  public void emptyGradeListReportsZeroGpaAndNoCourses() {
    assertTotalsOfList_Are("", "Courses: 0\nGPA: 0.00\n");
  }

  @Test
  public void singleCourseGradeReportsItself() {
    assertTotalsOfList_Are("CS 234        A ", "Courses: 1\nGPA: 4.00\n");
    assertTotalsOfList_Are("MAT    234    A-", "Courses: 1\nGPA: 3.67\n");
    assertTotalsOfList_Are("ENGR 121      B+", "Courses: 1\nGPA: 3.33\n");
    assertTotalsOfList_Are("CS 234         B", "Courses: 1\nGPA: 3.00\n");
    assertTotalsOfList_Are("CS 234        B-", "Courses: 1\nGPA: 2.67\n");
    assertTotalsOfList_Are("ENGR 011     C+ ", "Courses: 1\nGPA: 2.33\n");
    assertTotalsOfList_Are("ENGR 101      C ", "Courses: 1\nGPA: 2.00\n");
    assertTotalsOfList_Are("ENGR 101    C-\n", "Courses: 1\nGPA: 1.67\n");
    assertTotalsOfList_Are("ENGR 101      D+", "Courses: 1\nGPA: 1.33\n");
    assertTotalsOfList_Are("CS 122L        D", "Courses: 1\nGPA: 1.00\n");
    assertTotalsOfList_Are("CS 122L        F", "Courses: 1\nGPA: 0.00\n");
  }

  @Test
  public void multipleCoursesAreAllComputed() {
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B",
            "Courses: 2\nGPA: 3.50\n");
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B\nCS 122     B-\n",
            "Courses: 3\nGPA: 3.22\n");

  }

  @Test
  public void withdrawnCoursesDontCountTowardsCoursesTaken() {
    assertTotalsOfList_Are("CS 122L      W", "Courses: 0\nGPA: 0.00\n");
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B\nCS 122     W\n",
            "Courses: 2\nGPA: 3.50\n");
  }

  private void assertTotalsOfList_Are(String input, String output) {
    assertEquals(output, processGrades(new Scanner(input)));
  }
}
