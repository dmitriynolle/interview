package homeWork1.task3;

public class Triangle extends Figure{
    public Triangle(String name) {
        super(name);
    }

    @Override
    public void corner() {
        System.out.println(toString() + "3 угла");
    }
}
