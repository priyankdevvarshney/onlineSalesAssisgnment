package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;
//**********************DESCRIPTION****************
//This code defines a class EventSimulator that contains a main method to
// demonstrate the usage of the program. It includes two test cases: rolling
// of a biased six-faced dice and flipping of a biased coin. The simulateOccurrences
// method accepts a map of outcomes and their probabilities, along with the number
// of occurrences to simulate. It generates random occurrences based on the given
// probabilities and prints the occurrence counts for each outcome.

//The output will display the occurrence counts for each outcome based on the given probabilities.

public class EventSimulator {
        private static final Random random = new Random();

        public static void main(String[] args) {
            // Test case 1: Rolling of a six-faced biased dice
            Map<Integer, Integer> diceProbabilities = new HashMap<>();
            diceProbabilities.put(1, 10);
            diceProbabilities.put(2, 30);
            diceProbabilities.put(3, 15);
            diceProbabilities.put(4, 15);
            diceProbabilities.put(5, 30);
            diceProbabilities.put(6, 0);
            simulateOccurrences(diceProbabilities, 1000);

            System.out.println();

            // Test case 2: Flipping of a coin
            Map<String, Integer> coinProbabilities = new HashMap<>();
            coinProbabilities.put("Head", 35);
            coinProbabilities.put("Tail", 65);
            simulateOccurrences(coinProbabilities, 1000);
        }

        public static void simulateOccurrences(Map<?, Integer> probabilities, int numOccurrences) {
            List<?> outcomes = new ArrayList<>(probabilities.keySet());
            Map<Object, Integer> occurrenceCounts = new HashMap<>();

            // Initialize the occurrence counts for each outcome
            for (Object outcome : outcomes) {
                occurrenceCounts.put(outcome, 0);
            }

            // Simulate the occurrences
            for (int i = 0; i < numOccurrences; i++) {
                Object outcome = getRandomOutcome(probabilities);
                occurrenceCounts.put(outcome, occurrenceCounts.get(outcome) + 1);
            }

            // Print the occurrence counts
            for (Object outcome : outcomes) {
                System.out.println(outcome + " appeared " + occurrenceCounts.get(outcome) + " times.");
            }
        }

        private static Object getRandomOutcome(Map<?, Integer> probabilities) {
            int total = getTotalProbability(probabilities);
            int randomNum = random.nextInt(total);

            int cumulativeProb = 0;
            for (Map.Entry<?, Integer> entry : probabilities.entrySet()) {
                cumulativeProb += entry.getValue();
                if (randomNum < cumulativeProb) {
                    return entry.getKey();
                }
            }

            return null; // Should never reach this point
        }

        private static int getTotalProbability(Map<?, Integer> probabilities) {
            int total = 0;
            for (int prob : probabilities.values()) {
                total += prob;
            }
            return total;
        }
    }


