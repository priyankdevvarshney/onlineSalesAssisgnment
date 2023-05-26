import org.example.EventSimulator;

import java.util.HashMap;
import java.util.Map;
//**********************DESCRIPTION****************
//These test cases call the simulateOccurrences method with the respective
// input maps and the number of occurrences to simulate.
// After running the simulation, it prints a message indicating that the test is completed.

public class EventSimulatorTest {
    public static void main(String[] args) {
        // Test case 1: Rolling of a six-faced biased dice
        Map<Integer, Integer> diceProbabilities = new HashMap<>();
        diceProbabilities.put(1, 10);
        diceProbabilities.put(2, 30);
        diceProbabilities.put(3, 15);
        diceProbabilities.put(4, 15);
        diceProbabilities.put(5, 30);
        diceProbabilities.put(6, 0);
        simulateOccurrencesTest(diceProbabilities, 1000);

        // Test case 2: Flipping of a coin
        Map<String, Integer> coinProbabilities = new HashMap<>();
        coinProbabilities.put("Head", 35);
        coinProbabilities.put("Tail", 65);
        simulateOccurrencesTest(coinProbabilities, 1000);
    }

    public static void simulateOccurrencesTest(Map<?, Integer> probabilities, int numOccurrences) {
        EventSimulator.simulateOccurrences(probabilities, numOccurrences);
        System.out.println("Unit Test Case ");
    }
}
