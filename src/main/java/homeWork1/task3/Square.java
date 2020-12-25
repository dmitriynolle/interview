package homeWork1.task3;

public class Square extends Figure {
    public Square(String name) {
        super(name);
    }

    @Override
    public void corner() {
        System.out.println(toString() + "4 угла");
    }
}
