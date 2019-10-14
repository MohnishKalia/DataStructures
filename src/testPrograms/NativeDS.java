package testPrograms;

import java.lang.annotation.*;
import java.util.Stack;

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
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Kaliable {
        int id() default 10;
        String name();
    }
}