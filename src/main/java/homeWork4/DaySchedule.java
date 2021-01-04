package homeWork4;

import java.sql.Time;

public class DaySchedule {
    Time time;
    String name;
    Time timeFilm;
    Double price;

    public DaySchedule(Time time, String name, Time timeFilm, Double price){
        this.time = time;
        this.name = name;
        this.timeFilm = timeFilm;
        this.price = price;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTimeFilm() {
        return timeFilm;
    }

    public void setTimeFilm(Time timeFilm) {
        this.timeFilm = timeFilm;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
