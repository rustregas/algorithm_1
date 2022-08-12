package pro.sky.java.course2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListImpl {

    String[] stringList = new String[0];


    public StringListImpl() {

    }

    public String add(String item) {
        int size = stringList.length;

        if(item==null){
            throw new IllegalArgumentException("Не должен быть нулл");
        }
        String[] stringList2 = Arrays.copyOf(stringList, stringList.length + 1);
        stringList2[stringList.length] = item;
        stringList = stringList2;
        return stringList[size];
    }

    public String add(int index, String item) {
        int size = stringList.length;

        if (index >= size) {
            throw new IndexOutOfBoundsException("Вышел за пределы");
        } else {
            String[] stringList2 = new String[stringList.length + 1];

            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    stringList2[i] = item;
                } else {
                    stringList2[i] = stringList[i];
                }
            }

            for (int i = index + 1; i < size + 1; i++) {
                stringList2[i] = stringList[i-1];
            }

            stringList = stringList2;
            return stringList[index];
        }
    }

    public String set(int index, String item) {
        int size = stringList.length;

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            stringList[index] = item;
            return stringList[index];
        }
    }

    public String remove(String item) {
        int size = stringList.length;

        if (!Arrays.asList(stringList).contains(item)) {
            throw new IllegalArgumentException();
        } else if(size == 1) {
            String delElement = stringList[0];
            stringList[0] = null;
            return delElement;
        } else
            {
            stringList = (String[]) Arrays.stream(stringList)
                    .filter(str -> str.equals(item))
                    .toArray();
            return item;
        }
    }

    public String remove(int index) {
        int size = stringList.length;

        if (index >= size) throw new IndexOutOfBoundsException();
        else if(size == 1) {
            String delElement = stringList[index];
            stringList[index] = null;
            return delElement;
        }
        else {
            String delElement = stringList[index];
            stringList[index] = null;
            System.out.println(stringList[index]);
            stringList = (String[]) Arrays.stream(stringList)
                    .filter(str -> str==null)
                    .toArray();
            return delElement;
        }
    }

    public boolean contains(String item) {
        return Arrays.stream(stringList)
                .anyMatch(str -> str.equals(item));
    }

    public int indexOf(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String item) {
        for (int i = stringList.length-1; i > 0; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public String get(int index) {
        if (index < stringList.length) {
            return stringList[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean equals(String[] otherList){

        if (otherList == null){
            throw new IllegalArgumentException();
        }

        if (stringList.length != otherList.length){
            return false;
        }

        for (int i = 0; i < stringList.length; i++) {
            if(!stringList[i].equals(otherList[i])){
                return false;
            }
        }
        return true;
    }

    public int size(){
        return stringList.length;
    }

    public boolean isEmpty(){
        return Arrays.stream(stringList).noneMatch(str -> str != null);
    }

    public void clear(){
//        Object[] stringList2 = Arrays.stream(stringList).map(v -> (String) null).toArray();
        for (int i = 0; i < stringList.length; i++) {
            stringList[i]=null;
        }
    }

    public String[] toArray(){
        String[] result;
        result = stringList;
        return result;
    }

}
