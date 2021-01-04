package homeWork4;

public class Counter {
    int id;
    String name;
    int countTicket;
    int avgCountUser;
    double countMoney;

    public Counter(int id, String name, int countTicket, int avgCountUser, double countMoney) {
        this.id = id;
        this.name = name;
        this.countTicket = countTicket;
        this.avgCountUser = avgCountUser;
        this.countMoney = countMoney;
    }

    public double getCountMoney() {
        return countMoney;
    }
}
