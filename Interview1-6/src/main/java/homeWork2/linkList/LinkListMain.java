package homeWork2.linkList;

public class LinkListMain {
    public static void main(String[] args) {
        LinkList<String> newList = new LinkList();
        newList.addLink("1");
        newList.addLink("2");
        newList.addLink("3");
        newList.addLink("4");
        newList.printList();
        newList.delete("2");
        newList.printList();
        System.out.println("Размер: " + newList.getSize());
    }
}
