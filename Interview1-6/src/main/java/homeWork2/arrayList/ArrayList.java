package homeWork2.arrayList;

import java.util.Arrays;

public class ArrayList<E> {
    private final int DEFAULT_SIZE = 4;
    private Object[] data = new Object[DEFAULT_SIZE];
    private int size = 0;

    public boolean add(E data) {
        if (size >= this.data.length / 2) {
            increaseSize();
        }
        this.data[size++] = data;
        return true;
    }

    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) data[index];
    }
    public void remove(int index){
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        data[size] = null;
        size--;
    }

    public int size(){
        return size;
    }

    private void increaseSize() throws RuntimeException {
        data = Arrays.copyOf(data, data.length * 2);
    }
}

