package homeWork2.arrayList;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size());
        arrayList.remove(3);
        System.out.println(arrayList.size());
    }
}
