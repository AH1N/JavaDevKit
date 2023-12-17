package schoolDeBe.Program;

import schoolDeBe.models.Courses;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Main {

    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Hello schoolDeBe!");

        String url = "jdbc:mysql://localhost:3307"; // "jdbc:mysql://localhost:3307/schoolDB"
        String user = "root";
        String password = "password";

        //connect to DB
        try(Connection connection = DriverManager.getConnection(url,user, password)){
            //connect to DB
            //Connection connection = DriverManager.getConnection(url,user, password);
            //create to DB
            createDatabase(connection);
            System.out.println("> > > DB CREATED !");
            //use to DB
            useDatabase(connection);
            System.out.println("> > > DB ENGAGED !");
            //create Table
            creteTable(connection);
            System.out.println("> > > TABLE CREATED !");

            int count = random.nextInt(5,11);

            for (int i = 0; i < count; i++) {
                insertData(connection, Courses.create());
            }
            System.out.println("> > > INSERT DATA SUCCESSFUL !");

            Collection<Courses> courses = readData(connection);
            for (Courses course: courses) {
                System.out.println(course.toString());
            }
            System.out.println("> > > READ DATA SUCCESSFUL !");

            for (Courses course: courses) {
                course.updateTitle();
                course.updateDuration();
                updateData(connection, course);
            }
            System.out.println("> > > UPDATE DATA SUCCESSFUL !");
//            connection.close();
//            System.out.println("> > > DB DISCONNECTED!");

            for (Courses course: courses) {
                deleteData(connection, course.getId());
            }
            System.out.println("> > > DELETE DATA SUCCESSFUL !");

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    //HELP METHODS>>>

    private static void createDatabase(Connection connection) throws SQLException{
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS schoolDB;";
        try(PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException{
        String useDatabaseSQL = "USE schoolDB";
        try(PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void creteTable(Connection connection) throws SQLException{
        String createTableSQL = "CREATE Table IF NOT EXISTS Courses (id INT AUTO_INCREMENT PRiMARY key, title VARCHAR(255), duration INT);";
        try(PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    private static void insertData(Connection connection, Courses course) throws SQLException{
        String insertDataSQL = "INSERT INTO Courses (title, duration) VALUES (?, ?);";
        try(PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {

            statement.setString(1,course.getTitle());
            statement.setInt (2,course.getDuration());
            statement.execute();
        }
    }

    private static Collection<Courses> readData(Connection connection) throws SQLException{

        ArrayList<Courses> coursesList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM Courses;";
        try(PreparedStatement statement = connection.prepareStatement(readDataSQL)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getNString("title");
                int duration = resultSet.getInt("duration");
                coursesList.add(new Courses(id,title,duration));
            }
        }
        return coursesList;
    }

    private static void updateData(Connection connection, Courses courses) throws SQLException{
        String updateDataSQL = "UPDATE Courses SET title=?, duration=? WHERE id=?;";
        try(PreparedStatement statement = connection.prepareStatement(updateDataSQL)){
            statement.setString(1,courses.getTitle());
            statement.setInt (2,courses.getDuration());
            statement.setInt (3,courses.getId());
            statement.executeUpdate();
        }
    }

    private static void deleteData(Connection connection, int id) throws SQLException{
        String deleteDataSQL = "DELETE FROM Courses WHERE id=?";
        try(PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
    //HELP METHODS<<<
}