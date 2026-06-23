import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while(true) {

            System.out.println("\n===== Student Registration System =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    dao.addStudent(
                            new Student(name, email, course)
                    );
                    break;

                case 2:

                    List<Student> students =
                            dao.getAllStudents();

                    for(Student s : students) {
                        System.out.println(
                                s.getId() + " | " +
                                s.getName() + " | " +
                                s.getEmail() + " | " +
                                s.getCourse()
                        );
                    }
                    break;

                case 3:

                    System.out.print("Student ID: ");
                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    dao.updateStudent(updateId, newCourse);

                    break;

                case 4:

                    System.out.print("Student ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);

                    break;

                case 5:

                    System.out.println("Thank You!");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}