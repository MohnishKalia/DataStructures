package assignment4;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class DequeCLI {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            DeQueDLL<Integer> deque = new DeQueDLL<>();
            outer: while (true) {
                // make a list by dequing entirety of the dequeue and inserting into an arraylist
                ArrayList<Integer> elts = new ArrayList<Integer>();
                for (int i = 0, dequeSize = deque.size(); i < dequeSize; i++)
                    elts.add(deque.dequeueFront());

                System.out.println("Choose an operation - 1: Insert, 2: Delete, 3: Exit");

                switch (input.nextInt()) {
                case 1:
                    System.out.println("Enter the integer you wish to insert into the deque:");
                    elts.add(input.nextInt());
                    Collections.sort(elts);
                    // sort list, then enqueue all the elements to the rear (in ascending order)
                    for (int i : elts)
                        deque.enqueueRear(i);
                    break;
                case 2:
                    System.out.println("Enter the integer you wish to delete from the deque:");
                    elts.remove((Integer) input.nextInt());
                    // remove the element (if it exists), then enqueue all the elements to the rear (in ascending order)
                    for (int i : elts)
                        deque.enqueueRear(i);
                    break;
                case 3:
                    // breaks the infinite loop and ends program
                    break outer;
                default:
                    System.out.println("Invalid operation, please choose a listed option.");
                }

                System.out.println("Deque: " + deque.toString());
            }
        }
    }
}