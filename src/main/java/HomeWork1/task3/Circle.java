package HomeWork1.task3;

public class Circle extends Figure{
    public Circle(String name) {
        super(name);
    }

    @Override
    public void corner() {
        System.out.println(toString() + "нет углов");
    }

}
