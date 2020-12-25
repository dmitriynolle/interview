package HomeWork1.task3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle("Круг");
        Figure square = new Square("Квадрат");
        Figure triangle = new Triangle("Треугольник");
        List<Figure> figures = Arrays.asList(circle, square, triangle);
        for (Figure d : figures) {
            d.corner();
        }
    }
}
