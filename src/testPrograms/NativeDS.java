package testPrograms;

import java.lang.annotation.*;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NativeDS {
    @Kaliable(name = "Now", id = 43)
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(5);
        st.push(-7);
        st.pop();
        System.out.println(st.toString());
        System.out.println();
        Object obj = new Object();
        Day today = Day.SATURDAY;

        List<Integer> test = new ArrayList<Integer>(List.of(3, -2, 0, 1, 11, -6, 4, 17, -9, -23));
        Collections.sort(test);
        System.out.println(test);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Kaliable {
        int id() default 10;

        String name();
    }

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }
}