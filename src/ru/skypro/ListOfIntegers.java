package ru.skypro;

public interface ListOfIntegers {
    Integer add(Integer item);
    Integer add(int index, Integer item);
    Integer set(int index, Integer item);
    Integer remove(Integer item);
    Integer remove(int index);
    boolean contains(Integer item);
    int indexOf(Integer item);
    int lastIndexOf(Integer item);
    Integer get(int index);
    boolean equals(ListOfIntegers otherList);
    int size();
    boolean isEmpty();
    void clear();
    Integer[] toArray();
    int getCapacity();
}
