import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {

        String query =
                "INSERT INTO students(name,email,course) VALUES(?,?,?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String query = "SELECT * FROM students";

        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query)) {

            while(rs.next()) {

                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course")
                ));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public void updateStudent(int id, String course) {

        String query =
                "UPDATE students SET course=? WHERE id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, course);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Student Updated!");
            else
                System.out.println("Student Not Found!");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {

        String query =
                "DELETE FROM students WHERE id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Student Deleted!");
            else
                System.out.println("Student Not Found!");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}