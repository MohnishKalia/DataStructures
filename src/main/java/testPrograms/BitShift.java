package testPrograms;

import java.awt.*;

public class BitShift {
    public static void main(String[] args) {
        int code = hash();
        String actual = "01111100111000000000001100000010";

        // used for asserting that the method works
        System.out.println(Integer.parseInt(actual, 2));
        System.out.println(code);
        System.out.println(actual);
        System.out.println("0" + Integer.toBinaryString(code));
    }

    private static int hash() {
        Color col = new Color(255, 0b00111111, 0);
        Point loc = new Point(3, 2);

        /*
         * Operations and Sample Calculation:
         * 
         * 3 is 00000011, 3 << 5 will add 5 zeros to the end of the binary, or 01100000
         * (011 + 5 zeros) 00111111 >> 3 will delete the last 3 bits, making it 00111
         * 
         * There are 5 open spots at the end of 3<<5. When 3 << 5 | 00111111 >> 3
         * (bitwise or), it will copy the right side into the blank spaces of the left
         * side
         * 
         * 3 << 5 | 00111111 >> 3 = 01100111 (011 + 00111)
         * 
         * Repeat for concatenation
         */

        int hashCode = (col.getRed() >> 3); // shifting right by 3 will leave only 5 bits of value
        hashCode = (hashCode << 5) | (col.getGreen() >> 3);
        hashCode = (hashCode << 5) | (col.getBlue() >> 3);
        hashCode = (hashCode << 8) | loc.x; // loc.x is already 8 bits, no shift needed
        hashCode = (hashCode << 8) | loc.y;
        return hashCode;
    }
}