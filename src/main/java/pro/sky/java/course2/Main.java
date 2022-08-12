package pro.sky.java.course2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //String[] str1 = {"n1", "n2"};
        StringListImpl str = new StringListImpl();

        System.out.println(str.add("dsaf"));
        System.out.println(str.remove(0));
        System.out.println(str.get(0));
    }
}
