import org.example.MathExpressionEvaluator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//**********************DESCRIPTION****************
//The code defines a unit test case for the MathExpressionEvaluator program.
// It tests the evaluation of a set of mathematical expressions and compares
// the results with the expected values. The expressions and their corresponding
// expected results are defined as arrays. The test case captures the console
// output and splits it into individual lines. It then asserts that each line,
// after extracting the evaluated result, matches the expected result. The
// ByteArrayOutputStream and PrintStream classes are used to redirect and capture
// the console output. The Assertions.assertEquals method is used for result comparison.


public class MathExpressionEvaluatorTest {

    @Test
    public void testEvaluateMathExpressions() {
        String[] expressions = {
                "2 * 4 * 4",
                "5 / (7 - 5)",
                "Math.sqrt(Math.pow(5, 2) - Math.pow(4, 2))",
                "Math.sqrt(-Math.pow(3, 2) - Math.pow(4, 2))"
        };

        String[] expectedResults = {
                "32",
                "2.5",
                "3.0",
                "NaN"
        };

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        MathExpressionEvaluator.evaluateMathExpressions();

        System.setOut(originalOut);
        String[] printedLines = outputStream.toString().split(System.lineSeparator());

        // Asserting the results
        for (int i = 0; i < expressions.length; i++) {
            String expectedResult = expectedResults[i];
            String expressionResult = printedLines[i].substring(printedLines[i].indexOf(">") + 2);
            Assertions.assertEquals(expectedResult, expressionResult);
        }
    }
}
