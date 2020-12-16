package HomeWork1.task3;

public class Figure {
    private String name;

    public Figure (String name){
        this.name = name;
    }
    public void corner(){
        System.out.println(toString() + "Неизвестно");
    }
    @Override
    public String toString(){
        return name + " ";
    }
}
