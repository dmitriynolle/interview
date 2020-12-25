package homeWork2.linkList;

public class Link<T> {
    public T data;
    public Link next;
    public Link prev;

    public Link(T data) {
        this.data = data;
    }

    public void printLink() {
        System.out.println(data);
    }
}
