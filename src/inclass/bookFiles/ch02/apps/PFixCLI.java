//----------------------------------------------------------------------
// PFixCLI.java           by Dale/Joyce/Weems                  Chapter 2
//
// Evaluates postfix expressions entered by the user.
// Uses a command line interface.
//----------------------------------------------------------------------
package inclass.bookFiles.ch02.apps;

import java.util.Scanner;
import java.util.stream.Stream;
import java.util.IntSummaryStatistics;

import inclass.bookFiles.ch02.postfix.PostFixEvaluator;
import inclass.bookFiles.ch02.postfix.PostFixException;

public class PFixCLI {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String expression = null; // expression to be evaluated
    final String STOP = "X"; // indicates end of input
    int result; // result of evaluation

    while (!STOP.equals(expression)) {
      // Get next expression to be processed.
      System.out.print("\nPostfix Expression (" + STOP + " to stop): ");
      expression = scan.nextLine();

      if (!STOP.equals(expression)) {
        // Obtain and output result of expression evaluation.
        try {
          result = PostFixEvaluator.evaluate(expression);

          // Output result.
          System.out.println("Result = " + result);
        } catch (PostFixException error) {
          // Output error message.
          System.out.println("Error in expression - " + error.getMessage());
        }
        IntSummaryStatistics nums = Stream.of(expression.split(" ")).filter(token -> token.matches("-?\\d+"))
            .mapToInt(Integer::parseInt).summaryStatistics();
        System.out.println("**STATISTICS**\nLargest Number: " + nums.getMax() + "\nSmallest Number: " + nums.getMin()
            + "\nCount: " + nums.getCount() + "\nAverage: " + nums.getAverage());
      }
    }
  }
}
