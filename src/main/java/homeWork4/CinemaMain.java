package homeWork4;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CinemaMain {

    public static void main(String[] args) {
        long time = 0;
        List<DaySchedule> daySchedules = new ArrayList<>();
        List<Counter>counters = new ArrayList<>();

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
                daySchedules.add(new DaySchedule(rs.getTime(1), rs.getString(2), rs.getTime(3), rs.getDouble(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Накладки в расписании");
        for (int i = 0; i < daySchedules.size(); i++) {
            long ttime = daySchedules.get(i).time.getTime() / 60000;
            if (ttime - time < 0 && time != 0) {
                System.out.printf("%-30s | %-8s | %-8s || %-30s | %-8s | %-8s %n", daySchedules.get(i - 1).name, daySchedules.get(i - 1).time, daySchedules.get(i - 1).timeFilm, daySchedules.get(i).name, daySchedules.get(i).time, daySchedules.get(i).timeFilm);
            }
            time = daySchedules.get(i).time.getTime() / 60000 + (180 + daySchedules.get(i).timeFilm.getTime() / 60000);
        }

        System.out.println("Перерывы больше или равнык 30 минутам");
        for (int i = 0; i < daySchedules.size(); i++) {
            long ttime = daySchedules.get(i).time.getTime() / 60000;
            if (ttime - time >= 30 && time != 0) {
                System.out.printf("%-30s | %-8s | %-8s || %-30s | %-8s | %-8s %n", daySchedules.get(i - 1).name, daySchedules.get(i - 1).time, daySchedules.get(i - 1).timeFilm, daySchedules.get(i).name, daySchedules.get(i).time, daySchedules.get(i).timeFilm);
            }
            time = daySchedules.get(i).time.getTime() / 60000 + (180 + daySchedules.get(i).timeFilm.getTime() / 60000);
        }

        // Заполняем массив данными из базы
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
                            counters.add(new Counter(rsFilm.getInt(1), rsFilm.getString(2), rsCount.getInt(1), avg.getInt(1), rsCount1.getDouble(1)));
                        }
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        double count=0;
        Collections.sort(counters, Comparator.comparing(Counter::getCountMoney));
        System.out.println("Таблица с подчетами");
        System.out.printf("%-3s | %-30s | %-6s | %-6s %n", "№", "Название", "Билеты", "Сумма");
        for (Counter coun: counters) {
            System.out.printf("%-3s | %-30s | %-6s | %-6s %n", coun.id, coun.name, coun.countTicket, coun.countMoney);
            count+=coun.countMoney;
        }
        System.out.println("Среднее количество зрителей: " + counters.get(1).avgCountUser);
        System.out.println("Общая сумма выручки: " + count);
    }
}
