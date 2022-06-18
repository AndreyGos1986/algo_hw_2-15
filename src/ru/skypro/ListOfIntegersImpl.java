package ru.skypro;

import java.util.Arrays;

public class ListOfIntegersImpl implements ListOfIntegers {
    private int size = 0;
    private int capacity = 10;
    private Integer[] listOfInt;
    private int index = 0;

    public ListOfIntegersImpl() {
        listOfInt = new Integer[capacity];
    }

    public ListOfIntegersImpl(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            listOfInt = new Integer[this.capacity];
        } else {
            throw new IllegalArgumentException("недопустимое значение вместимости: " + capacity);
        }
    }

    @Override
    public Integer add(Integer item) {
        resizing();
        listOfInt[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkIndexRange(index);
        resizing();
        System.arraycopy(listOfInt, index, listOfInt, index + 1, size - index);
        listOfInt[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndexRange(index);
        int oldItem = listOfInt[index];
        listOfInt[index] = item;
        return oldItem;
    }

    @Override
    public Integer remove(Integer item) {
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        checkIndexRange(index);
        Integer item = listOfInt[index];
        System.arraycopy(listOfInt, index + 1, listOfInt, index, size - index);
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        int i = Arrays.binarySearch(Arrays.stream(listOfInt).distinct().toArray(), item);
        return i >= 0;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < listOfInt.length; i++) {
            if (listOfInt[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = listOfInt.length - 1; i >= 0; i--) {
            if (listOfInt[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndexRange(index);
        return listOfInt[index];
    }

    @Override
    public boolean equals(ListOfIntegers otherList) {
        if (otherList == null) {
            throw new NullPointerException("Список пуст");
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!listOfInt[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < listOfInt.length; i++) {
            listOfInt[i] = null;
            size = 0;
        }

    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(listOfInt, size);
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    private void resizing() {
        if (size == capacity) {
            capacity *= 2;
            listOfInt = Arrays.copyOf(listOfInt, capacity);
        }
    }

    private void checkIndexRange(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Неверный индекс: " + index + ", максимальный: " + (size - 1));
    }
}
