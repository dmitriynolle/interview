package homeWork2.linkList;

public class LinkList<T> {
    private Link first;
    private int size = 0;

    public LinkList() {
        first = null;
    }

    public void addLink(T data) {
        Link<T> link = new Link(data);
        if (first != null) first.next = link;
        link.prev = first;
        first = link;
        size++;
    }

    public void printList() {
        Link currentLink = first;
        System.out.println("List:");
        while (currentLink != null) {
            currentLink.printLink();
            currentLink = currentLink.prev;
        }
    }

    public int getSize() {
        return size;
    }

    public Link delete(T data) {
        Link currentLink = first;
        Link temp = first;
        if (first == null) {
            return null;
        }
        while (currentLink != null) {
            if (currentLink.data == data) {
                currentLink.prev.next = currentLink.next;
                if (currentLink.next == null) first = currentLink.prev;
                else currentLink.next.prev = currentLink.prev;
                size--;
                break;
            }
            currentLink = currentLink.prev;
        }
        return temp;
    }
}
