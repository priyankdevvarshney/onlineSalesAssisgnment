package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//**********************DESCRIPTION****************
//The code defines a MathExpressionEvaluator program that evaluates a set of
// mathematical expressions. It uses the JavaScript engine to evaluate the
// expressions and prints the expression along with its result to the console.
// The expressions include basic arithmetic operations and square root calculations.
// The program iterates over the expressions, evaluates each one, and handles any
// exceptions that may occur during evaluation. The main method invokes the
// evaluateMathExpressions method to start the evaluation process.

public class MathExpressionEvaluator {
    public static void main(String[] args) {
        evaluateMathExpressions();
    }

    public static void evaluateMathExpressions() {
        String[] expressions = {
                "2 * 4 * 4",
                "5 / (7 - 5)",
                "Math.sqrt(Math.pow(5, 2) - Math.pow(4, 2))",
                "Math.sqrt(-Math.pow(3, 2) - Math.pow(4, 2))"
        };

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        for (String expression : expressions) {
            if (expression.equalsIgnoreCase("end")) {
                break;
            }
            try {
                Object result = engine.eval(expression);
                System.out.println(expression + " => " + result);
            } catch (ScriptException e) {
                System.out.println("Error evaluating expression: " + expression);
            }
        }
    }
}
