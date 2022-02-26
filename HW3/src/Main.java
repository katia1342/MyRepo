import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

public class Main {
    public static void main(String[] args) {

        Integer[] intArr = new Integer[2];

        intArr[0] = 1;
        intArr[1] = 2;

        System.out.println(Arrays.deepToString(intArr));
        swap(List.of(intArr), 0, 1);
        System.out.println(Arrays.deepToString(intArr));

        ArrayList<Integer> arrList = new ArrayList<>();

       
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> box1 = new Box<Apple>(apple1, apple2, apple3);
        Box<Orange> box2 = new Box<Orange>(orange1, orange2);

        System.out.println(box1.compare(box2));

        Box<Orange> box3 = new Box<Orange>();
        box2.transfer(box3);
    }
}