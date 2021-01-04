package homeWork4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cinemaMain {

    public static void main(String[] args) {
        long time = 0;
        List<daySchedule> daySchedules = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/kino?serverTimezone=Europe/Moscow";
        String username = "root";
        String password = "password1!";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to Store DB succesfull!");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT c.time_schedule, b.name_film, b.time_film, a.price FROM day_schedule as a join film as b" +
                    " on a.film_day_schedule = b.id_film join schedule as c " +
                    "on a.sch_day_schedule = c.id_schedule order by c.time_schedule");

            while (rs.next()) {
                daySchedules.add(new daySchedule(rs.getTime(1), rs.getString(2), rs.getTime(3), rs.getDouble(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Накладки в расписании");
        for (int i = 0; i < daySchedules.size(); i++) {
            long ttime = daySchedules.get(i).time.getTime() / 60000;
            if (ttime - time < 0 && time != 0) {
                System.out.println(daySchedules.get(i - 1).name + " | " + daySchedules.get(i - 1).time + " | " + daySchedules.get(i - 1).timeFilm + " || " + daySchedules.get(i).name + " | " + daySchedules.get(i).time + " | " + daySchedules.get(i).timeFilm);
            }
            time = daySchedules.get(i).time.getTime() / 60000 + (180 + daySchedules.get(i).timeFilm.getTime() / 60000);
        }

        System.out.println("Перерывы больше 30 минут");
        for (int i = 0; i < daySchedules.size(); i++) {
            long ttime = daySchedules.get(i).time.getTime() / 60000;
            if (ttime - time >= 30 && time != 0) {
                System.out.println(daySchedules.get(i - 1).name + " | " + daySchedules.get(i - 1).time + " | " + daySchedules.get(i - 1).timeFilm + " || " + daySchedules.get(i).name + " | " + daySchedules.get(i).time + " | " + daySchedules.get(i).timeFilm);
            }
            time = daySchedules.get(i).time.getTime() / 60000 + (180 + daySchedules.get(i).timeFilm.getTime() / 60000);
        }

        System.out.println("Список фильмов");
        try {
            Statement stmt = conn.createStatement();
            ResultSet rsFilm = stmt.executeQuery("select * from film");
            while (rsFilm.next()) {
                PreparedStatement prst = conn.prepareStatement("SELECT count(*) FROM ticket as a join day_schedule as b on a.id_day_schedule = b.id_day_schedule where b.film_day_schedule = ?");
                prst.setInt(1, rsFilm.getInt(1));
                ResultSet rsCount = prst.executeQuery();
                while (rsCount.next()) {
                    Statement stmt1 = conn.createStatement();
                    ResultSet avg = stmt1.executeQuery("select count(id_ticket)/(select count(distinct id_day_schedule)from ticket) from ticket");
                    while (avg.next()) {
                        PreparedStatement prst1 = conn.prepareStatement("SELECT sum(price) FROM day_schedule as a join ticket as b on a.id_day_schedule = b.id_day_schedule where a.film_day_schedule = ?");
                        prst1.setInt(1, rsFilm.getInt(1));
                        ResultSet rsCount1 = prst1.executeQuery();
                        while (rsCount1.next()) {
                            System.out.println(rsFilm.getInt(1) + " " + rsFilm.getString(2) + " Кол-во билетов: " + rsCount.getInt(1) + " Среднее число зрителей за сеанс: " + avg.getInt(1) + " Сумма сбора: " + rsCount1.getDouble(1));
                        }
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
