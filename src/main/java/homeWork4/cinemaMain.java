package homeWork4;

import java.sql.*;

public class cinemaMain {

    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/kino?serverTimezone=UTC";
        String username = "root";
        String password = "password1!";
        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection to Store DB succesfull!");

            // getting Statement object to execute query
            Statement stmt = conn.createStatement();

            // executing SELECT query
            ResultSet rs = stmt.executeQuery("SELECT c.time_schedule, b.name_film, b.time_film, a.price FROM day_schedule as a join film as b" +
                    " on a.film_day_schedule = b.id_film join schedule as c " +
                    "on a.sch_day_schedule = c.id_schedule order by c.time_schedule");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getInt(3) + " | " + rs.getDouble(4));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
